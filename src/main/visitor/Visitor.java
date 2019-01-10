package main.visitor;

import jdk.internal.org.objectweb.asm.ClassWriter;
import jdk.internal.org.objectweb.asm.MethodVisitor;
import main.ast.node.Node;
import main.ast.node.Program;
import main.ast.node.declaration.ClassDeclaration;
import main.ast.node.declaration.MainMethodDeclaration;
import main.ast.node.declaration.MethodDeclaration;
import main.ast.node.declaration.VarDeclaration;
import main.ast.node.expression.*;
import main.ast.node.expression.Value.BooleanValue;
import main.ast.node.expression.Value.IntValue;
import main.ast.node.expression.Value.StringValue;
import main.ast.node.statement.*;

public interface Visitor {
    void visit(Node node);
    void visit(Program program);

    //Declarations
    void visit(ClassDeclaration classDeclaration);
    void visit(MethodDeclaration methodDeclaration, ClassWriter cw);
    void visit(MainMethodDeclaration mainMethodDeclaration, ClassWriter cw);
    void visit(VarDeclaration varDeclaration, ClassWriter cw);

    //Expressions
    void visit(ArrayCall arrayCall);
    void visit(BinaryExpression binaryExpression, MethodVisitor mv);
    void visit(Identifier identifier);
    void visit(Length length);
    void visit(MethodCall methodCall);
    void visit(NewArray newArray);
    void visit(NewClass newClass);
    void visit(This instance);
    void visit(UnaryExpression unaryExpression);
    void visit(BooleanValue value, MethodVisitor mv);
    void visit(IntValue value, MethodVisitor mv);
    void visit(StringValue value, MethodVisitor mv);

    //Statements
    void visit(Assign assign, MethodVisitor mv);
    void visit(Block block, MethodVisitor mv);
    void visit(Conditional conditional, MethodVisitor mv);
    void visit(While loop, MethodVisitor mv);
    void visit(Write write, MethodVisitor mv);






}
