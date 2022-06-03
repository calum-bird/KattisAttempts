import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

//Author: Calum Bird
//Age: 17
//School: Mount Allison University

public class PrecomputedMaximums
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //Initialize the input reader
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); //Initialize the output writer
		
		HashSet<Integer> pre = new HashSet<Integer>();
		
		
		long x = Long.parseLong(br.readLine()); //Read first line

		bw.close(); //Cleanup the writer
		br.close(); //Cleanup the reader
	}
	
	private Collection<Integer> n1()
	{
		List<Integer> l = new ArrayList<Integer>();
		l.add(0);
		l.add(1);
		l.add(2);
		l.add(3);
		l.add(4);
		l.add(5);
		l.add(6);
		l.add(7);
		l.add(8);
		l.add(9);
		l.add(10);
		l.add(11);
		l.add(12);
		l.add(13);
		l.add(14);
		l.add(15);
		l.add(16);
		l.add(17);
		l.add(18);
		l.add(19);
		l.add(20);
		l.add(21);
		
		return l;
	}
	
}