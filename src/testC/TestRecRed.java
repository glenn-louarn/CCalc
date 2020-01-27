package testC;

import java.util.OptionalInt;

public class TestRecRed extends Test {
    /**
     * Entry point. Executes all the red tests.
     *
     * @param args
     */
    public static void main(String[] args){
        boolean verbose = true;
        test(verbose, "test/red30.calc", "fibonacci classic", OptionalInt.of(1));
        test(verbose, "test/red10.calc", "mutually recursive functions", OptionalInt.of(1));
        test(verbose, "test/red11.calc", "mutually recursive functions", OptionalInt.of(0));

        report();
    }
}

