package ast;

import eval.State;

public class VarDef extends AST{
    private String var_id;
    private Exp e;

    public VarDef(String id, Exp e) {
        this.var_id = id;
        this.e = e;
    }

    public void eval(State<Integer> state){
        state.bind(this.var_id, this.e.eval(state));
    }

    @Override
    public String toString() {
        return "VarDef("+ this.var_id + " : " + this.e + ")";
    }

    @Override
    public String gen(int depth) {
        return var_id +" = " + this.e.gen(0);
    }

    @Override
    public Type type(State<Type> stVar) {
        return this.e.type(stVar);
    }
}