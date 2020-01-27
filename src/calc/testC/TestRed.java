package calc.testC;

import java.util.OptionalInt;

public class TestRed extends Test {
	/**
	 * Entry point. Executes all the red tests. 
	 * 
	 * @param args
	 */	
	public static void main(String[] args){	
		boolean verbose = true;
		test(verbose, "test/red1.calc", "one constant function", OptionalInt.of(2));
		test(verbose, "test/red2.calc", "one constant function, one call", OptionalInt.of(2));
		test(verbose, "test/red3.calc", "two constant functions and calls", OptionalInt.of(5));
		test(verbose, "test/red4.calc", "two constant functions and nested calls", OptionalInt.of(3));
		test(verbose, "test/red5.calc", "function and call with a parameter", OptionalInt.of(11));
		test(verbose, "test/red6.calc", "call with a composed expression", OptionalInt.of(12));
		test(verbose, "test/red20.calc", "local variable hide parameter", OptionalInt.empty());
		test(verbose, "test/red21.calc", "wrong number of parameters", OptionalInt.empty());
		test(verbose, "test/red22.calc", "function called without being defined", OptionalInt.empty());
		test(verbose, "test/red23.calc", "function redefinition", OptionalInt.empty());
		report();
	}
}
