package ast;

import eval.State;

public abstract class Exp extends AST {
    abstract public int eval(State<Integer> state);

}
