package calc.test;

import java.util.OptionalInt;

public class TestRed extends Test {
    public static void main(String[] args) {
        Test.main(args);
        // no recursion
        test(verbose, "test/redFunc0.calc", "(defun (zero) 0)(zero)", OptionalInt.of(0));
        test(verbose, "test/redId.calc", "(defun (id x) x) (id 11)", OptionalInt.of(11));
        test(verbose, "test/redFuncs.calc", "(defun (id x) x)(define (id2 x) x) 22", OptionalInt.of(22));
        test(verbose, "test/redFunc1.calc", "(defun (inc x) (+ x 1))(inc 0)", OptionalInt.of(1));
        test(verbose, "test/redFunc2.calc", "(defun (id x) x)(id (+ 0 1))", OptionalInt.of(1));
        test(verbose, "test/redFunc3.calc", "(defun (id x) x)(= a 3)a", OptionalInt.of(3));
        test(verbose, "test/redFunc4.calc", "(defun (inc x) (+ x 1))(inc (+ 3 1))", OptionalInt.of(5));
        test(verbose, "test/redFunc5.calc", "(defun (inc x) (+ x 1))(= a 2)(inc (+ 1 a))", OptionalInt.of(4));
        test(verbose, "test/redOverride.calc", "(inc x) (inc x y)", OptionalInt.empty());
        test(verbose, "test/redParam.calc", "(inc x) (= x 0)", OptionalInt.empty());
        test(verbose, "test/redParams.calc", "(defun (id x x) x) (id 0 1)", OptionalInt.empty());
        test(verbose, "test/redZarbi.calc", "(defun (f) a)(= a 1)(f)", OptionalInt.empty());
        test(verbose, "test/redPlusScoping.calc", "handling scopes", OptionalInt.of(99));
        test(verbose, "test/redPlusScoping2.calc", "handling scopes", OptionalInt.empty());
        test(verbose, "test/redNoLoop.calc", "lazy conditional", OptionalInt.of(2));
        // simple recursion
        test(verbose, "test/redFuncRedef.calc", "(defun (f x)(= x 1) x)(f x)", OptionalInt.empty());
        test(verbose, "test/redFib0.calc", "(defun (fib n)... (fib 4)", OptionalInt.of(3));
        test(verbose, "test/redFib.calc", "(defun (fib n)... (fib 4)", OptionalInt.of(3));
        test(verbose, "test/redFib2.calc", "(defun (fib n)... (fib 4))", OptionalInt.of(3));
        test(verbose, "test/redFib3.calc", "(defun (fib n)... (fib 4))", OptionalInt.of(3));
        // mutual recursion
        test(verbose, "test/redMutRec.calc", "odd & even", OptionalInt.of(2));
        report();
    }
}

