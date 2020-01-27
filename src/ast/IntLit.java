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
    public int eval(State<Integer> state) {
        return this.val;
    }
}
