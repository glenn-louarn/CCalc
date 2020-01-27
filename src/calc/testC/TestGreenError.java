package calc.testC;

import java.util.OptionalInt;

/**
 * Created by noye on 27/02/2017.
 */
public class TestGreenError extends Test {
    public static void main(String[] args){
        boolean verbose = false;
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

