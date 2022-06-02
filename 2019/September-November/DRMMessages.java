import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//Author: Calum Bird
//Age: 17
//School: Mount Allison University

public class DRMMessages
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in)); //Initialize the input reader
		BufferedWriter bw =  new BufferedWriter(new OutputStreamWriter(System.out)); //Initialize the output writer
		
		char[] line = br.readLine().toCharArray(); //Read first line
		int mid = line.length/2;
		
		char[] firstHalf = new char[mid];
		char[] secondHalf = new char[line.length - mid];

		for(int i = 0; i < line.length; i++)
		{
			if(i < mid)
				firstHalf[i] = line[i];
			else
				secondHalf[i - mid] = line[i];
		}
		
		char[] rotatedFirst = Rotate(firstHalf).toCharArray();
		char[] rotatedSecond = Rotate(secondHalf).toCharArray();
		
		String merged = Merge(rotatedFirst, rotatedSecond);
		
		bw.write(merged + "\n");
		
		bw.close(); //Cleanup the writer
		br.close(); //Cleanup the reader
	}
	
	private static String Merge(char[] first, char[] second)
	{
		char[] newString = new char[(first.length >= second.length)? first.length : second.length];
		
		for(int i = 0; i < newString.length; i++)
		{
			char newChar = (char) (((first[i] - 'A' + ((int)second[i] - 65)) % 26) + 'A');
			newString[i] = newChar;
		}
		
		return new String(newString);
	}
	
	private static String Rotate(char[] num)
	{
		char[] res = new char[num.length];
		int sum = 0;
		for(char c: num)
		{
			sum += (int)c - 65;
		}
		
		for(int i = 0; i < num.length; i++)
		{
			char newChar = (char) (((num[i] - 'A' + sum) % 26) + 'A');
			res[i] = newChar;
		}
		
		return new String(res);
	}
}