package main.ast;

import main.ast.Type.Type;
import main.ast.node.Program;
import main.ast.node.declaration.ClassDeclaration;
import main.ast.node.declaration.MethodDeclaration;
import main.ast.node.declaration.VarDeclaration;
import main.ast.node.expression.*;
import main.ast.node.expression.Value.BooleanValue;
import main.ast.node.expression.Value.IntValue;
import main.ast.node.expression.Value.StringValue;
import main.ast.node.statement.*;
import main.symbolTable.*;

import java.util.ArrayList;
import java.util.Map;

public class VisitorImpl implements Visitor {

    private int passNumber;
    private int varIndex = 0;
    private int lineNumber = 1;
    private ArrayList<SymbolTable> allSymbolTables= new ArrayList<>();

    public void setPassNumber(int passNumber) {
        this.passNumber = passNumber;
    }

    public void incLineNumber() {
        this.lineNumber++;
    }

    private SymbolTable getCurrentSymbolTable() {
        return this.allSymbolTables.get(this.allSymbolTables.size() - 1);
    }

    private void print(String str) {
        System.out.println(str);
    }

    @Override
    public void visit(Program program) {
        // init state
        this.varIndex = 0;
        this.lineNumber = 1;

        if (this.passNumber == 2)
            this.print(program.toString());

        // create main symbol table
        SymbolTable programSymbolTable = new SymbolTable("program");
        SymbolTable.push(programSymbolTable);

        // added to the list of all symbol tables
        if (this.passNumber == 1)
            this.allSymbolTables.add(programSymbolTable);

        visit(program.getMainClass());
        program.getClasses().forEach(m -> visit(m));

        SymbolTable.pop();
    }

    @Override
    public void visit(ClassDeclaration classDeclaration) {
        String className = classDeclaration.getName().toString();

        boolean error = true;
        do {
            try {
                // create symbol table item
                SymbolTableItem symbolTableItem = new SymbolTableClassItem(className);
                SymbolTable.getCurrentSymbolTable().put(symbolTableItem);
                error = false;
            } catch (ItemAlreadyExistsException e) {
                System.out.println("Line:" + this.lineNumber + ":Redefinition of class " + className);
                className = "Temporary_" + className + "_1";
            }
        } while(error);

        // create the symbol table
        SymbolTable classScope = new SymbolTable(className);
        SymbolTable.push(classScope); // add to stack

        // added to the list of all symbol tables
        if (this.passNumber == 1)
            this.allSymbolTables.add(classScope);

        if (this.passNumber == 2) {
            // 1- extend token care here
            String parentName = classDeclaration.getParentName().getName();
            SymbolTable parentSymbolTable = this.findSymbolTable(parentName);
            SymbolTable currentSymbolTable = this.findSymbolTable(className);

            // add parent symbol table items in the child symbol table
            for (Map.Entry<String, SymbolTableItem> entry : parentSymbolTable.getItems().entrySet()) {
                try {
                    currentSymbolTable.get(entry.getKey());
                } catch (ItemNotFoundException e) {
                    // the child symbol table did not contain the parent's element
                    // add items from the parent to the child
                    error = true;
                    String varName = entry.getKey();
                    do {
                        try {
                            // create symbol table item
                            SymbolTable.getCurrentSymbolTable().put(entry.getValue());
                            error = false;
                        } catch (ItemAlreadyExistsException ex) {
                            System.out.println("Line:" + this.lineNumber + ":Redefinition of variable " + varName);
                            varName = "Temporary_" + varName + "_1";
                        }
                    } while(error);
                }
            }

            // 2- pre-order
            print(classDeclaration.toString());

        }

        visit(classDeclaration.getName());
        visit(classDeclaration.getParentName());
        classDeclaration.getVarDeclarations().forEach(v -> visit(v));
        classDeclaration.getMethodDeclarations().forEach(m -> visit(m));

        SymbolTable.pop();
    }

    private SymbolTable findSymbolTable(String parentName) {
        for (SymbolTable s: this.allSymbolTables)
            if (s.getName().equals(parentName))
                return s;
        return null;
    }

