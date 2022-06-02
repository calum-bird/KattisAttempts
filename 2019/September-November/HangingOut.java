import java.io.*;

public class HangingOut
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in)); //Initialize the input reader
		BufferedWriter bw =  new BufferedWriter(new OutputStreamWriter(System.out)); //Initialize the output writer
		
		String[] firstParts = br.readLine().split(" "); //Read first line
		int fireLimit = Integer.parseInt(firstParts[0]);
		int events = Integer.parseInt(firstParts[1]);
		
		int onRoof = 0;
		
		int rejectedCount = 0;
		
		for(int i = 0; i < events; i++)
		{
			String[] lineParts = br.readLine().split(" ");
			if(lineParts[0].contains("enter"))
			{
				int count = Integer.parseInt(lineParts[1]);
				if(onRoof + count > fireLimit)
				{
					rejectedCount++;
				}
				else
				{
					onRoof += count;
				}
			}
			else if(lineParts[0].contains("leave"))
			{
				int count = Integer.parseInt(lineParts[1]);
				onRoof -= count;
			}
		}
		
		bw.write(Integer.toString(rejectedCount));
		

		bw.close(); //Cleanup the writer
		br.close(); //Cleanup the reader
	}
}