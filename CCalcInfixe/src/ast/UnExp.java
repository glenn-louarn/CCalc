package ast;

import eval.State;

public class UnExp extends Exp {
    private Exp e;
    private OP op;

    public UnExp(Exp exp, OP op) {
        this.e = exp;
        this.op = op;
    }

    @Override
    public String toString() {
        return "UnExp(" + this.op + " " + this.e + ")";
    }

    @Override
    public String gen(int depth) {
        String ret = null;
        if (this.op == OP.NOT) ret = "( !"+e.gen(depth)+")";
        if (this.op == OP.MINUS) ret = "( - "+e.gen(depth)+")";
        return ret;
    }

    @Override
    public int eval(State<Integer> state) {
        int ret = -1;
        if (this.op == OP.NOT) ret = this.e.eval(state) == 0 ? 1 : 0;
        if (this.op == OP.MINUS) ret = -this.e.eval(state);
        return ret;
    }

    @Override
    public Type type(State<Type> stVar) {
        if (this.e.type(stVar) == Type.BOOL && this.op == OP.NOT) return Type.BOOL;
        if (this.e.type(stVar) == Type.INT && this.op == OP.MINUS) return Type.INT;
        throw new SemanticError("Incompatible types");
    }
}
