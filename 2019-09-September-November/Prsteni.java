import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//Author: Calum Bird
//Age: 17
//School: Mount Allison University

public class Prsteni
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in)); //Initialize the input reader
		BufferedWriter bw =  new BufferedWriter(new OutputStreamWriter(System.out)); //Initialize the output writer
		
		br.readLine(); //Read first line
		
		String[] parts = br.readLine().split(" ");
		
		int first = 0;
		
		for(String p: parts)
		{
			if(first != 0)
			{
				int r = Integer.parseInt(p);
				
				bw.write(simplifyFraction(first, r) + "\n");
			}
			else
			{
				first = Integer.parseInt(p);
			}
		}

		bw.close(); //Cleanup the writer
		br.close(); //Cleanup the reader
	}
	
	private static String simplifyFraction(int num, int divisor)
	{
		int smaller = num < divisor ? num : divisor;
        int HCF = -1;
        for (int i = smaller; i > 0; --i) {
            if (num % i == 0 && divisor % i == 0) {
                HCF = i;
                return (num/HCF)+"/"+(divisor/HCF);
            }
        }
        
        return null;
	}
}