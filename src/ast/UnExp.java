package ast;

import eval.State;

public class UnExp extends Exp {
    private Exp e;

    public UnExp(Exp exp) {
        this.e = exp;
    }

    @Override
    public String toString() {
        return "UnExp(" + this.e + ")";
    }

    @Override
    public int eval(State<Integer> state) {
        return -this.e.eval(state);
    }
}
