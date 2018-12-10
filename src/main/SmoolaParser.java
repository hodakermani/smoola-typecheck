// Generated from Smoola.g4 by ANTLR 4.7.1

        import main.ast.*;
        import main.ast.node.*;
        import main.ast.node.expression.*;
        import main.ast.node.declaration.*;
        import main.ast.node.statement.*;
        import main.ast.node.expression.Value.*;
        import main.ast.Type.*;
        import main.ast.node.Program;
        import main.ast.Visitor;
   ;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SmoolaParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, T__36=37, T__37=38, 
		T__38=39, T__39=40, CONST_NUM=41, CONST_STR=42, NL=43, ID=44, COMMENT=45, 
		WS=46;
	public static final int
		RULE_program = 0, RULE_mainClass = 1, RULE_classDeclaration = 2, RULE_varDeclaration = 3, 
		RULE_methodDeclaration = 4, RULE_statements = 5, RULE_statement = 6, RULE_statementBlock = 7, 
		RULE_statementCondition = 8, RULE_statementLoop = 9, RULE_statementWrite = 10, 
		RULE_statementAssignment = 11, RULE_expression = 12, RULE_expressionAssignment = 13, 
		RULE_expressionOr = 14, RULE_expressionOrTemp = 15, RULE_expressionAnd = 16, 
		RULE_expressionAndTemp = 17, RULE_expressionEq = 18, RULE_expressionEqTemp = 19, 
		RULE_expressionCmp = 20, RULE_expressionCmpTemp = 21, RULE_expressionAdd = 22, 
		RULE_expressionAddTemp = 23, RULE_expressionMult = 24, RULE_expressionMultTemp = 25, 
		RULE_expressionUnary = 26, RULE_expressionMem = 27, RULE_expressionMemTemp = 28, 
		RULE_expressionMethods = 29, RULE_expressionMethodsTemp = 30, RULE_expressionOther = 31, 
		RULE_type = 32;
	public static final String[] ruleNames = {
		"program", "mainClass", "classDeclaration", "varDeclaration", "methodDeclaration", 
		"statements", "statement", "statementBlock", "statementCondition", "statementLoop", 
		"statementWrite", "statementAssignment", "expression", "expressionAssignment", 
		"expressionOr", "expressionOrTemp", "expressionAnd", "expressionAndTemp", 
		"expressionEq", "expressionEqTemp", "expressionCmp", "expressionCmpTemp", 
		"expressionAdd", "expressionAddTemp", "expressionMult", "expressionMultTemp", 
		"expressionUnary", "expressionMem", "expressionMemTemp", "expressionMethods", 
		"expressionMethodsTemp", "expressionOther", "type"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'class'", "'{'", "'def'", "'('", "')'", "':'", "'int'", "'return'", 
		"';'", "'}'", "'extends'", "'var'", "','", "'if'", "'then'", "'else'", 
		"'while'", "'writeln('", "'='", "'||'", "'&&'", "'=='", "'<>'", "'<'", 
		"'>'", "'+'", "'-'", "'*'", "'/'", "'!'", "'['", "']'", "'.'", "'length'", 
		"'new '", "'this'", "'true'", "'false'", "'boolean'", "'string'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, "CONST_NUM", "CONST_STR", "NL", "ID", "COMMENT", 
		"WS"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Smoola.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public SmoolaParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgramContext extends ParserRuleContext {
		public MainClassContext mainClass;
		public ClassDeclarationContext classDeclaration;
		public MainClassContext mainClass() {
			return getRuleContext(MainClassContext.class,0);
		}
		public TerminalNode EOF() { return getToken(SmoolaParser.EOF, 0); }
		public List<ClassDeclarationContext> classDeclaration() {
			return getRuleContexts(ClassDeclarationContext.class);
		}
		public ClassDeclarationContext classDeclaration(int i) {
			return getRuleContext(ClassDeclarationContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).exitProgram(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 Program program = new Program();
			setState(67);
			((ProgramContext)_localctx).mainClass = mainClass();
			 program.addClass(((ProgramContext)_localctx).mainClass.clasDeclaration);
			setState(74);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(69);
				((ProgramContext)_localctx).classDeclaration = classDeclaration();


				            program.addClass(((ProgramContext)_localctx).classDeclaration.clasDeclaration);

				       ;
				}
				}
				setState(76);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(77);
			match(EOF);

			         Visitor visitor = new VisitorImpl();
			         visitor.visit(program);
			         visitor.setPassNumber(1);
			         visitor.visit(program);
			         visitor.setPassNumber(2);
			       ;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MainClassContext extends ParserRuleContext {
		public ClassDeclaration clasDeclaration;
		public Token ID;
		public StatementsContext s;
		public ExpressionContext ex;
		public List<TerminalNode> ID() { return getTokens(SmoolaParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(SmoolaParser.ID, i);
		}
		public StatementsContext statements() {
			return getRuleContext(StatementsContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public MainClassContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mainClass; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).enterMainClass(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).exitMainClass(this);
		}
	}

	public final MainClassContext mainClass() throws RecognitionException {
		MainClassContext _localctx = new MainClassContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_mainClass);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(80);
			match(T__0);
			setState(81);
			((MainClassContext)_localctx).ID = match(ID);
			ClassDeclaration clasDeclaration = new ClassDeclaration(((MainClassContext)_localctx).ID);
			setState(83);
			match(T__1);
			setState(84);
			match(T__2);
			setState(85);
			((MainClassContext)_localctx).ID = match(ID);

			            MethodDeclaration methodDeclaration = new MethodDeclaration(((MainClassContext)_localctx).ID);
			            clasDeclaration.addMethodDeclaration(methodDeclaration);
			          
			setState(87);
			match(T__3);
			setState(88);
			match(T__4);
			setState(89);
			match(T__5);
			setState(90);
			match(T__6);


			          methodDeclaration.setReturnType(IntType)

			         ;
			setState(92);
			match(T__1);
			setState(93);
			((MainClassContext)_localctx).s = statements();
			 ((MainClassContext)_localctx).s.stmnts.forEach( v -> methodDeclaration.addStatement(v) );
			setState(95);
			match(T__7);
			setState(96);
			((MainClassContext)_localctx).ex = expression();
			methodDeclaration.setReturnValue(((MainClassContext)_localctx).ex.expr);
			setState(98);
			match(T__8);
			setState(99);
			match(T__9);
			setState(100);
			match(T__9);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassDeclarationContext extends ParserRuleContext {
		public ClassDeclaration clasDeclaration;
		public Token ID;
		public VarDeclarationContext v;
		public MethodDeclarationContext m;
		public List<TerminalNode> ID() { return getTokens(SmoolaParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(SmoolaParser.ID, i);
		}
		public List<VarDeclarationContext> varDeclaration() {
			return getRuleContexts(VarDeclarationContext.class);
		}
		public VarDeclarationContext varDeclaration(int i) {
			return getRuleContext(VarDeclarationContext.class,i);
		}
		public List<MethodDeclarationContext> methodDeclaration() {
			return getRuleContexts(MethodDeclarationContext.class);
		}
		public MethodDeclarationContext methodDeclaration(int i) {
			return getRuleContext(MethodDeclarationContext.class,i);
		}
		public ClassDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).enterClassDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).exitClassDeclaration(this);
		}
	}

	public final ClassDeclarationContext classDeclaration() throws RecognitionException {
		ClassDeclarationContext _localctx = new ClassDeclarationContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_classDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(102);
			match(T__0);
			setState(103);
			((ClassDeclarationContext)_localctx).ID = match(ID);
			ClassDeclaration clasDeclaration = new ClassDeclaration(((ClassDeclarationContext)_localctx).ID);
			setState(108);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__10) {
				{
				setState(105);
				match(T__10);
				setState(106);
				((ClassDeclarationContext)_localctx).ID = match(ID);
				clasDeclaration.setParentName(((ClassDeclarationContext)_localctx).ID);
				}
			}

			setState(110);
			match(T__1);
			setState(116);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__11) {
				{
				{
				setState(111);
				((ClassDeclarationContext)_localctx).v = varDeclaration();
				 clasDeclaration.addVarDeclaration(((ClassDeclarationContext)_localctx).v.variableDeclaration);
				}
				}
				setState(118);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(124);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(119);
				((ClassDeclarationContext)_localctx).m = methodDeclaration();
				 clasDeclaration.addMethodDeclaration(((ClassDeclarationContext)_localctx).m.methodDeclare);
				}
				}
				setState(126);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(127);
			match(T__9);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VarDeclarationContext extends ParserRuleContext {
		public VarDeclaration variableDeclaration;
		public Token ID;
		public TypeContext t;
		public TerminalNode ID() { return getToken(SmoolaParser.ID, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public VarDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).enterVarDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).exitVarDeclaration(this);
		}
	}

	public final VarDeclarationContext varDeclaration() throws RecognitionException {
		VarDeclarationContext _localctx = new VarDeclarationContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_varDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(129);
			match(T__11);
			setState(130);
			((VarDeclarationContext)_localctx).ID = match(ID);
			 VarDeclaration varDeclare = new VarDeclaration(((VarDeclarationContext)_localctx).ID);
			setState(132);
			match(T__5);
			setState(133);
			((VarDeclarationContext)_localctx).t = type();
			varDeclare.setType(((VarDeclarationContext)_localctx).t.typeDef);
			setState(135);
			match(T__8);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MethodDeclarationContext extends ParserRuleContext {
		public MethodDeclaration methodDeclare;
		public Token ID;
		public TypeContext t;
		public TypeContext tt;
		public TypeContext ttt;
		public VarDeclarationContext v;
		public StatementsContext s;
		public ExpressionContext ex;
		public List<TerminalNode> ID() { return getTokens(SmoolaParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(SmoolaParser.ID, i);
		}
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public StatementsContext statements() {
			return getRuleContext(StatementsContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<VarDeclarationContext> varDeclaration() {
			return getRuleContexts(VarDeclarationContext.class);
		}
		public VarDeclarationContext varDeclaration(int i) {
			return getRuleContext(VarDeclarationContext.class,i);
		}
		public MethodDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).enterMethodDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).exitMethodDeclaration(this);
		}
	}

	public final MethodDeclarationContext methodDeclaration() throws RecognitionException {
		MethodDeclarationContext _localctx = new MethodDeclarationContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_methodDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(137);
			match(T__2);
			setState(138);
			((MethodDeclarationContext)_localctx).ID = match(ID);
			 MethodDeclaration mtd = new MethodDeclaration(((MethodDeclarationContext)_localctx).ID) ;
			setState(162);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				{
				setState(140);
				match(T__3);
				setState(141);
				match(T__4);
				}
				break;
			case 2:
				{
				{
				setState(142);
				match(T__3);
				setState(143);
				((MethodDeclarationContext)_localctx).ID = match(ID);
				 VarDeclaration varDeclare = new VarDeclaration(((MethodDeclarationContext)_localctx).ID);
				setState(145);
				match(T__5);
				setState(146);
				((MethodDeclarationContext)_localctx).t = type();
				 varDeclare.setType(((MethodDeclarationContext)_localctx).t.typeDef); mtd.addArg(varDeclare);
				setState(157);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__12) {
					{
					{
					setState(148);
					match(T__12);
					setState(149);
					((MethodDeclarationContext)_localctx).ID = match(ID);
					 VarDeclaration varDeclare2 = new VarDeclaration(((MethodDeclarationContext)_localctx).ID);
					setState(151);
					match(T__5);
					setState(152);
					((MethodDeclarationContext)_localctx).tt = type();
					 varDeclare2.setType(((MethodDeclarationContext)_localctx).tt.typeDef); mtd.addArg(varDeclare2);
					}
					}
					setState(159);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(160);
				match(T__4);
				}
				}
				break;
			}
			setState(164);
			match(T__5);
			setState(165);
			((MethodDeclarationContext)_localctx).ttt = type();
			 mtd.setReturnType(((MethodDeclarationContext)_localctx).ttt.typeDef);
			setState(167);
			match(T__1);
			setState(173);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__11) {
				{
				{
				setState(168);
				((MethodDeclarationContext)_localctx).v = varDeclaration();
				 mtd.addLocalVar(((MethodDeclarationContext)_localctx).v.variableDeclaration);
				}
				}
				setState(175);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(176);
			((MethodDeclarationContext)_localctx).s = statements();
			 ((MethodDeclarationContext)_localctx).s.stmnts.forEach( v -> mtd.addStatement(v) );
			setState(178);
			match(T__7);
			setState(179);
			((MethodDeclarationContext)_localctx).ex = expression();
			 mtd.setReturnValue(((MethodDeclarationContext)_localctx).ex.expr);
			setState(181);
			match(T__8);
			setState(182);
			match(T__9);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementsContext extends ParserRuleContext {
		public ArrayList<Statement> stmnts;
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public StatementsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statements; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).enterStatements(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).exitStatements(this);
		}
	}

	public final StatementsContext statements() throws RecognitionException {
		StatementsContext _localctx = new StatementsContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_statements);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(187);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__3) | (1L << T__13) | (1L << T__16) | (1L << T__17) | (1L << T__26) | (1L << T__29) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << CONST_NUM) | (1L << CONST_STR) | (1L << ID))) != 0)) {
				{
				{
				setState(184);
				statement();
				}
				}
				setState(189);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementContext extends ParserRuleContext {
		public Statement sm;
		public StatementBlockContext statementBlock() {
			return getRuleContext(StatementBlockContext.class,0);
		}
		public StatementConditionContext statementCondition() {
			return getRuleContext(StatementConditionContext.class,0);
		}
		public StatementLoopContext statementLoop() {
			return getRuleContext(StatementLoopContext.class,0);
		}
		public StatementWriteContext statementWrite() {
			return getRuleContext(StatementWriteContext.class,0);
		}
		public StatementAssignmentContext statementAssignment() {
			return getRuleContext(StatementAssignmentContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).exitStatement(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_statement);
		try {
			setState(195);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
				enterOuterAlt(_localctx, 1);
				{
				setState(190);
				statementBlock();
				}
				break;
			case T__13:
				enterOuterAlt(_localctx, 2);
				{
				setState(191);
				statementCondition();
				}
				break;
			case T__16:
				enterOuterAlt(_localctx, 3);
				{
				setState(192);
				statementLoop();
				}
				break;
			case T__17:
				enterOuterAlt(_localctx, 4);
				{
				setState(193);
				statementWrite();
				}
				break;
			case T__3:
			case T__26:
			case T__29:
			case T__34:
			case T__35:
			case T__36:
			case T__37:
			case CONST_NUM:
			case CONST_STR:
			case ID:
				enterOuterAlt(_localctx, 5);
				{
				setState(194);
				statementAssignment();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementBlockContext extends ParserRuleContext {
		public StatementsContext s;
		public StatementsContext statements() {
			return getRuleContext(StatementsContext.class,0);
		}
		public StatementBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statementBlock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).enterStatementBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).exitStatementBlock(this);
		}
	}

	public final StatementBlockContext statementBlock() throws RecognitionException {
		StatementBlockContext _localctx = new StatementBlockContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_statementBlock);
		try {
			enterOuterAlt(_localctx, 1);
			{
			 Block block = new Block();
			setState(198);
			match(T__1);
			setState(199);
			((StatementBlockContext)_localctx).s = statements();
			((StatementBlockContext)_localctx).s.stmnts.forEach( v -> block.addStatement(v) );
			setState(201);
			match(T__9);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementConditionContext extends ParserRuleContext {
		public ExpressionContext ex;
		public StatementContext s;
		public StatementContext ss;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public StatementConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statementCondition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).enterStatementCondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).exitStatementCondition(this);
		}
	}

	public final StatementConditionContext statementCondition() throws RecognitionException {
		StatementConditionContext _localctx = new StatementConditionContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_statementCondition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			 Conditional stmnt = new Conditional();;
			setState(204);
			match(T__13);
			setState(205);
			match(T__3);
			setState(206);
			((StatementConditionContext)_localctx).ex = expression();
			 stmnt.setExpression(ex.expr);
			setState(208);
			match(T__4);
			setState(209);
			match(T__14);
			setState(210);
			((StatementConditionContext)_localctx).s = statement();
			 stmnt.setConsequenceBody(((StatementConditionContext)_localctx).s.sm); ;
			setState(216);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				{
				setState(212);
				match(T__15);
				setState(213);
				((StatementConditionContext)_localctx).ss = statement();
				 stmnt.setAlternativeBody(((StatementConditionContext)_localctx).ss.sm); ;
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementLoopContext extends ParserRuleContext {
		public ExpressionContext ex;
		public StatementContext s;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public StatementLoopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statementLoop; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).enterStatementLoop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).exitStatementLoop(this);
		}
	}

	public final StatementLoopContext statementLoop() throws RecognitionException {
		StatementLoopContext _localctx = new StatementLoopContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_statementLoop);
		try {
			enterOuterAlt(_localctx, 1);
			{
			 While stmnt = new While();
			setState(219);
			match(T__16);
			setState(220);
			match(T__3);
			setState(221);
			((StatementLoopContext)_localctx).ex = expression();
			 stmnt.setCondition(((StatementLoopContext)_localctx).ex.expr);
			setState(223);
			match(T__4);
			setState(224);
			((StatementLoopContext)_localctx).s = statement();
			 stmnt.setBody(((StatementLoopContext)_localctx).s.sm); ;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementWriteContext extends ParserRuleContext {
		public ExpressionContext ex;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public StatementWriteContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statementWrite; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).enterStatementWrite(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).exitStatementWrite(this);
		}
	}

	public final StatementWriteContext statementWrite() throws RecognitionException {
		StatementWriteContext _localctx = new StatementWriteContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_statementWrite);
		try {
			enterOuterAlt(_localctx, 1);
			{
			 Write write = new Write();
			setState(228);
			match(T__17);
			setState(229);
			((StatementWriteContext)_localctx).ex = expression();
			 write.setArg(((StatementWriteContext)_localctx).ex.expr);
			setState(231);
			match(T__4);
			setState(232);
			match(T__8);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementAssignmentContext extends ParserRuleContext {
		public ExpressionContext ex;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public StatementAssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statementAssignment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).enterStatementAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).exitStatementAssignment(this);
		}
	}

	public final StatementAssignmentContext statementAssignment() throws RecognitionException {
		StatementAssignmentContext _localctx = new StatementAssignmentContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_statementAssignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			Assign assignment = new Assign();
			setState(235);
			((StatementAssignmentContext)_localctx).ex = expression();
			assignment.setlValue(((StatementAssignmentContext)_localctx).ex.expr);
			setState(237);
			match(T__8);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionContext extends ParserRuleContext {
		public Expression expr;
		public ExpressionAssignmentContext expressionAssignment() {
			return getRuleContext(ExpressionAssignmentContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).exitExpression(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(239);
			expressionAssignment();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionAssignmentContext extends ParserRuleContext {
		public Expression expr;
		public ExpressionOrContext ex;
		public ExpressionAssignmentContext exx;
		public ExpressionOrContext expressionOr() {
			return getRuleContext(ExpressionOrContext.class,0);
		}
		public ExpressionAssignmentContext expressionAssignment() {
			return getRuleContext(ExpressionAssignmentContext.class,0);
		}
		public ExpressionAssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionAssignment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).enterExpressionAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).exitExpressionAssignment(this);
		}
	}

	public final ExpressionAssignmentContext expressionAssignment() throws RecognitionException {
		ExpressionAssignmentContext _localctx = new ExpressionAssignmentContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_expressionAssignment);
		try {
			setState(249);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(241);
				((ExpressionAssignmentContext)_localctx).ex = expressionOr();
				 BinaryExpression binaryExpr = new BinaryExpression();  binaryExpr.setLeft(((ExpressionAssignmentContext)_localctx).ex.expr);
				setState(243);
				match(T__18);
				 BinaryOperator op = BinaryOperator.ASSIGN; binaryExpr.setBinaryOperator(op);
				setState(245);
				((ExpressionAssignmentContext)_localctx).exx = expressionAssignment();
				 binaryExpr.setRight(((ExpressionAssignmentContext)_localctx).exx.expr);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(248);
				expressionOr();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionOrContext extends ParserRuleContext {
		public Expression expr;
		public ExpressionAndContext ex;
		public ExpressionOrTempContext expressionOrTemp() {
			return getRuleContext(ExpressionOrTempContext.class,0);
		}
		public ExpressionAndContext expressionAnd() {
			return getRuleContext(ExpressionAndContext.class,0);
		}
		public ExpressionOrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionOr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).enterExpressionOr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).exitExpressionOr(this);
		}
	}

	public final ExpressionOrContext expressionOr() throws RecognitionException {
		ExpressionOrContext _localctx = new ExpressionOrContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_expressionOr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(251);
			((ExpressionOrContext)_localctx).ex = expressionAnd();
			 BinaryExpression binaryExpr = new BinaryExpression();  binaryExpr.setLeft(((ExpressionOrContext)_localctx).ex.expr);
			setState(253);
			expressionOrTemp(binaryExpr);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionOrTempContext extends ParserRuleContext {
		public Expression b;
		public Expression expr;
		public ExpressionAndContext ex;
		public ExpressionOrTempContext exx;
		public ExpressionAndContext expressionAnd() {
			return getRuleContext(ExpressionAndContext.class,0);
		}
		public ExpressionOrTempContext expressionOrTemp() {
			return getRuleContext(ExpressionOrTempContext.class,0);
		}
		public ExpressionOrTempContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public ExpressionOrTempContext(ParserRuleContext parent, int invokingState, Expression b) {
			super(parent, invokingState);
			this.b = b;
		}
		@Override public int getRuleIndex() { return RULE_expressionOrTemp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).enterExpressionOrTemp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).exitExpressionOrTemp(this);
		}
	}

	public final ExpressionOrTempContext expressionOrTemp(Expression b) throws RecognitionException {
		ExpressionOrTempContext _localctx = new ExpressionOrTempContext(_ctx, getState(), b);
		enterRule(_localctx, 30, RULE_expressionOrTemp);
		try {
			setState(263);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__19:
				enterOuterAlt(_localctx, 1);
				{
				setState(255);
				match(T__19);
				BinaryOperator op = BinaryOperator.OR; b.setBinaryOperator(op);
				setState(257);
				((ExpressionOrTempContext)_localctx).ex = expressionAnd();
				 b.setRight(((ExpressionOrTempContext)_localctx).ex.expr);
				setState(259);
				((ExpressionOrTempContext)_localctx).exx = expressionOrTemp(b);
				((ExpressionOrTempContext)_localctx).exx.expr.setLeft(b);
				}
				break;
			case T__4:
			case T__8:
			case T__12:
			case T__18:
			case T__31:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionAndContext extends ParserRuleContext {
		public Expression expr;
		public ExpressionEqContext ex;
		public ExpressionAndTempContext expressionAndTemp() {
			return getRuleContext(ExpressionAndTempContext.class,0);
		}
		public ExpressionEqContext expressionEq() {
			return getRuleContext(ExpressionEqContext.class,0);
		}
		public ExpressionAndContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionAnd; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).enterExpressionAnd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).exitExpressionAnd(this);
		}
	}

	public final ExpressionAndContext expressionAnd() throws RecognitionException {
		ExpressionAndContext _localctx = new ExpressionAndContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_expressionAnd);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(265);
			((ExpressionAndContext)_localctx).ex = expressionEq();
			 BinaryExpression binaryExpr = new BinaryExpression();  binaryExpr.setLeft(((ExpressionAndContext)_localctx).ex.expr);
			setState(267);
			expressionAndTemp(binaryExpr);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionAndTempContext extends ParserRuleContext {
		public Expression b;
		public Expression expr;
		public ExpressionEqContext ex;
		public ExpressionAndTempContext exx;
		public ExpressionEqContext expressionEq() {
			return getRuleContext(ExpressionEqContext.class,0);
		}
		public ExpressionAndTempContext expressionAndTemp() {
			return getRuleContext(ExpressionAndTempContext.class,0);
		}
		public ExpressionAndTempContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public ExpressionAndTempContext(ParserRuleContext parent, int invokingState, Expression b) {
			super(parent, invokingState);
			this.b = b;
		}
		@Override public int getRuleIndex() { return RULE_expressionAndTemp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).enterExpressionAndTemp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).exitExpressionAndTemp(this);
		}
	}

	public final ExpressionAndTempContext expressionAndTemp(Expression b) throws RecognitionException {
		ExpressionAndTempContext _localctx = new ExpressionAndTempContext(_ctx, getState(), b);
		enterRule(_localctx, 34, RULE_expressionAndTemp);
		try {
			setState(277);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__20:
				enterOuterAlt(_localctx, 1);
				{
				setState(269);
				match(T__20);
				BinaryOperator op = BinaryOperator.AND; b.setBinaryOperator(op);
				setState(271);
				((ExpressionAndTempContext)_localctx).ex = expressionEq();
				 b.setRight(((ExpressionAndTempContext)_localctx).ex.expr);
				setState(273);
				((ExpressionAndTempContext)_localctx).exx = expressionAndTemp(b);
				((ExpressionAndTempContext)_localctx).exx.expr.setLeft(b);
				}
				break;
			case T__4:
			case T__8:
			case T__12:
			case T__18:
			case T__19:
			case T__31:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionEqContext extends ParserRuleContext {
		public Expression expr;
		public ExpressionCmpContext ex;
		public ExpressionEqTempContext expressionEqTemp() {
			return getRuleContext(ExpressionEqTempContext.class,0);
		}
		public ExpressionCmpContext expressionCmp() {
			return getRuleContext(ExpressionCmpContext.class,0);
		}
		public ExpressionEqContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionEq; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).enterExpressionEq(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).exitExpressionEq(this);
		}
	}

	public final ExpressionEqContext expressionEq() throws RecognitionException {
		ExpressionEqContext _localctx = new ExpressionEqContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_expressionEq);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(279);
			((ExpressionEqContext)_localctx).ex = expressionCmp();
			 BinaryExpression binaryExpr = new BinaryExpression();  binaryExpr.setLeft(((ExpressionEqContext)_localctx).ex.expr);
			setState(281);
			expressionEqTemp(binaryExpr);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionEqTempContext extends ParserRuleContext {
		public Expression b;
		public Expression expr;
		public ExpressionCmpContext ex;
		public ExpressionEqTempContext exx;
		public ExpressionCmpContext expressionCmp() {
			return getRuleContext(ExpressionCmpContext.class,0);
		}
		public ExpressionEqTempContext expressionEqTemp() {
			return getRuleContext(ExpressionEqTempContext.class,0);
		}
		public ExpressionEqTempContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public ExpressionEqTempContext(ParserRuleContext parent, int invokingState, Expression b) {
			super(parent, invokingState);
			this.b = b;
		}
		@Override public int getRuleIndex() { return RULE_expressionEqTemp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).enterExpressionEqTemp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).exitExpressionEqTemp(this);
		}
	}

	public final ExpressionEqTempContext expressionEqTemp(Expression b) throws RecognitionException {
		ExpressionEqTempContext _localctx = new ExpressionEqTempContext(_ctx, getState(), b);
		enterRule(_localctx, 38, RULE_expressionEqTemp);
		try {
			setState(295);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__21:
			case T__22:
				enterOuterAlt(_localctx, 1);
				{
				setState(287);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__21:
					{
					setState(283);
					match(T__21);
					BinaryOperator op = BinaryOperator.EQUALS; b.setBinaryOperator(op);
					}
					break;
				case T__22:
					{
					setState(285);
					match(T__22);
					op = BinaryOperator.NOT_EQUALS; b.setBinaryOperator(op);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(289);
				((ExpressionEqTempContext)_localctx).ex = expressionCmp();
				 b.setRight(((ExpressionEqTempContext)_localctx).ex.expr);
				setState(291);
				((ExpressionEqTempContext)_localctx).exx = expressionEqTemp(b);
				((ExpressionEqTempContext)_localctx).exx.expr.setLeft(b);
				}
				break;
			case T__4:
			case T__8:
			case T__12:
			case T__18:
			case T__19:
			case T__20:
			case T__31:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionCmpContext extends ParserRuleContext {
		public Expression expr;
		public ExpressionAddContext ex;
		public ExpressionCmpTempContext expressionCmpTemp() {
			return getRuleContext(ExpressionCmpTempContext.class,0);
		}
		public ExpressionAddContext expressionAdd() {
			return getRuleContext(ExpressionAddContext.class,0);
		}
		public ExpressionCmpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionCmp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).enterExpressionCmp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).exitExpressionCmp(this);
		}
	}

	public final ExpressionCmpContext expressionCmp() throws RecognitionException {
		ExpressionCmpContext _localctx = new ExpressionCmpContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_expressionCmp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(297);
			((ExpressionCmpContext)_localctx).ex = expressionAdd();
			 BinaryExpression binaryExpr = new BinaryExpression();  binaryExpr.setLeft(((ExpressionCmpContext)_localctx).ex.expr);
			setState(299);
			expressionCmpTemp(binaryExpr);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionCmpTempContext extends ParserRuleContext {
		public Expression b;
		public Expression expr;
		public ExpressionAddContext ex;
		public ExpressionCmpTempContext exx;
		public ExpressionAddContext expressionAdd() {
			return getRuleContext(ExpressionAddContext.class,0);
		}
		public ExpressionCmpTempContext expressionCmpTemp() {
			return getRuleContext(ExpressionCmpTempContext.class,0);
		}
		public ExpressionCmpTempContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public ExpressionCmpTempContext(ParserRuleContext parent, int invokingState, Expression b) {
			super(parent, invokingState);
			this.b = b;
		}
		@Override public int getRuleIndex() { return RULE_expressionCmpTemp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).enterExpressionCmpTemp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).exitExpressionCmpTemp(this);
		}
	}

	public final ExpressionCmpTempContext expressionCmpTemp(Expression b) throws RecognitionException {
		ExpressionCmpTempContext _localctx = new ExpressionCmpTempContext(_ctx, getState(), b);
		enterRule(_localctx, 42, RULE_expressionCmpTemp);
		try {
			setState(313);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__23:
			case T__24:
				enterOuterAlt(_localctx, 1);
				{
				setState(305);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__23:
					{
					setState(301);
					match(T__23);
					BinaryOperator op = BinaryOperator.LESS; b.setBinaryOperator(op);
					}
					break;
				case T__24:
					{
					setState(303);
					match(T__24);
					BinaryOperator op = BinaryOperator.GREATER; b.setBinaryOperator(op);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(307);
				((ExpressionCmpTempContext)_localctx).ex = expressionAdd();
				 b.setRight(((ExpressionCmpTempContext)_localctx).ex.expr);
				setState(309);
				((ExpressionCmpTempContext)_localctx).exx = expressionCmpTemp(b);
				((ExpressionCmpTempContext)_localctx).exx.expr.setLeft(b);
				}
				break;
			case T__4:
			case T__8:
			case T__12:
			case T__18:
			case T__19:
			case T__20:
			case T__21:
			case T__22:
			case T__31:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionAddContext extends ParserRuleContext {
		public Expression expr;
		public ExpressionMultContext ex;
		public ExpressionAddTempContext expressionAddTemp() {
			return getRuleContext(ExpressionAddTempContext.class,0);
		}
		public ExpressionMultContext expressionMult() {
			return getRuleContext(ExpressionMultContext.class,0);
		}
		public ExpressionAddContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionAdd; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).enterExpressionAdd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).exitExpressionAdd(this);
		}
	}

	public final ExpressionAddContext expressionAdd() throws RecognitionException {
		ExpressionAddContext _localctx = new ExpressionAddContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_expressionAdd);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(315);
			((ExpressionAddContext)_localctx).ex = expressionMult();
			 BinaryExpression binaryExpr = new BinaryExpression();  binaryExpr.setLeft(((ExpressionAddContext)_localctx).ex.expr);
			setState(317);
			expressionAddTemp(binaryExpr);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionAddTempContext extends ParserRuleContext {
		public Expression b;
		public Expression expr;
		public ExpressionMultContext ex;
		public ExpressionAddTempContext exx;
		public ExpressionMultContext expressionMult() {
			return getRuleContext(ExpressionMultContext.class,0);
		}
		public ExpressionAddTempContext expressionAddTemp() {
			return getRuleContext(ExpressionAddTempContext.class,0);
		}
		public ExpressionAddTempContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public ExpressionAddTempContext(ParserRuleContext parent, int invokingState, Expression b) {
			super(parent, invokingState);
			this.b = b;
		}
		@Override public int getRuleIndex() { return RULE_expressionAddTemp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).enterExpressionAddTemp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).exitExpressionAddTemp(this);
		}
	}

	public final ExpressionAddTempContext expressionAddTemp(Expression b) throws RecognitionException {
		ExpressionAddTempContext _localctx = new ExpressionAddTempContext(_ctx, getState(), b);
		enterRule(_localctx, 46, RULE_expressionAddTemp);
		try {
			setState(331);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__25:
			case T__26:
				enterOuterAlt(_localctx, 1);
				{
				setState(323);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__25:
					{
					setState(319);
					match(T__25);
					BinaryOperator op = BinaryOperator.PLUS; b.setBinaryOperator(op);
					}
					break;
				case T__26:
					{
					setState(321);
					match(T__26);
					BinaryOperator op = BinaryOperator.MINUS; b.setBinaryOperator(op);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(325);
				((ExpressionAddTempContext)_localctx).ex = expressionMult();
				 b.setRight(((ExpressionAddTempContext)_localctx).ex.expr);
				setState(327);
				((ExpressionAddTempContext)_localctx).exx = expressionAddTemp(b);
				((ExpressionAddTempContext)_localctx).exx.expr.setLeft(b);
				}
				break;
			case T__4:
			case T__8:
			case T__12:
			case T__18:
			case T__19:
			case T__20:
			case T__21:
			case T__22:
			case T__23:
			case T__24:
			case T__31:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionMultContext extends ParserRuleContext {
		public Expression expr;
		public ExpressionUnaryContext ex;
		public ExpressionMultTempContext expressionMultTemp() {
			return getRuleContext(ExpressionMultTempContext.class,0);
		}
		public ExpressionUnaryContext expressionUnary() {
			return getRuleContext(ExpressionUnaryContext.class,0);
		}
		public ExpressionMultContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionMult; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).enterExpressionMult(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).exitExpressionMult(this);
		}
	}

	public final ExpressionMultContext expressionMult() throws RecognitionException {
		ExpressionMultContext _localctx = new ExpressionMultContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_expressionMult);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(333);
			((ExpressionMultContext)_localctx).ex = expressionUnary();
			 BinaryExpression binaryExpr = new BinaryExpression();  binaryExpr.setLeft(((ExpressionMultContext)_localctx).ex.expr);
			setState(335);
			expressionMultTemp(binaryExpr);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionMultTempContext extends ParserRuleContext {
		public Expression b;
		public Expression expr;
		public ExpressionUnaryContext ex;
		public ExpressionMultTempContext exx;
		public ExpressionUnaryContext expressionUnary() {
			return getRuleContext(ExpressionUnaryContext.class,0);
		}
		public ExpressionMultTempContext expressionMultTemp() {
			return getRuleContext(ExpressionMultTempContext.class,0);
		}
		public ExpressionMultTempContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public ExpressionMultTempContext(ParserRuleContext parent, int invokingState, Expression b) {
			super(parent, invokingState);
			this.b = b;
		}
		@Override public int getRuleIndex() { return RULE_expressionMultTemp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).enterExpressionMultTemp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).exitExpressionMultTemp(this);
		}
	}

	public final ExpressionMultTempContext expressionMultTemp(Expression b) throws RecognitionException {
		ExpressionMultTempContext _localctx = new ExpressionMultTempContext(_ctx, getState(), b);
		enterRule(_localctx, 50, RULE_expressionMultTemp);
		try {
			setState(349);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__27:
			case T__28:
				enterOuterAlt(_localctx, 1);
				{
				setState(341);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__27:
					{
					setState(337);
					match(T__27);
					BinaryOperator op = BinaryOperator.MULTIPLY; b.setBinaryOperator(op);
					}
					break;
				case T__28:
					{
					setState(339);
					match(T__28);
					BinaryOperator op = BinaryOperator.DIVIDE; b.setBinaryOperator(op);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(343);
				((ExpressionMultTempContext)_localctx).ex = expressionUnary();
				 b.setRight(((ExpressionMultTempContext)_localctx).ex.expr);
				setState(345);
				((ExpressionMultTempContext)_localctx).exx = expressionMultTemp(b);
				((ExpressionMultTempContext)_localctx).exx.expr.setLeft(b);
				}
				break;
			case T__4:
			case T__8:
			case T__12:
			case T__18:
			case T__19:
			case T__20:
			case T__21:
			case T__22:
			case T__23:
			case T__24:
			case T__25:
			case T__26:
			case T__31:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionUnaryContext extends ParserRuleContext {
		public Expression expr;
		public ExpressionUnaryContext ex;
		public ExpressionUnaryContext expressionUnary() {
			return getRuleContext(ExpressionUnaryContext.class,0);
		}
		public ExpressionMemContext expressionMem() {
			return getRuleContext(ExpressionMemContext.class,0);
		}
		public ExpressionUnaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionUnary; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).enterExpressionUnary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).exitExpressionUnary(this);
		}
	}

	public final ExpressionUnaryContext expressionUnary() throws RecognitionException {
		ExpressionUnaryContext _localctx = new ExpressionUnaryContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_expressionUnary);
		try {
			setState(362);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__26:
			case T__29:
				enterOuterAlt(_localctx, 1);
				{
				 UnaryExpression unary = new UnaryExpression();
				setState(356);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__29:
					{
					setState(352);
					match(T__29);
					UnaryOperator op = UnaryOperator.NOT; unary.setUnaryOperator(op);
					}
					break;
				case T__26:
					{
					setState(354);
					match(T__26);
					UnaryOperator op = UnaryOperator.MINUS; unary.setUnaryOperator(op);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(358);
				((ExpressionUnaryContext)_localctx).ex = expressionUnary();
				unary.setValue(((ExpressionUnaryContext)_localctx).ex.expr);
				}
				break;
			case T__3:
			case T__34:
			case T__35:
			case T__36:
			case T__37:
			case CONST_NUM:
			case CONST_STR:
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(361);
				expressionMem();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionMemContext extends ParserRuleContext {
		public ExpressionMethodsContext ex;
		public ExpressionMemTempContext expressionMemTemp() {
			return getRuleContext(ExpressionMemTempContext.class,0);
		}
		public ExpressionMethodsContext expressionMethods() {
			return getRuleContext(ExpressionMethodsContext.class,0);
		}
		public ExpressionMemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionMem; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).enterExpressionMem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).exitExpressionMem(this);
		}
	}

	public final ExpressionMemContext expressionMem() throws RecognitionException {
		ExpressionMemContext _localctx = new ExpressionMemContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_expressionMem);
		try {
			enterOuterAlt(_localctx, 1);
			{
			 ArrayCall arrayy = new ArrayCall();
			setState(365);
			((ExpressionMemContext)_localctx).ex = expressionMethods();
			 arrayy.setInstance(((ExpressionMemContext)_localctx).ex.expr);
			setState(367);
			expressionMemTemp(arrayy);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionMemTempContext extends ParserRuleContext {
		public ArrayCall arr;
		public ExpressionContext ex;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ExpressionMemTempContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public ExpressionMemTempContext(ParserRuleContext parent, int invokingState, ArrayCall arr) {
			super(parent, invokingState);
			this.arr = arr;
		}
		@Override public int getRuleIndex() { return RULE_expressionMemTemp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).enterExpressionMemTemp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).exitExpressionMemTemp(this);
		}
	}

	public final ExpressionMemTempContext expressionMemTemp(ArrayCall arr) throws RecognitionException {
		ExpressionMemTempContext _localctx = new ExpressionMemTempContext(_ctx, getState(), arr);
		enterRule(_localctx, 56, RULE_expressionMemTemp);
		try {
			setState(375);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__30:
				enterOuterAlt(_localctx, 1);
				{
				setState(369);
				match(T__30);
				setState(370);
				((ExpressionMemTempContext)_localctx).ex = expression();
				arr.setIndex(((ExpressionMemTempContext)_localctx).ex.expr);
				setState(372);
				match(T__31);
				}
				break;
			case T__4:
			case T__8:
			case T__12:
			case T__18:
			case T__19:
			case T__20:
			case T__21:
			case T__22:
			case T__23:
			case T__24:
			case T__25:
			case T__26:
			case T__27:
			case T__28:
			case T__31:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionMethodsContext extends ParserRuleContext {
		public Expression expr;
		public ExpressionOtherContext ex;
		public ExpressionMethodsTempContext expressionMethodsTemp() {
			return getRuleContext(ExpressionMethodsTempContext.class,0);
		}
		public ExpressionOtherContext expressionOther() {
			return getRuleContext(ExpressionOtherContext.class,0);
		}
		public ExpressionMethodsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionMethods; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).enterExpressionMethods(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).exitExpressionMethods(this);
		}
	}

	public final ExpressionMethodsContext expressionMethods() throws RecognitionException {
		ExpressionMethodsContext _localctx = new ExpressionMethodsContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_expressionMethods);
		try {
			enterOuterAlt(_localctx, 1);
			{
			 MethodCall method = new MethodCall();
			setState(378);
			((ExpressionMethodsContext)_localctx).ex = expressionOther();
			method.setInstance(((ExpressionMethodsContext)_localctx).ex.expr);
			setState(380);
			expressionMethodsTemp(method);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionMethodsTempContext extends ParserRuleContext {
		public MethodCall method;
		public Expression expr;
		public Token ID;
		public ExpressionContext ex;
		public ExpressionContext exx;
		public ExpressionMethodsTempContext expressionMethodsTemp() {
			return getRuleContext(ExpressionMethodsTempContext.class,0);
		}
		public TerminalNode ID() { return getToken(SmoolaParser.ID, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ExpressionMethodsTempContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public ExpressionMethodsTempContext(ParserRuleContext parent, int invokingState, MethodCall method) {
			super(parent, invokingState);
			this.method = method;
		}
		@Override public int getRuleIndex() { return RULE_expressionMethodsTemp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).enterExpressionMethodsTemp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).exitExpressionMethodsTemp(this);
		}
	}

	public final ExpressionMethodsTempContext expressionMethodsTemp(MethodCall method) throws RecognitionException {
		ExpressionMethodsTempContext _localctx = new ExpressionMethodsTempContext(_ctx, getState(), method);
		enterRule(_localctx, 60, RULE_expressionMethodsTemp);
		int _la;
		try {
			setState(408);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__32:
				enterOuterAlt(_localctx, 1);
				{
				setState(382);
				match(T__32);
				setState(404);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
				case 1:
					{
					setState(383);
					((ExpressionMethodsTempContext)_localctx).ID = match(ID);
					 method.setMethodName(((ExpressionMethodsTempContext)_localctx).ID);
					setState(385);
					match(T__3);
					setState(386);
					match(T__4);
					}
					break;
				case 2:
					{
					setState(387);
					((ExpressionMethodsTempContext)_localctx).ID = match(ID);
					 method.setMethodName(((ExpressionMethodsTempContext)_localctx).ID);
					setState(389);
					match(T__3);
					{
					setState(390);
					((ExpressionMethodsTempContext)_localctx).ex = expression();
					 method.addArg(((ExpressionMethodsTempContext)_localctx).ex.expr);
					setState(398);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__12) {
						{
						{
						setState(392);
						match(T__12);
						setState(393);
						((ExpressionMethodsTempContext)_localctx).exx = expression();
						 method.addArg(((ExpressionMethodsTempContext)_localctx).exx.expr);
						}
						}
						setState(400);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
					setState(401);
					match(T__4);
					}
					break;
				case 3:
					{
					setState(403);
					match(T__33);
					}
					break;
				}
				setState(406);
				expressionMethodsTemp(method);
				}
				break;
			case T__4:
			case T__8:
			case T__12:
			case T__18:
			case T__19:
			case T__20:
			case T__21:
			case T__22:
			case T__23:
			case T__24:
			case T__25:
			case T__26:
			case T__27:
			case T__28:
			case T__30:
			case T__31:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionOtherContext extends ParserRuleContext {
		public Expression expr;
		public Token ID;
		public ExpressionContext s;
		public ExpressionContext ss;
		public TerminalNode CONST_NUM() { return getToken(SmoolaParser.CONST_NUM, 0); }
		public TerminalNode CONST_STR() { return getToken(SmoolaParser.CONST_STR, 0); }
		public TerminalNode ID() { return getToken(SmoolaParser.ID, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ExpressionOtherContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionOther; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).enterExpressionOther(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).exitExpressionOther(this);
		}
	}

	public final ExpressionOtherContext expressionOther() throws RecognitionException {
		ExpressionOtherContext _localctx = new ExpressionOtherContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_expressionOther);
		try {
			setState(439);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(410);
				match(CONST_NUM);
				 IntType type = new IntType(); IntValue constt = new IntValue(CONST_NUM,type);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(412);
				match(CONST_STR);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(413);
				match(T__34);
				setState(414);
				match(T__6);
				setState(415);
				match(T__30);
				setState(416);
				match(CONST_NUM);
				setState(417);
				match(T__31);
				NewArray arrayy = new NewArray(); arrayy.setExpression(constt); 
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(419);
				match(T__34);
				setState(420);
				((ExpressionOtherContext)_localctx).ID = match(ID);
				NewClass newClass = new NewClass(); newClass.setClassName(((ExpressionOtherContext)_localctx).ID);
				setState(422);
				match(T__3);
				setState(423);
				match(T__4);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(424);
				match(T__35);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(425);
				match(T__36);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(426);
				match(T__37);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(427);
				match(ID);
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(428);
				((ExpressionOtherContext)_localctx).ID = match(ID);
				setState(429);
				match(T__30);
				setState(430);
				((ExpressionOtherContext)_localctx).s = expression();
				setState(431);
				match(T__31);
				 ArrayCall arrayy = new ArrayCall(); arrayy.setInstance(((ExpressionOtherContext)_localctx).ID); arrayy.setIndex(((ExpressionOtherContext)_localctx).s.expr);
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(434);
				match(T__3);
				setState(435);
				((ExpressionOtherContext)_localctx).ss = expression();
				setState(436);
				match(T__4);
				  MethodCall method = new MethodCall(); method.addArg(((ExpressionOtherContext)_localctx).ss.expr);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeContext extends ParserRuleContext {
		public Type typeDef;
		public TerminalNode ID() { return getToken(SmoolaParser.ID, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).exitType(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_type);
		try {
			setState(448);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(441);
				match(T__6);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(442);
				match(T__38);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(443);
				match(T__39);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(444);
				match(T__6);
				setState(445);
				match(T__30);
				setState(446);
				match(T__31);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(447);
				match(ID);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\60\u01c5\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\3\2\3\2\3\2\3\2\3\2\3\2\7\2K\n\2\f\2\16\2N\13\2\3\2\3\2\3"+
		"\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\5\4o\n\4\3\4\3\4\3\4\3\4"+
		"\7\4u\n\4\f\4\16\4x\13\4\3\4\3\4\3\4\7\4}\n\4\f\4\16\4\u0080\13\4\3\4"+
		"\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\7\6\u009e\n\6\f\6\16\6\u00a1\13"+
		"\6\3\6\3\6\5\6\u00a5\n\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\7\6\u00ae\n\6\f\6"+
		"\16\6\u00b1\13\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\7\7\u00bc\n\7\f\7"+
		"\16\7\u00bf\13\7\3\b\3\b\3\b\3\b\3\b\5\b\u00c6\n\b\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u00db\n\n"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f"+
		"\3\f\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\5\17\u00fc\n\17\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\5\21\u010a\n\21\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\5\23\u0118\n\23\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25"+
		"\5\25\u0122\n\25\3\25\3\25\3\25\3\25\3\25\3\25\5\25\u012a\n\25\3\26\3"+
		"\26\3\26\3\26\3\27\3\27\3\27\3\27\5\27\u0134\n\27\3\27\3\27\3\27\3\27"+
		"\3\27\3\27\5\27\u013c\n\27\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\31\5\31"+
		"\u0146\n\31\3\31\3\31\3\31\3\31\3\31\3\31\5\31\u014e\n\31\3\32\3\32\3"+
		"\32\3\32\3\33\3\33\3\33\3\33\5\33\u0158\n\33\3\33\3\33\3\33\3\33\3\33"+
		"\3\33\5\33\u0160\n\33\3\34\3\34\3\34\3\34\3\34\5\34\u0167\n\34\3\34\3"+
		"\34\3\34\3\34\5\34\u016d\n\34\3\35\3\35\3\35\3\35\3\35\3\36\3\36\3\36"+
		"\3\36\3\36\3\36\5\36\u017a\n\36\3\37\3\37\3\37\3\37\3\37\3 \3 \3 \3 \3"+
		" \3 \3 \3 \3 \3 \3 \3 \3 \3 \7 \u018f\n \f \16 \u0192\13 \3 \3 \3 \5 "+
		"\u0197\n \3 \3 \5 \u019b\n \3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!"+
		"\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\5!\u01ba\n!\3\"\3\"\3\""+
		"\3\"\3\"\3\"\3\"\5\"\u01c3\n\"\3\"\2\2#\2\4\6\b\n\f\16\20\22\24\26\30"+
		"\32\34\36 \"$&(*,.\60\62\64\668:<>@B\2\2\2\u01cf\2D\3\2\2\2\4R\3\2\2\2"+
		"\6h\3\2\2\2\b\u0083\3\2\2\2\n\u008b\3\2\2\2\f\u00bd\3\2\2\2\16\u00c5\3"+
		"\2\2\2\20\u00c7\3\2\2\2\22\u00cd\3\2\2\2\24\u00dc\3\2\2\2\26\u00e5\3\2"+
		"\2\2\30\u00ec\3\2\2\2\32\u00f1\3\2\2\2\34\u00fb\3\2\2\2\36\u00fd\3\2\2"+
		"\2 \u0109\3\2\2\2\"\u010b\3\2\2\2$\u0117\3\2\2\2&\u0119\3\2\2\2(\u0129"+
		"\3\2\2\2*\u012b\3\2\2\2,\u013b\3\2\2\2.\u013d\3\2\2\2\60\u014d\3\2\2\2"+
		"\62\u014f\3\2\2\2\64\u015f\3\2\2\2\66\u016c\3\2\2\28\u016e\3\2\2\2:\u0179"+
		"\3\2\2\2<\u017b\3\2\2\2>\u019a\3\2\2\2@\u01b9\3\2\2\2B\u01c2\3\2\2\2D"+
		"E\b\2\1\2EF\5\4\3\2FL\b\2\1\2GH\5\6\4\2HI\b\2\1\2IK\3\2\2\2JG\3\2\2\2"+
		"KN\3\2\2\2LJ\3\2\2\2LM\3\2\2\2MO\3\2\2\2NL\3\2\2\2OP\7\2\2\3PQ\b\2\1\2"+
		"Q\3\3\2\2\2RS\7\3\2\2ST\7.\2\2TU\b\3\1\2UV\7\4\2\2VW\7\5\2\2WX\7.\2\2"+
		"XY\b\3\1\2YZ\7\6\2\2Z[\7\7\2\2[\\\7\b\2\2\\]\7\t\2\2]^\b\3\1\2^_\7\4\2"+
		"\2_`\5\f\7\2`a\b\3\1\2ab\7\n\2\2bc\5\32\16\2cd\b\3\1\2de\7\13\2\2ef\7"+
		"\f\2\2fg\7\f\2\2g\5\3\2\2\2hi\7\3\2\2ij\7.\2\2jn\b\4\1\2kl\7\r\2\2lm\7"+
		".\2\2mo\b\4\1\2nk\3\2\2\2no\3\2\2\2op\3\2\2\2pv\7\4\2\2qr\5\b\5\2rs\b"+
		"\4\1\2su\3\2\2\2tq\3\2\2\2ux\3\2\2\2vt\3\2\2\2vw\3\2\2\2w~\3\2\2\2xv\3"+
		"\2\2\2yz\5\n\6\2z{\b\4\1\2{}\3\2\2\2|y\3\2\2\2}\u0080\3\2\2\2~|\3\2\2"+
		"\2~\177\3\2\2\2\177\u0081\3\2\2\2\u0080~\3\2\2\2\u0081\u0082\7\f\2\2\u0082"+
		"\7\3\2\2\2\u0083\u0084\7\16\2\2\u0084\u0085\7.\2\2\u0085\u0086\b\5\1\2"+
		"\u0086\u0087\7\b\2\2\u0087\u0088\5B\"\2\u0088\u0089\b\5\1\2\u0089\u008a"+
		"\7\13\2\2\u008a\t\3\2\2\2\u008b\u008c\7\5\2\2\u008c\u008d\7.\2\2\u008d"+
		"\u00a4\b\6\1\2\u008e\u008f\7\6\2\2\u008f\u00a5\7\7\2\2\u0090\u0091\7\6"+
		"\2\2\u0091\u0092\7.\2\2\u0092\u0093\b\6\1\2\u0093\u0094\7\b\2\2\u0094"+
		"\u0095\5B\"\2\u0095\u009f\b\6\1\2\u0096\u0097\7\17\2\2\u0097\u0098\7."+
		"\2\2\u0098\u0099\b\6\1\2\u0099\u009a\7\b\2\2\u009a\u009b\5B\"\2\u009b"+
		"\u009c\b\6\1\2\u009c\u009e\3\2\2\2\u009d\u0096\3\2\2\2\u009e\u00a1\3\2"+
		"\2\2\u009f\u009d\3\2\2\2\u009f\u00a0\3\2\2\2\u00a0\u00a2\3\2\2\2\u00a1"+
		"\u009f\3\2\2\2\u00a2\u00a3\7\7\2\2\u00a3\u00a5\3\2\2\2\u00a4\u008e\3\2"+
		"\2\2\u00a4\u0090\3\2\2\2\u00a5\u00a6\3\2\2\2\u00a6\u00a7\7\b\2\2\u00a7"+
		"\u00a8\5B\"\2\u00a8\u00a9\b\6\1\2\u00a9\u00af\7\4\2\2\u00aa\u00ab\5\b"+
		"\5\2\u00ab\u00ac\b\6\1\2\u00ac\u00ae\3\2\2\2\u00ad\u00aa\3\2\2\2\u00ae"+
		"\u00b1\3\2\2\2\u00af\u00ad\3\2\2\2\u00af\u00b0\3\2\2\2\u00b0\u00b2\3\2"+
		"\2\2\u00b1\u00af\3\2\2\2\u00b2\u00b3\5\f\7\2\u00b3\u00b4\b\6\1\2\u00b4"+
		"\u00b5\7\n\2\2\u00b5\u00b6\5\32\16\2\u00b6\u00b7\b\6\1\2\u00b7\u00b8\7"+
		"\13\2\2\u00b8\u00b9\7\f\2\2\u00b9\13\3\2\2\2\u00ba\u00bc\5\16\b\2\u00bb"+
		"\u00ba\3\2\2\2\u00bc\u00bf\3\2\2\2\u00bd\u00bb\3\2\2\2\u00bd\u00be\3\2"+
		"\2\2\u00be\r\3\2\2\2\u00bf\u00bd\3\2\2\2\u00c0\u00c6\5\20\t\2\u00c1\u00c6"+
		"\5\22\n\2\u00c2\u00c6\5\24\13\2\u00c3\u00c6\5\26\f\2\u00c4\u00c6\5\30"+
		"\r\2\u00c5\u00c0\3\2\2\2\u00c5\u00c1\3\2\2\2\u00c5\u00c2\3\2\2\2\u00c5"+
		"\u00c3\3\2\2\2\u00c5\u00c4\3\2\2\2\u00c6\17\3\2\2\2\u00c7\u00c8\b\t\1"+
		"\2\u00c8\u00c9\7\4\2\2\u00c9\u00ca\5\f\7\2\u00ca\u00cb\b\t\1\2\u00cb\u00cc"+
		"\7\f\2\2\u00cc\21\3\2\2\2\u00cd\u00ce\b\n\1\2\u00ce\u00cf\7\20\2\2\u00cf"+
		"\u00d0\7\6\2\2\u00d0\u00d1\5\32\16\2\u00d1\u00d2\b\n\1\2\u00d2\u00d3\7"+
		"\7\2\2\u00d3\u00d4\7\21\2\2\u00d4\u00d5\5\16\b\2\u00d5\u00da\b\n\1\2\u00d6"+
		"\u00d7\7\22\2\2\u00d7\u00d8\5\16\b\2\u00d8\u00d9\b\n\1\2\u00d9\u00db\3"+
		"\2\2\2\u00da\u00d6\3\2\2\2\u00da\u00db\3\2\2\2\u00db\23\3\2\2\2\u00dc"+
		"\u00dd\b\13\1\2\u00dd\u00de\7\23\2\2\u00de\u00df\7\6\2\2\u00df\u00e0\5"+
		"\32\16\2\u00e0\u00e1\b\13\1\2\u00e1\u00e2\7\7\2\2\u00e2\u00e3\5\16\b\2"+
		"\u00e3\u00e4\b\13\1\2\u00e4\25\3\2\2\2\u00e5\u00e6\b\f\1\2\u00e6\u00e7"+
		"\7\24\2\2\u00e7\u00e8\5\32\16\2\u00e8\u00e9\b\f\1\2\u00e9\u00ea\7\7\2"+
		"\2\u00ea\u00eb\7\13\2\2\u00eb\27\3\2\2\2\u00ec\u00ed\b\r\1\2\u00ed\u00ee"+
		"\5\32\16\2\u00ee\u00ef\b\r\1\2\u00ef\u00f0\7\13\2\2\u00f0\31\3\2\2\2\u00f1"+
		"\u00f2\5\34\17\2\u00f2\33\3\2\2\2\u00f3\u00f4\5\36\20\2\u00f4\u00f5\b"+
		"\17\1\2\u00f5\u00f6\7\25\2\2\u00f6\u00f7\b\17\1\2\u00f7\u00f8\5\34\17"+
		"\2\u00f8\u00f9\b\17\1\2\u00f9\u00fc\3\2\2\2\u00fa\u00fc\5\36\20\2\u00fb"+
		"\u00f3\3\2\2\2\u00fb\u00fa\3\2\2\2\u00fc\35\3\2\2\2\u00fd\u00fe\5\"\22"+
		"\2\u00fe\u00ff\b\20\1\2\u00ff\u0100\5 \21\2\u0100\37\3\2\2\2\u0101\u0102"+
		"\7\26\2\2\u0102\u0103\b\21\1\2\u0103\u0104\5\"\22\2\u0104\u0105\b\21\1"+
		"\2\u0105\u0106\5 \21\2\u0106\u0107\b\21\1\2\u0107\u010a\3\2\2\2\u0108"+
		"\u010a\3\2\2\2\u0109\u0101\3\2\2\2\u0109\u0108\3\2\2\2\u010a!\3\2\2\2"+
		"\u010b\u010c\5&\24\2\u010c\u010d\b\22\1\2\u010d\u010e\5$\23\2\u010e#\3"+
		"\2\2\2\u010f\u0110\7\27\2\2\u0110\u0111\b\23\1\2\u0111\u0112\5&\24\2\u0112"+
		"\u0113\b\23\1\2\u0113\u0114\5$\23\2\u0114\u0115\b\23\1\2\u0115\u0118\3"+
		"\2\2\2\u0116\u0118\3\2\2\2\u0117\u010f\3\2\2\2\u0117\u0116\3\2\2\2\u0118"+
		"%\3\2\2\2\u0119\u011a\5*\26\2\u011a\u011b\b\24\1\2\u011b\u011c\5(\25\2"+
		"\u011c\'\3\2\2\2\u011d\u011e\7\30\2\2\u011e\u0122\b\25\1\2\u011f\u0120"+
		"\7\31\2\2\u0120\u0122\b\25\1\2\u0121\u011d\3\2\2\2\u0121\u011f\3\2\2\2"+
		"\u0122\u0123\3\2\2\2\u0123\u0124\5*\26\2\u0124\u0125\b\25\1\2\u0125\u0126"+
		"\5(\25\2\u0126\u0127\b\25\1\2\u0127\u012a\3\2\2\2\u0128\u012a\3\2\2\2"+
		"\u0129\u0121\3\2\2\2\u0129\u0128\3\2\2\2\u012a)\3\2\2\2\u012b\u012c\5"+
		".\30\2\u012c\u012d\b\26\1\2\u012d\u012e\5,\27\2\u012e+\3\2\2\2\u012f\u0130"+
		"\7\32\2\2\u0130\u0134\b\27\1\2\u0131\u0132\7\33\2\2\u0132\u0134\b\27\1"+
		"\2\u0133\u012f\3\2\2\2\u0133\u0131\3\2\2\2\u0134\u0135\3\2\2\2\u0135\u0136"+
		"\5.\30\2\u0136\u0137\b\27\1\2\u0137\u0138\5,\27\2\u0138\u0139\b\27\1\2"+
		"\u0139\u013c\3\2\2\2\u013a\u013c\3\2\2\2\u013b\u0133\3\2\2\2\u013b\u013a"+
		"\3\2\2\2\u013c-\3\2\2\2\u013d\u013e\5\62\32\2\u013e\u013f\b\30\1\2\u013f"+
		"\u0140\5\60\31\2\u0140/\3\2\2\2\u0141\u0142\7\34\2\2\u0142\u0146\b\31"+
		"\1\2\u0143\u0144\7\35\2\2\u0144\u0146\b\31\1\2\u0145\u0141\3\2\2\2\u0145"+
		"\u0143\3\2\2\2\u0146\u0147\3\2\2\2\u0147\u0148\5\62\32\2\u0148\u0149\b"+
		"\31\1\2\u0149\u014a\5\60\31\2\u014a\u014b\b\31\1\2\u014b\u014e\3\2\2\2"+
		"\u014c\u014e\3\2\2\2\u014d\u0145\3\2\2\2\u014d\u014c\3\2\2\2\u014e\61"+
		"\3\2\2\2\u014f\u0150\5\66\34\2\u0150\u0151\b\32\1\2\u0151\u0152\5\64\33"+
		"\2\u0152\63\3\2\2\2\u0153\u0154\7\36\2\2\u0154\u0158\b\33\1\2\u0155\u0156"+
		"\7\37\2\2\u0156\u0158\b\33\1\2\u0157\u0153\3\2\2\2\u0157\u0155\3\2\2\2"+
		"\u0158\u0159\3\2\2\2\u0159\u015a\5\66\34\2\u015a\u015b\b\33\1\2\u015b"+
		"\u015c\5\64\33\2\u015c\u015d\b\33\1\2\u015d\u0160\3\2\2\2\u015e\u0160"+
		"\3\2\2\2\u015f\u0157\3\2\2\2\u015f\u015e\3\2\2\2\u0160\65\3\2\2\2\u0161"+
		"\u0166\b\34\1\2\u0162\u0163\7 \2\2\u0163\u0167\b\34\1\2\u0164\u0165\7"+
		"\35\2\2\u0165\u0167\b\34\1\2\u0166\u0162\3\2\2\2\u0166\u0164\3\2\2\2\u0167"+
		"\u0168\3\2\2\2\u0168\u0169\5\66\34\2\u0169\u016a\b\34\1\2\u016a\u016d"+
		"\3\2\2\2\u016b\u016d\58\35\2\u016c\u0161\3\2\2\2\u016c\u016b\3\2\2\2\u016d"+
		"\67\3\2\2\2\u016e\u016f\b\35\1\2\u016f\u0170\5<\37\2\u0170\u0171\b\35"+
		"\1\2\u0171\u0172\5:\36\2\u01729\3\2\2\2\u0173\u0174\7!\2\2\u0174\u0175"+
		"\5\32\16\2\u0175\u0176\b\36\1\2\u0176\u0177\7\"\2\2\u0177\u017a\3\2\2"+
		"\2\u0178\u017a\3\2\2\2\u0179\u0173\3\2\2\2\u0179\u0178\3\2\2\2\u017a;"+
		"\3\2\2\2\u017b\u017c\b\37\1\2\u017c\u017d\5@!\2\u017d\u017e\b\37\1\2\u017e"+
		"\u017f\5> \2\u017f=\3\2\2\2\u0180\u0196\7#\2\2\u0181\u0182\7.\2\2\u0182"+
		"\u0183\b \1\2\u0183\u0184\7\6\2\2\u0184\u0197\7\7\2\2\u0185\u0186\7.\2"+
		"\2\u0186\u0187\b \1\2\u0187\u0188\7\6\2\2\u0188\u0189\5\32\16\2\u0189"+
		"\u0190\b \1\2\u018a\u018b\7\17\2\2\u018b\u018c\5\32\16\2\u018c\u018d\b"+
		" \1\2\u018d\u018f\3\2\2\2\u018e\u018a\3\2\2\2\u018f\u0192\3\2\2\2\u0190"+
		"\u018e\3\2\2\2\u0190\u0191\3\2\2\2\u0191\u0193\3\2\2\2\u0192\u0190\3\2"+
		"\2\2\u0193\u0194\7\7\2\2\u0194\u0197\3\2\2\2\u0195\u0197\7$\2\2\u0196"+
		"\u0181\3\2\2\2\u0196\u0185\3\2\2\2\u0196\u0195\3\2\2\2\u0197\u0198\3\2"+
		"\2\2\u0198\u019b\5> \2\u0199\u019b\3\2\2\2\u019a\u0180\3\2\2\2\u019a\u0199"+
		"\3\2\2\2\u019b?\3\2\2\2\u019c\u019d\7+\2\2\u019d\u01ba\b!\1\2\u019e\u01ba"+
		"\7,\2\2\u019f\u01a0\7%\2\2\u01a0\u01a1\7\t\2\2\u01a1\u01a2\7!\2\2\u01a2"+
		"\u01a3\7+\2\2\u01a3\u01a4\7\"\2\2\u01a4\u01ba\b!\1\2\u01a5\u01a6\7%\2"+
		"\2\u01a6\u01a7\7.\2\2\u01a7\u01a8\b!\1\2\u01a8\u01a9\7\6\2\2\u01a9\u01ba"+
		"\7\7\2\2\u01aa\u01ba\7&\2\2\u01ab\u01ba\7\'\2\2\u01ac\u01ba\7(\2\2\u01ad"+
		"\u01ba\7.\2\2\u01ae\u01af\7.\2\2\u01af\u01b0\7!\2\2\u01b0\u01b1\5\32\16"+
		"\2\u01b1\u01b2\7\"\2\2\u01b2\u01b3\b!\1\2\u01b3\u01ba\3\2\2\2\u01b4\u01b5"+
		"\7\6\2\2\u01b5\u01b6\5\32\16\2\u01b6\u01b7\7\7\2\2\u01b7\u01b8\b!\1\2"+
		"\u01b8\u01ba\3\2\2\2\u01b9\u019c\3\2\2\2\u01b9\u019e\3\2\2\2\u01b9\u019f"+
		"\3\2\2\2\u01b9\u01a5\3\2\2\2\u01b9\u01aa\3\2\2\2\u01b9\u01ab\3\2\2\2\u01b9"+
		"\u01ac\3\2\2\2\u01b9\u01ad\3\2\2\2\u01b9\u01ae\3\2\2\2\u01b9\u01b4\3\2"+
		"\2\2\u01baA\3\2\2\2\u01bb\u01c3\7\t\2\2\u01bc\u01c3\7)\2\2\u01bd\u01c3"+
		"\7*\2\2\u01be\u01bf\7\t\2\2\u01bf\u01c0\7!\2\2\u01c0\u01c3\7\"\2\2\u01c1"+
		"\u01c3\7.\2\2\u01c2\u01bb\3\2\2\2\u01c2\u01bc\3\2\2\2\u01c2\u01bd\3\2"+
		"\2\2\u01c2\u01be\3\2\2\2\u01c2\u01c1\3\2\2\2\u01c3C\3\2\2\2\37Lnv~\u009f"+
		"\u00a4\u00af\u00bd\u00c5\u00da\u00fb\u0109\u0117\u0121\u0129\u0133\u013b"+
		"\u0145\u014d\u0157\u015f\u0166\u016c\u0179\u0190\u0196\u019a\u01b9\u01c2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}