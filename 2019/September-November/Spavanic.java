import java.io.*;

public class Spavanic
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in)); //Initialize the input reader
		BufferedWriter bw =  new BufferedWriter(new OutputStreamWriter(System.out)); //Initialize the output writer
		
		String[] parts = br.readLine().split(" "); //Read first line
		
		int hours = Integer.parseInt(parts[0]);
		int minutes = Integer.parseInt(parts[1]);
		
		if(minutes > 45)
		{
			minutes -= 45;
		}
		else
		{
			if(hours == 0 && minutes <= 45)
			{
				hours = 23;
				minutes = (minutes - 45) + 60;
			}
			else
			{
				hours--;
				minutes += 15;
			}
		}
		
		bw.write(hours + " " + minutes);
		

		bw.close(); //Cleanup the writer
		br.close(); //Cleanup the reader
	}
}
