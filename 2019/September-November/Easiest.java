import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Scanner;

//Author: Calum Bird
//Age: 17
//School: Mount Allison University

public class Easiest
{
	public static void main(String[] args) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); //Initialize the output writer
		
		while(sc.hasNext())
		{
			String line = sc.nextLine();
			
		}

		bw.close(); //Cleanup the writer
		sc.close();
	}
	
	static int sumOfDigits(int n)
	{
		int sum = 0;
		while(n > 0)
		{
			sum += n % 10;
			n /= 10;
		}
		
		return sum;
	}
}