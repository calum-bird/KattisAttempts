import java.io.*;

public class NastyHacks
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in)); //Initialize the input reader
		BufferedWriter bw =  new BufferedWriter(new OutputStreamWriter(System.out)); //Initialize the output writer
		
		int cases = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < cases; i++)
		{
		    String[] splitLine = br.readLine().split(" ");
		    
		    if(Integer.parseInt(splitLine[1]) - Integer.parseInt(splitLine[2]) > Integer.parseInt(splitLine[0]))
		        bw.write("advertise \n");
		    
		    else if(Integer.parseInt(splitLine[1]) - Integer.parseInt(splitLine[2]) == Integer.parseInt(splitLine[0]))
		    	bw.write("does not matter \n");
		    
		    else
		    	bw.write("do not advertise \n");
		}
		
		

		bw.close(); //Cleanup the writer
		br.close(); //Cleanup the reader
	}
}

