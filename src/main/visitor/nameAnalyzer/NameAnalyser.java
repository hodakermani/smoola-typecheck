package main.visitor.nameAnalyzer;
import jdk.internal.org.objectweb.asm.ClassWriter;
import main.ast.Type.Type;
import main.ast.Type.UserDefinedType.UserDefinedType;
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
import main.symbolTable.ClassSymbolTableItem;
import main.symbolTable.SymbolTable;
import main.symbolTable.SymbolTableItem;
import main.symbolTable.SymbolTableMethodItem;
import main.symbolTable.itemException.ItemNotFoundException;
import main.symbolTable.symbolTableVariable.SymbolTableFieldVariableItem;
import main.symbolTable.symbolTableVariable.SymbolTableLocalVariableItem;
import main.symbolTable.symbolTableVariable.SymbolTableMethodArgumentItem;
import main.symbolTable.symbolTableVariable.SymbolTableVariableItemBase;
import main.visitor.VisitorImpl;
import jdk.internal.org.objectweb.asm.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import static jdk.internal.org.objectweb.asm.Opcodes.ACC_PUBLIC;
import static jdk.internal.org.objectweb.asm.Opcodes.V1_8;
import static sun.tools.java.RuntimeConstants.ACC_FINAL;

public class NameAnalyser extends VisitorImpl {
    private SymbolTableConstructor symConstructor;
    private TraverseState traverseState;
    private SymbolTableClassParentLinker symTableClassLinker;
    private ArrayList<String> nameErrors;
    private int lastIndexOfVariable;
    public NameAnalyser()
    {
        symConstructor = new SymbolTableConstructor();
        symTableClassLinker = new SymbolTableClassParentLinker();
        nameErrors = new ArrayList<>();
        lastIndexOfVariable = 0;
        setState( TraverseState.symbolTableConstruction );
    }
    public int numOfErrors()
    {
        return nameErrors.size();
    }
    private void switchState()
    {
        if( traverseState.name().equals( TraverseState.symbolTableConstruction.toString() ) )
            setState( TraverseState.redefinitionAndArrayErrorCatching );
        else if( traverseState.name().equals( TraverseState.redefinitionAndArrayErrorCatching.toString() ) && nameErrors.size() != 0 )
            setState( TraverseState.PrintError );
        else
            setState( TraverseState.Exit );
    }

    private void setState( TraverseState traverseState )
    {
        this.traverseState = traverseState;
    }

    private void checkForPropertyRedefinition( ClassDeclaration classDeclaration )
    {
        String name = classDeclaration.getName().getName();
        if( name.indexOf( '$' ) != -1 )
            nameErrors.add( "Line:" + classDeclaration.getName().getLineNum() + ":Redefinition of class " + name.substring( name.indexOf( '$' ) + 1 ) );
        try
        {
            ClassSymbolTableItem classItem = ( ClassSymbolTableItem ) SymbolTable.root.getInCurrentScope(ClassSymbolTableItem.CLASS + name );
            SymbolTable next = classItem.getClassSym();
            SymbolTable.push( next );
        }
        catch( ItemNotFoundException itemNotFound )
        {
            System.out.println( "there is an error in pushing class symbol table" );
        }
    }
    private void checkForPropertyRedefinitionInParentScopes( VarDeclaration varDeclaration )
    {
        String name = varDeclaration.getIdentifier().getName();
        Set<SymbolTable> visitedSymbolTables = new HashSet<>();
        String variableKey = SymbolTableVariableItemBase.VARIABLE + name;
        SymbolTable current = SymbolTable.top.getPreSymbolTable();
        visitedSymbolTables.add( SymbolTable.top );
        while( current != null &&  !visitedSymbolTables.contains( current ) )
        {
            visitedSymbolTables.add( current );
            try {
                current.getInCurrentScope( variableKey );
                SymbolTableVariableItemBase variable = (SymbolTableVariableItemBase) SymbolTable.top.getInCurrentScope(variableKey);
                variable.setName( "$" + variable.getName() );
                SymbolTable.top.updateItemInCurrentScope( variableKey , variable );
                nameErrors.add("Line:" + varDeclaration.getIdentifier().getLineNum() + ":Redefinition of variable " + name.substring(name.indexOf('$') + 1) );
                return;
            }
            catch( ItemNotFoundException itemNotFound )
            {
                current = current.getPreSymbolTable();
            }
        }
    }
    private void checkForPropertyRedefinition( VarDeclaration varDeclaration )
    {
        String name = varDeclaration.getIdentifier().getName();
        if( name.indexOf( '$' ) != -1 ) {
            nameErrors.add("Line:" + varDeclaration.getIdentifier().getLineNum() + ":Redefinition of variable " + name.substring(name.indexOf('$') + 1) );
            return;
        }
        try {
            SymbolTableVariableItemBase varItem = ( SymbolTableVariableItemBase) SymbolTable.top.getInCurrentScope( SymbolTableVariableItemBase.VARIABLE + name );
            varItem.setIndex( lastIndexOfVariable++ );
            SymbolTable.top.updateItemInCurrentScope( SymbolTableVariableItemBase.VARIABLE + name , varItem );
            if( varItem instanceof SymbolTableFieldVariableItem )
                checkForPropertyRedefinitionInParentScopes(varDeclaration);
        }
        catch( ItemNotFoundException itemNotFound )
        {
            System.out.println( "not important" );
        }
    }

