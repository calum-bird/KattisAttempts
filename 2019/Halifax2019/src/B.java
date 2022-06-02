import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//Author: Calum Bird
//Age: 17
//School: Mount Allison University

public class B
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //Initialize the input reader
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); //Initialize the output writer
		
		int x = Integer.parseInt(br.readLine()); //Read first line
		
		while(x-- > 0)
		{
			long val = Long.parseLong(br.readLine());
			val = 1+val;
			System.out.println(Long.toString(val, 2).substring(1));
		}

		bw.close(); //Cleanup the writer
		br.close(); //Cleanup the reader
	}
}