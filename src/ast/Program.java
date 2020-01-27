package ast;

public class Program {

    public static String genMain(String gen) {
        return
            "#include <stdio.h>\n" +
            "int main () {\n" +
            " return printf(\"%i\\n\"," + gen + ");\n" +
            "}\n";
    }
}
