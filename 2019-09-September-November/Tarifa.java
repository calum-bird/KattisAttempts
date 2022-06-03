import java.io.*;

public class Tarifa
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in)); //Initialize the input reader
		BufferedWriter bw =  new BufferedWriter(new OutputStreamWriter(System.out)); //Initialize the output writer
		
		int dataPerMonth = Integer.parseInt(br.readLine()); //Read the data per month
		int months = Integer.parseInt(br.readLine()); //Get the number of months
		
		int quota = dataPerMonth * months; //Define quota of data per month
		
		int usage = 0; //Define usage for later use
		
		for(int i = 0; i < months; i++)
		{
			usage += Integer.parseInt(br.readLine()); //For every month specified add the usage
		}
		
		int nextMonth = (quota - usage) + dataPerMonth; //Output the N+1 month's data allowance
		
		bw.write(Integer.toString(nextMonth)); //Output the next month's data allowance
		
		

		bw.close(); //Cleanup the writer
		br.close(); //Cleanup the reader
	}
}