import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//Author: Calum Bird
//Age: 17
//School: Mount Allison University

public class HarshadNumbers
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in)); //Initialize the input reader
		BufferedWriter bw =  new BufferedWriter(new OutputStreamWriter(System.out)); //Initialize the output writer
		
		int x = Integer.parseInt(br.readLine()); //Read first line
		
		for(long i = x; i < 1000000000; i++)
		{
			if(i % sumDigits(Long.toString(i)) == 0)
			{
				bw.write(Long.toString(i));
				break;
			}
		}

		bw.close(); //Cleanup the writer
		br.close(); //Cleanup the reader
	}
	
	public static long sumDigits(String number)
	{
		char[] numberChars = number.toCharArray();
		int sum = 0;
		
		for(char c: numberChars)
		{
			sum += Long.parseLong(Character.toString(c));
		}
		
		return sum;
	}
}