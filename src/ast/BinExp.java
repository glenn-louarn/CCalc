package ast;

import eval.State;

public class BinExp extends Exp {
    private OP op;
    private Exp e1;
    private Exp e2;

    public BinExp(OP op, Exp exp1, Exp exp2) {
        this.op = op;
        this.e1 = exp1;
        this.e2 = exp2;
    }

    @Override
    public String toString() {
        return "BinExp(" + this.op + " " + this.e1 + " " + this.e2 + ")";
    }

    @Override
    public int eval(State<Integer> state) {
        int val1 = this.e1.eval(state);
        int val2 = this.e2.eval(state);
        switch (this.op) {
            case PLUS:
                return val1 + val2;
            case MINUS:
                return val1 - val2;
            case TIMES:
                return val1 * val2;
            case DIVIDE:
                return val1 / val2;
            case LESS:
                return val1 < val2 ? 1 : 0;
            case EQUAL:
                return val1 == val2 ? 1 : 0;
            default:
                throw new SyntaxError("Unrecognized operand");
        }
    }

    public enum OP {
        PLUS, MINUS, TIMES, DIVIDE, EQUAL, LESS
    }
}
