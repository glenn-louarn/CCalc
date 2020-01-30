package ast;

import eval.State;

public class IntLit extends Exp {
    int val;

    public IntLit(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "IntLit(" + this.val + ")";
    }

    @Override
    public String gen(int depth) {
        return "" + this.val;
    }

    @Override
    public int eval(State<Integer> state) {
        return this.val;
    }

    @Override
    public Type type(State<Type> stVar) {
        return Type.INT;
    }
}
