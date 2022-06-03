import java.io.*;
import java.util.*;

public class B
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String group = br.readLine();

        int aCount = 0, bCount = 0, cCount = 0;

        for(char c: group.toCharArray())
        {
            if(c == 'A')
            {
                aCount++;
            }
            else if(c == 'B')
            {
                bCount++;
            }
            else if(c == 'C')
            {
                cCount++;
            }
        }

        group += group;

        int[][] prefixes = new int[3][n*2];

        print2DArray(prefixes);


        br.close();
    }

    static void print2DArray(int[][] arr)
    {
        System.out.print("[\n");
        for(int i = 0; i < arr.length; i++)
        {
            System.out.print("{");
            for(int j = 0; j < arr[i].length; j++)
            {
                System.out.print(arr[i][j] + ",");
            }
            System.out.print("},\n");
        }
        System.out.print("]\n");
    }
}