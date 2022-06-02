import java.io.*;
import java.util.*;

public class PrintingCosts
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		HashMap<Character, Integer> costs = new HashMap<Character, Integer>();
		costs.put(' ', 0);
		costs.put('!', 9);
		costs.put('"', 6);
		costs.put('#', 24);
		costs.put('$', 29);
		costs.put('%', 22);
		costs.put('&', 24);
		costs.put('\'', 3);
		costs.put('(', 12);
		costs.put(')', 12);
		costs.put('*', 17);
		costs.put('+', 13);
		costs.put(',', 7);
		costs.put('-', 7);
		costs.put('.', 4);
		costs.put('/', 10);
		costs.put('0', 22);
		costs.put('1', 19);
		costs.put('2', 22);
		costs.put('3', 23);
		costs.put('4', 21);
		costs.put('5', 27);
		costs.put('6', 26);
		costs.put('7', 16);
		costs.put('8', 23);
		costs.put('9', 26);
		costs.put(':', 8);
		costs.put(';', 11);
		costs.put('<', 10);
		costs.put('=', 14);
		costs.put('>', 10);
		costs.put('?', 15);
		costs.put('@', 32);
		costs.put('A', 24);
		costs.put('B', 29);
		costs.put('C', 20);
		costs.put('D', 26);
		costs.put('E', 26);
		costs.put('F', 20);
		costs.put('G', 25);
		costs.put('H', 25);
		costs.put('I', 18);
		costs.put('J', 18);
		costs.put('K', 21);
		costs.put('L', 16);
		costs.put('M', 28);
		costs.put('N', 25);
		costs.put('O', 26);
		costs.put('P', 23);
		costs.put('Q', 31);
		costs.put('R', 28);
		costs.put('S', 25);
		costs.put('T', 16);
		costs.put('U', 23);
		costs.put('V', 19);
		costs.put('W', 26);
		costs.put('X', 18);
		costs.put('Y', 14);
		costs.put('Z', 22);
		costs.put('[', 18);
		costs.put('\\', 10);
		costs.put(']', 18);
		costs.put('^', 7);
		costs.put('_', 8);
		costs.put('`', 3);
		costs.put('a', 23);
		costs.put('b', 25);
		costs.put('c', 17);
		costs.put('d', 25);
		costs.put('e', 23);
		costs.put('f', 18);
		costs.put('g', 30);
		costs.put('h', 21);
		costs.put('i', 15);
		costs.put('j', 20);
		costs.put('k', 21);
		costs.put('l', 16);
		costs.put('m', 22);
		costs.put('n', 18);
		costs.put('o', 20);
		costs.put('p', 25);
		costs.put('q', 25);
		costs.put('r', 13);
		costs.put('s', 21);
		costs.put('t', 17);
		costs.put('u', 17);
		costs.put('v', 13);
		costs.put('w', 19);
		costs.put('x', 13);
		costs.put('y', 24);
		costs.put('z', 19);
		costs.put('{', 18);
		costs.put('|', 12);
		costs.put('}', 18);
		costs.put('~', 9);
		
		String line = br.readLine();
		while(line != null)
		//while(!line.equals(""))
		{
			char[] charLine = line.toCharArray();
			int cost = 0;
			for(char c: charLine)
				cost += costs.get(c);
		
			bw.write(cost + "\n");
			line = br.readLine();
		}
		
		br.close();
		bw.close();
	}
}
