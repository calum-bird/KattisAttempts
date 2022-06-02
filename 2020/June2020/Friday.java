import java.util.*;
import java.io.*;

public class Friday
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int cases = Integer.parseInt(br.readLine());
        while(cases-- > 0)
        {
            int counter = 0;

            String[] params = br.readLine().split(" ");
            int days = Integer.parseInt(params[0]);
            int months = Integer.parseInt(params[1]);
            int currDay = 0;

            String[] monthLengths = br.readLine().split(" ");
            for(int i = 0; i < months; i++)
            {
                int numDays = Integer.parseInt(monthLengths[i]);
                for(int j = 0; j < numDays; j++)
                {
                    if(currDay == 5 && j == 12)
                    {
                        counter++;
                    }

                    currDay = ++currDay % 7;
                }
            }

            System.out.println(Integer.toString(counter));

        }

        br.close();
    }
}