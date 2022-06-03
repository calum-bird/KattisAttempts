import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//Author: Calum Bird
//Age: 17
//School: Mount Allison University

public class Cetvrta
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in)); //Initialize the input reader
		BufferedWriter bw =  new BufferedWriter(new OutputStreamWriter(System.out)); //Initialize the output writer
		
		String[] vertex1 = br.readLine().split(" "); //Read first vertice
		String[] vertex2 = br.readLine().split(" "); //Read second vertice
		String[] vertex3 = br.readLine().split(" "); //Read third vertice
		
		int[] xVals = new int[3];
		int[] yVals = new int[3];
		
		xVals[0] = Integer.parseInt(vertex1[0]);
		xVals[1] = Integer.parseInt(vertex2[0]);
		xVals[2] = Integer.parseInt(vertex3[0]);

		yVals[0] = Integer.parseInt(vertex1[1]);
		yVals[1] = Integer.parseInt(vertex2[1]);
		yVals[2] = Integer.parseInt(vertex3[1]);
		
		int xPoint = findSingle(xVals);
		int yPoint = findSingle(yVals);
		
		bw.write(Integer.toString(xPoint) + " " + Integer.toString(yPoint));	

		bw.close(); //Cleanup the writer
		br.close(); //Cleanup the reader
	}
	
	private static int findSingle(int ar[]) 
    { 
        // Do XOR of all elements and return 
        int res = ar[0]; 
        for (int i = 1; i < ar.length; i++) 
            res = res ^ ar[i]; 
      
        return res; 
    } 
}