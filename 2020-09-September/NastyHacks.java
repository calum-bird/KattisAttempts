import java.io.*;

public class NastyHacks
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        while(n-- > 0)
        {
            String[] params = br.readLine().split(" ");
            int revenue = Integer.parseInt(params[0]);

            int expected = Integer.parseInt(params[1]);

            int cost = Integer.parseInt(params[2]);
            

            if(expected - cost > revenue)
            {
                System.out.println("advertise");
            }
            else if(expected - cost == revenue)
            {
                System.out.println("does not matter");
            }
            else
            {
                System.out.println("do not advertise");
            }
        }

        br.close();
    }
}