package ast;

import eval.State;

import java.util.ArrayList;
import java.util.List;

public class Program extends AST {
    List<FunDef> defs;
    Body body;

    public Program(List<FunDef> defs, Body body) {
        this.defs = defs;
        this.body = body;
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
