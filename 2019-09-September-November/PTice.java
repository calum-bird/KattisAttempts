import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//Author: Calum Bird
//Age: 17
//School: Mount Allison University

public class PTice
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //Initialize the input reader
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); //Initialize the output writer
		
		int n = Integer.parseInt(br.readLine()); //Read first line
		
		char[] correct = br.readLine().toCharArray();
		
		char[] adrian = new char[n];
		char[] bruno = new char[n];
		char[] goran = new char[n];
		
		int aCounter = 0;
		boolean bNext = false;
		char gLast = 'C';
		
		for(int i = 0; i < n; i++)
		{
			//BEGIN ADRIAN LOGIC
			adrian[i] = (aCounter == 0) ? 'A': (aCounter == 1) ? 'B': 'C';
			if(aCounter == 2)
				aCounter = 0;
			else
				aCounter++;
			//END ADRIAN LOGIC
			
			//BEGIN BRUNO LOGIC
			if(i % 2 != 0)
			{
				if(bNext)
				{
					bruno[i] = 'C';
				}
				else
				{
					bruno[i] = 'A';
				}
				bNext = !bNext;
			}
			else
			{
				bruno[i] = 'B';
			}
			//END BRUNO LOGIC
			
			
			//BEGIN GORAN LOGIC
			goran[i] = gLast;
			if(i % 2 != 0)
			{
				switch(gLast)
				{
					case 'A':
						gLast = 'B';
						break;
					case 'B':
						gLast = 'C';
						break;
					case 'C':
						if(i != 0)
							gLast = 'A';
						break;
				}
			}
			//END GORAN LOGIC
		}
		
		int adrianCount = 0;
		int brunoCount = 0;
		int goranCount = 0;
		for(int i = 0; i < n; i++)
		{
			char check = correct[i];
			if(check == adrian[i])
				adrianCount++;
			if(check == bruno[i])
				brunoCount++;
			if(check == goran[i])
				goranCount++;
		}

		System.out.println(Math.max(Math.max(adrianCount,brunoCount),goranCount) + "");
		
		if(Math.max(Math.max(adrianCount,brunoCount),goranCount) == adrianCount)
		{
			System.out.println("Adrian");
		}
		if(Math.max(Math.max(adrianCount,brunoCount),goranCount) == brunoCount)
		{
			System.out.println("Bruno");
		}
		if(Math.max(Math.max(adrianCount,brunoCount),goranCount) == goranCount)
		{
			System.out.println("Goran");
		}

		bw.close(); //Cleanup the writer
		br.close(); //Cleanup the reader
	}
}