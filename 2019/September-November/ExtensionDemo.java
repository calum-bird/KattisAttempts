import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//Author: Calum Bird
//Age: 17
//School: Mount Allison University

public class ExtensionDemo
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //Initialize the input reader
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); //Initialize the output writer
		
		int n = Integer.parseInt(br.readLine()); //Read first line
		test t = new test();
		test2 t2 = new test2();
		while(n-- > 0)
		{
			t.printHello();
			t2.printHello();
		}
		

		bw.close(); //Cleanup the writer
		br.close(); //Cleanup the reader
	}
}

class test2 extends test
{
	void printNo()
	{
		System.out.println("Nope.");
	}
	/*
	void printHello() this is commented out
	{
		System.out.println("Overrided Hello, world!");
	}*/
}

class test
{
	void printHello()
	{
		System.out.println("Hello, world");
	}
}