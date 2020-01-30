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
    public String toString() {
        return "Var(" + this.string + ")";
    }

    @Override
    public String gen(int depth) {
        return string;
    }

    @Override
    public Type type(State<Type> stVar) {
        return stVar.lookup(this.string);
    }
}
