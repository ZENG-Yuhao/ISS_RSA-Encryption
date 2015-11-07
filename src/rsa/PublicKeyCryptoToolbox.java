package rsa;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Vector;

public class PublicKeyCryptoToolbox
{
	// / Secure pseudo random number generator
	SecureRandom prng;

	public PublicKeyCryptoToolbox()
	{
		// Create a new prng instance
		prng = new SecureRandom();
	}

	public static EEAResult extendedEuclideanAlgorithm(BigInteger a, BigInteger b)
	{

		/************************************************************
		 * Insert the code of Exercise 6a below this comment!
		 ************************************************************/

		EEAResult rslt = EEA(a, b);
		rslt.setA(a);
		rslt.setB(b);
		return rslt;
	}

	private static EEAResult EEA(BigInteger a, BigInteger b)
	{
		if (b.compareTo(BigInteger.ZERO) == 0)
		{
			return new EEAResult(null, null, a, BigInteger.ONE, BigInteger.ZERO);
		}
		else
		{
			EEAResult rslt = EEA(b, a.mod(b));
			BigInteger x = rslt.getY();
			BigInteger y = rslt.getX().subtract(a.divide(b).multiply(rslt.getY()));
			// because d does not change, we just keep it in "rslt".
			rslt.setX(x);
			rslt.setY(y);
			return rslt;
		}
	}

	static public BigInteger modExp(BigInteger a, BigInteger b, BigInteger m)
	{

		/************************************************************
		 * Insert the code of Exercise 7a below this comment!
		 ************************************************************/
		BigInteger c = BigInteger.ZERO;
		BigInteger d = BigInteger.ONE;
		for (int i = b.bitLength() - 1; i >= 0; i--)
		{
			c = c.multiply(BigInteger.valueOf(2));
			d = d.multiply(d).mod(m);
			if (b.testBit(i))
			{
				c = c.add(BigInteger.ONE);
				d = d.multiply(a).mod(m);
			}
		}
		return d;
	}

	public BigInteger randomInteger(int bit_length)
	{

		/************************************************************
		 * Insert the code of Exercise 7a below this comment!
		 ************************************************************/
		BigInteger rslt = new BigInteger(bit_length, prng);
		return rslt;
	}

	public BigInteger randomInteger(BigInteger n)
	{

		/************************************************************
		 * Insert the code of Exercise 7b below this comment!
		 ************************************************************/
		int bit_length = n.bitLength();
		BigInteger rslt;
		do
			rslt = new BigInteger(bit_length, prng);
		while (!(rslt.compareTo(BigInteger.ONE) >= 0) || !(rslt.compareTo(n) < 0));
		return rslt;
	}

	public boolean witness(BigInteger a, BigInteger n)
	{

		/************************************************************
		 * Insert the code of Exercise 8a below this comment!
		 ************************************************************/
		// BigInteger is a type just like normal Integer type
		// so parameters been transfered by values rather than references
		BigInteger n1 = n.subtract(BigInteger.ONE);
		BigInteger d = BigInteger.ONE;
		BigInteger x;
		for (int i = n1.bitLength() - 1; i >= 0; i--)
		{
			x = d;
			d = d.multiply(d).mod(n);
			if (d.compareTo(BigInteger.ONE) == 0 && x.compareTo(BigInteger.ONE) != 0 && x.compareTo(n1) != 0)
				return true;
			if (n1.testBit(i))
				d = d.multiply(a).mod(n);
		}
		if (d.compareTo(BigInteger.ONE) != 0)
			return true;

		return false;
	}

	public boolean millerRabinTest(BigInteger n, int s)
	{

		/********************
		 * **************************************** Insert the code of Exercise
		 * 8b below this comment!
		 ************************************************************/
		BigInteger a;
		for (int i = 1; i <= s; i++)
		{
			a = randomInteger(n);
			if (witness(a, n))
				return false;
		}
		return true;
	}

	public BigInteger randomPrime(int bit_length, int s)
	{

		/************************************************************
		 * Insert the code of Exercise 9d below this comment!
		 ************************************************************/
		BigInteger rnd;
		do
		{
			rnd = new BigInteger(bit_length, prng);
			if (!rnd.testBit(bit_length - 1))
				continue;

		} while (!millerRabinTest(rnd, s));
		
		return rnd;
	}

}
