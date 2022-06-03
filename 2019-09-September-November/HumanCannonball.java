import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//Author: Calum Bird
//Age: 17
//School: Mount Allison University

public class HumanCannonball
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in)); //Initialize the input reader
		BufferedWriter bw =  new BufferedWriter(new OutputStreamWriter(System.out)); //Initialize the output writer
		
		int x = Integer.parseInt(br.readLine()); //Read first line
		
		for(int i = 0; i < x; i++)
		{
			String[] parts = br.readLine().split(" ");
			double v = Double.parseDouble(parts[0]);
			double theta = Double.parseDouble(parts[1]);
			double x1 = Double.parseDouble(parts[2]);
			double h1 = Double.parseDouble(parts[3]);
			double h2 = Double.parseDouble(parts[4]);
			double g = 9.81f;
			
			double t = x1/v/Math.cos(Math.toRadians(theta));
			
			
			double h = v * t * Math.sin(Math.toRadians(theta)) - (0.5*g) * Math.pow(t, 2);
					
			if(h - h1 >= 1 && h2 - h >= 1)
			{
				bw.write("Safe \n");
			}
			else
			{
				bw.write("Not Safe \n");
			}
		}

		bw.close(); //Cleanup the writer
		br.close(); //Cleanup the reader
	}
}