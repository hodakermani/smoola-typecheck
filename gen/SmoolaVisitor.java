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
    
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link SmoolaParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface SmoolaVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link SmoolaParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(SmoolaParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link SmoolaParser#mainClass}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMainClass(SmoolaParser.MainClassContext ctx);
	/**
	 * Visit a parse tree produced by {@link SmoolaParser#classDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassDeclaration(SmoolaParser.ClassDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link SmoolaParser#varDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDeclaration(SmoolaParser.VarDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link SmoolaParser#methodDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodDeclaration(SmoolaParser.MethodDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link SmoolaParser#statements}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatements(SmoolaParser.StatementsContext ctx);
	/**
	 * Visit a parse tree produced by {@link SmoolaParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(SmoolaParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SmoolaParser#statementBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementBlock(SmoolaParser.StatementBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link SmoolaParser#statementCondition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementCondition(SmoolaParser.StatementConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SmoolaParser#statementLoop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementLoop(SmoolaParser.StatementLoopContext ctx);
	/**
	 * Visit a parse tree produced by {@link SmoolaParser#statementWrite}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementWrite(SmoolaParser.StatementWriteContext ctx);
	/**
	 * Visit a parse tree produced by {@link SmoolaParser#statementAssignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementAssignment(SmoolaParser.StatementAssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link SmoolaParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(SmoolaParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SmoolaParser#expressionAssignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionAssignment(SmoolaParser.ExpressionAssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link SmoolaParser#expressionOr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionOr(SmoolaParser.ExpressionOrContext ctx);
	/**
	 * Visit a parse tree produced by {@link SmoolaParser#expressionOrTemp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionOrTemp(SmoolaParser.ExpressionOrTempContext ctx);
	/**
	 * Visit a parse tree produced by {@link SmoolaParser#expressionAnd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionAnd(SmoolaParser.ExpressionAndContext ctx);
	/**
	 * Visit a parse tree produced by {@link SmoolaParser#expressionAndTemp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionAndTemp(SmoolaParser.ExpressionAndTempContext ctx);
	/**
	 * Visit a parse tree produced by {@link SmoolaParser#expressionEq}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionEq(SmoolaParser.ExpressionEqContext ctx);
	/**
	 * Visit a parse tree produced by {@link SmoolaParser#expressionEqTemp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionEqTemp(SmoolaParser.ExpressionEqTempContext ctx);
	/**
	 * Visit a parse tree produced by {@link SmoolaParser#expressionCmp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionCmp(SmoolaParser.ExpressionCmpContext ctx);
	/**
	 * Visit a parse tree produced by {@link SmoolaParser#expressionCmpTemp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionCmpTemp(SmoolaParser.ExpressionCmpTempContext ctx);
	/**
	 * Visit a parse tree produced by {@link SmoolaParser#expressionAdd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionAdd(SmoolaParser.ExpressionAddContext ctx);
	/**
	 * Visit a parse tree produced by {@link SmoolaParser#expressionAddTemp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionAddTemp(SmoolaParser.ExpressionAddTempContext ctx);
	/**
	 * Visit a parse tree produced by {@link SmoolaParser#expressionMult}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionMult(SmoolaParser.ExpressionMultContext ctx);
	/**
	 * Visit a parse tree produced by {@link SmoolaParser#expressionMultTemp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionMultTemp(SmoolaParser.ExpressionMultTempContext ctx);
	/**
	 * Visit a parse tree produced by {@link SmoolaParser#expressionUnary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionUnary(SmoolaParser.ExpressionUnaryContext ctx);
	/**
	 * Visit a parse tree produced by {@link SmoolaParser#expressionMem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionMem(SmoolaParser.ExpressionMemContext ctx);
	/**
	 * Visit a parse tree produced by {@link SmoolaParser#expressionMemTemp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionMemTemp(SmoolaParser.ExpressionMemTempContext ctx);
	/**
	 * Visit a parse tree produced by {@link SmoolaParser#expressionMethods}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionMethods(SmoolaParser.ExpressionMethodsContext ctx);
	/**
	 * Visit a parse tree produced by {@link SmoolaParser#expressionMethodsTemp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionMethodsTemp(SmoolaParser.ExpressionMethodsTempContext ctx);
	/**
	 * Visit a parse tree produced by {@link SmoolaParser#expressionOther}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionOther(SmoolaParser.ExpressionOtherContext ctx);
	/**
	 * Visit a parse tree produced by {@link SmoolaParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(SmoolaParser.TypeContext ctx);
}