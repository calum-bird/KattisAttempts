import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//Author: Calum Bird
//Age: 17
//School: Mount Allison University

public class NeedForSpeed
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //Initialize the input reader
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); //Initialize the output writer
		
		String[] initParts = br.readLine().split(" ");
		int n = Integer.parseInt(initParts[0]); //Read first line
		int t = Integer.parseInt(initParts[1]);
		
		int sumS = 0;
		int sumD = 0;
		

		//sum(s+c) / sum(d) = tavg
		//c(sum(s+1)) / sum(d) = tavg
		int temp = n;
		while(temp-- > 0)
		{
			String[] lineParts = br.readLine().split(" ");
			int d = Integer.parseInt(lineParts[0]);
			int s = Integer.parseInt(lineParts[1]);
			
			sumS += (s+1);
			sumD += d;
		}
		
		sumS = Math.abs(sumS);
		
		double avgTime = t/n;
		double c = (avgTime*sumD)/sumS;
		
		bw.write(Double.toString(c) + "\n");
		

		bw.close(); //Cleanup the writer
		br.close(); //Cleanup the reader
	}
}