import java.io.*;
import java.util.*;

//Author: Calum Bird
//Age: 18
//School: Mount Allison University

public class WordsForNumbers
{
	private static final String[] tensNames = {
    		"",
    		"ten",
    		"twenty",
    		"thirty",
    		"forty",
    		"fifty",
    		"sixty",
    		"seventy",
    		"eighty",
    		"ninety"
  	};

  	private static final String[] numNames = {
    		"",
    		"one",
    		"two",
    		"three",
    		"four",
    		"five",
    		"six",
    		"seven",
    		"eight",
    		"nine",
    		"ten",
    		"eleven",
    		"twelve",
    		"thirteen",
    		"fourteen",
    		"fifteen",
    		"sixteen",
    		"seventeen",
    		"eighteen",
    		"nineteen"
  	};
  	
  	private static String convertNumber(int number)
  	{
		String soFar = "";

	    	if(number % 100 < 20)
	    	{
	      		soFar = numNames[number % 100];
	      		number /= 100;
	    	}
	    	else
	    	{
	      		soFar = "-" + numNames[number % 10];
	      		number /= 10;

	      		soFar = tensNames[number % 10] + soFar;
	      		number /= 10;
	    	}
	    	
	    	if(soFar.charAt(soFar.length()-1) == '-')
	    		soFar = soFar.substring(0, soFar.length()-1);
	    	
	    	if(number == 0) return soFar;
	    	
	    	return numNames[number] + " hundred" + soFar;
	}
  	
	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String line = br.readLine();
		
		while(line != null)
		//while(!line.equals(""))
		{
			StringBuilder sb = new StringBuilder();
			for(String w: line.split(" "))
			{
				int v = isNumber(w);
				if(v != -1)
				{
					sb.append(convertNumber(v) + " ");
				}
				else
				{
					sb.append(w + " ");
				}
			}
			sb.append("\n");
			sb.replace(0, 1, Character.toString(sb.charAt(0)).toUpperCase());
			
			System.out.print(sb);
			line = br.readLine();
		}
		
		br.close();
	}
	
	static int isNumber(String s)
	{
		int val = -1;
		
		try
		{
			val = Integer.parseInt(s);
		}
		catch (NumberFormatException nfe)
		{
			val = -1;
		}
		
		return val;
	}
}
