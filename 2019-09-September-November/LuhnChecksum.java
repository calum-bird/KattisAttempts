import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//Author: Calum Bird
//Age: 17
//School: Mount Allison University

public class LuhnChecksum
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //Initialize the input reader
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); //Initialize the output writer
		
		int x = Integer.parseInt(br.readLine()); //Read first line
		
		while(x-- > 0)
		{
			char[] parts = br.readLine().toCharArray();
			int sum = 0;
			for(int i = 0; i < parts.length; i++)
			{
				int v = (int)parts[i] - 48;
				v = v*2;
				bw.write("Num 1: " + v + "\n");
				if(v > 9)
				{
					v = sumDigits(v);
				}
				bw.write("Num 2: " + v + "\n");
				sum += v;
			}
			
			if(sum % 10 == 0)
				bw.write("PASS\n");
			else
				bw.write("FAIL\n");
		}

		bw.close(); //Cleanup the writer
		br.close(); //Cleanup the reader
	}
	
	static int sumDigits(int num)
	{
		int sum = 0;
		while (num > 0)
		{
			sum = sum + num % 10;
			num = num / 10;
		}
		return sum;

	}
}