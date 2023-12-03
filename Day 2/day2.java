import java.util.*;
import java.io.*;
//import java.Integer.*;
class day2
{
	public static void main(String[] args)throws FileNotFoundException
	{
		//System.out.println("MAin\n");
		int maxRed = 12;
		int maxGreen = 13;
		int maxBlue = 14;

		int pow = 0;
		
		List<Integer> numList = count(maxRed, maxBlue, maxGreen);
		pow = powerCalc(maxRed, maxBlue, maxGreen);
		
		System.out.print("___HERE IS THE LIST of GAMES___\n"+numList+"\n");
		System.out.println("HERE    s u m    of GAMES: "+listSum(numList));
		System.out.println("FINAL POWERLEVEL: "+pow);
		
	}
	
	public static List<Integer> count(int maxRed, int maxBlue, int maxGreen)throws FileNotFoundException
	{
		System.out.println("count function\n");
		
		List<Integer> gameList = new ArrayList<Integer>();
		int num = 0;	
		
		File file = new File("input.txt");
		
		Scanner input = new Scanner(file);	
			int red = 0;
			int blue = 0;
			int green = 0;
		String s = "";	
	
		
		while(input.hasNext())
		{
			num++;
			s = input.nextLine();
			
			System.out.println("GGGGGGGGGGAAAAAAAAAAAME: "+num);
			red = getColorMax(s, "r");
					System.out.println("Here is red: "+red);
			blue = getColorMax(s, "b");
					System.out.println("Here is blue: "+blue);
			green = getColorMax(s, "g");
					System.out.println("Here is green: "+green);
			
			
			if(red<=maxRed && blue<=maxBlue && green<=maxGreen)
			{
				gameList.add(num);
			}
			
		}			
		
		return gameList;
	}	
	
	//TESTED and 100% VVorking
	public static int listSum(List<Integer> numList)
	{
		int sum = 0;
		
		for(int i = 0; i<numList.size(); ++i)
		{
		
			sum += numList.get(i);
			
		}
		return sum;
	}	
	
	public static int getColorMax(String s, String color)
	{
		//System.out.println("count red function\n");
		String temp = "";
		int n = 0;
		
		int holdR = 0;
		int holdB = 0;
		int holdG = 0;
		Scanner in = new Scanner(s);
		
		
		while(in.hasNext())
		{
			temp = in.next();
			if(Character.isDigit(temp.charAt(0)))
			{
				n = Integer.parseInt(temp);
				temp = in.next();
				
				if(temp.startsWith("red"))
				{
					holdR = holdR>=n ? holdR : n;
					//System.out.println("in red: "+temp+"value: "+holdR);
					
				}
				else if(temp.startsWith("blue"))
				{
					holdB = holdB>=n ? holdB : n;
					//System.out.println("iun green: "+temp+"value: "+holdB);
				}
				else if(temp.startsWith("green"))
				{
					holdG = holdG>=n ? holdG : n;
					//System.out.println("uin rbluer: "+temp+"value: "+holdG);
				}
				else
				{
					System.out.println("uh oh, gotte deal with: "+temp);
				}
			}
			else
			{
				System.out.println("IN the EL<>SLE");
			}
			
		}
		
		//Return cases
		switch(color)
		{
			case "r":
				return holdR;
			case "b":
				return holdB;
			case "g":
				return holdG;
			default:
				System.out.print("In default for switch");
				return -1000;
		}
	}
	
	public static int getPower(int red, int blue, int green)
	{
		return red*blue*green;
	}
	
	
	
	public static int powerCalc(int maxRed, int maxBlue, int maxGreen)throws FileNotFoundException
	{
		//List<Integer> gameList = new ArrayList<Integer>();
		int num = 0;
		int pow = 0;		
		
		File file = new File("input.txt");
		Scanner input = new Scanner(file);	
		
		int red = 0;
		int blue = 0;
		int green = 0;
		
		String s = "";	
	
		
		while(input.hasNext())
		{
			num++;
			s = input.nextLine();
			
			red = getColorMax(s, "r");
			blue = getColorMax(s, "b");
			green = getColorMax(s, "g");
			
			
			if(red<=maxRed && blue<=maxBlue && green<=maxGreen)
			{
				//gameList.add(num);
				pow += getPower(red, blue, green);
			}
			
		}			
		
		return pow;
	}	
	
	
	
	
	
	
	
	
	
}



