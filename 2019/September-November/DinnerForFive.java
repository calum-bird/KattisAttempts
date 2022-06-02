import java.io.*;
import java.util.Arrays;

public class DinnerForFive
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in)); //Initialize the input reader
		BufferedWriter bw =  new BufferedWriter(new OutputStreamWriter(System.out)); //Initialize the output writer
		
        int HS = 0;
        int winner = 0;
        for(int i = 1; i < 6; i++){
            int iSum = Arrays.stream(br.readLine().split(" ")).mapToInt((String s) -> Integer.parseInt(s)).sum();
            if(HS < iSum) {
                winner = i;
                HS = iSum;
            }
        }
        System.out.print(winner + " " + HS);

		bw.close(); //Cleanup the writer
		br.close(); //Cleanup the reader
	}
}