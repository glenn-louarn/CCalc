package ast;

import java.sql.Time;
import java.sql.Timestamp;

public enum OP{
    PLUS, EQUAL,MINUS, TIMES, DIVIDE, LESS;

    public String gen(OP op) {
        switch (op){
            case(OP.PLUS):
                return "+";
            case(EQUAL):
                return  "=";
            case(MINUS):
                return "-";
            case(TIMES):
                return "*";
            case(DIVIDE):
                return "/";
            case(LESS):
                return "<";
        }
    }

}