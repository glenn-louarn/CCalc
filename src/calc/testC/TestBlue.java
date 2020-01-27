package calc.testC;

import java.util.OptionalInt;

public class TestBlue extends Test {
	/**
	 * Entry point. Executes all the tests. 
	 * 
	 * @param args
	 */
	public static void main(String[] args){	
		boolean verbose = false;
		test(verbose, "test/blue1.calc", "one variable def", OptionalInt.of(102));
		test(verbose, "test/blue2.calc", "one variable def and use", OptionalInt.of(101));
		test(verbose, "test/blue3.calc", "two variable defs used in expression", OptionalInt.of(103));
		test(verbose, "test/blue4.calc", "two variable defs with nested uses", OptionalInt.of(104));
		test(verbose, "test/blue5.calc", "variable use without a def", OptionalInt.empty());
		test(verbose, "test/blue6.calc", "variable used before its def", OptionalInt.empty());
		test(verbose, "test/blue7.calc", "redefinition of a variable", OptionalInt.empty());
		test(verbose, "test/blue8.calc", "erroneous variable name", OptionalInt.empty());
		report();
	}
}
