import java.math.BigInteger;
import java.util.Random;

	static Random randy = new Random();
	static int certainty = 100; //higher number means higher runtime
						 //but lower failure rate
	
	public static boolean isPrime(BigInteger b, int size)
	{
		//basic Miller Robinson
		BigInteger alpha;
		// 
		BigInteger c = b.subtract(BigInteger.valueOf(1));
		
		for (int i = 1; i < certainty; i++)
		{
			//generating a random number alpha included in [0, b-1]
			alpha = new BigInteger(size - 1, randy);
			
			if (!alpha.modPow(c, b).equals(BigInteger.valueOf(1)))
				return false;
		}
		return true;
	}
	public static BigInteger genPrime(int size)
	{
		//lower bound becomes 2^n-1 aka the largest bit
		BigInteger bound = new BigInteger("2");
		bound = bound.pow(size - 1);
		
		while(true)
		{
			//generates the n - 1 lowest bits of the number
			BigInteger test = new BigInteger(size - 1, randy);
		
			//test is now [2^n-1, 2^n -1]
			test = test.add(bound);
		
			//checking if test is prime
			if(isPrime(test, size))
				return test;
			
			//generate again if it fails
		}
	}
	public static void main(String[] args) {

		BigInteger p;
		p = genPrime(100);
		System.out.println(p);
		

			
	}
