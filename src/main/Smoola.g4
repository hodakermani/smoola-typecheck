grammar Smoola;

    @header {
        import main.ast.*;
        import main.ast.node.*;
        import main.ast.node.expression.*;
        import main.ast.node.declaration.*;
        import main.ast.node.statement.*;
        import main.ast.node.expression.Value.*;
        import main.ast.Type.*;
        import main.ast.node.Program;
        import main.ast.Visitor;
   ;}

    program: { Program program = new Program();}
        mainClass { program.addClass($mainClass.clasDeclaration);}  (classDeclaration {

            program.addClass($classDeclaration.clasDeclaration);

       ;} )* EOF {
         Visitor visitor = new VisitorImpl();
         visitor.visit(program);
         visitor.setPassNumber(1);
         visitor.visit(program);
         visitor.setPassNumber(2);
       }
   ;
    mainClass returns [ClassDeclaration clasDeclaration] :
        // name should be checked later
        'class' ID {ClassDeclaration clasDeclaration = new ClassDeclaration($ID);}
         '{' 'def'
         ID {
            MethodDeclaration methodDeclaration = new MethodDeclaration($ID);
            clasDeclaration.addMethodDeclaration(methodDeclaration);
          }
          '(' ')' ':' 'int' {

          methodDeclaration.setReturnType(IntType)

         ;} '{'  s=statements { $s.stmnts.forEach( v -> methodDeclaration.addStatement(v) );}
          'return' ex=expression {methodDeclaration.setReturnValue($ex.expr);}  ';' '}' '}'
   ;
    classDeclaration returns [ClassDeclaration clasDeclaration]:
        'class' ID {ClassDeclaration clasDeclaration = new ClassDeclaration($ID);}

         ('extends' ID {clasDeclaration.setParentName($ID);} )? '{'

         (v=varDeclaration { clasDeclaration.addVarDeclaration($v.variableDeclaration);})
         *
         (m=methodDeclaration { clasDeclaration.addMethodDeclaration($m.methodDeclare);} )* '}'
   ;

    varDeclaration returns [VarDeclaration variableDeclaration]:
        'var' ID { VarDeclaration varDeclare = new VarDeclaration($ID);} ':' t=type {varDeclare.setType($t.typeDef);} ';'
   ;


    methodDeclaration returns [MethodDeclaration methodDeclare]:
        'def' ID { MethodDeclaration mtd = new MethodDeclaration($ID) ;} ('(' ')' | ('(' ID { VarDeclaration varDeclare = new VarDeclaration($ID);}  ':' t=type { varDeclare.setType($t.typeDef); mtd.addArg(varDeclare);}
         (',' ID { VarDeclaration varDeclare2 = new VarDeclaration($ID);} ':' tt=type { varDeclare2.setType($tt.typeDef); mtd.addArg(varDeclare2);} )* ')')) ':' ttt=type  { mtd.setReturnType($ttt.typeDef);} '{'
          (v=varDeclaration { mtd.addLocalVar($v.variableDeclaration);}) *
          s=statements { $s.stmnts.forEach( v -> mtd.addStatement(v) );}
         'return' ex=expression { mtd.setReturnValue($ex.expr);} ';' '}'
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
    statementBlock: { Block block = new Block();}
        '{'  s=statements {$s.stmnts.forEach( v -> block.addStatement(v) );} '}'
   ;
    statementCondition: { Conditional stmnt = new Conditional();;}
        'if' '('ex=expression { stmnt.setExpression(ex.expr);} ')' 'then'
        s=statement { stmnt.setConsequenceBody($s.sm); ;} ('else' ss=statement { stmnt.setAlternativeBody($ss.sm); ;}  )?
   ;
    statementLoop: { While stmnt = new While();}
        'while' '(' ex=expression { stmnt.setCondition($ex.expr);} ')'
        s=statement { stmnt.setBody($s.sm); ;}
   ;
    statementWrite: { Write write = new Write();}
        'writeln(' ex=expression { write.setArg($ex.expr);}  ')' ';'
   ;
    statementAssignment: {Assign assignment = new Assign();}
        ex=expression {assignment.setlValue($ex.expr);} ';'
   ;

    expression returns [Expression expr]:
		expressionAssignment
	;

    expressionAssignment returns [Expression expr]:
		ex=expressionOr { BinaryExpression binaryExpr = new BinaryExpression();  binaryExpr.setLeft($ex.expr);} '=' { BinaryOperator op = BinaryOperator.ASSIGN; binaryExpr.setBinaryOperator(op);}
		 exx=expressionAssignment { binaryExpr.setRight($exx.expr);}
	    |	expressionOr
	;

    expressionOr returns [Expression expr]:

		ex=expressionAnd { BinaryExpression binaryExpr = new BinaryExpression();  binaryExpr.setLeft($ex.expr);} expressionOrTemp[binaryExpr]
	;

    expressionOrTemp [Expression b] returns [Expression expr]:
		'||' {BinaryOperator op = BinaryOperator.OR; b.setBinaryOperator(op);}  ex=expressionAnd { b.setRight($ex.expr);} exx=expressionOrTemp[b] {$exx.expr.setLeft(b);}
	    |
	;

    expressionAnd returns [Expression expr]:
		ex=expressionEq { BinaryExpression binaryExpr = new BinaryExpression();  binaryExpr.setLeft($ex.expr);} expressionAndTemp[binaryExpr]
	;

    expressionAndTemp[Expression b] returns [Expression expr]:
		'&&' {BinaryOperator op = BinaryOperator.AND; b.setBinaryOperator(op);} ex=expressionEq { b.setRight($ex.expr);} exx=expressionAndTemp[b] {$exx.expr.setLeft(b);}
	    |
	;

    expressionEq returns [Expression expr]:
		ex=expressionCmp  { BinaryExpression binaryExpr = new BinaryExpression();  binaryExpr.setLeft($ex.expr);} expressionEqTemp[binaryExpr]
	;

    expressionEqTemp[Expression b] returns [Expression expr]:
		('==' {BinaryOperator op = BinaryOperator.EQUALS; b.setBinaryOperator(op);} | '<>' {op = BinaryOperator.NOT_EQUALS; b.setBinaryOperator(op);} ) ex=expressionCmp { b.setRight($ex.expr);} exx=expressionEqTemp[b] {$exx.expr.setLeft(b);}
	    |
	;

    expressionCmp returns [Expression expr]:
		ex=expressionAdd { BinaryExpression binaryExpr = new BinaryExpression();  binaryExpr.setLeft($ex.expr);} expressionCmpTemp[binaryExpr]
	;

    expressionCmpTemp[Expression b] returns [Expression expr]:
		('<' {BinaryOperator op = BinaryOperator.LESS; b.setBinaryOperator(op);} | '>' {BinaryOperator op = BinaryOperator.GREATER; b.setBinaryOperator(op);}) ex=expressionAdd { b.setRight($ex.expr);} exx=expressionCmpTemp[b] {$exx.expr.setLeft(b);}
	    |
	;

    expressionAdd returns [Expression expr]:
		ex=expressionMult { BinaryExpression binaryExpr = new BinaryExpression();  binaryExpr.setLeft($ex.expr);} expressionAddTemp[binaryExpr]
	;

    expressionAddTemp[Expression b] returns [Expression expr]:
		('+' {BinaryOperator op = BinaryOperator.PLUS; b.setBinaryOperator(op);} | '-' {BinaryOperator op = BinaryOperator.MINUS; b.setBinaryOperator(op);}) ex=expressionMult { b.setRight($ex.expr);} exx=expressionAddTemp[b] {$exx.expr.setLeft(b);}
	    |
	;

        expressionMult returns [Expression expr]:
		ex=expressionUnary { BinaryExpression binaryExpr = new BinaryExpression();  binaryExpr.setLeft($ex.expr);} expressionMultTemp[binaryExpr]
	;

    expressionMultTemp[Expression b] returns [Expression expr]:
		('*' {BinaryOperator op = BinaryOperator.MULTIPLY; b.setBinaryOperator(op);} | '/' {BinaryOperator op = BinaryOperator.DIVIDE; b.setBinaryOperator(op);}) ex=expressionUnary  { b.setRight($ex.expr);} exx=expressionMultTemp[b] {$exx.expr.setLeft(b);}
	    |
	;

    expressionUnary returns [Expression expr]: { UnaryExpression unary = new UnaryExpression();}
		('!' {UnaryOperator op = UnaryOperator.NOT; unary.setUnaryOperator(op);} | '-' {UnaryOperator op = UnaryOperator.MINUS; unary.setUnaryOperator(op);}) ex=expressionUnary {unary.setValue($ex.expr);}
	    |	expressionMem
	;

    expressionMem: { ArrayCall arrayy = new ArrayCall();}
		ex=expressionMethods { arrayy.setInstance($ex.expr);} expressionMemTemp[arrayy]
	;

    expressionMemTemp[ArrayCall arr]:
		'[' ex=expression {arr.setIndex($ex.expr);} ']'
	    |
	;
	expressionMethods returns [Expression expr]: { MethodCall method = new MethodCall();}
	    ex=expressionOther {method.setInstance($ex.expr);} expressionMethodsTemp[method]
	;
	expressionMethodsTemp[MethodCall method] returns [Expression expr]:
	    '.' (ID { method.setMethodName($ID);} '(' ')' | ID { method.setMethodName($ID);} '(' (ex=expression { method.addArg($ex.expr);}
	     (',' exx=expression { method.addArg($exx.expr);} )*) ')' | 'length') expressionMethodsTemp[method]
	    |
	;
    expressionOther returns [Expression expr]:
		CONST_NUM { IntType type = new IntType(); IntValue constt = new IntValue(CONST_NUM,type);}
        |	CONST_STR
        |   'new ' 'int' '[' CONST_NUM ']' {NewArray arrayy = new NewArray(); arrayy.setExpression(constt); }
        |   'new '  ID {NewClass newClass = new NewClass(); newClass.setClassName($ID);} '(' ')'
        |   'this'
        |   'true'
        |   'false'
        |	ID
        |   ID '[' s=expression ']' { ArrayCall arrayy = new ArrayCall(); arrayy.setInstance($ID); arrayy.setIndex($s.expr);}
        |	'(' ss=expression ')' {  MethodCall method = new MethodCall(); method.addArg($ss.expr);}
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
    NL: { visitor.incLineNumber();}
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