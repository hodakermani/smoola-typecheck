package main.ast;
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
        n.getBody().forEach(l -> l.accept(this));
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
        binaryExpression.getLeft().accept(this);
        binaryExpression.getRight().accept(this);
    }

    @Override
    public void visit(Identifier identifier) {
        identifier.accept(this);
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
       instance.accept(this);
    }

    @Override
    public void visit(UnaryExpression unaryExpression) {
        unaryExpression.getValue().accept(this);
    }

    @Override
    public void visit(BooleanValue value) {
        value.accept(this);
    }

    @Override
    public void visit(IntValue value) {
        value.accept(this);
    }

    @Override
    public void visit(StringValue value) {
        value.accept(this);
    }

    @Override
    public void visit(Assign assign) {
        assign.accept(this);

    }

    @Override
    public void visit(Block block) {
        block.getBody().forEach(b -> b.accept(this));
    }

    @Override
    public void visit(Conditional conditional) {
        conditional.getAlternativeBody().accept(this);
        conditional.getConsequenceBody().accept(this);
        conditional.getExpression().accept(this);
    }

    @Override
    public void visit(While loop) {
        loop.getBody().accept(this);
        loop.getCondition().accept(this);
    }

    @Override
    public void visit(Write write) {
       write.accept(this);
    }
}
