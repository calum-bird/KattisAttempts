import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//Author: Calum Bird
//Age: 17
//School: Mount Allison University

public class AnotherBrick
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //Initialize the input reader
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); //Initialize the output writer
		
		String[] line = br.readLine().split(" ");
		int h = Integer.parseInt(line[0]), w = Integer.parseInt(line[1]), n = Integer.parseInt(line[2]);
		
		int[] bricks = new int[n];
		String[] brickInput = br.readLine().split(" ");
		
		for(int i = 0; i < n; i++)
		{
			bricks[i] = Integer.parseInt(brickInput[i]);
		}
		
		boolean successful = true;
		
		for(int i = 0; i < h; i++)
		{
			int curr = 0;
			for(int j = 0; j+i < n; j++)
			{
				curr += bricks[i+j];
				if(curr == w)
					curr = 0;
			}
			
			if(curr != w)
			{
				successful = false;
				break;
			}
		}
		
		if(successful)
			bw.write("YES");
		else
			bw.write("NO");

		bw.close(); //Cleanup the writer
		br.close(); //Cleanup the reader
	}
}