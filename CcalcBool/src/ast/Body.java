package ast;

import eval.State;

import java.util.List;

public class Body extends AST {
    private List<VarDef> defs;
    private Exp exp;

    public Body(List<VarDef> defs, Exp exp) {
        super();
        this.defs = defs;
        this.exp = exp;
    }

    public int eval(State<Integer> state) {
        for (VarDef varDef : defs) {
            varDef.eval(state);
        }
        return this.exp.eval(state);
    }

    @Override
    public String toString() {
        return "Body : " + this.exp;
    }

    @Override
    public String gen(int depth) {
        String st = "";
        for (VarDef vd : defs) {
            st += vd.gen(depth);
        }
        return
            st +
            exp.gen(depth);
    }

    @Override
    public Type type(State<Type> stVar) {
        for (VarDef vd : defs) {
            vd.type(stVar);
        }
        return exp.type(stVar);
    }
}