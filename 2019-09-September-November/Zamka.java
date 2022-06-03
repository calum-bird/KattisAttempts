import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//Author: Calum Bird
//Age: 17
//School: Mount Allison University

public class Zamka
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in)); //Initialize the input reader
		BufferedWriter bw =  new BufferedWriter(new OutputStreamWriter(System.out)); //Initialize the output writer
		
		int L = Integer.parseInt(br.readLine()); //Read first line
		int D = Integer.parseInt(br.readLine()); //Read second line
		int X = Integer.parseInt(br.readLine()); //Read third line
		
		int minNum = 1000000;
		int maxNum = 0;
		
		for(int i = 0; i < 1000000; i++)
		{
			if(sumDigits(Integer.toString(i)) == X && i >= L && i <= D)
			{
				if(i < minNum)
				{
					minNum = i;
				}
				
				if(i > maxNum)
				{
					maxNum = i;
				}
			}
		}
		
		bw.write(Integer.toString(minNum) + "\n");
		bw.write(Integer.toString(maxNum) + "\n");
		

		bw.close(); //Cleanup the writer
		br.close(); //Cleanup the reader
	}
	
	public static int sumDigits(String number)
	{
		char[] numberChars = number.toCharArray();
		int sum = 0;
		
		for(char c: numberChars)
		{
			sum += Integer.parseInt(Character.toString(c));
		}
		
		return sum;
	}
}