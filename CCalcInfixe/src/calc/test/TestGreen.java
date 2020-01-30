package calc.test;

import java.util.OptionalInt;

public class TestGreen extends Test {
	/**
	 * Entry point. Executes all the tests. 
	 * 
	 * @param args
	 */
	public static void main(String[] args){
		boolean verbose = true;
		test(verbose, "test/green1.calc", "number", OptionalInt.of(1234567890));
		test(verbose, "test/green2.calc", "addition", OptionalInt.of(2));
		test(verbose, "test/green3.calc", "arithmetic expression with priority", OptionalInt.of(7));
		test(verbose, "test/green4.calc", "unary minus", OptionalInt.of(-4));
		test(verbose, "test/green5.calc", "boolean", OptionalInt.of(0));
		test(verbose, "test/green6.calc", "boolean expression", OptionalInt.of(1));
		test(verbose, "test/green7.calc", "boolean expression with priority", OptionalInt.of(1));
		test(verbose, "test/green8.calc", "boolean expression with explicit priority", OptionalInt.of(0));
		test(verbose, "test/green9.calc", "unary not", OptionalInt.of(1));
		test(verbose, "test/green10.calc", "conditional", OptionalInt.of(12));
		test(verbose, "test/green11.calc", "conditional", OptionalInt.of(21));
		test(verbose, "test/green12.calc", "comparison", OptionalInt.of(1));
		test(verbose, "test/green13.calc", "nested conditionals", OptionalInt.of(2));
		test(verbose, "test/green14.calc", "unequality", OptionalInt.of(1));
		test(verbose, "test/green15.calc", "equality", OptionalInt.of(0));
		test(verbose, "test/green16.calc", "equality", OptionalInt.empty());
		test(verbose, "test/green17.calc", "nested divisions", OptionalInt.of(1));
		test(verbose, "test/green18.calc", "minus mix", OptionalInt.of(2));
		test(verbose, "test/green19.calc", "parenthesized number", OptionalInt.of(2));
		test(verbose, "test/green20.calc", "erroneous expression", OptionalInt.empty());
		test(verbose, "test/green21.calc", "garbage", OptionalInt.empty());
		test(verbose, "test/green22.calc", "garbage", OptionalInt.empty());
		test(verbose, "test/green23.calc", "erroneous conditional", OptionalInt.empty());
		test(verbose, "test/green24.calc", "erroneous conditional/garbage", OptionalInt.empty());
		test(verbose, "test/green25.calc", "division by zero", OptionalInt.empty());
		test(verbose, "test/green26.calc", "division by zero", OptionalInt.empty());
		test(verbose, "test/green27.calc", "erroneous number", OptionalInt.empty());
	report();
	}
}
