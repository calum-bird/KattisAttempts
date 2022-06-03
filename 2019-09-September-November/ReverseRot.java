import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//Author: Calum Bird
//Age: 17
//School: Mount Allison University

public class ReverseRot
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //Initialize the input reader
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); //Initialize the output writer
		
		String line = br.readLine(); //Read first line
		
		while(line != "0")
		{
			String[] parts = line.split(" ");
			int rotations = Integer.parseInt(parts[0]);
			String message = parts[1];
			
			StringBuilder sb = new StringBuilder();
			message = sb.append(message).reverse().toString();
			
			char[] current = new char[message.length()];
			
			for(int i = 0; i < rotations; i++)
			{
				
			}
			
			line = br.readLine();
		}

		bw.close(); //Cleanup the writer
		br.close(); //Cleanup the reader
	}
}