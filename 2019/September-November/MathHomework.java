import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//Author: Calum Bird
//Age: 17
//School: Mount Allison University

public class MathHomework
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in)); //Initialize the input reader
		BufferedWriter bw =  new BufferedWriter(new OutputStreamWriter(System.out)); //Initialize the output writer
		
		String[] lines = br.readLine().split(" "); //Read first line
		int legs1, legs2, legs3, legCount;
		legs1 = Integer.parseInt(lines[0]);
		legs2 = Integer.parseInt(lines[1]);
		legs3 = Integer.parseInt(lines[2]);
		legCount = Integer.parseInt(lines[3]);
		
		for(int i = 0; i < legCount/legs1; i++)
		{
			for(int j = 0; j < legCount/legs2; j++)
			{
				for(int h = 0; h < legCount/legs3; h++)
				{
					if(i*legs1 + j*legs2 + h*legs3 == legCount)
					{
						bw.write(i + " " + j + " " + h + "\n");
					}
				}
			}
		}
		

		bw.close(); //Cleanup the writer
		br.close(); //Cleanup the reader
	}
}