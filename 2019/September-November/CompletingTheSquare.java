import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

//Author: Calum Bird
//Age: 17
//School: Mount Allison University

public class CompletingTheSquare
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in)); //Initialize the input reader
		BufferedWriter bw =  new BufferedWriter(new OutputStreamWriter(System.out)); //Initialize the output writer
		
		String[] parts1 = br.readLine().split(" ");
		String[] parts2 = br.readLine().split(" ");
		String[] parts3 = br.readLine().split(" ");
		
		ArrayList<Integer> xCoords = new ArrayList<Integer>();
		xCoords.add(Integer.parseInt(parts1[0]));
		xCoords.add(Integer.parseInt(parts2[0]));
		xCoords.add(Integer.parseInt(parts3[0]));
		
		ArrayList<Integer> yCoords = new ArrayList<Integer>();
		yCoords.add(Integer.parseInt(parts1[1]));
		yCoords.add(Integer.parseInt(parts2[1]));
		yCoords.add(Integer.parseInt(parts3[1]));
		
		double euclidianBaseDistance1 = euclidianDistance(xCoords.get(0), yCoords.get(0), xCoords.get(1), yCoords.get(1));
		double euclidianBaseDistance2 = euclidianDistance(xCoords.get(1), yCoords.get(1), xCoords.get(2), yCoords.get(2));
		double euclidianBaseDistance3 = euclidianDistance(xCoords.get(2), yCoords.get(2), xCoords.get(1), yCoords.get(1));
		
		int midPointX, midPointY;
		
		if(euclidianBaseDistance1 > euclidianBaseDistance2 && euclidianBaseDistance1 > euclidianBaseDistance3)
		{
			midPointX = xCoords.get(2);
			midPointY = yCoords.get(2);
			xCoords.remove(2);
			yCoords.remove(2);
		}
		else if(euclidianBaseDistance2 > euclidianBaseDistance1 && euclidianBaseDistance2 > euclidianBaseDistance3)
		{
			midPointX = xCoords.get(0);
			midPointY = yCoords.get(0);
			xCoords.remove(0);
			yCoords.remove(0);
		}
		else
		{
			midPointX = xCoords.get(1);
			midPointY = yCoords.get(1);
			xCoords.remove(1);
			yCoords.remove(1);
		}
		
		int newX = xCoords.get(0) + xCoords.get(1) - midPointX;
		int newY = yCoords.get(0) + yCoords.get(1) - midPointY;
		
		bw.write(newX + " " + newY + "\n");
		

		bw.close(); //Cleanup the writer
		br.close(); //Cleanup the reader
	}
	
	private static double euclidianDistance(int x1, int y1, int x2, int y2)
	{
		return Math.sqrt(Math.pow(Math.abs(x2-x1), 2) + Math.pow(Math.abs(y2-y1), 2));
	}
}