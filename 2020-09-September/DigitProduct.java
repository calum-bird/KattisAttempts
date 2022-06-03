import java.io.*;
import java.util.*;

public class DigitProduct
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] num = br.readLine().toCharArray();
        boolean solved = false;

        while(!solved)
        {
            num = multiplyDigits(num);
            if(num.length == 1){
                solved = true;
            }
        }

        System.out.println(num);

        br.close();
    }

    private static char[] multiplyDigits(char[] n)
    {
        int digit;

        int multiple = 1;

        for(int i = 0; i < n.length; i++) {
            digit = n[i] - 48;

            if(digit != 0) {
                multiple *= digit;
            }
        }

        return Integer.toString(multiple).toCharArray();
    }
}