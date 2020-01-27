package ast;

import eval.State;

import java.util.List;

public class Program extends AST {
    List<FunDef> defs;
    Body body;


    @Override
    public String toString() {
        return null;
    }

    public int eval(State<> state, State<FunDef> sFun){
        State<FunDef> stFun = new State<>();
        for(FunDef def: defs){
            stFun.bind(def.name, def);
        }
        return body.eval(new State<>(), stFun);
    }
}
