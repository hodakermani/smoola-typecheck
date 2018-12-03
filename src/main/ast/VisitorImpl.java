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
import java.util.HashMap;
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

    @Override
    public void visit(Program program) {
        // init state
        this.varIndex = 0;
        this.lineNumber = 1;

        // create main symbol table
        SymbolTable programSymbolTable = new SymbolTable("program");
        SymbolTable.push(programSymbolTable);

        if (this.passNumber == 1) {
            // added to the list of all symbol tables
            this.allSymbolTables.add(programSymbolTable);
        }

        program.getClasses().forEach(m -> m.accept(this));
        program.getMainClass().accept(this);

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

        if (this.passNumber == 1) {
            // added to the list of all symbol tables
            this.allSymbolTables.add(classScope);
        }

        // extend token care here
        if (this.passNumber == 2) {

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

        }

        classDeclaration.getMethodDeclarations().forEach(m -> m.accept(this));
        classDeclaration.getName().accept(this);
        classDeclaration.getParentName().accept(this);
        classDeclaration.getVarDeclarations().forEach(v -> v.accept(this));

        SymbolTable.pop();
    }

    private SymbolTable findSymbolTable(String parentName) {
        for (int i = 0; i < this.allSymbolTables.size(); i++)
            if (this.allSymbolTables.get(i).getName().equals(parentName))
                return this.allSymbolTables.get(i);
        return null;
    }

    @Override
    public void visit(MethodDeclaration n) {
        String methodName = n.getName().toString();
        ArrayList<Type> argTypes = new ArrayList<>();
        n.getArgs().forEach(a -> argTypes.add(a.getType())); //todo: syntax might be wrong

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

        if (this.passNumber == 1) {
            // added to the list of all symbol tables
            this.allSymbolTables.add(classScope);
        }

        n.getBody().forEach(l -> l.accept(this));
        n.getName().accept(this);
        n.getArgs().forEach(p -> p.accept(this));
        n.getLocalVars().forEach(v -> v.accept(this));

        SymbolTable.pop();
    }

    @Override
    public void visit(VarDeclaration varDeclaration) {
        String varName = varDeclaration.getIdentifier().getName(); //alpha
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

        varDeclaration.getIdentifier().accept(this);
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
