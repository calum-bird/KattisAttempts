import java.io.*;

public class GrassSeed
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in)); //Initialize the input reader
		BufferedWriter bw =  new BufferedWriter(new OutputStreamWriter(System.out)); //Initialize the output writer
		
		double C = Double.parseDouble(br.readLine()); //Read first line
		double L = Double.parseDouble(br.readLine()); //Read first line
		
		double totalCost = 0;
		
		for(int i = 0; i < L; i++)
		{
			String[] parts = br.readLine().split(" ");
			double[] vals = new double[parts.length];
			vals[0] = Double.parseDouble(parts[0]);
			vals[1] = Double.parseDouble(parts[1]);
			double area = vals[0] * vals[1];
			totalCost += (area * C);
		}
		
		bw.write(Double.toString(totalCost));

		bw.close(); //Cleanup the writer
		br.close(); //Cleanup the reader
	}
}