    private void checkForPropertyRedefinitionInParentScope( MethodDeclaration methodDeclaration )
    {
        String name = methodDeclaration.getName().getName();
        String methodKey = SymbolTableMethodItem.METHOD + name;
        SymbolTable current = SymbolTable.top.getPreSymbolTable();
        Set<SymbolTable> visitedSymbolTables = new HashSet<>();
        visitedSymbolTables.add( SymbolTable.top );
        while( current != null && !visitedSymbolTables.contains( current ) )
        {
            visitedSymbolTables.add( current );
            try {
                current.getInCurrentScope( methodKey );
                SymbolTableMethodItem method = (SymbolTableMethodItem) SymbolTable.top.getInCurrentScope(methodKey);
                method.setName( "$" + method.getName() );
                SymbolTable.top.updateItemInCurrentScope( methodKey , method );
                nameErrors.add("Line:" + methodDeclaration.getName().getLineNum() + ":Redefinition of method " + name.substring(name.indexOf('$') + 1) );
                return;
            }
            catch( ItemNotFoundException itemNotFound )
            {
                current = current.getPreSymbolTable();
            }
        }
    }
    private void checkForPropertyRedefinition( MethodDeclaration methodDeclaration )
    {
        String name = methodDeclaration.getName().getName();
        SymbolTable next = null;
        String methodKey = SymbolTableMethodItem.METHOD + name;
        try
        {
            next = (( SymbolTableMethodItem )SymbolTable.top.getInCurrentScope( methodKey ) ).getMethodSymbolTable();
        }
        catch( ItemNotFoundException itemNotFound )
        {
            System.out.println( "an error occurred in pushing method symbol table" );
            return;
        }
        if( name.indexOf( '$' ) != -1 ) {
            nameErrors.add("Line:" + methodDeclaration.getName().getLineNum() + ":Redefinition of method " + name.substring(name.indexOf('$') + 1) );
            SymbolTable.push( next );
            return;
        }
        checkForPropertyRedefinitionInParentScope( methodDeclaration );
        SymbolTable.push( next );
    }
    @Override
    public void visit(Node node) {
        //TODO: implement appropriate visit functionality
    }

    @Override
    public void visit(Program program){

        //TODO: implement appropriate visit functionality
        while( !traverseState.toString().equals( TraverseState.Exit.toString() )) {
            if (traverseState.name().equals(TraverseState.symbolTableConstruction.toString()))
                symConstructor.constructProgramSym();
            else if (traverseState.name().equals(TraverseState.redefinitionAndArrayErrorCatching.toString()))
                symTableClassLinker.findClassesParents(program);
            else if( traverseState.name().equals( TraverseState.PrintError.toString() ) ) {
                for (String error : nameErrors)
                    System.out.println(error);
                return;
            }
            this.visit(program.getMainClass());
            for (ClassDeclaration classDeclaration : program.getClasses())
                this.visit(classDeclaration);
            switchState();
        }
    }

