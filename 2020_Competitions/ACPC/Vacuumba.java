import java.util.*;

public class Vacuumba {
    public static void main(String[]args) {
        Scanner scan = new Scanner(System.in);
        int numTests = scan.nextInt();
        double currAngle = 0;
        for(int i=0;i<numTests;i++) {
            int numCases = scan.nextInt();
            double x=0;
            double y=0;
            for(int j=0;j<numCases;j++) {
                double angle = scan.nextDouble();
                //currAngle = angle;
                double distance = scan.nextDouble();
                //System.out.println(x + " " + y);
                x = x + (Math.sin(-1*rad(angle))*distance);
                y = y + (Math.cos(-1*rad(angle))*distance);
                //System.out.println(x + " " + y);
            }
            System.out.println(x + " " + y);
        }
    }

    public static double rad(double deg) {
        return (deg/180.0)*Math.PI;
    }
    
}
