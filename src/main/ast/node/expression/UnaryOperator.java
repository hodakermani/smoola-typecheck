package main.ast.node.expression;

public enum UnaryOperator {
    NOT ("!"),
    MINUS("-");

    private final String codeRep;
    UnaryOperator(String codeRep) {
        this.codeRep = codeRep;
    }
}
