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
        return "BinExp(" + this.e1 + " " + this.op + " " + this.e2 + ")";
    }

    @Override
    public String gen(int depth) {
        return "(" + e1.gen(0) + " " + op.gen(this.op) + " " + e2.gen(0) + ")";
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
            case EQUAL:
                return val1 == val2 ? 1 : 0;
            case NOTEQUAL:
                return val1 != val2 ? 1 : 0;
            case LESS:
                return val1 < val2 ? 1 : 0;
            case MORE:
                return val1 > val2 ? 1 : 0;
            case EQUALORLESS:
                return val1 <= val2 ? 1 : 0;
            case EQUALORMORE:
                return val1 >= val2 ? 1 : 0;
            case AND:
                return val1 == 1 && val2 == 1 ? 1 : 0;
            case OR:
                return val1 == 1 || val2 == 1 ? 1 : 0;
            default:
                throw new SyntaxError("Unrecognized operand");
        }
    }

    @Override
    public Type type(State<Type> stVar) {
        switch (this.op) {
            case PLUS:
            case MINUS:
            case TIMES:
            case DIVIDE:
                if (this.e1.type(stVar) == Type.INT && this.e2.type(stVar) == Type.INT) {
                    if (this.e2.eval(new State<>()) == 0) throw new SemanticError("Division by 0");
                    return Type.INT;
                } else {
                    throw new SemanticError("Incompatible types");
                }
            case LESS:
            case MORE:
            case EQUALORLESS:
            case EQUALORMORE:
                if (this.e1.type(stVar) == Type.INT && this.e2.type(stVar) == Type.INT) {
                    return Type.BOOL;
                } else {
                    throw new SemanticError("Incompatible types");
                }
            case EQUAL:
            case NOTEQUAL:
                if (this.e1.type(stVar) == this.e2.type(stVar) ) {
                    return Type.BOOL;
                } else {
                    throw new SemanticError("Incompatible types");
                }
            case AND:
            case OR:
                if (this.e1.type(stVar) == Type.BOOL && this.e2.type(stVar) == Type.BOOL) {
                    return Type.BOOL;
                } else {
                    throw new SemanticError("Incompatible types");
                }
            default:
                throw new SyntaxError("Unrecognized operand");
        }
    }
}
