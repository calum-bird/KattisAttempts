import java.io.*;
import java.util.*;

public class Skocimis
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] params = br.readLine().split(" ");
		int a = Integer.parseInt(params[0]);
		int b = Integer.parseInt(params[1]);
		int c = Integer.parseInt(params[2]);
		
		bw.write((c-b-1) + "");
		
		br.close();
		bw.close();
	}
}
