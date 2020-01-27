package ast;

import eval.State;

public class CondExp extends Exp {
    private Exp e1;
    private Exp e2;
    private Exp e3;

    public CondExp(Exp exp1, Exp exp2, Exp exp3) {
        this.e1 = exp1;
        this.e2 = exp2;
        this.e3 = exp3;
    }

    @Override
    public String toString() {
        return "CondExp(" + this.e1 + " " + this.e2 + " " + this.e3 + ")";
    }

    @Override
    public int eval(State<Integer> state) {
        return e1.eval(state) != 0 ? e2.eval(state) : e3.eval(state);
    }
}
