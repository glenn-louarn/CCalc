package ast;

import eval.State;

abstract public class AST {
    public abstract String toString();
    public abstract String gen(int depth);
    public abstract Type type(State<Type> stVar);
}
