import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//Author: Calum Bird
//Age: 17
//School: Mount Allison University

public class TaisFormula
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in)); //Initialize the input reader
		BufferedWriter bw =  new BufferedWriter(new OutputStreamWriter(System.out)); //Initialize the output writer
		
		int glucoseSamplesCount = Integer.parseInt(br.readLine()); //Read first line
		
		String[] lineParts = br.readLine().split(" ");
		double prevT = Double.parseDouble(lineParts[0]);
		double prevV = Double.parseDouble(lineParts[1]);
		
		double totalArea = 0.0f;
		
		for(int n = 0; n < glucoseSamplesCount - 1; n++)
		{
			String[] parts = br.readLine().split(" ");
			double t = Double.parseDouble(parts[0]);
			double v = Double.parseDouble(parts[1]);
			
			totalArea += ((prevV + v)/2) * (t - prevT) / 1000;
			
			prevV = v;
			prevT = t;
		}
		
		bw.write(Double.toString(totalArea));

		bw.close(); //Cleanup the writer
		br.close(); //Cleanup the reader
	}
}