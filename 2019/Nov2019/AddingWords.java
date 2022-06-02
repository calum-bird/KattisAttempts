import java.io.*;
import java.util.*;

//Author: Calum Bird
//Age: 18
//School: Mount Allison University

public class AddingWords
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw =  new BufferedWriter(new OutputStreamWriter(System.out)); //Initialize the output writer
		
		HashMap<String, Integer> definedVariables = new HashMap<String, Integer>();
		
		String line = br.readLine();
		while(line != null)
		//while(!line.equals(""))
		{
			if(line.contains("clear"))
			{
				definedVariables.clear();
			}
			else if(line.contains("def"))
			{
				//Define a new variable...
				String sub = line.substring(4); //Remove the "def" part
				String[] parts = sub.split(" "); //Split the string to isolate variable name and value
				definedVariables.put(parts[0], Integer.parseInt(parts[1]));
			}
			else if(line.contains("calc"))
			{
				//Calculate some variables
				line = line.substring(5);
				bw.write(line);
				
				boolean known = true;
				line = line.substring(0, line.length() - 1);
				String[] parts = line.split(" ");
				
				ArrayList<Character> operators = new ArrayList<Character>();
				ArrayList<Integer> expressionDetails = new ArrayList<Integer>();
				
				for(String p: parts)
				{
					p = p.trim();
					if(!p.contains("+") && !p.contains("-"))
					{
						if(definedVariables.get(p) != null)
						{
							expressionDetails.add(definedVariables.get(p));
							//p = Integer.toString(definedVariables.get(p));
						}
						else if(p != " ")
						{
							known = false;
						}
					}
					else
					{
						operators.add(p.toCharArray()[0]);
					}
				}
				if(known)
				{
					int result = expressionDetails.get(0);
					for(int i = 1; i < expressionDetails.size(); i++)
					{
						if(operators.get(i - 1) == '+')
						{
							result += expressionDetails.get(i);
						}
						else
						{
							result -= expressionDetails.get(i);
						}
					}
					
					bw.write(" " + existsInList(result, definedVariables) + "\n");
				}
				else
				{
					bw.write(" unknown\n");
				}
			}
			
			line = br.readLine();
		}
		br.close();
		bw.close(); //Cleanup the writer
	}
	
	private static String existsInList(int check, HashMap<String, Integer> map)
	{
		for(Map.Entry<String, Integer> entry: map.entrySet())
		{
			if(entry.getValue() == check)
				return entry.getKey();
		}
		
		return "unknown";
	}
}
