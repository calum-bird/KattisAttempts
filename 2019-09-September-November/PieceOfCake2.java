import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//Author: Calum Bird
//Age: 17
//School: Mount Allison University

public class PieceOfCake2
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //Initialize the input reader
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); //Initialize the output writer
		
		String[] line = br.readLine().split(" ");
		int n = Integer.parseInt(line[0]);
		int h = Integer.parseInt(line[1]);
		int v = Integer.parseInt(line[2]);
		
		if(h > n/2)
		{
			if(v > n/2)
			{
				bw.write(h*v*4 + "");
			}
			else
			{
				bw.write(h*(n-v)*4 + "");
			}
		}
		else
		{
			//Use n-h
			if(v > n/2)
			{
				bw.write((n-h)*v*4 + "");
			}
			else
			{
				bw.write((n-h)*(n-v)*4 + "");
			}
		}

		bw.close(); //Cleanup the writer
		br.close(); //Cleanup the reader
	}
}