package main.ast.node.expression;

import main.ast.Type.Type;
import main.visitor.Visitor;
import main.ast.node.expression.BinOp.BinaryOperator;

public class BinaryExpression extends Expression {

    private Expression left;
    private Expression right;
    private BinaryOperator binaryOperator;
    public BinaryExpression(Expression left, Expression right, BinaryOperator binaryOperator) {
        this.left = left;
        this.right = right;
        this.binaryOperator = binaryOperator;
    }
//    public BinaryExpression(Expression left, Expression right, BinaryOperator binaryOperator, Type leftType, Type rightType) {
//        this.left = left;
//        this.right = right;
//        this.binaryOperator = binaryOperator;
//        this.left.setType(leftType);
//        this.right.setType(rightType);
//        System.out.println(rightType.toString());
//        System.out.println("what?");
//        System.out.println("what?");
//        if(leftType == null) {
//                    System.out.println("m");
//        }
//    }

    public Expression getLeft() {
        return left;
    }

    public void setLeft(Expression left) {
        this.left = left;
    }
    public void setLeftType(Type type) {
        this.left.setType(type);
    }
    public Type getLeftType() {
        return this.left.getType();
    }

    public Expression getRight() {
        return right;
    }

    public void setRight(Expression right) {
        this.right = right;
    }

    public BinaryOperator getBinaryOperator() {
        return binaryOperator;
    }

    public void setBinaryOperator(BinaryOperator binaryOperator) {
        this.binaryOperator = binaryOperator;
    }

    @Override
    public String toString() {
        return "BinaryExpression " + binaryOperator.name();
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

