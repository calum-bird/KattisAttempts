import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//Author: Calum Bird
//Age: 17
//School: Mount Allison University

public class Tri
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //Initialize the input reader
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); //Initialize the output writer
		
		String[] lineParts = br.readLine().split(" ");
		
		int[] vals = new int[3];
		vals[0] = Integer.parseInt(lineParts[0]);
		vals[1] = Integer.parseInt(lineParts[1]);
		vals[2] = Integer.parseInt(lineParts[2]);
		
		//0 - 1 - 2
		if(vals[0] + vals[1] == vals[2])
		{
			bw.write(vals[0] + "+" + vals[1] + "=" + vals[2]);
		}
		else if(vals[0] - vals[1] == vals[2])
		{
			bw.write(vals[0] + "-" + vals[1] + "=" + vals[2]);
		}
		else if(vals[0] * vals[1] == vals[2])
		{
			bw.write(vals[0] + "*" + vals[1] + "=" + vals[2]);
		}
		else if(vals[0] / vals[1] == vals[2])
		{
			bw.write(vals[0] + "/" + vals[1] + "=" + vals[2]);
		}
		
		
		else if(vals[0] == vals[1] + vals[2])
		{
			bw.write(vals[0] + "=" + vals[1] + "+" + vals[2]);
		}
		else if(vals[0] == vals[1] - vals[2])
		{
			bw.write(vals[0] + "=" + vals[1] + "-" + vals[2]);
		}
		else if(vals[0] == vals[1] * vals[2])
		{
			bw.write(vals[0] + "=" + vals[1] + "*" + vals[2]);
		}
		else if(vals[0] == vals[1] / vals[2])
		{
			bw.write(vals[0] + "=" + vals[1] + "/" + vals[2]);
		}

		bw.close(); //Cleanup the writer
		br.close(); //Cleanup the reader
	}
}