import java.io.*;

public class Herman
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        double n = Double.parseDouble(br.readLine());
        double regular = n*n*Math.PI;
        double newSystem = 2*n*n;

        System.out.print(regular + "\n" + newSystem);

        br.close();
    }
}