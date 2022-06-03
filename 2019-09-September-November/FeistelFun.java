import java.io.BufferedReader;
import java.io.InputStreamReader;

//Author: Calum Bird
//Age: 17
//School: Mount Allison University

public class FeistelFun
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //Initialize the input reader
		
		int[] vals = new int[40];
		vals[0] = 0;
		vals[1] = 0;
		vals[2] = 0;
		vals[3] = 0;
		vals[4] = 0;
		vals[5] = 0;
		vals[6] = 0;
		vals[7] = 0;
		vals[8] = 0;
		vals[9] = 0;
		vals[10] = 0;
		vals[11] = 0;
		vals[12] = 0;
		vals[13] = 0;
		vals[14] = 0;
		vals[15] = 0;
		vals[16] = 0;
		vals[17] = 0;
		vals[18] = 0;
		vals[19] = 0;
		vals[20] = 0;
		vals[21] = 0;
		vals[22] = 0;
		vals[23] = 0;
		vals[24] = 0;
		vals[25] = 0;
		vals[26] = 0;
		vals[27] = 0;
		vals[28] = 0;
		vals[29] = 0;
		vals[30] = 0;
		vals[31] = 0;
		vals[32] = 0;
		vals[33] = 0;
		vals[34] = 0;
		vals[35] = 0;
		vals[36] = 0;
		vals[37] = 0;
		vals[38] = 0;
		vals[39] = 0;
		
		int n = Integer.parseInt(br.readLine());
		
		System.out.println(Integer.toString(vals[n-1]));
		
		br.close(); //Cleanup the reader
	}
}