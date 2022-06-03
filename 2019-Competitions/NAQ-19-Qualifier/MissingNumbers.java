import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;

public class MissingNumbers
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		ArrayDeque<Integer> q = new ArrayDeque<Integer>();

		ArrayList<Integer> required = new ArrayList<Integer>();
		
		int count = Integer.parseInt(br.readLine());
		for(int i = 0; i < count; i++)
		{
			int val = Integer.parseInt(br.readLine());
			if(i > 0)
			{
				int prev = q.peek();
				
				if(prev != val - 1)
				{
					for(int j = 1; prev+j < val; j++)
						required.add(prev+j);
				}
			}
			else
			{
				if(val != 1)
					for(int j = 1; j < val; j++)
						required.add(j);
			}
			
			q.push(val);
		}
		
		if(required.size() > 0)
			for(int i: required)
				bw.write(Integer.toString(i) + "\n");
		else
		{
			bw.write("good job\n");
		}
		
		br.close();
		bw.close();
	}
}
