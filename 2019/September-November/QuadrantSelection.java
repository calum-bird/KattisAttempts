import java.io.*;

public class QuadrantSelection
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in)); //Initialize the input reader
		BufferedWriter bw =  new BufferedWriter(new OutputStreamWriter(System.out)); //Initialize the output writer
		
		int x = Integer.parseInt(br.readLine()); //Get number of stones on the ground
		int y = Integer.parseInt(br.readLine()); //Get number of stones on the ground
		
		if(x > 0)
		{
			if(y > 0)
			{
				bw.write("1"); //X and Y positive, Quadrant 1
			}
			else
			{
				bw.write("4"); //X positive and Y negative, Quadrant 4
			}
		}
		else
		{
			if(y > 0)
			{
				bw.write("2"); //X negative and Y positive, Quadrant 2
			}
			else
			{
				bw.write("3"); //X and Y negative, Quadrant 3
			}
		}

		bw.close(); //Cleanup the writer
		br.close(); //Cleanup the reader
	}
}