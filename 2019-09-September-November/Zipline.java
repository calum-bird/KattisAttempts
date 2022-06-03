import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//Author: Calum Bird
//Age: 17
//School: Mount Allison University

public class Zipline
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in)); //Initialize the input reader
		BufferedWriter bw =  new BufferedWriter(new OutputStreamWriter(System.out)); //Initialize the output writer
		
		int x = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < x; i++)
		{
			String[] ziplineParts = br.readLine().split(" ");
			double width = Double.parseDouble(ziplineParts[0]);
			double pole1 = Double.parseDouble(ziplineParts[1]);
			double pole2 = Double.parseDouble(ziplineParts[2]);
			double rider = Double.parseDouble(ziplineParts[3]);
			
			double h1 = pole1-rider;
			double h2 = pole2-rider;
			
			if(h1 == 0 && h2 == 0)
			{
				bw.write(Double.toString(width) + " " + Double.toString(width) + "\n");
			}
			else
			{
				double x1 = (h1*width)/(h2+h1);
				double euclidianMin = Math.sqrt(Math.pow(width, 2) + Math.pow(Math.abs(pole1-pole2), 2));
				double euclidianMax = Math.sqrt(Math.pow(x1,2) + Math.pow(h1, 2)) + Math.sqrt(Math.pow(width-x1,2) + Math.pow(h2, 2));
				bw.write(Double.toString(euclidianMin) + " " + Double.toString(euclidianMax) + "\n");
			}
			
		}

		bw.close(); //Cleanup the writer
		br.close(); //Cleanup the reader
	}
}