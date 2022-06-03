import java.io.*;

public class ProvincesGold
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in)); //Initialize the input reader
		BufferedWriter bw =  new BufferedWriter(new OutputStreamWriter(System.out)); //Initialize the output writer
		
		String[] parts = br.readLine().split(" "); //Read first line
		
		int wallet = 0;
		
		for(int i = 0; i < parts.length; i++)
		{
			switch (i)
			{
				case 0:
					wallet += (3 * Integer.parseInt(parts[i]));
					break;
				case 1:
					wallet += (2 * Integer.parseInt(parts[i]));
					break;
				case 2:
					wallet += (1 * Integer.parseInt(parts[i]));
					break;
			}
		}
		
		
		if(wallet <= 1)
		{
			bw.write("Copper");
		}
		else if(wallet > 1 && wallet < 3)
		{
			bw.write("Estate or Copper");
		}
		else if(wallet >= 3 && wallet < 5)
		{
			bw.write("Estate or Silver");
		}
		else if(wallet >= 5 && wallet < 6)
		{
			bw.write("Duchy or Silver");
		}
		else if(wallet >= 6 && wallet < 8)
		{
			bw.write("Duchy or Gold");
		}
		else
		{
			bw.write("Province or Gold");
		}

		bw.close(); //Cleanup the writer
		br.close(); //Cleanup the reader
	}
}