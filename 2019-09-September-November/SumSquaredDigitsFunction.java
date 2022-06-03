import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;

//Author: Calum Bird
//Age: 17
//School: Mount Allison University

public class SumSquaredDigitsFunction
{
	static HashMap<Character, Integer> hexMap = new HashMap<>();
	
	public static void main(String[] args) throws Exception
	{
		hexMap.put('a', 10);
		hexMap.put('b', 11);
		hexMap.put('c', 12);
		hexMap.put('d', 13);
		hexMap.put('e', 14);
		hexMap.put('f', 15);
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in)); //Initialize the input reader
		BufferedWriter bw =  new BufferedWriter(new OutputStreamWriter(System.out)); //Initialize the output writer
		
		int P = Integer.parseInt(br.readLine()); //Read first line
		
		for(int i = 0; i < P; i++)
		{
			String[] lineParts = br.readLine().split(" ");
			int K = Integer.parseInt(lineParts[0]);
			int B = Integer.parseInt(lineParts[1]);
			int N = Integer.parseInt(lineParts[2]);
			
			bw.write(Integer.toString(K) + " " + sumDigits(changeBase(Integer.toString(N), 10, B)) + "\n");
		}

		bw.close(); //Cleanup the writer
		br.close(); //Cleanup the reader
	}
	
	public static int sumDigits(String number)
	{
		char[] numberChars = number.toCharArray();
		int sum = 0;
		
		for(char c: numberChars)
		{
			int n;
			if(c >= 'a')
				n = hexMap.get(c);
			else
				n = Integer.parseInt(Character.toString(c));
			
			sum += (n * n);
		}
		
		return sum;
	}
	
	public static String changeBase(String number, int fromBase, int toBase)
	{
		String newNum = Integer.toString(Integer.parseInt(number, fromBase), toBase);
	    return newNum;
	}
}