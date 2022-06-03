import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class SummerTrip
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		ArrayList<Character> uniqueEvents = new ArrayList<Character>();
		
		int count = 0;
		
		char[] line = br.readLine().toCharArray();
		ArrayList<Character> lineList = new ArrayList<Character>();
		
		for(char c: line)
		{
			lineList.add(c);
			
			if(!inArray(c, uniqueEvents))
				uniqueEvents.add(c);
		}
		
		for(int i = 0; i < uniqueEvents.size(); i++)
		{
			for(int j = 0; j < uniqueEvents.size(); j++)
			{
				
			}
		}
		
		bw.write(Integer.toString(count) + "\n");
		
		
		br.close();
		bw.close();
	}
	
	static boolean inArray(char in, ArrayList<Character> a)
	{
		for(char c: a)
			if(in == c)
				return true;
		
		return false;
	}
	
	static int instanceOf(char in, ArrayList<Character> a)
	{
		int count = 0;
		
		for(char c: a)
			if(in == c)
				count++;
		
		return count;
	}
}
