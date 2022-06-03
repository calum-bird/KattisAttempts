import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//Author: Calum Bird
//Age: 17
//School: Mount Allison University

public class Avion
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //Initialize the input reader
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); //Initialize the output writer
		
		boolean success = false;
		
		for(int i = 0; i < 5; i++)
		{
			if(br.readLine().contains("FBI"))
			{
				bw.write(Integer.toString(i + 1) + " ");
				success = true;
			}
		}
		
		if(!success)
			bw.write("HE GOT AWAY!");

		bw.close(); //Cleanup the writer
		br.close(); //Cleanup the reader
	}
}