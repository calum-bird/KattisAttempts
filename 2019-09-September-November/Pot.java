import java.io.*;;

public class Pot
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in)); //Initialize the input reader
		BufferedWriter bw =  new BufferedWriter(new OutputStreamWriter(System.out)); //Initialize the output writer
		
		int count = Integer.parseInt(br.readLine()); //Read first line
		
		int sum = 0;
		
		for(int i = 0; i < count; i++)
		{
			char[] line = br.readLine().toCharArray();
			int pow = Character.getNumericValue(line[line.length - 1]);
			
			char[] num = new char[line.length - 1];
			
			for(int j = 0; j < line.length - 1; j++)
			{
				num[j] = line[j];
			}
			
			int number = Integer.parseInt(new String(num));
			
			sum += Math.pow(number, pow);
		}
		
		bw.write(Integer.toString(sum));
		

		bw.close(); //Cleanup the writer
		br.close(); //Cleanup the reader
	}
}