package parser;

import ast.*;

import parser.gen.*;

import java.util.ArrayList;
import java.util.List;

public class ASTVisitor extends CalcBaseVisitor<AST> {
    @Override
    public AST visitBody(CalcParser.BodyContext ctx) {
        CalcParser.ExpressionContext ectx = ctx.expression();
        Exp exp = (Exp)visit(ectx);
        return new Body(new ArrayList<>(), exp);
    }

    @Override
    public AST visitIntLit(CalcParser.IntLitContext ctx) {
        int val = Integer.parseInt(ctx.getText());
        return new IntLit(val);
    }

    @Override
    public AST visitBoolLit(CalcParser.BoolLitContext ctx) {
        boolean bool = Boolean.parseBoolean(ctx.getText());
        return new BoolLit(bool);
    }

    @Override
    public AST visitVar(CalcParser.VarContext ctx) {
        String val = ctx.getText();
        return new Var(val);
    }

    @Override
    public AST visitUnExp(CalcParser.UnExpContext ctx) {
        CalcParser.ExpressionContext expCtxs = ctx.expression();
        OP op = ctx.getChild(0).getText().equals("!") ? OP.NOT : OP.MINUS;
        return new UnExp((Exp) visit(expCtxs), op);
    }

    @Override
    public AST visitBinExp(CalcParser.BinExpContext ctx) {
        List<CalcParser.ExpressionContext> expCtxs = ctx.expression();
        Exp exp1 = (Exp) visit(expCtxs.get(0));
        Exp exp2 = (Exp) visit(expCtxs.get(1));
        String opString = ctx.getChild(1).getText();
        OP op;
        switch(opString) {
            case "+":
                op = OP.PLUS;
                break;
            case "-":
                op = OP.MINUS;
                break;
            case "*":
                op = OP.TIMES;
                break;
            case "/":
                op = OP.DIVIDE;
                break;
            case "==":
                op = OP.EQUAL;
                break;
            case "!=":
                op = OP.NOTEQUAL;
                break;
            case "<":
                op = OP.LESS;
                break;
            case ">":
                    op = OP.MORE;
                break;
            case "<=":
                op = OP.EQUALORLESS;
                break;
            case ">=":
                op = OP.EQUALORMORE;
                break;
            case "&&":
                op = OP.AND;
                break;
            case "||":
                op = OP.OR;
                break;
            default:
                return null;
        }
        return new BinExp(op, exp1, exp2);
    }

    @Override
    public AST visitCondExp(CalcParser.CondExpContext ctx) {
        List<CalcParser.ExpressionContext> expCtxs = ctx.expression();
        Exp exp1 = (Exp) visit(expCtxs.get(0));
        Exp exp2 = (Exp) visit(expCtxs.get(1));
        Exp exp3 = (Exp) visit(expCtxs.get(2));
        return new CondExp(exp1, exp2, exp3);
    }

    @Override
    public AST visitParExp(CalcParser.ParExpContext ctx) {
        return visit(ctx.expression());
    }

    @Override
    public AST visitFuncDef(CalcParser.FuncDefContext ctx) {
        return new VarDef(null, null);
    }
}
