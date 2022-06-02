import java.io.*;
import java.util.*;

public class Supercomputer
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] params = br.readLine().split(" ");
		int n = Integer.parseInt(params[0])-1;
		BitSet bs = new BitSet(n);
		
		int k = Integer.parseInt(params[1]);
		
		int arg1,arg2,i;
		
		StringBuilder sb = new StringBuilder();
		
		while(k-- > 0)
		{
			String[] cmd = br.readLine().split(" ");
			arg1 = Integer.parseInt(cmd[1]) - 1;
			if(cmd[0].equals("C"))
			{
				arg2 = Integer.parseInt(cmd[2]);
				sb.append(bs.get(arg1, arg2).cardinality() + "\n");
			}
			else
			{
				bs.flip(arg1);
			}
		}
		
		System.out.print(sb);
			
		br.close();
	}
}
