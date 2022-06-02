import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//Author: Calum Bird
//Age: 17
//School: Mount Allison University

public class Bela
{
	static char dominant;
	
	public static void main(String[] args) throws Exception
	{
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in)); //Initialize the input reader
		BufferedWriter bw =  new BufferedWriter(new OutputStreamWriter(System.out)); //Initialize the output writer
		
		String[] parts = br.readLine().split(" "); //Read first line
		int hands = 4 * Integer.parseInt(parts[0]);
		dominant = parts[1].toCharArray()[0];
		
		int points = 0;
		
		for(int i = 0; i < hands; i++)
		{
			String line = br.readLine();
			points += getValue(line.toCharArray()[0], line.toCharArray()[1]);
		}
		
		bw.write(Integer.toString(points));
		
		bw.close(); //Cleanup the writer
		br.close(); //Cleanup the reader
	}
	
	private static int getValue(char card, char suit)
	{
		if(suit == dominant)
		{
			switch (card)
			{
				case 'A':
					return 11;
				case 'K':
					return 4;
				case 'Q':
					return 3;
				case 'J':
					return 20;
				case 'T':
					return 10;
				case '9':
					return 14;
				case '8':
					return 0;
				case '7':
					return 0;
			}
		}
		else
		{
			switch (card)
			{
				case 'A':
					return 11;
				case 'K':
					return 4;
				case 'Q':
					return 3;
				case 'J':
					return 2;
				case 'T':
					return 10;
				case '9':
					return 0;
				case '8':
					return 0;
				case '7':
					return 0;
			}
		}
		
		return 0;
	}
}