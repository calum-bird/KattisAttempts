import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//Author: Calum Bird
//Age: 17
//School: Mount Allison University

public class NumberFun
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in)); //Initialize the input reader
		BufferedWriter bw =  new BufferedWriter(new OutputStreamWriter(System.out)); //Initialize the output writer
		
		int x = Integer.parseInt(br.readLine()); //Read first line
		
		for(int i = 0; i < x; i++)
		{
			String[] parts = br.readLine().split(" ");
			double a = Double.parseDouble(parts[0]);
			double b = Double.parseDouble(parts[1]);
			double c = Double.parseDouble(parts[2]);
			
			boolean possible = false;
			
			if(a + b == c)
			{
				possible = true;
			}
			else if(a - b == c)
			{
				possible = true;
			}
			else if(b - a == c)
			{
				possible = true;
			}
			else if(a * b == c)
			{
				possible = true;
			}
			else if(a / b == c)
			{
				possible = true;
			}
			else if(b / a == c)
			{
				possible = true;
			}
			else
			{
				possible = false;
			}
			
			
			if(possible)
			{
				bw.write("Possible \n");
			}
			else
			{
				bw.write("Impossible \n");
			}
		}

		bw.close(); //Cleanup the writer
		br.close(); //Cleanup the reader
	}
}