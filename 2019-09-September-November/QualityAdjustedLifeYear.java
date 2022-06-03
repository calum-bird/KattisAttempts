import java.io.*;

public class QualityAdjustedLifeYear
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in)); //Initialize the input reader
		BufferedWriter bw =  new BufferedWriter(new OutputStreamWriter(System.out)); //Initialize the output writer
		
		int lineCount = Integer.parseInt(br.readLine()); //Get number of lines to read
		
		double qaly = 0; //Initialize sum
		
		while(lineCount-- > 0) //Loop through all lines to read, until there are none left
		{
			String[] lineParts = br.readLine().split(" "); //Split the line we read into two parts
			double product = Double.parseDouble(lineParts[0]) * Double.parseDouble(lineParts[1]); //Calculate the product of those two parts
			qaly += product; //Add the product to the quality adjusted life year sum
		}
		
		bw.write(Double.toString(qaly)); //Output the quality-adjusted-life-year
		
		bw.close(); //Cleanup the writer
		br.close(); //Cleanup the reader
	}
}