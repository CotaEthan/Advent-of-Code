import java.util.*;
import java.io.*;
class day4
{
	public static void main(String[]args)throws FileNotFoundException
	{
		System.out.println("MAIN");
		
		List<Integer> fin = count();
		
		System.out.println("Resultant point set: "+fin);
		
		System.out.println("Final Sum: "+summer(fin));			
	}
	public static List<Integer> count()throws FileNotFoundException
	{		
		File f = new File("testinputFixed.txt");
		Scanner input = new Scanner(f);
		int count = 0;
		
		int sum = 0;
		boolean flag = true;
		boolean first = true;
		
		String line = "";
		HashSet<Integer> set = new HashSet<>();
		List<Integer> points = new ArrayList<>();
		
		while(input.hasNext())
		{
			count++;
			line = input.nextLine();
			Scanner in = new Scanner(line);
			String s = "";
			
			while(in.hasNext())
			{
				s = in.next();
				//System.out.println("THIS IS S: "+s+" and firrst is: "+first);
				
				if(first)
				{
					if(s.equals("|"))
					{
						first = false;
					}
					else
					{
								//System.out.println(count+" HEE: "+set);
								//System.out.println("ADDING VLAUE: "+s);
						set.add(Integer.parseInt(s));
								//System.out.println(count+" SET: "+set);
					}
				}
				else
				{
					System.out.println(s+" is present: "+set.contains(Integer.parseInt(s)));
					if(set.contains(Integer.parseInt(s)))
					{
						if(flag)
						{
							sum += 1;
							flag  = false;
						}
						else
						{
							sum *= 2;
						}
					}
				}
			}
			System.out.println("Final Set Number "+count+": "+set);
			System.out.println("Number "+count+" Sum = "+sum);
			set.clear();
			flag = true;
			first = true;
			if(sum>0)
			{
				points.add(sum);
				sum = 0;
			}
		}	
		
		return points;
	}
	
	public static int summer(List<Integer> list)
	{
		int tote = 0;
		
		for(int i = 0; i<list.size(); ++i)
		{
			tote += list.get(i);
		}
		
		return tote;
	}
}
