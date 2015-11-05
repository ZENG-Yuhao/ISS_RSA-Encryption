package rsa;

import java.math.BigInteger;
import java.util.Vector;

public class PKCTExercise {
	
	void eeaResultExercise() {
		
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
		System.out.println("Is realatively prime? " + (eear.isRelativlyPrime()?"YES":"NO"));
		System.out.println(eear.getInverse()); 
	}

	void euclidExercise() {

		System.out.println("\nExercise 6:");
		System.out.println("===========\n");

		/************************************************************
		 * Insert the code of Exercise 6b+c below this comment!
		 ************************************************************/
		
	}
	
	void modExpExercise() {
		System.out.println("\nExercise 7:");
		System.out.println("===========\n");

		/************************************************************
		 * Insert the code of Exercise 6b+c below this comment!
		 ************************************************************/

		
	}
	
	void randomNumbers() {
		System.out.println("\nExercise 8:");
		System.out.println("===========\n");

		/************************************************************
		 * Insert the code of Exercise 8c below this comment!
		 ************************************************************/

	}

	void primalityTest() {
		System.out.println("\nExercise 9:");
		System.out.println("===========\n");

		/************************************************************
		 * Insert the code of Exercise 9c+e below this comment!
		 ************************************************************/

	}
	
	void run() {
		/*
		 * Uncomment the method after completion of the
                 * respective exercise!
		 */
		eeaResultExercise();
		//euclidExercise();
		//modExpExercise();
		//randomNumbers();
		//primalityTest();
	}
	
	public static void main(String[] args) {

		PKCTExercise m = new PKCTExercise();
		m.run();
	}

}
