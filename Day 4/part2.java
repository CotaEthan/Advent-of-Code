import java.util.*;
import java.io.*;
class part2
{
	public static void main(String[]args)throws FileNotFoundException
	{
		System.out.println("MAIN");
		
		List<Integer> fin = count();
		
		//System.out.println("Resultant point set: "+fin);
		
		System.out.println("Final Sum: "+summer(fin));			
	}
	public static List<Integer> count()throws FileNotFoundException
	{		
		File f = new File("testinputFixed.txt");
		Scanner input = new Scanner(f);
		int count = 0;
		int sumCount = 0;
		
		int sum = 0;
		boolean flag = true;
		boolean first = true;
		
		String line = "";
		HashSet<Integer> set = new HashSet<>();
		List<Integer> points = new ArrayList<>();
		List<Integer> sumSet = new ArrayList<>();
		
		while(input.hasNext())
		{
			count++;
			line = input.nextLine();
			Scanner in = new Scanner(line);
			String s = "";
			
			while(in.hasNext())
			{
				s = in.next();
				
				if(first)
				{
					if(s.equals("|"))
					{
						first = false;
					}
					else
					{		
						set.add(Integer.parseInt(s));
					}
				}
				else
				{
					if(set.contains(Integer.parseInt(s)))
					{
						if(flag)
						{
							sum += 1;
							flag  = false;
							sumCount++;
						}
						else
						{
							sum *= 2;
							sumCount++;
						}
					}
				}
			}
		
			
			if(sumCount > 0)
				sumSet.add(sumCount);
			sumCount = 0;
			
	
					System.out.println("\nFinal Points list "+count+": "+points);
					System.out.println("Sum Set: "+sumSet);
					System.out.println("\nNumber "+count+" Sum = "+sum);
				
			
			set.clear();
			flag = true;
			first = true;
			if(sum>0)
			{
				points.add(sum);
				sum = 0;
			}
		}	
		
		
		//return setMod(points, sumSet);
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
	
	/*public static List<Integer> setMod(List<Integer> points, List<Integer> sumSet)
	{
		List<Integer> modList = new ArrayList<>();
		
		for(int i = 0; i<points.size();++i)
		{
			modList.add(points.get(i));
		}
		
		for(int j = 0; j<sumSet.size();++j)
		{			
			for(int i = j+1; (i<sumSet.size() || i<sumSet.get(j)); ++i)
			{
				modList.add(modList.get(i));
			}
		}
		
	
		
		System.out.println("\n THIS THE MODDED LIST WITH SIZE "+modList.size()+": "+modList+"\n");
		
		return modList;	
	}*/
	
}
