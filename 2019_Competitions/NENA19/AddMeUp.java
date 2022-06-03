import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.HashSet;
import java.util.Hashtable;

//Author: Calum Bird
//Age: 17
//School: Mount Allison University

public class AddMeUp
{
	static HashSet<Integer> vals = new HashSet<Integer>();
	
	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //Initialize the input reader
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); //Initialize the output writer
		
		String[] l = br.readLine().split(" ");
		int n = Integer.parseInt(l[0]);
		int s = Integer.parseInt(l[1]);
		
		String[] input = br.readLine().split(" ");
		
		for(String ln: input)
			vals.addAll(getRotatedValue(ln.toCharArray(), 0));
		
		Boolean success = false;
		
		for(int v: vals)
		{
			int sumCheck = v;
			for(int v2: vals)
			{
				int count = 1;
				if(v2 != v && count < 2)
				{
					if(sumCheck + v2 == s)
					{
						success = true;
						break;
					}
					else
					{
						count = 2;
					}
				}
			}
			if(success)
				break;
		}
		
		if(success)
		{
			bw.write("YES");
		}
		else
		{
			bw.write("No");
		}

		bw.close(); //Cleanup the writer
		br.close(); //Cleanup the reader
	}
	
	static HashSet<Integer> getRotatedValue(char[] num, int index)
	{
		HashSet<Integer> valsLoc = new HashSet<Integer>();
		
		for(int i = index; i < num.length; i++)
		{
			char c = num[i];
			int originalVal = Integer.parseInt(new String(num));
			if(!valsLoc.contains(originalVal) && !vals.contains(originalVal))
				valsLoc.add(originalVal);
			
			if(c == '5')
			{
				num[i] = '2';
				int v = Integer.parseInt(new String(num));
				if(!valsLoc.contains(v) && !vals.contains(v))
				{
					vals.add(v);
				}
				if(i+1 <= num.length)
					valsLoc.addAll(getRotatedValue(num, i+1));
				
			}
			else if(c == '2')
			{
				num[i] = '5';
				int v = Integer.parseInt(new String(num));
				if(!valsLoc.contains(v) && !vals.contains(v))
				{
					valsLoc.add(v);
				}
				if(i+1 <= num.length)
					valsLoc.addAll(getRotatedValue(num, i+1));
			}
			else if(c == '6')
			{
				num[i] = '9';
				int v = Integer.parseInt(new String(num));
				if(!valsLoc.contains(v) && !vals.contains(v))
				{
					valsLoc.add(v);
				}
				if(i+1 <= num.length)
					valsLoc.addAll(getRotatedValue(num, i+1));
			}
			else if(c == '9')
			{
				num[i] = '6';
				int v = Integer.parseInt(new String(num));
				if(!valsLoc.contains(v) && !vals.contains(v))
				{
					valsLoc.add(v);
				}
				if(i+1 <= num.length)
					valsLoc.addAll(getRotatedValue(num, i+1));
			}

		}
		
		return valsLoc;
	}
}