//Author: Calum Bird
//Age: 17
//School: Mount Allison University

public class basketballoneonone
{
	public static void main(String[] args) throws Exception
	{
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out, "ASCII"), 8);
		int secondLast = 0;
		int last = 0;
		
		while(true)
		{
			last = System.in.read();
			if(last == 10)
			{
				System.out.append((char)secondLast);
				break;
			}
			else if(last >= 65)
			{
				secondLast = last;
			}
		}
	}
}