package parser;

public class ErrorFlag {
    static boolean flag;
    public static void setFlag() {
        flag = true;
    }

    public static void reset() {
        flag = false;
    }

    public static boolean getFlag(){
        return flag;
    }
}
