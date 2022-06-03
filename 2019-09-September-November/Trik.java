import java.io.*;

public class Trik
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in)); //Initialize the input reader
		BufferedWriter bw =  new BufferedWriter(new OutputStreamWriter(System.out)); //Initialize the output writer
		
		char[] chars = br.readLine().toCharArray(); //Read first line
		
		int place = 1;
		
		for(char c: chars)
		{
			if(c == 'A')
			{
				switch (place)
				{
					case (1):
						place = 2;
						break;
					case (2):
						place = 1;
						break;
					case (3):
						place = 3;
						break;
				}
			}
			else if(c == 'B')
			{
				switch (place)
				{
					case (1):
						place = 1;
						break;
					case (2):
						place = 3;
						break;
					case (3):
						place = 2;
						break;
				}
			}
			else
			{
				switch (place)
				{
					case (1):
						place = 3;
						break;
					case (2):
						place = 2;
						break;
					case (3):
						place = 1;
						break;
				}
			}
		}
		
		bw.write(Integer.toString(place));

		bw.close(); //Cleanup the writer
		br.close(); //Cleanup the reader
	}
}