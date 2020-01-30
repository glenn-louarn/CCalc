package ast;

public enum OP {
    NOT, PLUS, EQUAL, MINUS, TIMES, DIVIDE, LESS, MORE, EQUALORLESS, EQUALORMORE, NOTEQUAL, AND, OR;

    public String gen(OP op) {
        switch (op){
            case NOT:
                return "!";
            case PLUS:
                return "+";
            case MINUS:
                return "-";
            case TIMES:
                return "*";
            case DIVIDE:
                return "/";
            case EQUAL:
                return  "==";
            case NOTEQUAL:
                return "!=";
            case LESS:
                return "<";
            case MORE:
                return ">";
            case EQUALORLESS:
                return "<=";
            case EQUALORMORE:
                return ">=";
            case AND:
                return "&&";
            case OR:
                return "||";
            default:
                throw new SyntaxError("Unrecognized operand");
        }
    }

}