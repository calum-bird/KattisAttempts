import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//Author: Calum Bird
//Age: 17
//School: Mount Allison University

public class LastFactorialDigit
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in)); //Initialize the input reader
		BufferedWriter bw =  new BufferedWriter(new OutputStreamWriter(System.out)); //Initialize the output writer
		
		int x = Integer.parseInt(br.readLine()); //Read first line
		
		for(int i = 0; i < x; i++)
		{
			int num = Integer.parseInt(br.readLine());
			
			int factor = 1;
			
			for(int j = 1; j <= num; j++)
			{
				factor = factor*j;
			}
			
			char[] number = Integer.toString(factor).toCharArray();
			bw.write(number[number.length - 1] + "\n");
		}

		bw.close(); //Cleanup the writer
		br.close(); //Cleanup the reader
	}
}