package calc.test;

import java.util.OptionalInt;

public class TestGreenPlus extends Test {
	/**
	 * Entry point. Executes all the tests. 
	 * 
	 * @param args
	 */
	public static void main(String[] args){
		boolean verbose = true;
		test(verbose, "test/green29.calc", "parenthesized expression", OptionalInt.of(3));
		test(verbose, "test/green30.calc", "another parenthesized expression", OptionalInt.of(2));
		test(verbose, "test/green31.calc", "true < false", OptionalInt.empty());
		test(verbose, "test/green32.calc", "true < false < true", OptionalInt.empty());
		report();
	}
}

