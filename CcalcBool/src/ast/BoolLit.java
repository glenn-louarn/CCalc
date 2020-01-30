package ast;

import eval.State;

public class BoolLit extends Exp {

    private Boolean var;

    public BoolLit(Boolean var) {
        this.var = var;
    }

    @Override
    public int eval(State<Integer> state) {
        return var ? 1 : 0;
    }

    @Override
    public Type type(State<Type> stVar) {
        return Type.BOOL;
    }

    @Override
    public String toString() {
        return "BoolLit(" + var + ")";
    }

    @Override
    public String gen(int depth) {
        return "" + this.var;
    }
}
