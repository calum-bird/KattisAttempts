import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//Author: Calum Bird
//Age: 17
//School: Mount Allison University

public class InverseFactorial
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in)); //Initialize the input reader
		BufferedWriter bw =  new BufferedWriter(new OutputStreamWriter(System.out)); //Initialize the output writer
		
		char[] buff = br.readLine().toCharArray();
		int x = buff.length; //Read first line
		
		if(x < 4)
		{
			double val = Double.parseDouble(new String(buff));
			bw.write(Integer.toString(preComputed(val)));
		}
		else
		{
			int num = 6;
	        double sum = 4 * Math.log10(2) + 2 * Math.log10(3) + Math.log10(5);
	        while (true)
	        {
	            sum += Math.log10(num+1);
	            if (sum > x)
	            {
	                bw.write(Integer.toString(num));
	                break;
	            }
	            
	            num++;
	        }
		}
 
		bw.close(); //Cleanup the writer
		br.close(); //Cleanup the reader
	}
	
	static int preComputed(double n)
	{
		return n == 1 ? 1 : n == 2 ? 2 : n == 6 ? 3 : n == 24 ? 4 : n == 120 ? 5 : 6;
	}
}