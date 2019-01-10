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

public abstract class VisitorImpl implements Visitor {
    protected void visitStatement( Statement stat, MethodVisitor mv )
    {
        if( stat == null )
            return;
        else if( stat instanceof Write )
            this.visit( ( Write ) stat,  mv );
        else if( stat instanceof Block )
            this.visit( ( Block ) stat,  mv );
        else if( stat instanceof Conditional )
            this.visit( ( Conditional ) stat,  mv );
        else if( stat instanceof Assign )
            this.visit( ( Assign ) stat, mv );
        else if( stat instanceof While )
            this.visit( ( While ) stat, mv );
    }
    protected void visitExpr( Expression expr )
    {
        if( expr == null )
            return;
        else if( expr instanceof ArrayCall )
            this.visit( ( ArrayCall ) expr );
        else if( expr instanceof BinaryExpression )
            this.visit( ( BinaryExpression ) expr );
        else if( expr instanceof Identifier )
            this.visit( ( Identifier ) expr );
        else if( expr instanceof Length )
            this.visit( ( Length ) expr );
        else if( expr instanceof MethodCall )
            this.visit( ( MethodCall ) expr );
        else if( expr instanceof NewArray )
            this.visit( ( NewArray ) expr );
        else if( expr instanceof NewClass )
            this.visit( ( NewClass ) expr );
        else if( expr instanceof This )
            this.visit( ( This ) expr );
        else if( expr instanceof UnaryExpression )
            this.visit( ( UnaryExpression ) expr );
        else if( expr instanceof BooleanValue )
            this.visit( ( BooleanValue ) expr );
        else if( expr instanceof IntValue )
            this.visit( ( IntValue ) expr );
        else if( expr instanceof StringValue )
            this.visit( ( StringValue ) expr );
    }
    public abstract void visit (Node node);
    public abstract void visit (Program program);

    //Declarations
    public abstract void visit (ClassDeclaration classDeclaration);
    public abstract void visit (MethodDeclaration methodDeclaration, ClassWriter cw);
    public abstract void visit (MainMethodDeclaration mainMethodDeclaration);
    public abstract void visit (VarDeclaration varDeclaration, ClassWriter cw);

    //Expressions
    public abstract void visit(ArrayCall arrayCall);
    public abstract void visit(BinaryExpression binaryExpression);
    public abstract void visit(Identifier identifier);
    public abstract void visit(Length length);
    public abstract void visit(MethodCall methodCall);
    public abstract void visit(NewArray newArray);
    public abstract void visit(NewClass newClass);
    public abstract void visit(This instance);
    public abstract void visit(UnaryExpression unaryExpression);
    public abstract void visit(BooleanValue value);
    public abstract void visit(IntValue value);
    public abstract void visit(StringValue value);

    //Statements
    public abstract void visit(Assign assign);
    public abstract void visit(Block block);
    public abstract void visit(Conditional conditional);
    public abstract void visit(While loop);
    public abstract void visit(Write write);
}