    @Override
    public void visit(MethodDeclaration n) {
        String methodName = n.getName().toString();
        ArrayList<Type> argTypes = new ArrayList<>();
        for (VarDeclaration v: n.getArgs()) {
            argTypes.add(v.getType());
        }

        boolean error = true;
        do {
            try {
                // create symbol table item
                SymbolTableItem symbolTableItem = new SymbolTableMethodItem(methodName, argTypes);
                SymbolTable.getCurrentSymbolTable().put(symbolTableItem);
                error = false;
            } catch (ItemAlreadyExistsException e) {
                System.out.println("Line:" + this.lineNumber + ":Redefinition of method " + methodName);
                methodName = "Temporary_" + methodName + "_1";
            }
        } while(error);

        // create the symbol table
        SymbolTable classScope = new SymbolTable(methodName);
        SymbolTable.push(classScope); // add to stack

        // added to the list of all symbol tables
        if (this.passNumber == 1)
            this.allSymbolTables.add(classScope);

        if (this.passNumber == 2)
            this.print(n.toString());

        visit(n.getName());
        n.getArgs().forEach(p -> visit(p));
        n.getBody().forEach(l -> l.accept(this));
        n.getLocalVars().forEach(v -> visit(v));

        SymbolTable.pop();
    }

    @Override
    public void visit(VarDeclaration varDeclaration) {
        String varName = varDeclaration.getIdentifier().getName();
        Type type = varDeclaration.getType();

        boolean error = true;
        do {
            try {
                // create symbol table item
                SymbolTableItem symbolTableItem = new SymbolTableVariableItemBase(varName, type, varIndex);
                SymbolTable.getCurrentSymbolTable().put(symbolTableItem);
                error = false;
            } catch (ItemAlreadyExistsException e) {
                System.out.println("Line:" + this.lineNumber + ":Redefinition of variable " + varName);
                varName = "Temporary_" + varName + "_1";
            }
        } while(error);

        this.varIndex++;

        if (this.passNumber == 2)
            this.print(varDeclaration.toString());

        visit(varDeclaration.getIdentifier());
    }

    @Override
    public void visit(ArrayCall arrayCall) {
        if (this.passNumber == 2)
            this.print(arrayCall.toString());

        arrayCall.getIndex().accept(this);
        arrayCall.getInstance().accept(this);
    }

    @Override
    public void visit(BinaryExpression binaryExpression) {
        if (this.passNumber == 2)
            this.print(binaryExpression.toString());

        binaryExpression.getLeft().accept(this);
        binaryExpression.getRight().accept(this);
    }

    @Override
    public void visit(Identifier identifier) {
        if (this.passNumber == 2)
            this.print(identifier.toString());
    }

    @Override
    public void visit(Length length) {
        if (this.passNumber == 2)
            this.print(length.toString());

        length.getExpression().accept(this);
    }

    @Override
    public void visit(MethodCall methodCall) {
        if (this.passNumber == 2)
            this.print(methodCall.toString());

        methodCall.getArgs().forEach(m -> m.accept(this));
    }

    @Override
    public void visit(NewArray newArray) {
        if (this.passNumber == 2)
            this.print(newArray.toString());

        newArray.getExpression().accept(this);
    }

    @Override
    public void visit(NewClass newClass) {
        if (this.passNumber == 2)
            this.print(newClass.toString());

//        newClass.getClassName().accept(this);
    }

    @Override
    public void visit(This instance) {
        if (this.passNumber == 2)
            this.print(instance.toString());

//        instance.accept(this);
    }

    @Override
    public void visit(UnaryExpression unaryExpression) {
        if (this.passNumber == 2)
            this.print(unaryExpression.toString());

        unaryExpression.getValue().accept(this);
    }

    @Override
    public void visit(BooleanValue value) {
        if (this.passNumber == 2)
            this.print(value.toString());

//        value.accept(this);
    }

    @Override
    public void visit(IntValue value) {
        if (this.passNumber == 2)
            this.print(value.toString());

//        value.accept(this);
    }

    @Override
    public void visit(StringValue value) {
        if (this.passNumber == 2)
            this.print(value.toString());

//        value.accept(this);
    }

    @Override
    public void visit(Assign assign) {
        if (this.passNumber == 2)
            this.print(assign.toString());

        assign.getlValue().accept(this);
        assign.getrValue().accept(this);
    }

    @Override
    public void visit(Block block) {
        if (this.passNumber == 2)
            this.print(block.toString());

        block.getBody().forEach(b -> b.accept(this));
    }

    @Override
    public void visit(Conditional conditional) {
        if (this.passNumber == 2)
            this.print(conditional.toString());

        conditional.getExpression().accept(this);
        conditional.getConsequenceBody().accept(this);
        conditional.getAlternativeBody().accept(this);
    }

    @Override
    public void visit(While loop) {
        if (this.passNumber == 2)
            this.print(loop.toString());

        loop.getCondition().accept(this);
        loop.getBody().accept(this);
    }

    @Override
    public void visit(Write write) {
        if (this.passNumber == 2)
            this.print(write.toString());

       write.getArg().accept(this);
    }
}
