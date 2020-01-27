package ast;

import eval.State;

public class Program extends AST {
    Body body;

    public Program(Body body) {
        this.body = body;
    }

    public static String genMain(String gen) {
        return gen;
    }

    @Override
    public String toString() {
        return null;
    }

    public int eval(State<Integer> state){
        return body.eval(state);
    }

    @Override
    public String gen(int depth) {
        return "#include <stdio.h>\n" +
                "int main () {\n" +
                " return printf(\"%i\\n\"," + body.gen(0) + ");\n" +
                "}\n";
    }
}
