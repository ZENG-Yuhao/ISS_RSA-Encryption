package bigint;

import java.math.BigInteger;
import java.security.SecureRandom;

public class BigIntegerExercise {

	public BigIntegerExercise() {
	}

	void expression() {

		System.out.println("\nExercise 2:");
		System.out.println("===========\n");

		/************************************************************
		 * Insert the code of Exercise 2 below this comment!
		 ************************************************************/

		BigInteger a, b, c, d, result;
		a = new BigInteger("512");
		b = new BigInteger("102");
		c = new BigInteger("3");
		d = new BigInteger("761");
		// expression: (a * b - 4)/c + ((d * d) - (a - b))
		result = a.multiply(b).subtract(BigInteger.valueOf(4)).divide(c).add(d.multiply(d).subtract(a.subtract(b)));
		System.out.println(result);
		System.out.print("Comparison Result with Normal Type: ");
		System.out.println((512 * 102 - 4) / 3 + ((761 * 761) - (512 - 102)));
	}

	void comparison() {
		System.out.println("\nExercise 3:");
		System.out.println("===========\n");

		/************************************************************
		 * Insert the code of Exercise 3 below this comment!
		 ************************************************************/
		BigInteger a, b;
		a = new BigInteger("781");
		b = new BigInteger("12891");
		System.out.println("a = " + a.toString() + "; b = " + b.toString());
		System.out.print("a < b? ");
		System.out.println((a.compareTo(b) < 0) ? "Yes" : "No");
		System.out.print("a <= b? ");
		System.out.println((a.compareTo(b) <= 0) ? "Yes" : "No");
		System.out.print("a = b? ");
		System.out.println((a.compareTo(b) == 0) ? "Yes" : "No");
		System.out.print("a > b? ");
		System.out.println((a.compareTo(b) > 0) ? "Yes" : "No");
		System.out.print("a >= b? ");
		System.out.println((a.compareTo(b) >= 0) ? "Yes" : "No");
		System.out.print("a != b? ");
		System.out.println((a.compareTo(b) != 0) ? "Yes" : "No");
	}

	void randomNumbers() {
		System.out.println("\nExercise 4:");
		System.out.println("===========\n");

		/************************************************************
		 * Insert the code of Exercise 4 below this comment!
		 ************************************************************/
		SecureRandom prng = new SecureRandom();
		randomNumberDisplay(64, prng);
		randomNumberDisplay(128, prng);
		randomNumberDisplay(256, prng);
		randomNumberDisplay(512, prng);
		randomNumberDisplay(1024, prng);
		randomNumberDisplay(2048, prng);
	}

	void randomNumberDisplay(int num_bits, SecureRandom prng) {
		BigInteger ng = new BigInteger(num_bits, prng);
		System.out.println("The generated pseudo random number of " + num_bits + "-bits: ");
		System.out.println(ng);
		System.out.println();
	}

	public void run() {
		/*
		 * Uncomment the method after the implementation!
		 */
		expression();
		comparison();
		randomNumbers();
	}

	public static void main(String[] args) {
		BigIntegerExercise m = new BigIntegerExercise();

		m.run();
	}

}
