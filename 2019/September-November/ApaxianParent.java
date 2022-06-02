import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//Author: Calum Bird
//Age: 17
//School: Mount Allison University

public class ApaxianParent
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //Initialize the input reader
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); //Initialize the output writer
		
		String[] parts = br.readLine().split(" ");
		char[] Y = parts[0].toCharArray();
		char[] P = parts[1].toCharArray();
		
		StringBuilder sb = new StringBuilder();
		if(Y[Y.length - 1] == 'e')
		{
			sb.append(Y).append('x').append(P);
			System.out.println(sb);
		}
		else if(Y[Y.length - 1] == 'a' || Y[Y.length - 1] == 'i' || Y[Y.length - 1] == 'o' || Y[Y.length - 1] == 'u')
		{
			sb.append(Y).replace(Y.length - 1, Y.length, "ex").append(P);
			System.out.println(sb);
		}
		else if(Y[Y.length - 1] == 'x' && Y[Y.length - 2] == 'e')
		{
			sb.append(Y).append(P);
			System.out.println(sb);
		}
		else
		{
			sb.append(Y).append("ex").append(P);
			System.out.println(sb);
		}
		

		bw.close(); //Cleanup the writer
		br.close(); //Cleanup the reader
	}
}