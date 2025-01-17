// Generated from /Users/hoda/Desktop/untitled/src/Smoola.g4 by ANTLR 4.7

        import main.ast.node.*;
        import main.ast.node.expression.*;
        import main.ast.node.declaration.*;
        import main.ast.*;
        import main.ast.Type.ArrayType.*;
        import main.ast.Type.UserDefinedType.*;
        import main.ast.Type.PrimitiveType.*;
        import main.ast.Type.*;
        import java.util.ArrayList;
        import main.ast.node.statement.*;
        import main.ast.node.expression.BinOp.BinaryOperator;
        import main.ast.node.expression.Value.*;
    
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link SmoolaParser}.
 */
public interface SmoolaListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link SmoolaParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(SmoolaParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link SmoolaParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(SmoolaParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link SmoolaParser#mainClass}.
	 * @param ctx the parse tree
	 */
	void enterMainClass(SmoolaParser.MainClassContext ctx);
	/**
	 * Exit a parse tree produced by {@link SmoolaParser#mainClass}.
	 * @param ctx the parse tree
	 */
	void exitMainClass(SmoolaParser.MainClassContext ctx);
	/**
	 * Enter a parse tree produced by {@link SmoolaParser#classDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterClassDeclaration(SmoolaParser.ClassDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link SmoolaParser#classDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitClassDeclaration(SmoolaParser.ClassDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link SmoolaParser#varDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterVarDeclaration(SmoolaParser.VarDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link SmoolaParser#varDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitVarDeclaration(SmoolaParser.VarDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link SmoolaParser#methodDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterMethodDeclaration(SmoolaParser.MethodDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link SmoolaParser#methodDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitMethodDeclaration(SmoolaParser.MethodDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link SmoolaParser#statements}.
	 * @param ctx the parse tree
	 */
	void enterStatements(SmoolaParser.StatementsContext ctx);
	/**
	 * Exit a parse tree produced by {@link SmoolaParser#statements}.
	 * @param ctx the parse tree
	 */
	void exitStatements(SmoolaParser.StatementsContext ctx);
	/**
	 * Enter a parse tree produced by {@link SmoolaParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(SmoolaParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SmoolaParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(SmoolaParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SmoolaParser#statementBlock}.
	 * @param ctx the parse tree
	 */
	void enterStatementBlock(SmoolaParser.StatementBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link SmoolaParser#statementBlock}.
	 * @param ctx the parse tree
	 */
	void exitStatementBlock(SmoolaParser.StatementBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link SmoolaParser#statementCondition}.
	 * @param ctx the parse tree
	 */
	void enterStatementCondition(SmoolaParser.StatementConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SmoolaParser#statementCondition}.
	 * @param ctx the parse tree
	 */
	void exitStatementCondition(SmoolaParser.StatementConditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SmoolaParser#statementLoop}.
	 * @param ctx the parse tree
	 */
	void enterStatementLoop(SmoolaParser.StatementLoopContext ctx);
	/**
	 * Exit a parse tree produced by {@link SmoolaParser#statementLoop}.
	 * @param ctx the parse tree
	 */
	void exitStatementLoop(SmoolaParser.StatementLoopContext ctx);
	/**
	 * Enter a parse tree produced by {@link SmoolaParser#statementWrite}.
	 * @param ctx the parse tree
	 */
	void enterStatementWrite(SmoolaParser.StatementWriteContext ctx);
	/**
	 * Exit a parse tree produced by {@link SmoolaParser#statementWrite}.
	 * @param ctx the parse tree
	 */
	void exitStatementWrite(SmoolaParser.StatementWriteContext ctx);
	/**
	 * Enter a parse tree produced by {@link SmoolaParser#statementAssignment}.
	 * @param ctx the parse tree
	 */
	void enterStatementAssignment(SmoolaParser.StatementAssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link SmoolaParser#statementAssignment}.
	 * @param ctx the parse tree
	 */
	void exitStatementAssignment(SmoolaParser.StatementAssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link SmoolaParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(SmoolaParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SmoolaParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(SmoolaParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SmoolaParser#expressionAssignment}.
	 * @param ctx the parse tree
	 */
	void enterExpressionAssignment(SmoolaParser.ExpressionAssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link SmoolaParser#expressionAssignment}.
	 * @param ctx the parse tree
	 */
	void exitExpressionAssignment(SmoolaParser.ExpressionAssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link SmoolaParser#expressionOr}.
	 * @param ctx the parse tree
	 */
	void enterExpressionOr(SmoolaParser.ExpressionOrContext ctx);
	/**
	 * Exit a parse tree produced by {@link SmoolaParser#expressionOr}.
	 * @param ctx the parse tree
	 */
	void exitExpressionOr(SmoolaParser.ExpressionOrContext ctx);
	/**
	 * Enter a parse tree produced by {@link SmoolaParser#expressionOrTemp}.
	 * @param ctx the parse tree
	 */
	void enterExpressionOrTemp(SmoolaParser.ExpressionOrTempContext ctx);
	/**
	 * Exit a parse tree produced by {@link SmoolaParser#expressionOrTemp}.
	 * @param ctx the parse tree
	 */
	void exitExpressionOrTemp(SmoolaParser.ExpressionOrTempContext ctx);
	/**
	 * Enter a parse tree produced by {@link SmoolaParser#expressionAnd}.
	 * @param ctx the parse tree
	 */
	void enterExpressionAnd(SmoolaParser.ExpressionAndContext ctx);
	/**
	 * Exit a parse tree produced by {@link SmoolaParser#expressionAnd}.
	 * @param ctx the parse tree
	 */
	void exitExpressionAnd(SmoolaParser.ExpressionAndContext ctx);
	/**
	 * Enter a parse tree produced by {@link SmoolaParser#expressionAndTemp}.
	 * @param ctx the parse tree
	 */
	void enterExpressionAndTemp(SmoolaParser.ExpressionAndTempContext ctx);
	/**
	 * Exit a parse tree produced by {@link SmoolaParser#expressionAndTemp}.
	 * @param ctx the parse tree
	 */
	void exitExpressionAndTemp(SmoolaParser.ExpressionAndTempContext ctx);
	/**
	 * Enter a parse tree produced by {@link SmoolaParser#expressionEq}.
	 * @param ctx the parse tree
	 */
	void enterExpressionEq(SmoolaParser.ExpressionEqContext ctx);
	/**
	 * Exit a parse tree produced by {@link SmoolaParser#expressionEq}.
	 * @param ctx the parse tree
	 */
	void exitExpressionEq(SmoolaParser.ExpressionEqContext ctx);
	/**
	 * Enter a parse tree produced by {@link SmoolaParser#expressionEqTemp}.
	 * @param ctx the parse tree
	 */
	void enterExpressionEqTemp(SmoolaParser.ExpressionEqTempContext ctx);
	/**
	 * Exit a parse tree produced by {@link SmoolaParser#expressionEqTemp}.
	 * @param ctx the parse tree
	 */
	void exitExpressionEqTemp(SmoolaParser.ExpressionEqTempContext ctx);
	/**
	 * Enter a parse tree produced by {@link SmoolaParser#expressionCmp}.
	 * @param ctx the parse tree
	 */
	void enterExpressionCmp(SmoolaParser.ExpressionCmpContext ctx);
	/**
	 * Exit a parse tree produced by {@link SmoolaParser#expressionCmp}.
	 * @param ctx the parse tree
	 */
	void exitExpressionCmp(SmoolaParser.ExpressionCmpContext ctx);
	/**
	 * Enter a parse tree produced by {@link SmoolaParser#expressionCmpTemp}.
	 * @param ctx the parse tree
	 */
	void enterExpressionCmpTemp(SmoolaParser.ExpressionCmpTempContext ctx);
	/**
	 * Exit a parse tree produced by {@link SmoolaParser#expressionCmpTemp}.
	 * @param ctx the parse tree
	 */
	void exitExpressionCmpTemp(SmoolaParser.ExpressionCmpTempContext ctx);
	/**
	 * Enter a parse tree produced by {@link SmoolaParser#expressionAdd}.
	 * @param ctx the parse tree
	 */
	void enterExpressionAdd(SmoolaParser.ExpressionAddContext ctx);
	/**
	 * Exit a parse tree produced by {@link SmoolaParser#expressionAdd}.
	 * @param ctx the parse tree
	 */
	void exitExpressionAdd(SmoolaParser.ExpressionAddContext ctx);
	/**
	 * Enter a parse tree produced by {@link SmoolaParser#expressionAddTemp}.
	 * @param ctx the parse tree
	 */
	void enterExpressionAddTemp(SmoolaParser.ExpressionAddTempContext ctx);
	/**
	 * Exit a parse tree produced by {@link SmoolaParser#expressionAddTemp}.
	 * @param ctx the parse tree
	 */
	void exitExpressionAddTemp(SmoolaParser.ExpressionAddTempContext ctx);
	/**
	 * Enter a parse tree produced by {@link SmoolaParser#expressionMult}.
	 * @param ctx the parse tree
	 */
	void enterExpressionMult(SmoolaParser.ExpressionMultContext ctx);
	/**
	 * Exit a parse tree produced by {@link SmoolaParser#expressionMult}.
	 * @param ctx the parse tree
	 */
	void exitExpressionMult(SmoolaParser.ExpressionMultContext ctx);
	/**
	 * Enter a parse tree produced by {@link SmoolaParser#expressionMultTemp}.
	 * @param ctx the parse tree
	 */
	void enterExpressionMultTemp(SmoolaParser.ExpressionMultTempContext ctx);
	/**
	 * Exit a parse tree produced by {@link SmoolaParser#expressionMultTemp}.
	 * @param ctx the parse tree
	 */
	void exitExpressionMultTemp(SmoolaParser.ExpressionMultTempContext ctx);
	/**
	 * Enter a parse tree produced by {@link SmoolaParser#expressionUnary}.
	 * @param ctx the parse tree
	 */
	void enterExpressionUnary(SmoolaParser.ExpressionUnaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link SmoolaParser#expressionUnary}.
	 * @param ctx the parse tree
	 */
	void exitExpressionUnary(SmoolaParser.ExpressionUnaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link SmoolaParser#expressionMem}.
	 * @param ctx the parse tree
	 */
	void enterExpressionMem(SmoolaParser.ExpressionMemContext ctx);
	/**
	 * Exit a parse tree produced by {@link SmoolaParser#expressionMem}.
	 * @param ctx the parse tree
	 */
	void exitExpressionMem(SmoolaParser.ExpressionMemContext ctx);
	/**
	 * Enter a parse tree produced by {@link SmoolaParser#expressionMemTemp}.
	 * @param ctx the parse tree
	 */
	void enterExpressionMemTemp(SmoolaParser.ExpressionMemTempContext ctx);
	/**
	 * Exit a parse tree produced by {@link SmoolaParser#expressionMemTemp}.
	 * @param ctx the parse tree
	 */
	void exitExpressionMemTemp(SmoolaParser.ExpressionMemTempContext ctx);
	/**
	 * Enter a parse tree produced by {@link SmoolaParser#expressionMethods}.
	 * @param ctx the parse tree
	 */
	void enterExpressionMethods(SmoolaParser.ExpressionMethodsContext ctx);
	/**
	 * Exit a parse tree produced by {@link SmoolaParser#expressionMethods}.
	 * @param ctx the parse tree
	 */
	void exitExpressionMethods(SmoolaParser.ExpressionMethodsContext ctx);
	/**
	 * Enter a parse tree produced by {@link SmoolaParser#expressionMethodsTemp}.
	 * @param ctx the parse tree
	 */
	void enterExpressionMethodsTemp(SmoolaParser.ExpressionMethodsTempContext ctx);
	/**
	 * Exit a parse tree produced by {@link SmoolaParser#expressionMethodsTemp}.
	 * @param ctx the parse tree
	 */
	void exitExpressionMethodsTemp(SmoolaParser.ExpressionMethodsTempContext ctx);
	/**
	 * Enter a parse tree produced by {@link SmoolaParser#expressionOther}.
	 * @param ctx the parse tree
	 */
	void enterExpressionOther(SmoolaParser.ExpressionOtherContext ctx);
	/**
	 * Exit a parse tree produced by {@link SmoolaParser#expressionOther}.
	 * @param ctx the parse tree
	 */
	void exitExpressionOther(SmoolaParser.ExpressionOtherContext ctx);
	/**
	 * Enter a parse tree produced by {@link SmoolaParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(SmoolaParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link SmoolaParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(SmoolaParser.TypeContext ctx);
}