import java.io.*;
import java.util.*;

public class TextureAnalysis
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        String line = br.readLine();
        int counter = 1;
        while(!line.equals("END"))
        {
            char[] str = line.toCharArray();

            HashSet<Integer> counters = new HashSet<Integer>();
            int currCounter = 0;
            for(int i = 0; i < str.length; i++)
            {
                if(str[i] == '*')
                {
                    if(i != 0)
                    {
                        counters.add(currCounter);
                    }

                    currCounter = 0;
                }
                else if(str[i] == '.')
                {
                    currCounter++;
                }
            }


            if(counters.size() > 1)
            {
                sb.append(counter);
                sb.append(" NOT EVEN\n");
            }
            else
            {
                sb.append(counter);
                sb.append(" EVEN\n");
            }

            counter++;
            line = br.readLine();
        }

        System.out.print(sb);

        br.close();
    }
}