import java.io.*;

public class FizzBuzz
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in)); //Initialize the input reader
		BufferedWriter bw =  new BufferedWriter(new OutputStreamWriter(System.out)); //Initialize the output writer
		
		String[] parts = br.readLine().split(" "); //Read first line
		
		int[] vals = new int[parts.length];
		
		for(int i = 0; i < parts.length; i++)
		{
			vals[i] = Integer.parseInt(parts[i]);
		}
		
		int x = vals[0];
		int y = vals[1];
		
		for(int n = 1; n < vals[2] + 1; n++)
		{
			if(n % x == 0 && n % y == 0)
			{
				bw.write("FizzBuzz \n");
			}
			else if(n % x == 0)
			{
				bw.write("Fizz \n");
			}
			else if(n % y == 0)
			{
				bw.write("Buzz \n");
			}
			else
			{
				bw.write(Integer.toString(n) + "\n");
			}
		}

		bw.close(); //Cleanup the writer
		br.close(); //Cleanup the reader
	}
}