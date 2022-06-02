import java.io.*;
import java.util.*;

public class Herman
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		double n = Double.parseDouble(br.readLine());
		double reg = Math.PI*n*n;
		double newSys = 2*n*n;
		
		bw.write(reg + "\n" + newSys);
		
		br.close();
		bw.close();
	}
}
