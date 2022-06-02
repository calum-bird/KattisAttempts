import java.io.*;

public class I
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++)
        {
            int moves = Integer.parseInt(br.readLine());

            double currX = 0;
            double currY = 0;

            // In degrees, will need to convert later to radians
            double currAngle = 0;

            for(int j = 0; j < moves; j++)
            {
                String[] params = br.readLine().split(" ");

                double rotation = Double.parseDouble(params[0]);
                double dist = Double.parseDouble(params[1]);

                currAngle += rotation;

                currX += Math.sin(-1*rad(currAngle))*dist;
                currY += Math.cos(-1*rad(currAngle))*dist;
            }

            System.out.println(Double.toString(currX) + " " + Double.toString(currY));
        }

        br.close();
    }

    public static double rad(double deg) {
        return (deg/180.0)*Math.PI;
    } 
}