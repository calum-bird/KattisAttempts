import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

//Author: Calum Bird
//Age: 17
//School: Mount Allison University

public class Classy
{
	static BufferedReader br;
	static BufferedWriter bw;
	
	static int maxLength = 0;
	
	public static void main(String[] args) throws Exception
	{
		br = new BufferedReader(new InputStreamReader(System.in)); //Initialize the input reader
		bw = new BufferedWriter(new OutputStreamWriter(System.out)); //Initialize the output writer
		
		
		int count = Integer.parseInt(br.readLine());
		
        for (int i = 0; i < count; i++)
        {
            int size = Integer.parseInt(br.readLine());
            
            ClassNamePair[] individuals = new ClassNamePair[size];
            
            for (int j = 0; j < size; j++)
            {
            	String[] lineParts = br.readLine().split(":");
            	
                String name = lineParts[0];
                String classStr = lineParts[1].substring(0, lineParts[1].length() - 5).trim();
                
                individuals[j] = new ClassNamePair(name, classStr.split("-"));
            }
            
            Arrays.sort(individuals);
            
            for (ClassNamePair p : individuals)
            {
            	bw.write(p.name + "\n");
            }
            bw.write("==============================\n");
        }

		bw.close(); //Cleanup the writer
		br.close(); //Cleanup the reader
	}
}

class ClassNamePair implements Comparable<ClassNamePair>
{
	public final String name;
    private String compareString;

    public ClassNamePair(String name, String[] classes)
    {
        this.name = name;
        char[] tmp = new char[10];
        
        for (int i = 0; i < classes.length; i++)
        {
        	tmp[i] = convertCharToNumber(classes[classes.length - i - 1]);
        }
        for (int i = classes.length; i < 10; i++)
        {
        	tmp[i] = '1';
        }
        
        this.compareString = new String(tmp);
    }

    private char convertCharToNumber(String s)
    {
        return s.charAt(0) == 'u' ? '0' : s.charAt(0) == 'm' ? '1' : '2';
    }

    @Override
    public int compareTo(ClassNamePair pair)
    {
        int x = this.compareString.compareTo(pair.compareString);
        
        return x == 0 ? this.name.compareTo(pair.name) : x;
    }
}

/* TEST CASE
2
5
mom: upper-upper-lower-middle class
dad: middle-middle-middle-lower-middle class
queenelizabeth: upper-upper-upper class
chair: lower-lower class
unclebob: middle-middle-lower-middle class
5
mom: upper-upper-lower-middle class
dad: middle-middle-middle-lower-middle class
queenelizabeth: upper-upper-upper class
chair: lower-lower class
unclebob: upper class

*/