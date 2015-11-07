package bigint;

import java.math.BigInteger;

public class test
{
	public static void main(String args[])
	{
		BigInteger a = new BigInteger("7");
		BigInteger b = new BigInteger("2");
		System.out.println(a.divide(b));
		a = b;
		b = new BigInteger("4");
		System.out.print("Binary representation of " + b + ": ");
		for (int i=b.bitLength()-1; i>=0; i--) {
		if (b.testBit(i)==true) {
		System.out.print("1");
		} else {
		System.out.print("0");
		}
		}
		System.out.println(";");
		System.out.println(a);
		System.out.println(b);
		fun(b);
		System.out.println(b);
	}
	
	public static void fun(BigInteger e){
		e = new BigInteger("1234");
	}
}