import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//Author: Calum Bird
//Age: 17
//School: Mount Allison University

public class JudgingMoose
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //Initialize the input reader
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); //Initialize the output writer
		
		String[] parts = br.readLine().split(" ");
		int left = Integer.parseInt(parts[0]);
		int right = Integer.parseInt(parts[1]);
		
		if(left == 0 && right == 0)
		{
			bw.write("Not a moose");
		}
		else if(left != right)
		{
			bw.write("Odd " + Integer.toString(Math.max(left, right) * 2));
		}
		else
		{
			bw.write("Even " + Integer.toString(left+right));
		}

		bw.close(); //Cleanup the writer
		br.close(); //Cleanup the reader
	}
}