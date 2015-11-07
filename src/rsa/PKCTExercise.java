package rsa;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Vector;

public class PKCTExercise
{

	void eeaResultExercise()
	{

		System.out.println("\nExercise 5:");
		System.out.println("===========\n");

		/************************************************************
		 * Insert the code of Exercise 5a+b below this comment!
		 ************************************************************/
		BigInteger a, b, d, x, y;
		a = new BigInteger("8002109");
		b = new BigInteger("7186131");
		d = new BigInteger("1");
		x = new BigInteger("-2996671");
		y = new BigInteger("3336940");
		EEAResult eear = new EEAResult(a, b, d, x, y);
		System.out.println("Is realatively prime? " + (eear.isRelativlyPrime() ? "YES" : "NO"));
		System.out.println(eear.getInverse());
	}

	void euclidExercise()
	{

		System.out.println("\nExercise 6:");
		System.out.println("===========\n");

		/************************************************************
		 * Insert the code of Exercise 6b+c below this comment!
		 ************************************************************/
		// Exercise 6b
		BigInteger a = new BigInteger("7019544");
		BigInteger b = new BigInteger("8135112");
		EEAResult rslt = PublicKeyCryptoToolbox.extendedEuclideanAlgorithm(a, b);
		System.out.println("A = " + a + "; B = " + b + ";");
		System.out.println("D = " + rslt.getD());
		System.out.println("X = " + rslt.getX());
		System.out.println("Y = " + rslt.getY());

		// Exercise 6c
		a = new BigInteger("7186131");
		b = new BigInteger("8002109");
		rslt = PublicKeyCryptoToolbox.extendedEuclideanAlgorithm(a, b);
		System.out.println("A = " + a + "; B = " + b + ";");
		System.out.println("D = " + rslt.getD());
		System.out.println("X = " + rslt.getX());
		System.out.println("Y = " + rslt.getY());
		System.out.println("Is a invertible modulo of b? " + (rslt.isRelativlyPrime() ? "YES" : "NO"));
		System.out.println(
				"Inverse integer of a: " + (rslt.isRelativlyPrime() ? rslt.getInverse() : "Non-exist"));
	}

	void modExpExercise()
	{
		System.out.println("\nExercise 7:");
		System.out.println("===========\n");

		/************************************************************
		 * Insert the code of Exercise 6b+c below this comment!
		 ************************************************************/
		BigInteger a = new BigInteger("17");
		BigInteger b = new BigInteger("1005");
		BigInteger m = new BigInteger("230");
		System.out.println("modExp(): " + PublicKeyCryptoToolbox.modExp(a, b, m));
		System.out.println("modPow(): " + a.modPow(b, m));
	}

	void randomNumbers()
	{
		System.out.println("\nExercise 8:");
		System.out.println("===========\n");

		/************************************************************
		 * Insert the code of Exercise 8c below this comment!
		 ************************************************************/
		PublicKeyCryptoToolbox toolbox = new PublicKeyCryptoToolbox();
		BigInteger n = new BigInteger("102030405060708090");
		for (int i = 1; i <= 20; i++)
		{
			System.out.println("No." + i + " : " + toolbox.randomInteger(n));
		}
	}

	void primalityTest()
	{
		System.out.println("\nExercise 9:");
		System.out.println("===========\n");

		/************************************************************
		 * Insert the code of Exercise 9c+e below this comment!
		 ************************************************************/
		System.out.println("Exercise 9c");
		ArrayList<BigInteger> list = new ArrayList<BigInteger>();
		list.add(new BigInteger("343232674978653231166402657365997144371953839307928119227511"));
		list.add(new BigInteger("667984267564412673929015509827448340743034959781814076053617"));
		list.add(new BigInteger("902857742149935096180418505174605673479122931367283811478172"));
		list.add(new BigInteger("408025803078911998315951562970145017384911797981108589419277"));
		list.add(new BigInteger("1040747016400791716218800060097121047453800566864795676123313"));
		list.add(new BigInteger("341920262248211364330159957004187372102128507551704555404569"));
		list.add(new BigInteger("880723572255844606588685481136407927962444382553394348261623"));
		list.add(new BigInteger("1130242628975018265380102543215055338361897468448588898970126"));

		int s = 10;
		PublicKeyCryptoToolbox toolbox = new PublicKeyCryptoToolbox();
		System.out.println(list.size());
		for (BigInteger e : list)
		{
			System.out.print(e + " is prime? ");

			if (toolbox.millerRabinTest(e, s))
				System.out.println("YES");
			else
				System.out.println("No");

		}
		
		System.out.println("Exercise 9e");
		System.out.println("128-bit prime: "+toolbox.randomPrime(128, 100));
		System.out.println("256-bit prime: "+toolbox.randomPrime(256, 100));
		System.out.println("512-bit prime: "+toolbox.randomPrime(512, 100));
		System.out.println("1024-bit prime: "+toolbox.randomPrime(1024, 100));
	}

	void run()
	{
		/*
		 * Uncomment the method after completion of the respective exercise!
		 */
		// eeaResultExercise();
		// euclidExercise();
		// modExpExercise();
		// randomNumbers();
		primalityTest();
	}

	public static void main(String[] args)
	{

		PKCTExercise m = new PKCTExercise();
		m.run();
	}

}
