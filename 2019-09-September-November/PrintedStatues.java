import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//Author: Calum Bird
//Age: 17
//School: Mount Allison University

public class PrintedStatues
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in)); //Initialize the input reader
		BufferedWriter bw =  new BufferedWriter(new OutputStreamWriter(System.out)); //Initialize the output writer
		
		int statues = Integer.parseInt(br.readLine());
		int printers = 1;
		int statuesPrinted = 0;
		int days = 0;

		while(statuesPrinted < statues)
		{
		    if((statues-statuesPrinted) > printers){
		        days += 1;
		        printers += printers;
		    }
		    else {
		        days += 1;
		        statuesPrinted += printers;
		    }
		}
		
		bw.write(Integer.toString(days));

		bw.close(); //Cleanup the writer
		br.close(); //Cleanup the reader
	}
}

