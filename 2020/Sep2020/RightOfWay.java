import java.io.*;
import java.util.*;

public class RightOfWay
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] directions = new int[3];

        String[] params = br.readLine().split(" ");

        for(int i = 0; i < 3; i++)
        {
            directions[i] = getDirInt(params[i]);
        }

        String ans = "No";
        if((isOpposite(directions[0], directions[1]) && isRight(directions[0], directions[2])) || (isLeft(directions[0], directions[1]) && (isOpposite(directions[0], directions[2]) || isRight(directions[0], directions[2]))))
            ans = "Yes";


        System.out.println(ans);


        br.close();
    }

    public static int getDirInt(String dir)
    {
        switch(dir)
        {
            case "North":
                return 0;
            case "East":
                return 1;
            case "South":
                return 2;
            case "West":
                return 3;
            default:
                return 0;
        }
    }

    public static boolean isLeft(int current, int goal)
    {
        if(current == 3 && goal == 0) return true;

        if(goal == current + 1) return true;

        return false;
    }

    public static boolean isRight(int current, int goal)
    {
        if(current == 0 && goal == 3) return true;

        if(goal == current - 1) return true;

        return false;
    }


    public static boolean isOpposite(int first, int second)
    {
        if(first + 2 == second || second + 2 == first) return true;

        return false;
    }
}