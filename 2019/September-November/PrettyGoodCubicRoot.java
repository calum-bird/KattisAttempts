import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;

//Author: Calum Bird
//Age: 17
//School: Mount Allison University

public class PrettyGoodCubicRoot
{
	public static void main(String[] args) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		
		while(sc.hasNext())
		{
			String line = sc.next();
			BigInteger val = new BigInteger(line);
			
			BigInteger res = NewtonCubicRoot(val);
			
			System.out.println(res.toString());
		}
		
		sc.close();
	}
	
	static BigInteger NewtonCubicRoot(BigInteger x) 
    {
		BigDecimal s = BigDecimal.ZERO;
		BigInteger result = BigInteger.ZERO.setBit(x.bitLength()/3);
		
		BigDecimal copy = new BigDecimal(x);
		
		while (!result.equals(s.toBigInteger()))
		{
		    s = new BigDecimal(result);

		    BigDecimal temp0 = new BigDecimal(result.shiftLeft(1));
		    BigDecimal temp1 = temp0.add(copy.divide(s.multiply(s), BigDecimal.ROUND_HALF_UP));
		    BigDecimal temp2 = temp1.divide(BigDecimal.valueOf(3), BigDecimal.ROUND_HALF_UP);
		    result = temp2.toBigInteger();
		}
		
		return result;
    }
}