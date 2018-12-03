grammar Smoola;

    @header {
        import main.ast.*;
        import main.ast.node.*;
        import main.ast.node.Program;
    }

    program: { Program program = new Program(); }
        mainClass { program.addClass(mainClass.clasDeclaration); }  (classDeclaration {

            program.addClass(classDeclaration.clasDeclaration);

        } )* EOF {
         Visitor visitor = new VisitorImpl();
         visitor.visit(program);
         visitor.setPassNumber(1);
         visitor.visit(program);
         visitor.setPassNumber(2);
        }
    ;
    mainClass returns [ClassDeclaration clasDeclaration] :
        // name should be checked later
        'class' ID {ClassDeclaration clasDeclaration = new ClassDeclaration(ID) }
         '{' 'def'
         ID {
            MethodDeclaration methodDeclaration = new MethodDeclaration($ID);
            clasDeclaration.addMethodDeclaration(methodDeclaration);
          }
          '(' ')' ':' 'int' {

          methodDeclaration.setReturnType(IntType) --?

          } '{'  s=statements { $s.stmnts.forEach( v -> methodDeclaration.addStatement(v) ) }
          'return' ex=expression {methodDeclaration.setReturnValue($ex.expr)}  ';' '}' '}'
    ;
    classDeclaration returns [ClassDeclaration clasDeclaration]:
        'class' ID {ClassDeclaration clasDeclaration = new ClassDeclaration(ID) }

         ('extends' ID {clasDeclaration.setParentName($ID)} )? '{'

         (v=varDeclaration { clasDeclaration.addVarDeclaration(v.variableDeclaration) })
         *
         (m=methodDeclaration { clasDeclaration.addMethodDeclaration(m.methodDeclare) } )* '}'
    ;

    varDeclaration returns [VarDeclaration variableDeclaration]:
        'var' ID { VarDeclaration varDeclare = new VarDeclaration(ID) } ':' t=type {varDeclare.setType(t.typeDef)} ';'
    ;


    methodDeclaration returns [MethodDeclaration methodDeclare]:
        'def' ID { MethodDeclaration mtd = new MethodDeclaration(ID)  } ('(' ')' | ('(' ID { $varDeclare = new VarDeclaration(ID); }  ':' t=type { $varDeclare.setType($t.typeDef); mtd.addArg($varDeclare); }
         (',' ID { VarDeclaration varDeclare2 = new VarDeclaration(ID) } ':' tt=type { varDeclare2.setType($tt.typeDef); $mtd.addArg($varDeclare2) } )* ')')) ':' ttt=type  { mtd.setReturnType($ttt.typeDef); } '{'
          (v=varDeclaration { mtd.addLocalVar($v.variableDeclaration) }) *
          s=statements { $s.stmnts.forEach( v -> mtd.addStatement(v) ) }
         'return' ex=expression { mtd.setReturnValue($ex.expr) } ';' '}'
    ;

    statements returns [ArrayList<Statement> stmnts]:
        (statement)*
    ;
    statement returns [Statement sm]:
        statementBlock |
        statementCondition |
        statementLoop |
        statementWrite |
        statementAssignment
    ;
    statementBlock: { Block block = new Block(); }
        '{'  s=statements {$s.stmnts.forEach( v -> block.addStatement(v) )} '}'
    ;
    statementCondition: { Conditional stmnt = new Conditional();}
        'if' '('ex=expression { stmnt.setExpression(ex.expr); } ')' 'then'
        s=statement { stmnt.setConsequenceBody($s.sm);  } ('else' ss=statement { stmnt.setAlternativeBody($ss.sm);  }  )?
    ;
    statementLoop: { While stmnt = new While(); }
        'while' '(' ex=expression { stmnt.setCondition($ex.expr); } ')'
        s=statement { stmnt.setBody($s.sm);  }
    ;
    statementWrite: { Write write = new Write(); }
        'writeln(' ex=expression { write.setArg($ex.expr); }  ')' ';'
    ;
    statementAssignment: {Assign assignment = new Assign()}
        ex=expression {assignment.setlValue($ex.expr)} ';'
    ;

    expression returns [Expression expr]:
		expressionAssignment
	;

    expressionAssignment returns [Expression expr]:
		ex=expressionOr { BinaryExpression binaryExpr = new BinaryExpression();  binaryExpr.setLeft($ex.expr) } '=' { $op = BinaryOperator.ASSIGN; binaryExpr.setBinaryOperator($op); }
		 exx=expressionAssignment { binaryExpr.setRight($exx.expr) }
	    |	expressionOr
	;

    expressionOr returns [Expression expr]:

		ex=expressionAnd { BinaryExpression binaryExpr = new BinaryExpression();  binaryExpr.setLeft($ex.expr) } expressionOrTemp[binaryExpr]
	;

    expressionOrTemp [BinaryExpression b] returns [BinaryExpression binaryExpr]:
		'||' {$op = BinaryOperator.OR; b.setBinaryOperator($op); }  ex=expressionAnd { b.setRight($ex.expr); } exx=expressionOrTemp[b] {$exx.setLeft(b)}
	    |
	;

    expressionAnd returns [Expression expr]:
		ex=expressionEq { $binaryExpr = new BinaryExpression();  $binaryExpr.setLeft($ex.expr); } expressionAndTemp[$binaryExpr]
	;

    expressionAndTemp[BinaryExpression b] returns [BinaryExpression binaryExpr]:
		'&&' {$op = BinaryOperator.AND; b.setBinaryOperator($op); } ex=expressionEq { b.setRight($ex.expr); } exx=expressionAndTemp[b] {$exx.setLeft(b)}
	    |
	;

    expressionEq returns [Expression expr]:
		ex=expressionCmp  { $binaryExpr = new BinaryExpression();  $binaryExpr.setLeft($ex.expr); } expressionEqTemp[$binaryExpr]
	;

    expressionEqTemp[BinaryExpression b] returns [BinaryExpression binaryExpr]:
		('==' {$op = BinaryOperator.EQUALS; b.setBinaryOperator($op); } | '<>' {$op = BinaryOperator.NOT_EQUALS; b.setBinaryOperator($op); } ) ex=expressionCmp { b.setRight($ex.expr); } expressionEqTemp[b] {$exx.setLeft(b)}
	    |
	;

    expressionCmp returns [Expression expr]:
		expressionAdd { $binaryExpr = new BinaryExpression();  $binaryExpr.setLeft($ex.expr); } expressionCmpTemp[$binaryExpr]
	;

    expressionCmpTemp[BinaryExpression b] returns [BinaryExpression binaryExpr]:
		('<' {$op = BinaryOperator.LESS; b.setBinaryOperator($op); } | '>' {$op = BinaryOperator.GREATER; b.setBinaryOperator($op); }) ex=expressionAdd { b.setRight($ex.expr); } exx=expressionCmpTemp[b] {$exx.setLeft(b)}
	    |
	;

    expressionAdd returns [Expression expr]:
		expressionMult { $binaryExpr = new BinaryExpression();  $binaryExpr.setLeft($ex.expr); } expressionAddTemp[$binaryExpr]
	;

    expressionAddTemp[BinaryExpression b] returns [BinaryExpression binaryExpr]:
		('+' {$op = BinaryOperator.PLUS; b.setBinaryOperator($op); } | '-' {$op = BinaryOperator.MINUS; b.setBinaryOperator($op); }) ex=expressionMult { b.setRight($ex.expr); } expressionAddTemp[b] {$exx.setLeft(b)}
	    |
	;

        expressionMult returns [Expression expr]:
		ex=expressionUnary { $binaryExpr = new BinaryExpression();  $binaryExpr.setLeft($ex.expr); } expressionMultTemp[$binaryExpr]
	;

    expressionMultTemp[BinaryExpression b] returns [BinaryExpression binaryExpr]:
		('*' {$op = BinaryOperator.MULTIPLY; b.setBinaryOperator($op); } | '/' {$op = BinaryOperator.DIVIDE; b.setBinaryOperator($op); }) ex=expressionUnary  { b.setRight($ex.expr); } exx=expressionMultTemp[b] {$exx.setLeft(b)}
	    |
	;

    expressionUnary returns [Expression expr]: { $unary = new UnaryExpression()}
		('!' {$op = UnaryOperator.NOT; $unary.setUnaryOperator($op); } | '-' {$op = UnaryOperator.MINUS; $unary.setUnaryOperator($op); }) ex=expressionUnary {$unary.setValue(ex.expr)}
	    |	expressionMem
	;

    expressionMem: { $array = new ArrayCall(); }
		ex=expressionMethods { $array.setInstance($ex.expr) } expressionMemTemp[$array]
	;

    expressionMemTemp[ArrayCall arr]:
		'[' ex=expression {arr.setIndex($ex.expr)} ']'
	    |
	;
	expressionMethods returns [Expression expr]: { $method = new MethodCall(); }
	    ex=expressionOther {$method.setInstance($ex.expr)} expressionMethodsTemp[$method]
	;
	expressionMethodsTemp[MethodCall method] returns [Expression expr]:
	    '.' (ID { method.setMethodName(ID) } '(' ')' | ID { method.setMethodName(ID) } '(' (ex=expression { method.addArg($ex.expr) }
	     (',' exx=expression { method.addArg($exx.expr) } )*) ')' | 'length') expressionMethodsTemp[method]
	    |
	;
    expressionOther returns [Expression expr]:
		CONST_NUM { $type = new IntType();  $const = new IntValue(CONST_NUM,$type); }
        |	CONST_STR
        |   'new ' 'int' '[' CONST_NUM ']' {$array = new NewArray(); $array.setExpression($s.expr) }
        |   'new '  ID {$newClass = new NewClass(); $newClass.setClassName(ID) } '(' ')'
        |   'this'
        |   'true'
        |   'false'
        |	ID
        |   ID '[' s=expression ']' { $array = new ArrayCall(); $array.setInstance(ID) $array.setIndex($s.expr); }
        |	'(' ss=expression ')' {  $method = new MethodCall(); $method.addArg($ss.expr); }
	;
	type returns [Type typeDef] :
	    'int' |
	    'boolean' |
	    'string' |
	    'int' '[' ']' |
	    ID
	;
    CONST_NUM:
		[0-9]+
	;

    CONST_STR:
		'"' ~('\r' | '\n' | '"')* '"'
	;
    NL: { visitor.incLineNumber() }
		'\r'? '\n' -> skip
	;

    ID:
		 [a-zA-Z_][a-zA-Z0-9_]* //todo: check this
	;

    COMMENT:
		'#'(~[\r\n])* -> skip
	;

    WS:
    	[ \t] -> skip
    ;