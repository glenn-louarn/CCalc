package ast;

public enum OP {
    PLUS, EQUAL,MINUS, TIMES, DIVIDE, LESS;

    public String gen(OP op) {
        switch (op){
            case PLUS:
                return "+";
            case EQUAL:
                return  "=";
            case MINUS:
                return "-";
            case TIMES:
                return "*";
            case DIVIDE:
                return "/";
            case LESS:
                return "<";
            default:
                throw new Error("OP NOT FOUND");
        }
    }

}