package calc.test;

import java.util.OptionalInt;

public class TestError extends Test {

    public static void main(String[] args) {
        Test.main(args);
        // various errors
        test(verbose, "test/error.calc", "no file", OptionalInt.empty());
        test(verbose, "test/errorEmpty.calc", "", OptionalInt.empty());
        test(verbose, "test/errorGarbage.calc", "FOO!", OptionalInt.empty());
        test(verbose, "test/errorGarbage2.calc", "01", OptionalInt.empty());
        test(verbose, "test/errorUnaryExp.calc", "(+ 2)", OptionalInt.empty());
        test(verbose, "test/errorParens.calc", "(2)", OptionalInt.empty());
        test(verbose, "test/errorRPar.calc", "(+ 1 2", OptionalInt.empty());
        test(verbose, "test/errorIf.calc", "(if1 1 0)", OptionalInt.empty());
        test(verbose, "test/errorIf2.calc", "(if 1 1)", OptionalInt.empty());
        test(verbose, "test/errorDivide.calc", "(/ 1 0)", OptionalInt.empty());
        report();
    }
}

