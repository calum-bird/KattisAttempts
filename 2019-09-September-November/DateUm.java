import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
//Author: Calum Bird
//Age: 17
//School: Mount Allison University
import java.util.Date;

public class DateUm
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in)); //Initialize the input reader
		BufferedWriter bw =  new BufferedWriter(new OutputStreamWriter(System.out)); //Initialize the output writer
		
		String[] parts = br.readLine().split(" "); //Read the input line
		
		int num1 = Integer.parseInt(parts[0]);
		int num2 = Integer.parseInt(parts[1]);
		
		String input_date= num1 + "/" + num2 + "/2009";
		SimpleDateFormat format1 = new SimpleDateFormat("dd/MM/yyyy");
		
		Date date = format1.parse(input_date);
		
		DateFormat format2 = new SimpleDateFormat("EEEE");
		
		String dayOfWeek = format2.format(date);
		
		bw.write(dayOfWeek);

		bw.close(); //Cleanup the writer
		br.close(); //Cleanup the reader
	}
}