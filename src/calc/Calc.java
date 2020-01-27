package calc;

import ast.AST;
import ast.Exp;
import eval.State;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import parser.*;
import parser.generated.CalcLexer;
import parser.generated.CalcParser;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;

public class Calc {
    /**
     * @param args - args[0] is the name of the file to analyze,
     *                otherwise the program is entered at the console.
     */
    public static void main(String[] args) throws IOException {
        InputStream is;

        switch (args.length) {
            case 0:
                is = System.in;
                break;
            case 1:
                is = new FileInputStream(args[0]);
                break;
            default:
                throw new java.lang.IllegalArgumentException();
        }
        compile(is, "");
        System.out.println("EVAL : "+interpret(is));
    }

    public static void compile(InputStream is, String inputFile) throws IOException {
        AST ast = analyze(is);
        String code = ast.gen(0);
        if (inputFile!= null) {
            write(code, inputFile);
        } else {
            System.out.println(code);
        }
    }

    static String write(String code, String filename) throws IOException {
        String CFilename = filename.replaceFirst("\\.calc", ".c");
        boolean verbose = true;
        if(verbose) System.out.println("Writing C code to : "+CFilename);
        FileWriter out = new FileWriter(CFilename);
        out.write(code);
        out.flush();
        out.close();
        return CFilename;
    }

    public static AST analyze(InputStream is) throws IOException {
        ANTLRInputStream input = new ANTLRInputStream(is);
        CalcLexer lexer = new CalcLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        CalcParser parser = new CalcParser(tokens);

        ParseTree tree = parser.program();
        System.out.println("ANTLR Syntax tree: " + tree.toStringTree(parser));
        ASTVisitor visitor = new ASTVisitor();
        Exp exp = (Exp) visitor.visit(tree);
        System.out.println("AST : " + exp);
        return exp;
    }

    public static int interpret(InputStream is) throws IOException {
        Exp exp = (Exp) analyze(is);
        int eval = exp.eval(new State<>());
        return eval;
    }
}
