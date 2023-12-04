import java.util.*;
import java.io.*;
class day3
{
	public static void main(String[] args)throws FileNotFoundException
	{
		System.out.println("MAIN");
		int i = 0;
		
		mapper();
	}
	
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
	
	
	public static List<Integer> searchMap(List<List<String>> mapp)
	{
		List<Integer> list = new ArrayList<>();
		
		
		
		
		
		
		
		
		
		
		
		
		return list;
	}
	public static int numSum(List<Integer> list)
	{
		int sum = 0;
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		return sum;
	}
	
	
}
