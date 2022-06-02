import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//Author: Calum Bird
//Age: 17
//School: Mount Allison University

public class OneChicken
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //Initialize the input reader
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); //Initialize the output writer
		
		String[] parts = br.readLine().split(" ");
		
		int n = Integer.parseInt(parts[0]);
		int m = Integer.parseInt(parts[1]);
		
		if(m > n)
		{
			if(m-n == 1)
				bw.write("Dr. Chaz will have 1 piece of chicken left over!\n");
			else
				bw.write("Dr. Chaz will have " + (m-n) + " pieces of chicken left over!\n");
		}
		else
		{
			if(n-m == 1)
				bw.write("Dr. Chaz needs 1 more piece of chicken!\n");
			else
				bw.write("Dr. Chaz needs " + (n-m) + " more pieces of chicken!\n");
		}

		bw.close(); //Cleanup the writer
		br.close(); //Cleanup the reader
	}
}