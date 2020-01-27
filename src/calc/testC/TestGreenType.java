package calc.testC;

import java.util.OptionalInt;

/**
 * Created by noye on 27/02/2017.
 */
public class TestGreenType extends Test {
    public static void main(String[] args){
        boolean verbose = true;
        test(verbose, "test/green16.calc", "equality", OptionalInt.empty());
        test(verbose, "test/green20.calc", "erroneous expression", OptionalInt.empty());
        test(verbose, "test/green28.calc", "non assoc", OptionalInt.empty());
        report();
    }
}
