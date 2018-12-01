package main.ast;
import java.util.Optional;
import main.ast.node.Program;
import main.ast.node.declaration.ClassDeclaration;
import main.ast.node.declaration.MethodDeclaration;
import main.ast.node.declaration.VarDeclaration;
import main.ast.node.expression.*;
import main.ast.node.expression.Value.BooleanValue;
import main.ast.node.expression.Value.IntValue;
import main.ast.node.expression.Value.StringValue;
import main.ast.node.statement.*;

public class VisitorImpl implements Visitor {

    @Override
    public void visit(Program program) {
        program.getClasses().forEach(m -> m.accept(this));
        program.getMainClass().accept(this);
    }

    @Override
    public void visit(ClassDeclaration classDeclaration) {
        classDeclaration.getMethodDeclarations().forEach(m -> m.accept(this));
        classDeclaration.getName().accept(this);
        classDeclaration.getParentName().accept(this);
        classDeclaration.getVarDeclarations().forEach(v -> v.accept(this));
    }

    @Override
    public void visit(MethodDeclaration n) {
        n.getBody().ifPresent(l -> l.accept(this));
        n.getReturnType(); //todo: check accept for type
        n.getName().accept(this);
        n.getArgs().forEach(p -> p.accept(this));
        n.getLocalVars().forEach(v -> v.accept(this));
    }

    @Override
    public void visit(VarDeclaration varDeclaration) {
        varDeclaration.getIdentifier().accept(this);
        varDeclaration.getType();
    }

    @Override
    public void visit(ArrayCall arrayCall) {
       arrayCall.getIndex().accept(this);
       arrayCall.getInstance().accept(this);
    }

    @Override
    public void visit(BinaryExpression binaryExpression) {
      binaryExpression.getBinaryOperator(); //todo: accept?
        binaryExpression.getLeft().accept(this);
        binaryExpression.getRight().accept(this);
    }

    @Override
    public void visit(Identifier identifier) {
        //TODO: implement appropriate visit functionality
        identifier.getClass()
    }

    @Override
    public void visit(Length length) {
        length.getExpression().accept(this);
    }

    @Override
    public void visit(MethodCall methodCall) {
        methodCall.getArgs().forEach(m -> m.accept(this));
    }

    @Override
    public void visit(NewArray newArray) {
            newArray.getExpression().accept(this);

    }

    @Override
    public void visit(NewClass newClass) {
        newClass.getClassName().accept(this);
    }

    @Override
    public void visit(This instance) {
       //todo: accept?
    }

    @Override
    public void visit(UnaryExpression unaryExpression) {
        unaryExpression.getUnaryOperator(); //todo: accept for unary operator
    }

    @Override
    public void visit(BooleanValue value) {
        //todo
    }

    @Override
    public void visit(IntValue value) {
    }

    @Override
    public void visit(StringValue value) {
        //TODO: implement appropriate visit functionality
    }

    @Override
    public void visit(Assign assign) {
        //TODO: implement appropriate visit functionality
    }

    @Override
    public void visit(Block block) {
        //TODO: implement appropriate visit functionality
    }

    @Override
    public void visit(Conditional conditional) {
        //TODO: implement appropriate visit functionality
    }

    @Override
    public void visit(While loop) {
        //TODO: implement appropriate visit functionality
    }

    @Override
    public void visit(Write write) {
        //TODO: implement appropriate visit functionality
    }
}
