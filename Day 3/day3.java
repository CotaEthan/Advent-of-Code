import java.util.*;
import java.io.*;
class day3
{
	public static void main(String[] args)throws FileNotFoundException
	{
		System.out.println("MAIN");
		int i = 0;
		
		
		//System.out.println("mapperS_________\n"+mapperSimple());
		List<Integer> list = searchMap(mapperSimple());
		
		System.out.println(list);
	}
	
	/*
	public static List<List<String>> mapper()throws FileNotFoundException
	{
		File f = new File("testinput.txt");
		Scanner input = new Scanner(f);
		String line = "";
		//int lineCount = 0;
		int sum = 0;
		
		List<List<String>> map = new ArrayList<>();
		
		
		while(input.hasNext())
		{
			line = input.nextLine();
			List<String> list = new ArrayList<>();
			
			for(int i = 0; i<line.length();i++)
			{
				if(Character.isDigit(line.charAt(i)))
				{
					sum = (sum*10) + Character.getNumericValue(line.charAt(i));
				}
				else
				{
					if(sum > 0) 
					{
						list.add(Integer.toString(sum));
						sum = 0;
					}
					list.add(Character.toString(line.charAt(i)));
				}
			}
			//lineCount++;
			
			
			map.add(list);
			//System.out.println(map);
		}
		
		//System.out.println(map);
		
		return map;
	}
	*/

	public static List<List<String>> mapperSimple()throws FileNotFoundException
	{
		File f = new File("testinput.txt");
		Scanner input = new Scanner(f);
		String line = "";
		
		int sum = 0;
		
		List<List<String>> map = new ArrayList<>();
		
		
		while(input.hasNext())
		{
			line = input.nextLine();
			List<String> list = new ArrayList<>();
			
			for(int i = 0; i<line.length();i++)
			{		
				list.add(Character.toString(line.charAt(i)));
			}		
			
			map.add(list);
			//System.out.println(map);
		}
		
		//System.out.println(map);
		
		return map;
	}




	
	
	public static List<Integer> searchMap(List<List<String>> mapp)throws FileNotFoundException
	{
		List<Integer> list = new ArrayList<>();
		int sum = 0;
		
		
		for(int i = 0; i<mapp.size(); ++i)
		{
			for(int j = 0; j<mapp.get(i).size();++j)
			{
				if(checkValid(mapp, i, j) == 1)
				{
					sum = (sum*10) + Integer.parseInt(mapp.get(i).get(j));
				}
				else if(checkValid(mapp, i, j) == 2)
				{
					if(checkAdj(mapp, i, j))
					{
						sum = (sum*10) + Integer.parseInt(mapp.get(i).get(j));
						list.add(sum);
						sum = 0;
					}
					else
					{
						sum = (sum*10) + Integer.parseInt(mapp.get(i).get(j));
						System.out.println("Sum thrown: "+sum);
						sum = 0;
					}				
				}
				else if(checkValid(mapp, i, j) == 3)
				{
					//System.out.println("OP 3 was hit");
				}
			}
		} 
		return list;
	}
	
	public static int numSum(List<Integer> list)
	{
		int sum = 0;
		
		for(int i = 0; i<list.size();++i)
		{
			sum += list.get(i);
		}
		
		return sum;
	}
	
	
	//	Required Checks...
	//		1 - is incomplete number - parent to add to sum
	//		2 - is complete number that requires a check - parent to determine adj and add sum if good
	//		3 - is not Digit - Parent to continue iteration
	//
	public static int checkValid(List<List<String>> mapp, int i, int j)
	{
		boolean flag = true;
		int option = 0;
		

		//System.out.println(mapp.get(i).get(j));
		
		if(Character.isDigit(mapp.get(i).get(j).charAt(0)))
		{
			if(j == 0)
			{
				if(Character.isDigit(mapp.get(i).get(j+1).charAt(0)))
					option = 1;
				if(!Character.isDigit(mapp.get(i).get(j+1).charAt(0)))
				{
					option = 2;	
				}
			}
			else if(j > 0 && j<mapp.get(i).size())
			{
				if(Character.isDigit(mapp.get(i).get(j+1).charAt(0)))
					option = 1;
				if(!Character.isDigit(mapp.get(i).get(j+1).charAt(0)))
				{
					option = 2;	
				}
			}
			else
			{
				option = 2;
			}
		}
		else
		{
			option = 3;
		}
		
		return option;
	}	

	public static boolean checkAdj(List<List<String>> input, int row, int col)
	{
        // Define the possible adjacent positions
        int[] dr = {-2, -1, 0, 1, 2};
        int[] dc = {-1, 0, 1};

        // Iterate over adjacent positions
        for (int rOffset : dr) {
            for (int cOffset : dc) {
                int newRow = row + rOffset;
                int newCol = col + cOffset;

                // Check if the new position is within bounds
                if (newRow >= 0 && newRow < input.size() && newCol >= 0 && newCol < input.get(0).size()) {
                    String symbol = input.get(newRow).get(newCol);
 
                    // Check if the symbol is not a digit or '.'
                    if (!Character.isDigit(symbol.charAt(0)) && !symbol.equals(".")) {
                        return true; // There is an adjacent symbol
                    }
                }
            }
        }

        return false; // No adjacent symbol found
	}
	
	
}