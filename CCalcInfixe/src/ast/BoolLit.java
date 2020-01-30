package ast;

import eval.State;

public class BoolLit extends Exp {
    boolean bool;

    public BoolLit(boolean bool) {
        this.bool = bool;
    }

    @Override
    public String toString() {
        return "BoolLit(" + this.bool + ")";
    }

    @Override
    public String gen(int depth) {
        return this.bool ? "1" : "0";
    }

    @Override
    public int eval(State<Integer> state) {
        return this.bool ? 1 : 0;
    }

    @Override
    public Type type(State<Type> stVar) {
        return Type.BOOL;
    }
}
