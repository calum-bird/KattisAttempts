import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Random;

//Author: Calum Bird
//Age: 17
//School: Mount Allison University

public class NeuralNet
{
	public static void main(String[] args) throws Exception
	{
		BufferedWriter bw =  new BufferedWriter(new OutputStreamWriter(System.out)); //Initialize the output writer
		
		Random r = new Random();
		
		for(int i = 0; i < 150; i++)
		{
			for(int j = 0; j < 51; j++)
			{
				if(r.nextBoolean())
					bw.write(r.nextDouble() + " ");
				else
					bw.write((r.nextDouble() * -1) + " ");
			}
			bw.write("\n");
		}

		bw.close(); //Cleanup the writer
	}
}