    @Override
    public void visit(ClassDeclaration classDeclaration) {
        //TODO: implement appropriate visit functionality
        ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES);

        if( classDeclaration == null )
            return;
        String className = classDeclaration.getName().getName();

        if( traverseState.name().equals( TraverseState.symbolTableConstruction.toString() ) ) {
            symConstructor.construct( classDeclaration, className);
        }
        else if( traverseState.name().equals( TraverseState.redefinitionAndArrayErrorCatching.toString() ) )
            checkForPropertyRedefinition( classDeclaration );
        visitExpr( classDeclaration.getName() );
        visitExpr( classDeclaration.getParentName() );

        cw.visit(V1_8, ACC_PUBLIC, className, null, "java/lang/Object", new String[] { classDeclaration.getParentName().getName().toString() });

        for( VarDeclaration varDeclaration: classDeclaration.getVarDeclarations() ) {
            this.visit(varDeclaration);
            cw.visitField(ACC_PUBLIC , varDeclaration.getIdentifier().getName().toString(), convertTypesToASM(varDeclaration.selfType),
                    null, null).visitEnd();
        }
        for( MethodDeclaration methodDeclaration: classDeclaration.getMethodDeclarations() ) {
            this.visit(methodDeclaration, cw);
        }
        SymbolTable.pop();
    }
    private String convertTypesToASM (String type) {
        if(type.equals("int")) {
            return "I";
        }  else if(type.equals("bool")) {
            return "Z";
        } else if (type.equals("int[]")) {
            return "[I";
        } else if(type.equals("string")) {
            return "S";
        } else {
            return "Ljava/lang/Object;";
        }
    };

    private String getArgTypes(ArrayList<VarDeclaration> vars) {
        String s = "";
        for( VarDeclaration varDeclaration: vars ) {
            s += convertTypesToASM(varDeclaration.getType().toString());
        }
        return s;
    }

    @Override
    public void visit(MethodDeclaration methodDeclaration, ClassWriter cw) {
        //TODO: implement appropriate visit functionality
        if( methodDeclaration == null )
            return;
        if( traverseState.name().equals( TraverseState.symbolTableConstruction.toString() ) )
            symConstructor.construct( methodDeclaration );
        else if( traverseState.name().equals( TraverseState.redefinitionAndArrayErrorCatching.toString() ) )
            checkForPropertyRedefinition( methodDeclaration );
        for( VarDeclaration argDeclaration: methodDeclaration.getArgs() )
            visit( argDeclaration );
        for( VarDeclaration localVariable: methodDeclaration.getLocalVars() )
            this.visit( localVariable );
        for( Statement statement : methodDeclaration.getBody() )
            visitStatement( statement );
        visitExpr( methodDeclaration.getReturnValue() );
        MethodVisitor mv = cw.visitMethod(ACC_PUBLIC, methodDeclaration.getName().toString(), "(" + getArgTypes(methodDeclaration.getArgs()) + ")" + methodDeclaration.getActualReturnType().toString(), null, null);
        mv.visitCode();
        Label methodStart = new Label();
        Label methodEnd = new Label();
        mv.visitLabel(methodStart);

        for( VarDeclaration localVariable: methodDeclaration.getLocalVars() ) {
            mv.visitLocalVariable(localVariable.getIdentifier().getName(),convertTypesToASM(localVariable.getType().toString()),null,methodStart,methodEnd, /*get indx of this variable from symbol table*/);
        }
        SymbolTable.pop();
    }

    @Override
    public void visit(MainMethodDeclaration mainMethodDeclaration) {
        //TODO: implement appropriate visit functionality
        if( mainMethodDeclaration == null )
            return;
        if( traverseState.name().equals( TraverseState.symbolTableConstruction.toString() ) )
            visit( ( MethodDeclaration ) mainMethodDeclaration );
        else if( traverseState.name().equals( TraverseState.redefinitionAndArrayErrorCatching.toString()) )
            visit( ( MethodDeclaration ) mainMethodDeclaration );
        for( Statement statement : mainMethodDeclaration.getBody() )
            visitStatement( statement );
        visitExpr( mainMethodDeclaration.getReturnValue() );
    }

    @Override
    public void visit(VarDeclaration varDeclaration, ClassWriter cw) {

        if( varDeclaration == null )
            return;
        if( traverseState.name().equals( TraverseState.redefinitionAndArrayErrorCatching.toString() ) )
            checkForPropertyRedefinition( varDeclaration );
        visitExpr( varDeclaration.getIdentifier() );

        if (varDeclaration.getType() == null)
            varDeclaration.setType(new UserDefinedType(varDeclaration.getIdentifier()));
    }

    @Override
    public void visit(ArrayCall arrayCall) {
        //TODO: implement appropriate visit functionality
        if( arrayCall == null )
            return;
        try {
            visitExpr( arrayCall.getInstance() );
            visitExpr( arrayCall.getIndex() );
            if(arrayCall.getInstance().typeCorrect && arrayCall.getInstance().selfType.equals("int[]") && arrayCall.getIndex().typeCorrect && arrayCall.getIndex().selfType.equals("int")) {
                arrayCall.typeCorrect = true;
                arrayCall.selfType = "int";
                arrayCall.getType().isRightValue = true;
            } else {
                //System.out.println("array call type error!");
                this.addError("array call type error!", arrayCall.getLineNum());
            }
        }
        catch( NullPointerException npe )
        {
            System.out.println( "instance or index is null" );
        }

    }

    @Override
    public void visit(BinaryExpression binaryExpression) {
        //TODO: implement appropriate visit functionality
        if( binaryExpression == null )
            return;
        Expression lOperand = binaryExpression.getLeft();
        Expression rOperand = binaryExpression.getRight();
        try {
            visitExpr(lOperand);
            visitExpr(rOperand);
            if(lOperand.typeCorrect && rOperand.typeCorrect) {
                if(binaryExpression.getBinaryOperator().toString().equals("eq") || binaryExpression.getBinaryOperator().toString().equals("neq")) {
                    if(lOperand.typeCorrect && rOperand.typeCorrect && !lOperand.selfType.equals(rOperand.selfType)) {
                        binaryExpression.typeCorrect = false;
                        this.addError("left and right side types of equality binaryExpressions must be equal",binaryExpression.getLineNum());
                    } else if(lOperand.selfType.equals("int[]") && rOperand.selfType.equals("int[]")){
                       //todo: check for length equality
//                        System.out.println("haha");
//                        ArrayCall a = (ArrayCall) lOperand;
//                        ArrayCall b = (ArrayCall) rOperand;
//                        if( ((IntValue) a.getIndex()).getConstant() == ((IntValue) b.getIndex()).getConstant()) {
//                            binaryExpression.typeCorrect = true;
//                            binaryExpression.selfType = "bool";
//                        } else {
//                            binaryExpression.typeCorrect = false;
//                            System.out.println("arrays length do not match");
//                        }
                    }else {
                        binaryExpression.typeCorrect = true;
                        binaryExpression.selfType = "bool";
                    }
                } else if (binaryExpression.getBinaryOperator().toString().equals("and") || binaryExpression.getBinaryOperator().toString().equals("or")) {
                    if(lOperand.typeCorrect && rOperand.typeCorrect) {
                        if(lOperand.selfType.equals("bool") && rOperand.selfType.equals("bool")) {
                            binaryExpression.selfType = "bool";
                            binaryExpression.typeCorrect = true;
                        } else {
                            binaryExpression.typeCorrect = false;
                            this.addError("and/or oprands must be boolean",binaryExpression.getLineNum());
                        }
                    }
                } else if (binaryExpression.getBinaryOperator().toString().equals("lt") || binaryExpression.getBinaryOperator().toString().equals("gt") || binaryExpression.getBinaryOperator().toString().equals("lte")) {
                    if(lOperand.typeCorrect && rOperand.typeCorrect) {
                        if(lOperand.selfType.equals("int") && rOperand.selfType.equals("int")) {
                            binaryExpression.selfType = "bool";
                            binaryExpression.typeCorrect = true;
                        } else {
                            binaryExpression.typeCorrect = false;
                            this.addError("gt/lt oprands must be int",binaryExpression.getLineNum());
                        }
                    }
                } else if (binaryExpression.getBinaryOperator().toString().equals("div") || binaryExpression.getBinaryOperator().toString().equals("mult") &&
                        binaryExpression.getBinaryOperator().toString().equals("add") || binaryExpression.getBinaryOperator().toString().equals("sub")) {
                    if(lOperand.typeCorrect && rOperand.typeCorrect) {
                        if(lOperand.selfType.equals("int") && rOperand.selfType.equals("int")) {
                            binaryExpression.selfType = "int";
                            binaryExpression.typeCorrect = true;
                        } else {
                            binaryExpression.typeCorrect = false;
                            this.addError("arithmetical operators oprand must be int",binaryExpression.getLineNum());
                        }
                    }
                }
            }
        }
        catch( NullPointerException npe )
        {
            System.out.println( "one of operands is null, there is a syntax error" );
        }
    }

    @Override
    public void visit(Identifier identifier) {
        //TODO: implement appropriate visit functionality
        identifier.typeCorrect = true;

        if (identifier.getType() != null)
            return;

        String name = identifier.getName();
        SymbolTable currentSymbolTable = SymbolTable.top;
        try {
            SymbolTableItem item = currentSymbolTable.find(name);
            identifier.setType(item.getType());
            identifier.selfType = item.getType().toString();
//            identifier.getType().isRightValue = false;
        } catch (ItemNotFoundException e) {
            this.addError("variable " + name + " is not declared", identifier.getLineNum());
        }
    }

    @Override
    public void visit(Length length) {
        //TODO: implement appropriate visit functionality
        if( length == null )
            return;
        visitExpr( length.getExpression() );
        if(length.getExpression().typeCorrect && length.getExpression().selfType.equals("int[]")) {
            length.typeCorrect = true;
            length.selfType = "int";
        } else {
            this.addError("invalid type for length function",length.getLineNum());
        }
    }

    @Override
    public void visit(MethodCall methodCall) {
        if( methodCall == null )
            return;
        try {
            visitExpr(methodCall.getInstance());
            String className = methodCall.getInstance().getType().toString();
            ClassSymbolTableItem classSymbolTableItem = null;
            SymbolTableMethodItem methodSymbolTableItem = null;
            try {
                if( traverseState == TraverseState.redefinitionAndArrayErrorCatching )
                    classSymbolTableItem = (ClassSymbolTableItem) SymbolTable.root.find(className);
            } catch (ItemNotFoundException e) {
                this.addError("class " + className + " is not declared" + className, methodCall.getInstance().getLineNum());
                return;
            }

            String methodName = methodCall.getMethodName().getName();
            try {
                Expression methodReturnType = ((SymbolTableMethodItem)classSymbolTableItem.getClassSym().find(methodName)).getMethodDeclaration().getReturnValue();
                Type methodActualReturnType = ((SymbolTableMethodItem)classSymbolTableItem.getClassSym().find(methodName)).getMethodDeclaration().getActualReturnType();
                visitExpr(methodReturnType);
                methodCall.typeCorrect = true;
                methodCall.selfType = methodReturnType.selfType;
                if(!methodReturnType.getType().toString().equals(methodActualReturnType.toString())) {
                   this.addError(methodName + " return type must be " + methodActualReturnType.toString(), methodCall.getLineNum()); //todo: extention not handled
                }

            } catch (ItemNotFoundException e) {
                this.addError("there is no method named " + methodName + " in class " + className, methodCall.getInstance().getLineNum());
                return;
            }

            try {
                if( traverseState == TraverseState.redefinitionAndArrayErrorCatching )
                    classSymbolTableItem.getClassSym().find(methodName);
            } catch (ItemNotFoundException e) {
                this.addError("there is no method named " + methodName + " in class " + className, methodCall.getInstance().getLineNum());
                return;
            }


//            try {
//                if( traverseState == TraverseState.redefinitionAndArrayErrorCatching )
//                    methodSymbolTableItem = (SymbolTableMethodItem) SymbolTable.root.find(methodName);
//            }catch (ItemNotFoundException e) {
//                this.addError("there is no method named " + methodName + " in class " + className, methodCall.getInstance().getLineNum());
//                return;
//            }
//            if(!((methodSymbolTableItem.getMethodDeclaration().getReturnValue().getType()) instanceof (methodSymbolTableItem.getMethodDeclaration().getActualReturnType()))) {
//                System.out.println("return type problem");
//            }

            methodCall.getMethodName().setType(new UserDefinedType(methodCall.getMethodName()));

            visitExpr(methodCall.getMethodName());
            for (Expression argument : methodCall.getArgs())
                visitExpr(argument);

            ArrayList<Expression> arguments = methodCall.getArgs();
            ArrayList<Type> methodArguments = null;
            try {
                if( traverseState != TraverseState.redefinitionAndArrayErrorCatching )
                    return;

                methodArguments = ((SymbolTableMethodItem)classSymbolTableItem.getClassSym().find(methodName)).getArgTypes();
                if (methodArguments.size() != arguments.size()) {
                    this.addError("number of arguments used for calling " + methodName + " do not match method signature ", methodCall.getInstance().getLineNum());
                    return;
                }
                for (int i = 0; i < arguments.size(); i++) {
                    Type methodType = methodArguments.get(i);
                    Type calledType = arguments.get(i).getType();
                    if (!methodType.equals(calledType)) {
                        this.addError("arguments used for calling " + methodName + " do not match method signature ", methodCall.getInstance().getLineNum());
                        return;
                    }
                }
            } catch (ItemNotFoundException e) {
                this.addError("there is no method named " + methodName + " in class " + className, methodCall.getInstance().getLineNum());
                return;
            }
        }
        catch( NullPointerException npe )
        {
            System.out.println( "syntax error occurred" );
        }
    }

    @Override
    public void visit(NewArray newArray) {
        //TODO: implement appropriate visit functionality
        if( newArray == null )
            return;
        if( traverseState.name().equals( TraverseState.redefinitionAndArrayErrorCatching.toString() ) )
            if( newArray.getExpression() instanceof IntValue && ((IntValue) newArray.getExpression()).getConstant() <= 0 )
            {
                nameErrors.add( "Line:" + newArray.getExpression().getLineNum() + ":Array length should not be zero or negative" );
                newArray.typeCorrect = false;
                ((IntValue) newArray.getExpression()).setConstant( 0 );
            }
        visitExpr( newArray.getExpression() );
        newArray.typeCorrect = true;
        newArray.selfType = "int[]";
    }

    @Override
    public void visit(NewClass newClass) {
        //TODO: implement appropriate visit functionality
        if( newClass == null )
            return;
        UserDefinedType u = new UserDefinedType(newClass.getClassName());
        newClass.setType(u);
        newClass.typeCorrect = true;
        newClass.selfType = newClass.getClassName().getName();
        visitExpr( newClass.getClassName());
    }

    @Override
    public void visit(This instance) {
        SymbolTable top = SymbolTable.top.getPreSymbolTable();
        String className = top.getName();
        try {
            Type t = SymbolTable.root.get(ClassSymbolTableItem.CLASS + className).getType();
            instance.setType(t);
            instance.typeCorrect = true;
            instance.selfType = className;
        } catch (ItemNotFoundException e) {
            this.addError("class " + className + " is not declared" + className, instance.getLineNum());
        }
    }

    @Override
    public void visit(UnaryExpression unaryExpression) {
        //TODO: implement appropriate visit functionality
        if( unaryExpression == null )
            return;
        try {
            visitExpr(unaryExpression.getValue());
            if(unaryExpression.getValue().typeCorrect && unaryExpression.getValue().selfType.equals("bool") && unaryExpression.getUnaryOperator().toString().equals("not")) {
                unaryExpression.typeCorrect = true;
                unaryExpression.selfType = "bool";
            } else if(unaryExpression.getValue().typeCorrect && unaryExpression.getValue().selfType.equals("int") && unaryExpression.getUnaryOperator().toString().equals("minus")) {
                unaryExpression.typeCorrect = true;
                unaryExpression.selfType = "int";
            } else {
                unaryExpression.typeCorrect = false;
                this.addError("not a valid type for unary expression", unaryExpression.getLineNum());
            }
        }
        catch( NullPointerException npe )
        {
            System.out.println("unary value is null");
        }
    }

    @Override
    public void visit(BooleanValue value) {
        //TODO: implement appropriate visit functionality
        value.typeCorrect = true;
        value.selfType = "bool";
    }

    @Override
    public void visit(IntValue value) {
        //TODO: implement appropriate visit functionality
        value.typeCorrect = true;
        value.selfType = "int";
    }

    @Override
    public void visit(StringValue value) {
        //TODO: implement appropriate visit functionality
        value.typeCorrect = true;
        value.selfType = "string";
    }

    @Override
    public void visit(Assign assign) {
        //TODO: implement appropriate visit functionality
        if( assign == null )
            return;
        try {
            Expression lExpr = assign.getlValue();
            visitExpr(lExpr);
            Expression rValExpr = assign.getrValue();
            if (rValExpr != null)
                visitExpr(rValExpr);
            if( lExpr instanceof BooleanValue ||  lExpr instanceof IntValue ||  lExpr instanceof StringValue) {
                assign.typeCorrect = false;
                this.addError("left side of assignment must be a valid lvalue", lExpr.getLineNum());
            } else if(!lExpr.selfType.equals(rValExpr.selfType)) {
                assign.typeCorrect = false;
                this.addError("left side of assignment must be a valid lvalue", lExpr.getLineNum());
            } else {
                assign.typeCorrect = true;
            }
            //if (lExpr.getType().isRightValue)
               // this.addError("left side of assignment must be a left value", lExpr.getLineNum());
        }
        catch( NullPointerException npe )
        {
            System.out.println("lvalue expression is null");
        }
    }

    @Override
    public void visit(Block block) {
        //TODO: implement appropriate visit functionality
        if( block == null )
            return;
        for( Statement blockStat : block.getBody() )
            this.visitStatement( blockStat );
    }

    @Override
    public void visit(Conditional conditional) {
        //TODO: implement appropriate visit functionality
        if( conditional == null )
            return;
        visitExpr( conditional.getExpression() );
        visitStatement( conditional.getConsequenceBody() );
        visitStatement( conditional.getAlternativeBody() );
        if(conditional.getExpression().typeCorrect && conditional.getExpression().selfType.equals("bool")) {
            conditional.typeCorrect = true;
        } else {
            conditional.typeCorrect = false;
            this.addError("condition type must be boolean", conditional.getLineNum());
        }
    }

    @Override
    public void visit(While loop) {
        //TODO: implement appropriate visit functionality
        if( loop == null )
            return;
        visitExpr( loop.getCondition() );
        visitStatement( loop.getBody() );
        if(loop.getCondition().typeCorrect && loop.getCondition().selfType.equals("bool")) {
            loop.typeCorrect = true;
        } else {
            loop.typeCorrect = false;
            this.addError("condition type must be boolean", loop.getLineNum());
        }
    }

    @Override
    public void visit(Write write) {
        //TODO: implement appropriate visit functionality
        if( write == null )
            return;
        visitExpr( write.getArg() );
        if(write.getArg().typeCorrect && ( write.getArg().selfType.equals("string") || write.getArg().selfType.equals("int")) ) {
            write.typeCorrect = true;
        } else {
            write.typeCorrect = false;
            this.addError("unsupported type for writeln", write.getLineNum());
        }
    }

    private void addError(String msg, int lineNumber) {
        if( traverseState == TraverseState.redefinitionAndArrayErrorCatching )
            nameErrors.add( "Line:" + lineNumber + ":" + msg );
    }
}
