import java.io.*;
import java.util.*;

public class D
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] params = br.readLine().split(" ");
        int n = Integer.parseInt(params[0]);
        int m = Integer.parseInt(params[1]);

        HashMap<Integer, Integer> detectors = new HashMap<Integer, Integer>();

        for(int i = 0; i < n; i++)
        {
            String[] detector = br.readLine().split(" ");
            int p = Integer.parseInt(detector[0]);
            int c = Integer.parseInt(detector[1]);

            detectors.put(p, c);
        }

        System.out.println(detectors.toString());


        br.close();
    }
}