// Generated from C:/Users/Glenn/Documents/Ecole/Ingénieur/Semestre 1/LangageProg/CcalcGit/CcalcBool/src/parser\Calc.g4 by ANTLR 4.8
package parser;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CalcLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, OP=7, BOOL=8, IDENTIFIER=9, 
		INTEGER=10, WS=11, LINE_COMMENT=12;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "OP", "BOOL", "IDENTIFIER", 
			"INTEGER", "WS", "LINE_COMMENT"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "'defun'", "')'", "'='", "'-'", "'if'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, "OP", "BOOL", "IDENTIFIER", 
			"INTEGER", "WS", "LINE_COMMENT"
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


	public CalcLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Calc.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\16`\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\5\3\5\3"+
		"\6\3\6\3\7\3\7\3\7\3\b\3\b\3\b\3\b\5\b\61\n\b\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\5\t<\n\t\3\n\3\n\7\n@\n\n\f\n\16\nC\13\n\3\13\3\13\3\13\7"+
		"\13H\n\13\f\13\16\13K\13\13\5\13M\n\13\3\f\6\fP\n\f\r\f\16\fQ\3\f\3\f"+
		"\3\r\3\r\3\r\3\r\7\rZ\n\r\f\r\16\r]\13\r\3\r\3\r\2\2\16\3\3\5\4\7\5\t"+
		"\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\3\2\6\4\2,-\61\61\4\2\62;"+
		"c|\5\2\13\f\17\17\"\"\3\2\f\f\2g\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2"+
		"\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2"+
		"\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\3\33\3\2\2\2\5\35\3\2\2\2"+
		"\7#\3\2\2\2\t%\3\2\2\2\13\'\3\2\2\2\r)\3\2\2\2\17\60\3\2\2\2\21;\3\2\2"+
		"\2\23=\3\2\2\2\25L\3\2\2\2\27O\3\2\2\2\31U\3\2\2\2\33\34\7*\2\2\34\4\3"+
		"\2\2\2\35\36\7f\2\2\36\37\7g\2\2\37 \7h\2\2 !\7w\2\2!\"\7p\2\2\"\6\3\2"+
		"\2\2#$\7+\2\2$\b\3\2\2\2%&\7?\2\2&\n\3\2\2\2\'(\7/\2\2(\f\3\2\2\2)*\7"+
		"k\2\2*+\7h\2\2+\16\3\2\2\2,\61\t\2\2\2-.\7?\2\2.\61\7?\2\2/\61\7>\2\2"+
		"\60,\3\2\2\2\60-\3\2\2\2\60/\3\2\2\2\61\20\3\2\2\2\62\63\7v\2\2\63\64"+
		"\7t\2\2\64\65\7w\2\2\65<\7g\2\2\66\67\7h\2\2\678\7c\2\289\7n\2\29:\7u"+
		"\2\2:<\7g\2\2;\62\3\2\2\2;\66\3\2\2\2<\22\3\2\2\2=A\4c|\2>@\t\3\2\2?>"+
		"\3\2\2\2@C\3\2\2\2A?\3\2\2\2AB\3\2\2\2B\24\3\2\2\2CA\3\2\2\2DM\7\62\2"+
		"\2EI\4\63;\2FH\4\62;\2GF\3\2\2\2HK\3\2\2\2IG\3\2\2\2IJ\3\2\2\2JM\3\2\2"+
		"\2KI\3\2\2\2LD\3\2\2\2LE\3\2\2\2M\26\3\2\2\2NP\t\4\2\2ON\3\2\2\2PQ\3\2"+
		"\2\2QO\3\2\2\2QR\3\2\2\2RS\3\2\2\2ST\b\f\2\2T\30\3\2\2\2UV\7\61\2\2VW"+
		"\7\61\2\2W[\3\2\2\2XZ\n\5\2\2YX\3\2\2\2Z]\3\2\2\2[Y\3\2\2\2[\\\3\2\2\2"+
		"\\^\3\2\2\2][\3\2\2\2^_\7\f\2\2_\32\3\2\2\2\n\2\60;AILQ[\3\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}