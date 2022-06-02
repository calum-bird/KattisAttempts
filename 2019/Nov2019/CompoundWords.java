import java.io.*;
import java.util.*;

public class CompoundWords
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		ArrayList<String> wordList = new ArrayList<String>();
		
		String line = br.readLine();
		while(line != null)
		{
			String[] words = line.split(" ");
			for(String w: words)
			{
				wordList.add(w);
			}
			
			line = br.readLine();
		}
		
		ArrayList<String> res = new ArrayList<String>();
		for(String w: wordList)
		{
			for(String w2: wordList)
			{
				String compound = w + w2;
				if(!w.equals(w2) && !res.contains(compound))
				{
					res.add(compound);
				}
			}
		}
		
		Collections.sort(res);
		
		for(String w: res)
		{
			bw.write(w + "\n");
		}
		
		br.close();
		bw.close();
	}
}
