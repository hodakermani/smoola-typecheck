package main.ast.node.expression;

public enum BinaryOperator {
    //add, sub, mult, div, and, or, eq, neq, lt, gt, assign

    PLUS("+"),
    MINUS("-"),
    DIVIDE("/"),
    MULTIPLY("*"),
    AND("&&"),
    OR("||"),
    EQUALS("=="),
    NOT_EQUALS("<>"),
    LESS("<"),
    GREATER(">"),
    NOT("!"),
    ASSIGN("=");
    private final String codeRep;
    BinaryOperator(String codeRep) {
        this.codeRep = codeRep;
    }
}
