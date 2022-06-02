import java.io.*;

public class Filip
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in)); //Initialize the input reader
		BufferedWriter bw =  new BufferedWriter(new OutputStreamWriter(System.out)); //Initialize the output writer
		
		String[] parts = br.readLine().split(" "); //Read first line
		
		int num1 = reverseNum(Integer.parseInt(parts[0]));
		int num2 = reverseNum(Integer.parseInt(parts[1]));
		
		bw.write(Integer.toString(Math.max(num1, num2)));

		bw.close(); //Cleanup the writer
		br.close(); //Cleanup the reader
	}
	
	private static int reverseNum(int num)
	{
		int rev = 0;
        while(num != 0)
        {
            int dig = num % 10;
            rev = rev * 10 + dig;
            num /= 10;
        }
        
        return rev;
	}
	
}