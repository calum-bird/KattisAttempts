import java.io.*;
import java.util.*;

public class C
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] params = br.readLine().split(" ");

        // Rows
        int r = Integer.parseInt(params[0]);
        // Columns
        int c = Integer.parseInt(params[1]);

        // Starting row
        int i = Integer.parseInt(params[2]);

        // Ending row
        int j = Integer.parseInt(params[3]);

        // Number of steps
        long n = Long.parseLong(params[4]);


        // Initialize our grid
        char[][] grid = new char[r][c];
        for(char[] row: grid)
        {
            Arrays.fill(row, '.');
        }



        // Run pacman algorithm

        // 0 = up, 1 = right, so on & so forth
        int currDir = 0;
        int stepSize = 1;
        char currColour = 'A';
        int currX = 0, currY = 0;
        for(long i = 0; i < n; i++)
        {

            currDir
            stepSize++;
        }



        // Output the grid
        StringBuilder sb = new StringBuilder();
        
        for(int k = 0; k < grid.length; k++)
        {
            sb.append(new String(grid[k]));
            if(k + 1 < grid.length) sb.append('\n');
        }
        System.out.println(sb);

        br.close();
    }
}