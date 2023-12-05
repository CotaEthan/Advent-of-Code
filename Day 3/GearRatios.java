import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class GearRatios {

    public static void main(String[] args) {
        try {
            // Read the engine schematic from a file
            BufferedReader reader = new BufferedReader(new FileReader("testinput.txt"));
            String line;
            StringBuilder engineSchematic = new StringBuilder();

            while ((line = reader.readLine()) != null) {
                engineSchematic.append(line).append("\n");
            }

            // Close the reader
            reader.close();

            // Calculate the sum of part numbers
            int sum = calculateSum(engineSchematic.toString());

            // Print the result
            System.out.println("Sum of part numbers: " + sum);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int calculateSum(String engineSchematic) {
        int sum = 0;
        char[][] grid = parseEngineSchematic(engineSchematic);

        // Iterate through each character in the grid
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (Character.isDigit(grid[i][j]) || isSymbol(grid[i][j])) {
                    // Calculate sum of adjacent numbers
                    sum += getAdjacentSum(grid, i, j);
                }
            }
        }

        return sum;
    }

    private static boolean isSymbol(char c) {
        return c == '*' || c == '#' || c == '+' || c == '$';
    }

    private static int getAdjacentSum(char[][] grid, int row, int col) {
        int sum = 0;

        // Define the relative positions of adjacent numbers and symbols
        int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

        // Iterate through adjacent positions
        for (int i = 0; i < dx.length; i++) {
            int newRow = row + dx[i];
            int newCol = col + dy[i];

            // Check if the position is within the grid
            if (newRow >= 0 && newRow < grid.length && newCol >= 0 && newCol < grid[0].length) {
                // Check if the character is a digit or a symbol
                if (Character.isDigit(grid[newRow][newCol]) || isSymbol(grid[newRow][newCol])) {
                    // Add the adjacent digit or symbol to the sum
                    sum += Integer.parseInt(String.valueOf(grid[newRow][newCol]));
                }
            }
        }

        return sum;
    }

    private static char[][] parseEngineSchematic(String engineSchematic) {
        String[] lines = engineSchematic.trim().split("\n");
        int rows = lines.length;
        int cols = lines[0].length();
        char[][] grid = new char[rows][cols];

        // Fill the grid with characters from the engine schematic
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                grid[i][j] = lines[i].charAt(j);
            }
        }

        return grid;
    }
}
