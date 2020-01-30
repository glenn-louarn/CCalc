package ast;

import eval.State;

abstract public class AST {
    public abstract String toString();
    public abstract String gen(int depth);
    abstract public Type type(State<Type> stVar);
}
