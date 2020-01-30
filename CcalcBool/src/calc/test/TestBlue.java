package calc.test;

import java.util.OptionalInt;

public class TestBlue extends Test {
    public static void main(String[] args) {
        Test.main(args);
        test(verbose, "test/blueDef.calc", "(= a 11) a", OptionalInt.of(11));
        test(verbose, "test/blueDefError.calc", "(= A 11) A", OptionalInt.empty());
        test(verbose, "test/blueDef1.calc", "(= if0 11) if0", OptionalInt.of(11));
        test(verbose, "test/blueDef2.calc", "(= a 1) (= b 2) (+ a b)", OptionalInt.of(3));
        test(verbose, "test/blueDef3.calc", "(= a 1) (= b (- a 1)) (+ a b)", OptionalInt.of(1));
        test(verbose, "test/blueDef4.calc", "(= a 11) (+ 0a)", OptionalInt.of(11));
        test(verbose, "test/blueRedef.calc", "(= a 11) (= a 12)", OptionalInt.empty());
        test(verbose, "test/blueUndef.calc", "a", OptionalInt.empty());
        test(verbose, "test/blueUseDef.calc", "(= b a) (= a 1) b", OptionalInt.empty());
        report();
    }
}
