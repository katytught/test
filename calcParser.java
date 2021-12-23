// Generated from .\calc.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class calcParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, FuncType=17, 
		FFuncType=18, Orfunc=19, Andfunc=20, Comfunc=21, Judgefunc=22, Idigit=23, 
		Nondigit=24, Addfunc=25, Mulfunc=26, Number=27, Decimalconst=28, Octalconst=29, 
		Hexadecimalconst=30, Hexadecimalprefix=31, Nonzerodigit=32, Octaldigit=33, 
		Digit=34, Hexadecimaldigit=35, WHITE_SPACE=36;
	public static final int
		RULE_compUnit = 0, RULE_funcDef = 1, RULE_funcfParams = 2, RULE_funcfParam = 3, 
		RULE_decl = 4, RULE_constDecl = 5, RULE_constDef = 6, RULE_constInitVal = 7, 
		RULE_constExp = 8, RULE_varDecl = 9, RULE_varDef = 10, RULE_initVal = 11, 
		RULE_block = 12, RULE_blockItem = 13, RULE_stmt = 14, RULE_cond = 15, 
		RULE_lorexp = 16, RULE_landexp = 17, RULE_eqexp = 18, RULE_relexp = 19, 
		RULE_exp = 20, RULE_lval = 21, RULE_primaryexp = 22, RULE_addexp = 23, 
		RULE_mulexp = 24, RULE_unaryexp = 25, RULE_funcrParams = 26;
	private static String[] makeRuleNames() {
		return new String[] {
			"compUnit", "funcDef", "funcfParams", "funcfParam", "decl", "constDecl", 
			"constDef", "constInitVal", "constExp", "varDecl", "varDef", "initVal", 
			"block", "blockItem", "stmt", "cond", "lorexp", "landexp", "eqexp", "relexp", 
			"exp", "lval", "primaryexp", "addexp", "mulexp", "unaryexp", "funcrParams"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "')'", "','", "'['", "']'", "'const'", "';'", "'='", "'{'", 
			"'}'", "'if'", "'else'", "'while'", "'break'", "'continue'", "'return'", 
			"'int'", "'void'", "'||'", "'&&'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, "FuncType", "FFuncType", "Orfunc", "Andfunc", 
			"Comfunc", "Judgefunc", "Idigit", "Nondigit", "Addfunc", "Mulfunc", "Number", 
			"Decimalconst", "Octalconst", "Hexadecimalconst", "Hexadecimalprefix", 
			"Nonzerodigit", "Octaldigit", "Digit", "Hexadecimaldigit", "WHITE_SPACE"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
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
	public String getGrammarFileName() { return "calc.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public calcParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class CompUnitContext extends ParserRuleContext {
		public List<DeclContext> decl() {
			return getRuleContexts(DeclContext.class);
		}
		public DeclContext decl(int i) {
			return getRuleContext(DeclContext.class,i);
		}
		public List<FuncDefContext> funcDef() {
			return getRuleContexts(FuncDefContext.class);
		}
		public FuncDefContext funcDef(int i) {
			return getRuleContext(FuncDefContext.class,i);
		}
		public CompUnitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compUnit; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calcVisitor ) return ((calcVisitor<? extends T>)visitor).visitCompUnit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CompUnitContext compUnit() throws RecognitionException {
		CompUnitContext _localctx = new CompUnitContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_compUnit);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(56);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				{
				setState(54);
				decl();
				}
				break;
			case 2:
				{
				setState(55);
				funcDef();
				}
				break;
			}
			setState(62);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__5) | (1L << FuncType) | (1L << FFuncType))) != 0)) {
				{
				setState(60);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
				case 1:
					{
					setState(58);
					decl();
					}
					break;
				case 2:
					{
					setState(59);
					funcDef();
					}
					break;
				}
				}
				setState(64);
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

	public static class FuncDefContext extends ParserRuleContext {
		public TerminalNode Idigit() { return getToken(calcParser.Idigit, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TerminalNode FuncType() { return getToken(calcParser.FuncType, 0); }
		public TerminalNode FFuncType() { return getToken(calcParser.FFuncType, 0); }
		public FuncfParamsContext funcfParams() {
			return getRuleContext(FuncfParamsContext.class,0);
		}
		public FuncDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcDef; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calcVisitor ) return ((calcVisitor<? extends T>)visitor).visitFuncDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FuncDefContext funcDef() throws RecognitionException {
		FuncDefContext _localctx = new FuncDefContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_funcDef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(65);
			_la = _input.LA(1);
			if ( !(_la==FuncType || _la==FFuncType) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(66);
			match(Idigit);
			setState(67);
			match(T__0);
			setState(69);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==FuncType) {
				{
				setState(68);
				funcfParams();
				}
			}

			setState(71);
			match(T__1);
			setState(72);
			block();
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

	public static class FuncfParamsContext extends ParserRuleContext {
		public List<FuncfParamContext> funcfParam() {
			return getRuleContexts(FuncfParamContext.class);
		}
		public FuncfParamContext funcfParam(int i) {
			return getRuleContext(FuncfParamContext.class,i);
		}
		public FuncfParamsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcfParams; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calcVisitor ) return ((calcVisitor<? extends T>)visitor).visitFuncfParams(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FuncfParamsContext funcfParams() throws RecognitionException {
		FuncfParamsContext _localctx = new FuncfParamsContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_funcfParams);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(74);
			funcfParam();
			setState(79);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(75);
				match(T__2);
				setState(76);
				funcfParam();
				}
				}
				setState(81);
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

	public static class FuncfParamContext extends ParserRuleContext {
		public TerminalNode FuncType() { return getToken(calcParser.FuncType, 0); }
		public TerminalNode Idigit() { return getToken(calcParser.Idigit, 0); }
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public FuncfParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcfParam; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calcVisitor ) return ((calcVisitor<? extends T>)visitor).visitFuncfParam(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FuncfParamContext funcfParam() throws RecognitionException {
		FuncfParamContext _localctx = new FuncfParamContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_funcfParam);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(82);
			match(FuncType);
			setState(83);
			match(Idigit);
			setState(95);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__3) {
				{
				setState(84);
				match(T__3);
				setState(85);
				match(T__4);
				setState(92);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__3) {
					{
					{
					setState(86);
					match(T__3);
					setState(87);
					exp();
					setState(88);
					match(T__4);
					}
					}
					setState(94);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
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

	public static class DeclContext extends ParserRuleContext {
		public ConstDeclContext constDecl() {
			return getRuleContext(ConstDeclContext.class,0);
		}
		public VarDeclContext varDecl() {
			return getRuleContext(VarDeclContext.class,0);
		}
		public DeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decl; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calcVisitor ) return ((calcVisitor<? extends T>)visitor).visitDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclContext decl() throws RecognitionException {
		DeclContext _localctx = new DeclContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_decl);
		try {
			setState(99);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__5:
				enterOuterAlt(_localctx, 1);
				{
				setState(97);
				constDecl();
				}
				break;
			case FuncType:
				enterOuterAlt(_localctx, 2);
				{
				setState(98);
				varDecl();
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

	public static class ConstDeclContext extends ParserRuleContext {
		public TerminalNode FuncType() { return getToken(calcParser.FuncType, 0); }
		public List<ConstDefContext> constDef() {
			return getRuleContexts(ConstDefContext.class);
		}
		public ConstDefContext constDef(int i) {
			return getRuleContext(ConstDefContext.class,i);
		}
		public ConstDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constDecl; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calcVisitor ) return ((calcVisitor<? extends T>)visitor).visitConstDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstDeclContext constDecl() throws RecognitionException {
		ConstDeclContext _localctx = new ConstDeclContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_constDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(101);
			match(T__5);
			setState(102);
			match(FuncType);
			setState(103);
			constDef();
			setState(108);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(104);
				match(T__2);
				setState(105);
				constDef();
				}
				}
				setState(110);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(111);
			match(T__6);
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

	public static class ConstDefContext extends ParserRuleContext {
		public TerminalNode Idigit() { return getToken(calcParser.Idigit, 0); }
		public ConstInitValContext constInitVal() {
			return getRuleContext(ConstInitValContext.class,0);
		}
		public List<ConstExpContext> constExp() {
			return getRuleContexts(ConstExpContext.class);
		}
		public ConstExpContext constExp(int i) {
			return getRuleContext(ConstExpContext.class,i);
		}
		public ConstDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constDef; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calcVisitor ) return ((calcVisitor<? extends T>)visitor).visitConstDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstDefContext constDef() throws RecognitionException {
		ConstDefContext _localctx = new ConstDefContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_constDef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(113);
			match(Idigit);
			setState(120);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__3) {
				{
				{
				setState(114);
				match(T__3);
				setState(115);
				constExp();
				setState(116);
				match(T__4);
				}
				}
				setState(122);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(123);
			match(T__7);
			setState(124);
			constInitVal();
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

	public static class ConstInitValContext extends ParserRuleContext {
		public ConstExpContext constExp() {
			return getRuleContext(ConstExpContext.class,0);
		}
		public List<ConstInitValContext> constInitVal() {
			return getRuleContexts(ConstInitValContext.class);
		}
		public ConstInitValContext constInitVal(int i) {
			return getRuleContext(ConstInitValContext.class,i);
		}
		public ConstInitValContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constInitVal; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calcVisitor ) return (T) ((calcVisitor<? extends T>)visitor).visitConstInitVal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstInitValContext constInitVal() throws RecognitionException {
		ConstInitValContext _localctx = new ConstInitValContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_constInitVal);
		int _la;
		try {
			setState(139);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
			case Idigit:
			case Addfunc:
			case Number:
				enterOuterAlt(_localctx, 1);
				{
				setState(126);
				constExp();
				}
				break;
			case T__8:
				enterOuterAlt(_localctx, 2);
				{
				setState(127);
				match(T__8);
				setState(136);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__8) | (1L << Idigit) | (1L << Addfunc) | (1L << Number))) != 0)) {
					{
					setState(128);
					constInitVal();
					setState(133);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__2) {
						{
						{
						setState(129);
						match(T__2);
						setState(130);
						constInitVal();
						}
						}
						setState(135);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(138);
				match(T__9);
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

	public static class ConstExpContext extends ParserRuleContext {
		public AddexpContext addexp() {
			return getRuleContext(AddexpContext.class,0);
		}
		public ConstExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constExp; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calcVisitor ) return (T) ((calcVisitor<? extends T>)visitor).visitConstExp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstExpContext constExp() throws RecognitionException {
		ConstExpContext _localctx = new ConstExpContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_constExp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(141);
			addexp(0);
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

	public static class VarDeclContext extends ParserRuleContext {
		public TerminalNode FuncType() { return getToken(calcParser.FuncType, 0); }
		public List<VarDefContext> varDef() {
			return getRuleContexts(VarDefContext.class);
		}
		public VarDefContext varDef(int i) {
			return getRuleContext(VarDefContext.class,i);
		}
		public VarDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDecl; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calcVisitor ) return ((calcVisitor<? extends T>)visitor).visitVarDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarDeclContext varDecl() throws RecognitionException {
		VarDeclContext _localctx = new VarDeclContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_varDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(143);
			match(FuncType);
			setState(144);
			varDef();
			setState(149);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(145);
				match(T__2);
				setState(146);
				varDef();
				}
				}
				setState(151);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(152);
			match(T__6);
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

	public static class VarDefContext extends ParserRuleContext {
		public TerminalNode Idigit() { return getToken(calcParser.Idigit, 0); }
		public List<ConstExpContext> constExp() {
			return getRuleContexts(ConstExpContext.class);
		}
		public ConstExpContext constExp(int i) {
			return getRuleContext(ConstExpContext.class,i);
		}
		public InitValContext initVal() {
			return getRuleContext(InitValContext.class,0);
		}
		public VarDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDef; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calcVisitor ) return ((calcVisitor<? extends T>)visitor).visitVarDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarDefContext varDef() throws RecognitionException {
		VarDefContext _localctx = new VarDefContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_varDef);
		int _la;
		try {
			setState(176);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(154);
				match(Idigit);
				setState(161);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__3) {
					{
					{
					setState(155);
					match(T__3);
					setState(156);
					constExp();
					setState(157);
					match(T__4);
					}
					}
					setState(163);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(164);
				match(Idigit);
				setState(171);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__3) {
					{
					{
					setState(165);
					match(T__3);
					setState(166);
					constExp();
					setState(167);
					match(T__4);
					}
					}
					setState(173);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(174);
				match(T__7);
				setState(175);
				initVal();
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

	public static class InitValContext extends ParserRuleContext {
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public List<InitValContext> initVal() {
			return getRuleContexts(InitValContext.class);
		}
		public InitValContext initVal(int i) {
			return getRuleContext(InitValContext.class,i);
		}
		public InitValContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_initVal; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calcVisitor ) return (T) ((calcVisitor<? extends T>)visitor).visitInitVal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InitValContext initVal() throws RecognitionException {
		InitValContext _localctx = new InitValContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_initVal);
		int _la;
		try {
			setState(191);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
			case Idigit:
			case Addfunc:
			case Number:
				enterOuterAlt(_localctx, 1);
				{
				setState(178);
				exp();
				}
				break;
			case T__8:
				enterOuterAlt(_localctx, 2);
				{
				setState(179);
				match(T__8);
				setState(188);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__8) | (1L << Idigit) | (1L << Addfunc) | (1L << Number))) != 0)) {
					{
					setState(180);
					initVal();
					setState(185);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__2) {
						{
						{
						setState(181);
						match(T__2);
						setState(182);
						initVal();
						}
						}
						setState(187);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(190);
				match(T__9);
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

	public static class BlockContext extends ParserRuleContext {
		public List<BlockItemContext> blockItem() {
			return getRuleContexts(BlockItemContext.class);
		}
		public BlockItemContext blockItem(int i) {
			return getRuleContext(BlockItemContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calcVisitor ) return ((calcVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(193);
			match(T__8);
			setState(197);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__5) | (1L << T__6) | (1L << T__8) | (1L << T__10) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << FuncType) | (1L << Idigit) | (1L << Addfunc) | (1L << Number))) != 0)) {
				{
				{
				setState(194);
				blockItem();
				}
				}
				setState(199);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(200);
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

	public static class BlockItemContext extends ParserRuleContext {
		public DeclContext decl() {
			return getRuleContext(DeclContext.class,0);
		}
		public StmtContext stmt() {
			return getRuleContext(StmtContext.class,0);
		}
		public BlockItemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_blockItem; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calcVisitor ) return ((calcVisitor<? extends T>)visitor).visitBlockItem(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockItemContext blockItem() throws RecognitionException {
		BlockItemContext _localctx = new BlockItemContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_blockItem);
		try {
			setState(204);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__5:
			case FuncType:
				enterOuterAlt(_localctx, 1);
				{
				setState(202);
				decl();
				}
				break;
			case T__0:
			case T__6:
			case T__8:
			case T__10:
			case T__12:
			case T__13:
			case T__14:
			case T__15:
			case Idigit:
			case Addfunc:
			case Number:
				enterOuterAlt(_localctx, 2);
				{
				setState(203);
				stmt();
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

	public static class StmtContext extends ParserRuleContext {
		public LvalContext lval() {
			return getRuleContext(LvalContext.class,0);
		}
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public CondContext cond() {
			return getRuleContext(CondContext.class,0);
		}
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public StmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmt; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calcVisitor ) return ((calcVisitor<? extends T>)visitor).visitStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StmtContext stmt() throws RecognitionException {
		StmtContext _localctx = new StmtContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_stmt);
		int _la;
		try {
			setState(240);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(206);
				lval();
				setState(207);
				match(T__7);
				setState(208);
				exp();
				setState(209);
				match(T__6);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(211);
				block();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(213);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << Idigit) | (1L << Addfunc) | (1L << Number))) != 0)) {
					{
					setState(212);
					exp();
					}
				}

				setState(215);
				match(T__6);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(216);
				match(T__10);
				setState(217);
				match(T__0);
				setState(218);
				cond();
				setState(219);
				match(T__1);
				setState(220);
				stmt();
				setState(223);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
				case 1:
					{
					setState(221);
					match(T__11);
					setState(222);
					stmt();
					}
					break;
				}
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(225);
				match(T__12);
				setState(226);
				match(T__0);
				setState(227);
				cond();
				setState(228);
				match(T__1);
				setState(229);
				stmt();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(231);
				match(T__13);
				setState(232);
				match(T__6);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(233);
				match(T__14);
				setState(234);
				match(T__6);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(235);
				match(T__15);
				setState(237);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << Idigit) | (1L << Addfunc) | (1L << Number))) != 0)) {
					{
					setState(236);
					exp();
					}
				}

				setState(239);
				match(T__6);
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

	public static class CondContext extends ParserRuleContext {
		public LorexpContext lorexp() {
			return getRuleContext(LorexpContext.class,0);
		}
		public CondContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cond; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calcVisitor ) return (T) ((calcVisitor<? extends T>)visitor).visitCond(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CondContext cond() throws RecognitionException {
		CondContext _localctx = new CondContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_cond);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(242);
			lorexp(0);
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

	public static class LorexpContext extends ParserRuleContext {
		public LandexpContext landexp() {
			return getRuleContext(LandexpContext.class,0);
		}
		public LorexpContext lorexp() {
			return getRuleContext(LorexpContext.class,0);
		}
		public TerminalNode Orfunc() { return getToken(calcParser.Orfunc, 0); }
		public LorexpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lorexp; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calcVisitor ) return (T) ((calcVisitor<? extends T>)visitor).visitLorexp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LorexpContext lorexp() throws RecognitionException {
		return lorexp(0);
	}

	private LorexpContext lorexp(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		LorexpContext _localctx = new LorexpContext(_ctx, _parentState);
		LorexpContext _prevctx = _localctx;
		int _startState = 32;
		enterRecursionRule(_localctx, 32, RULE_lorexp, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(245);
			landexp(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(252);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new LorexpContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_lorexp);
					setState(247);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(248);
					match(Orfunc);
					setState(249);
					landexp(0);
					}
					} 
				}
				setState(254);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class LandexpContext extends ParserRuleContext {
		public EqexpContext eqexp() {
			return getRuleContext(EqexpContext.class,0);
		}
		public LandexpContext landexp() {
			return getRuleContext(LandexpContext.class,0);
		}
		public TerminalNode Andfunc() { return getToken(calcParser.Andfunc, 0); }
		public LandexpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_landexp; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calcVisitor ) return (T) ((calcVisitor<? extends T>)visitor).visitLandexp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LandexpContext landexp() throws RecognitionException {
		return landexp(0);
	}

	private LandexpContext landexp(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		LandexpContext _localctx = new LandexpContext(_ctx, _parentState);
		LandexpContext _prevctx = _localctx;
		int _startState = 34;
		enterRecursionRule(_localctx, 34, RULE_landexp, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(256);
			eqexp(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(263);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new LandexpContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_landexp);
					setState(258);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(259);
					match(Andfunc);
					setState(260);
					eqexp(0);
					}
					} 
				}
				setState(265);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class EqexpContext extends ParserRuleContext {
		public RelexpContext relexp() {
			return getRuleContext(RelexpContext.class,0);
		}
		public EqexpContext eqexp() {
			return getRuleContext(EqexpContext.class,0);
		}
		public TerminalNode Judgefunc() { return getToken(calcParser.Judgefunc, 0); }
		public EqexpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_eqexp; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calcVisitor ) return (T) ((calcVisitor<? extends T>)visitor).visitEqexp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EqexpContext eqexp() throws RecognitionException {
		return eqexp(0);
	}

	private EqexpContext eqexp(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		EqexpContext _localctx = new EqexpContext(_ctx, _parentState);
		EqexpContext _prevctx = _localctx;
		int _startState = 36;
		enterRecursionRule(_localctx, 36, RULE_eqexp, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(267);
			relexp(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(274);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new EqexpContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_eqexp);
					setState(269);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(270);
					match(Judgefunc);
					setState(271);
					relexp(0);
					}
					} 
				}
				setState(276);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class RelexpContext extends ParserRuleContext {
		public AddexpContext addexp() {
			return getRuleContext(AddexpContext.class,0);
		}
		public RelexpContext relexp() {
			return getRuleContext(RelexpContext.class,0);
		}
		public TerminalNode Comfunc() { return getToken(calcParser.Comfunc, 0); }
		public RelexpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relexp; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calcVisitor ) return (T) ((calcVisitor<? extends T>)visitor).visitRelexp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RelexpContext relexp() throws RecognitionException {
		return relexp(0);
	}

	private RelexpContext relexp(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		RelexpContext _localctx = new RelexpContext(_ctx, _parentState);
		RelexpContext _prevctx = _localctx;
		int _startState = 38;
		enterRecursionRule(_localctx, 38, RULE_relexp, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(278);
			addexp(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(285);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new RelexpContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_relexp);
					setState(280);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(281);
					match(Comfunc);
					setState(282);
					addexp(0);
					}
					} 
				}
				setState(287);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class ExpContext extends ParserRuleContext {
		public AddexpContext addexp() {
			return getRuleContext(AddexpContext.class,0);
		}
		public ExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exp; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calcVisitor ) return (T) ((calcVisitor<? extends T>)visitor).visitExp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpContext exp() throws RecognitionException {
		ExpContext _localctx = new ExpContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_exp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(288);
			addexp(0);
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

	public static class LvalContext extends ParserRuleContext {
		public TerminalNode Idigit() { return getToken(calcParser.Idigit, 0); }
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public LvalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lval; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calcVisitor ) return (T) ((calcVisitor<? extends T>)visitor).visitLval(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LvalContext lval() throws RecognitionException {
		LvalContext _localctx = new LvalContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_lval);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(290);
			match(Idigit);
			setState(297);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,30,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(291);
					match(T__3);
					setState(292);
					exp();
					setState(293);
					match(T__4);
					}
					} 
				}
				setState(299);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,30,_ctx);
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

	public static class PrimaryexpContext extends ParserRuleContext {
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public LvalContext lval() {
			return getRuleContext(LvalContext.class,0);
		}
		public TerminalNode Number() { return getToken(calcParser.Number, 0); }
		public PrimaryexpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primaryexp; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calcVisitor ) return (T) ((calcVisitor<? extends T>)visitor).visitPrimaryexp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrimaryexpContext primaryexp() throws RecognitionException {
		PrimaryexpContext _localctx = new PrimaryexpContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_primaryexp);
		try {
			setState(306);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
				enterOuterAlt(_localctx, 1);
				{
				setState(300);
				match(T__0);
				setState(301);
				exp();
				setState(302);
				match(T__1);
				}
				break;
			case Idigit:
				enterOuterAlt(_localctx, 2);
				{
				setState(304);
				lval();
				}
				break;
			case Number:
				enterOuterAlt(_localctx, 3);
				{
				setState(305);
				match(Number);
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

	public static class AddexpContext extends ParserRuleContext {
		public MulexpContext mulexp() {
			return getRuleContext(MulexpContext.class,0);
		}
		public AddexpContext addexp() {
			return getRuleContext(AddexpContext.class,0);
		}
		public TerminalNode Addfunc() { return getToken(calcParser.Addfunc, 0); }
		public AddexpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_addexp; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calcVisitor ) return (T) ((calcVisitor<? extends T>)visitor).visitAddexp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AddexpContext addexp() throws RecognitionException {
		return addexp(0);
	}

	private AddexpContext addexp(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		AddexpContext _localctx = new AddexpContext(_ctx, _parentState);
		AddexpContext _prevctx = _localctx;
		int _startState = 46;
		enterRecursionRule(_localctx, 46, RULE_addexp, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(309);
			mulexp(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(316);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,32,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new AddexpContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_addexp);
					setState(311);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(312);
					match(Addfunc);
					setState(313);
					mulexp(0);
					}
					} 
				}
				setState(318);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,32,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class MulexpContext extends ParserRuleContext {
		public UnaryexpContext unaryexp() {
			return getRuleContext(UnaryexpContext.class,0);
		}
		public MulexpContext mulexp() {
			return getRuleContext(MulexpContext.class,0);
		}
		public TerminalNode Mulfunc() { return getToken(calcParser.Mulfunc, 0); }
		public MulexpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mulexp; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calcVisitor ) return (T) ((calcVisitor<? extends T>)visitor).visitMulexp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MulexpContext mulexp() throws RecognitionException {
		return mulexp(0);
	}

	private MulexpContext mulexp(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		MulexpContext _localctx = new MulexpContext(_ctx, _parentState);
		MulexpContext _prevctx = _localctx;
		int _startState = 48;
		enterRecursionRule(_localctx, 48, RULE_mulexp, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(320);
			unaryexp();
			}
			_ctx.stop = _input.LT(-1);
			setState(327);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,33,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new MulexpContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_mulexp);
					setState(322);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(323);
					match(Mulfunc);
					setState(324);
					unaryexp();
					}
					} 
				}
				setState(329);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,33,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class UnaryexpContext extends ParserRuleContext {
		public PrimaryexpContext primaryexp() {
			return getRuleContext(PrimaryexpContext.class,0);
		}
		public TerminalNode Idigit() { return getToken(calcParser.Idigit, 0); }
		public FuncrParamsContext funcrParams() {
			return getRuleContext(FuncrParamsContext.class,0);
		}
		public TerminalNode Addfunc() { return getToken(calcParser.Addfunc, 0); }
		public UnaryexpContext unaryexp() {
			return getRuleContext(UnaryexpContext.class,0);
		}
		public UnaryexpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unaryexp; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calcVisitor ) return (T) ((calcVisitor<? extends T>)visitor).visitUnaryexp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnaryexpContext unaryexp() throws RecognitionException {
		UnaryexpContext _localctx = new UnaryexpContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_unaryexp);
		int _la;
		try {
			setState(339);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,35,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(330);
				primaryexp();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(331);
				match(Idigit);
				setState(332);
				match(T__0);
				setState(334);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << Idigit) | (1L << Addfunc) | (1L << Number))) != 0)) {
					{
					setState(333);
					funcrParams();
					}
				}

				setState(336);
				match(T__1);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(337);
				match(Addfunc);
				setState(338);
				unaryexp();
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

	public static class FuncrParamsContext extends ParserRuleContext {
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public FuncrParamsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcrParams; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calcVisitor ) return (T) ((calcVisitor<? extends T>)visitor).visitFuncrParams(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FuncrParamsContext funcrParams() throws RecognitionException {
		FuncrParamsContext _localctx = new FuncrParamsContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_funcrParams);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(341);
			exp();
			setState(346);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(342);
				match(T__2);
				setState(343);
				exp();
				}
				}
				setState(348);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 16:
			return lorexp_sempred((LorexpContext)_localctx, predIndex);
		case 17:
			return landexp_sempred((LandexpContext)_localctx, predIndex);
		case 18:
			return eqexp_sempred((EqexpContext)_localctx, predIndex);
		case 19:
			return relexp_sempred((RelexpContext)_localctx, predIndex);
		case 23:
			return addexp_sempred((AddexpContext)_localctx, predIndex);
		case 24:
			return mulexp_sempred((MulexpContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean lorexp_sempred(LorexpContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean landexp_sempred(LandexpContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean eqexp_sempred(EqexpContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean relexp_sempred(RelexpContext _localctx, int predIndex) {
		switch (predIndex) {
		case 3:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean addexp_sempred(AddexpContext _localctx, int predIndex) {
		switch (predIndex) {
		case 4:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean mulexp_sempred(MulexpContext _localctx, int predIndex) {
		switch (predIndex) {
		case 5:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3&\u0160\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\3\2\3\2\5\2;\n\2\3\2\3\2\7\2?\n\2\f\2\16"+
		"\2B\13\2\3\3\3\3\3\3\3\3\5\3H\n\3\3\3\3\3\3\3\3\4\3\4\3\4\7\4P\n\4\f\4"+
		"\16\4S\13\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\7\5]\n\5\f\5\16\5`\13\5\5"+
		"\5b\n\5\3\6\3\6\5\6f\n\6\3\7\3\7\3\7\3\7\3\7\7\7m\n\7\f\7\16\7p\13\7\3"+
		"\7\3\7\3\b\3\b\3\b\3\b\3\b\7\by\n\b\f\b\16\b|\13\b\3\b\3\b\3\b\3\t\3\t"+
		"\3\t\3\t\3\t\7\t\u0086\n\t\f\t\16\t\u0089\13\t\5\t\u008b\n\t\3\t\5\t\u008e"+
		"\n\t\3\n\3\n\3\13\3\13\3\13\3\13\7\13\u0096\n\13\f\13\16\13\u0099\13\13"+
		"\3\13\3\13\3\f\3\f\3\f\3\f\3\f\7\f\u00a2\n\f\f\f\16\f\u00a5\13\f\3\f\3"+
		"\f\3\f\3\f\3\f\7\f\u00ac\n\f\f\f\16\f\u00af\13\f\3\f\3\f\5\f\u00b3\n\f"+
		"\3\r\3\r\3\r\3\r\3\r\7\r\u00ba\n\r\f\r\16\r\u00bd\13\r\5\r\u00bf\n\r\3"+
		"\r\5\r\u00c2\n\r\3\16\3\16\7\16\u00c6\n\16\f\16\16\16\u00c9\13\16\3\16"+
		"\3\16\3\17\3\17\5\17\u00cf\n\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\5\20"+
		"\u00d8\n\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\5\20\u00e2\n\20\3"+
		"\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\5\20\u00f0"+
		"\n\20\3\20\5\20\u00f3\n\20\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\7\22"+
		"\u00fd\n\22\f\22\16\22\u0100\13\22\3\23\3\23\3\23\3\23\3\23\3\23\7\23"+
		"\u0108\n\23\f\23\16\23\u010b\13\23\3\24\3\24\3\24\3\24\3\24\3\24\7\24"+
		"\u0113\n\24\f\24\16\24\u0116\13\24\3\25\3\25\3\25\3\25\3\25\3\25\7\25"+
		"\u011e\n\25\f\25\16\25\u0121\13\25\3\26\3\26\3\27\3\27\3\27\3\27\3\27"+
		"\7\27\u012a\n\27\f\27\16\27\u012d\13\27\3\30\3\30\3\30\3\30\3\30\3\30"+
		"\5\30\u0135\n\30\3\31\3\31\3\31\3\31\3\31\3\31\7\31\u013d\n\31\f\31\16"+
		"\31\u0140\13\31\3\32\3\32\3\32\3\32\3\32\3\32\7\32\u0148\n\32\f\32\16"+
		"\32\u014b\13\32\3\33\3\33\3\33\3\33\5\33\u0151\n\33\3\33\3\33\3\33\5\33"+
		"\u0156\n\33\3\34\3\34\3\34\7\34\u015b\n\34\f\34\16\34\u015e\13\34\3\34"+
		"\2\b\"$&(\60\62\35\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60"+
		"\62\64\66\2\3\3\2\23\24\2\u0171\2:\3\2\2\2\4C\3\2\2\2\6L\3\2\2\2\bT\3"+
		"\2\2\2\ne\3\2\2\2\fg\3\2\2\2\16s\3\2\2\2\20\u008d\3\2\2\2\22\u008f\3\2"+
		"\2\2\24\u0091\3\2\2\2\26\u00b2\3\2\2\2\30\u00c1\3\2\2\2\32\u00c3\3\2\2"+
		"\2\34\u00ce\3\2\2\2\36\u00f2\3\2\2\2 \u00f4\3\2\2\2\"\u00f6\3\2\2\2$\u0101"+
		"\3\2\2\2&\u010c\3\2\2\2(\u0117\3\2\2\2*\u0122\3\2\2\2,\u0124\3\2\2\2."+
		"\u0134\3\2\2\2\60\u0136\3\2\2\2\62\u0141\3\2\2\2\64\u0155\3\2\2\2\66\u0157"+
		"\3\2\2\28;\5\n\6\29;\5\4\3\2:8\3\2\2\2:9\3\2\2\2;@\3\2\2\2<?\5\n\6\2="+
		"?\5\4\3\2><\3\2\2\2>=\3\2\2\2?B\3\2\2\2@>\3\2\2\2@A\3\2\2\2A\3\3\2\2\2"+
		"B@\3\2\2\2CD\t\2\2\2DE\7\31\2\2EG\7\3\2\2FH\5\6\4\2GF\3\2\2\2GH\3\2\2"+
		"\2HI\3\2\2\2IJ\7\4\2\2JK\5\32\16\2K\5\3\2\2\2LQ\5\b\5\2MN\7\5\2\2NP\5"+
		"\b\5\2OM\3\2\2\2PS\3\2\2\2QO\3\2\2\2QR\3\2\2\2R\7\3\2\2\2SQ\3\2\2\2TU"+
		"\7\23\2\2Ua\7\31\2\2VW\7\6\2\2W^\7\7\2\2XY\7\6\2\2YZ\5*\26\2Z[\7\7\2\2"+
		"[]\3\2\2\2\\X\3\2\2\2]`\3\2\2\2^\\\3\2\2\2^_\3\2\2\2_b\3\2\2\2`^\3\2\2"+
		"\2aV\3\2\2\2ab\3\2\2\2b\t\3\2\2\2cf\5\f\7\2df\5\24\13\2ec\3\2\2\2ed\3"+
		"\2\2\2f\13\3\2\2\2gh\7\b\2\2hi\7\23\2\2in\5\16\b\2jk\7\5\2\2km\5\16\b"+
		"\2lj\3\2\2\2mp\3\2\2\2nl\3\2\2\2no\3\2\2\2oq\3\2\2\2pn\3\2\2\2qr\7\t\2"+
		"\2r\r\3\2\2\2sz\7\31\2\2tu\7\6\2\2uv\5\22\n\2vw\7\7\2\2wy\3\2\2\2xt\3"+
		"\2\2\2y|\3\2\2\2zx\3\2\2\2z{\3\2\2\2{}\3\2\2\2|z\3\2\2\2}~\7\n\2\2~\177"+
		"\5\20\t\2\177\17\3\2\2\2\u0080\u008e\5\22\n\2\u0081\u008a\7\13\2\2\u0082"+
		"\u0087\5\20\t\2\u0083\u0084\7\5\2\2\u0084\u0086\5\20\t\2\u0085\u0083\3"+
		"\2\2\2\u0086\u0089\3\2\2\2\u0087\u0085\3\2\2\2\u0087\u0088\3\2\2\2\u0088"+
		"\u008b\3\2\2\2\u0089\u0087\3\2\2\2\u008a\u0082\3\2\2\2\u008a\u008b\3\2"+
		"\2\2\u008b\u008c\3\2\2\2\u008c\u008e\7\f\2\2\u008d\u0080\3\2\2\2\u008d"+
		"\u0081\3\2\2\2\u008e\21\3\2\2\2\u008f\u0090\5\60\31\2\u0090\23\3\2\2\2"+
		"\u0091\u0092\7\23\2\2\u0092\u0097\5\26\f\2\u0093\u0094\7\5\2\2\u0094\u0096"+
		"\5\26\f\2\u0095\u0093\3\2\2\2\u0096\u0099\3\2\2\2\u0097\u0095\3\2\2\2"+
		"\u0097\u0098\3\2\2\2\u0098\u009a\3\2\2\2\u0099\u0097\3\2\2\2\u009a\u009b"+
		"\7\t\2\2\u009b\25\3\2\2\2\u009c\u00a3\7\31\2\2\u009d\u009e\7\6\2\2\u009e"+
		"\u009f\5\22\n\2\u009f\u00a0\7\7\2\2\u00a0\u00a2\3\2\2\2\u00a1\u009d\3"+
		"\2\2\2\u00a2\u00a5\3\2\2\2\u00a3\u00a1\3\2\2\2\u00a3\u00a4\3\2\2\2\u00a4"+
		"\u00b3\3\2\2\2\u00a5\u00a3\3\2\2\2\u00a6\u00ad\7\31\2\2\u00a7\u00a8\7"+
		"\6\2\2\u00a8\u00a9\5\22\n\2\u00a9\u00aa\7\7\2\2\u00aa\u00ac\3\2\2\2\u00ab"+
		"\u00a7\3\2\2\2\u00ac\u00af\3\2\2\2\u00ad\u00ab\3\2\2\2\u00ad\u00ae\3\2"+
		"\2\2\u00ae\u00b0\3\2\2\2\u00af\u00ad\3\2\2\2\u00b0\u00b1\7\n\2\2\u00b1"+
		"\u00b3\5\30\r\2\u00b2\u009c\3\2\2\2\u00b2\u00a6\3\2\2\2\u00b3\27\3\2\2"+
		"\2\u00b4\u00c2\5*\26\2\u00b5\u00be\7\13\2\2\u00b6\u00bb\5\30\r\2\u00b7"+
		"\u00b8\7\5\2\2\u00b8\u00ba\5\30\r\2\u00b9\u00b7\3\2\2\2\u00ba\u00bd\3"+
		"\2\2\2\u00bb\u00b9\3\2\2\2\u00bb\u00bc\3\2\2\2\u00bc\u00bf\3\2\2\2\u00bd"+
		"\u00bb\3\2\2\2\u00be\u00b6\3\2\2\2\u00be\u00bf\3\2\2\2\u00bf\u00c0\3\2"+
		"\2\2\u00c0\u00c2\7\f\2\2\u00c1\u00b4\3\2\2\2\u00c1\u00b5\3\2\2\2\u00c2"+
		"\31\3\2\2\2\u00c3\u00c7\7\13\2\2\u00c4\u00c6\5\34\17\2\u00c5\u00c4\3\2"+
		"\2\2\u00c6\u00c9\3\2\2\2\u00c7\u00c5\3\2\2\2\u00c7\u00c8\3\2\2\2\u00c8"+
		"\u00ca\3\2\2\2\u00c9\u00c7\3\2\2\2\u00ca\u00cb\7\f\2\2\u00cb\33\3\2\2"+
		"\2\u00cc\u00cf\5\n\6\2\u00cd\u00cf\5\36\20\2\u00ce\u00cc\3\2\2\2\u00ce"+
		"\u00cd\3\2\2\2\u00cf\35\3\2\2\2\u00d0\u00d1\5,\27\2\u00d1\u00d2\7\n\2"+
		"\2\u00d2\u00d3\5*\26\2\u00d3\u00d4\7\t\2\2\u00d4\u00f3\3\2\2\2\u00d5\u00f3"+
		"\5\32\16\2\u00d6\u00d8\5*\26\2\u00d7\u00d6\3\2\2\2\u00d7\u00d8\3\2\2\2"+
		"\u00d8\u00d9\3\2\2\2\u00d9\u00f3\7\t\2\2\u00da\u00db\7\r\2\2\u00db\u00dc"+
		"\7\3\2\2\u00dc\u00dd\5 \21\2\u00dd\u00de\7\4\2\2\u00de\u00e1\5\36\20\2"+
		"\u00df\u00e0\7\16\2\2\u00e0\u00e2\5\36\20\2\u00e1\u00df\3\2\2\2\u00e1"+
		"\u00e2\3\2\2\2\u00e2\u00f3\3\2\2\2\u00e3\u00e4\7\17\2\2\u00e4\u00e5\7"+
		"\3\2\2\u00e5\u00e6\5 \21\2\u00e6\u00e7\7\4\2\2\u00e7\u00e8\5\36\20\2\u00e8"+
		"\u00f3\3\2\2\2\u00e9\u00ea\7\20\2\2\u00ea\u00f3\7\t\2\2\u00eb\u00ec\7"+
		"\21\2\2\u00ec\u00f3\7\t\2\2\u00ed\u00ef\7\22\2\2\u00ee\u00f0\5*\26\2\u00ef"+
		"\u00ee\3\2\2\2\u00ef\u00f0\3\2\2\2\u00f0\u00f1\3\2\2\2\u00f1\u00f3\7\t"+
		"\2\2\u00f2\u00d0\3\2\2\2\u00f2\u00d5\3\2\2\2\u00f2\u00d7\3\2\2\2\u00f2"+
		"\u00da\3\2\2\2\u00f2\u00e3\3\2\2\2\u00f2\u00e9\3\2\2\2\u00f2\u00eb\3\2"+
		"\2\2\u00f2\u00ed\3\2\2\2\u00f3\37\3\2\2\2\u00f4\u00f5\5\"\22\2\u00f5!"+
		"\3\2\2\2\u00f6\u00f7\b\22\1\2\u00f7\u00f8\5$\23\2\u00f8\u00fe\3\2\2\2"+
		"\u00f9\u00fa\f\3\2\2\u00fa\u00fb\7\25\2\2\u00fb\u00fd\5$\23\2\u00fc\u00f9"+
		"\3\2\2\2\u00fd\u0100\3\2\2\2\u00fe\u00fc\3\2\2\2\u00fe\u00ff\3\2\2\2\u00ff"+
		"#\3\2\2\2\u0100\u00fe\3\2\2\2\u0101\u0102\b\23\1\2\u0102\u0103\5&\24\2"+
		"\u0103\u0109\3\2\2\2\u0104\u0105\f\3\2\2\u0105\u0106\7\26\2\2\u0106\u0108"+
		"\5&\24\2\u0107\u0104\3\2\2\2\u0108\u010b\3\2\2\2\u0109\u0107\3\2\2\2\u0109"+
		"\u010a\3\2\2\2\u010a%\3\2\2\2\u010b\u0109\3\2\2\2\u010c\u010d\b\24\1\2"+
		"\u010d\u010e\5(\25\2\u010e\u0114\3\2\2\2\u010f\u0110\f\3\2\2\u0110\u0111"+
		"\7\30\2\2\u0111\u0113\5(\25\2\u0112\u010f\3\2\2\2\u0113\u0116\3\2\2\2"+
		"\u0114\u0112\3\2\2\2\u0114\u0115\3\2\2\2\u0115\'\3\2\2\2\u0116\u0114\3"+
		"\2\2\2\u0117\u0118\b\25\1\2\u0118\u0119\5\60\31\2\u0119\u011f\3\2\2\2"+
		"\u011a\u011b\f\3\2\2\u011b\u011c\7\27\2\2\u011c\u011e\5\60\31\2\u011d"+
		"\u011a\3\2\2\2\u011e\u0121\3\2\2\2\u011f\u011d\3\2\2\2\u011f\u0120\3\2"+
		"\2\2\u0120)\3\2\2\2\u0121\u011f\3\2\2\2\u0122\u0123\5\60\31\2\u0123+\3"+
		"\2\2\2\u0124\u012b\7\31\2\2\u0125\u0126\7\6\2\2\u0126\u0127\5*\26\2\u0127"+
		"\u0128\7\7\2\2\u0128\u012a\3\2\2\2\u0129\u0125\3\2\2\2\u012a\u012d\3\2"+
		"\2\2\u012b\u0129\3\2\2\2\u012b\u012c\3\2\2\2\u012c-\3\2\2\2\u012d\u012b"+
		"\3\2\2\2\u012e\u012f\7\3\2\2\u012f\u0130\5*\26\2\u0130\u0131\7\4\2\2\u0131"+
		"\u0135\3\2\2\2\u0132\u0135\5,\27\2\u0133\u0135\7\35\2\2\u0134\u012e\3"+
		"\2\2\2\u0134\u0132\3\2\2\2\u0134\u0133\3\2\2\2\u0135/\3\2\2\2\u0136\u0137"+
		"\b\31\1\2\u0137\u0138\5\62\32\2\u0138\u013e\3\2\2\2\u0139\u013a\f\3\2"+
		"\2\u013a\u013b\7\33\2\2\u013b\u013d\5\62\32\2\u013c\u0139\3\2\2\2\u013d"+
		"\u0140\3\2\2\2\u013e\u013c\3\2\2\2\u013e\u013f\3\2\2\2\u013f\61\3\2\2"+
		"\2\u0140\u013e\3\2\2\2\u0141\u0142\b\32\1\2\u0142\u0143\5\64\33\2\u0143"+
		"\u0149\3\2\2\2\u0144\u0145\f\3\2\2\u0145\u0146\7\34\2\2\u0146\u0148\5"+
		"\64\33\2\u0147\u0144\3\2\2\2\u0148\u014b\3\2\2\2\u0149\u0147\3\2\2\2\u0149"+
		"\u014a\3\2\2\2\u014a\63\3\2\2\2\u014b\u0149\3\2\2\2\u014c\u0156\5.\30"+
		"\2\u014d\u014e\7\31\2\2\u014e\u0150\7\3\2\2\u014f\u0151\5\66\34\2\u0150"+
		"\u014f\3\2\2\2\u0150\u0151\3\2\2\2\u0151\u0152\3\2\2\2\u0152\u0156\7\4"+
		"\2\2\u0153\u0154\7\33\2\2\u0154\u0156\5\64\33\2\u0155\u014c\3\2\2\2\u0155"+
		"\u014d\3\2\2\2\u0155\u0153\3\2\2\2\u0156\65\3\2\2\2\u0157\u015c\5*\26"+
		"\2\u0158\u0159\7\5\2\2\u0159\u015b\5*\26\2\u015a\u0158\3\2\2\2\u015b\u015e"+
		"\3\2\2\2\u015c\u015a\3\2\2\2\u015c\u015d\3\2\2\2\u015d\67\3\2\2\2\u015e"+
		"\u015c\3\2\2\2\':>@GQ^aenz\u0087\u008a\u008d\u0097\u00a3\u00ad\u00b2\u00bb"+
		"\u00be\u00c1\u00c7\u00ce\u00d7\u00e1\u00ef\u00f2\u00fe\u0109\u0114\u011f"+
		"\u012b\u0134\u013e\u0149\u0150\u0155\u015c";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}