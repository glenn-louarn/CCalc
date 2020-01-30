package ast;

import eval.State;

public class Var extends Exp {
    private String string;

    public Var(String string) {
        this.string = string;
    }

    @Override
    public int eval(State<Integer> state) {
        Integer value = state.lookup(this.string);
        if (value != null) {
            return value;
        } else {
            throw new SyntaxError("Unknown Var : " + this.string);
        }
    }

    @Override
    public Type type(State<Type> stVar) {
        Type type = stVar.lookup(this.string);
        if (type != null) {
            return type;
        } else {
            throw new SemanticError("Unknown type : "+type);
        }
    }

    @Override
    public String toString() {
        return "Var(" + this.string + ")";
    }

    @Override
    public String gen(int depth) {
        return string;
    }
}
