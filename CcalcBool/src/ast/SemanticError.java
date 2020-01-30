package ast;

public class SemanticError extends RuntimeException {
    public SemanticError(String message) {
        super(message);
    }
}
