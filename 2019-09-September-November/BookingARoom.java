import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//Author: Calum Bird
//Age: 17
//School: Mount Allison University

public class BookingARoom
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in)); //Initialize the input reader
		BufferedWriter bw =  new BufferedWriter(new OutputStreamWriter(System.out)); //Initialize the output writer
		
		String[] parts = br.readLine().split(" ");
		int roomCount = Integer.parseInt(parts[0]); //Read first integer, r
		int bookedCount = Integer.parseInt(parts[1]); //Read second integer, n
		
		int[] bookedRooms = new int[bookedCount];
		
		for(int i = 0; i < bookedCount; i++)
		{
			int roomNum = Integer.parseInt(br.readLine());
			bookedRooms[i] = roomNum;
		}
		
		if(bookedCount == roomCount)
			bw.write("too late");
		else
		{
			for(int i = 1; i < roomCount + 1; i++)
			{
				boolean booked = false;
				for(int j = 0; j < bookedRooms.length; j++)
				{
					if(bookedRooms[j] == i)
						booked = true;
				}
				
				if(!booked)
				{
					bw.write(Integer.toString(i) + "\n");
					break;
				}
			}
		}

		bw.close(); //Cleanup the writer
		br.close(); //Cleanup the reader
	}
}