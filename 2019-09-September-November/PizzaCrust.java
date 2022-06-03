import java.io.*;

public class PizzaCrust
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in)); //Initialize the input reader
		BufferedWriter bw =  new BufferedWriter(new OutputStreamWriter(System.out)); //Initialize the output writer
		
		String line = br.readLine(); //Read first line
		
		String[] parts = line.split(" ");
		int R = Integer.parseInt(parts[0]);
		int C = Integer.parseInt(parts[1]);
		
		float areaPizza = (float)Math.PI * R * R;
		float areaCheese = (float)Math.PI * (R - C) * (R - C);
		
		float percentageCheese =  (100 * areaCheese/areaPizza);
		
		bw.write(Float.toString(percentageCheese));

		bw.close(); //Cleanup the writer
		br.close(); //Cleanup the reader
	}
}