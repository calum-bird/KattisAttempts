import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//Author: Calum Bird
//Age: 17
//School: Mount Allison University

public class JobExpenses
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //Initialize the input reader
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); //Initialize the output writer
		
		br.readLine();
		String[] parts = br.readLine().split(" ");
		int sum = 0;			
		for(String s: parts)
		{
			if(!s.equals(""))
			{
				int v = Integer.parseInt(s);
				if(v < 0)
					sum -= v;
			}
		}
		
		bw.write(Integer.toString(sum));

		bw.close(); //Cleanup the writer
		br.close(); //Cleanup the reader
	}
}