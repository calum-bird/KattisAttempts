import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.HashMap;

public class CircuitMath
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		HashMap<Character, Boolean> map = new HashMap<Character, Boolean>();
		
		int x = Integer.parseInt(br.readLine());
		
		String[] vals = br.readLine().split(" ");
		
		for(int i = 0; i < x; i++)
		{
			map.put((char)(i+65), Boolean.parseBoolean(vals[i].contains("T") ? "true": "false"));
		}
		
		map.put('<', map.get('A'));
		
		char[] line = br.readLine().replaceAll("\\s", "").toCharArray();
		

		ArrayDeque<Boolean> currentValues = new ArrayDeque<Boolean>();
		
		for(char c: line)
		{
			if(c == '*')
			{
				boolean a = currentValues.poll();
				boolean b = currentValues.poll();
				if(a && b)
				{
					currentValues.push(true);
				}
				else
				{
					currentValues.push(false);
				}
			}
			else if(c == '+')
			{
				boolean a = currentValues.poll();
				boolean b = currentValues.poll();
				if(a || b)
				{
					currentValues.push(true);
				}
				else
				{
					currentValues.push(false);
				}
			}
			else if(c == '-')
			{
				boolean a = currentValues.poll();
				currentValues.push(!a);
			}
			else
			{
				currentValues.add(map.get(c));
			}
		}
		
		if(currentValues.peek())
			bw.write("T");
		else
			bw.write("F");
		
		br.close();
		bw.close();
	}
	
	/*
4
T F T F
A B * C D + - +

4
F T F T
A B * C D + - +

3
T F F
A C + - B *

	 */
}
