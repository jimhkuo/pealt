// $ANTLR 3.5.1 /Users/jkuo/PealApp-lift/antlr/Z3Output.g 2014-05-22 10:13:20

package peal.antlr;
import java.util.*;
import peal.domain.z3.*;
import peal.*;
import org.antlr.runtime.BitSet;
import peal.synthesis.*;
import peal.synthesis.analysis.*;
import peal.domain.operator.*;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class Z3OutputParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "IDENT", "NUMBER", "WS", "Z3ERROR", 
		"'('", "'()'", "'(declare-fun'", "'(define-fun'", "'(model'", "')'", "'-'", 
		"'/'", "'='", "'?'", "'Result of analysis ['", "']:'", "'sat'", "'unsat'"
	};
	public static final int EOF=-1;
	public static final int T__8=8;
	public static final int T__9=9;
	public static final int T__10=10;
	public static final int T__11=11;
	public static final int T__12=12;
	public static final int T__13=13;
	public static final int T__14=14;
	public static final int T__15=15;
	public static final int T__16=16;
	public static final int T__17=17;
	public static final int T__18=18;
	public static final int T__19=19;
	public static final int T__20=20;
	public static final int T__21=21;
	public static final int IDENT=4;
	public static final int NUMBER=5;
	public static final int WS=6;
	public static final int Z3ERROR=7;

	// delegates
	public Parser[] getDelegates() {
		return new Parser[] {};
	}

	// delegators


	public Z3OutputParser(TokenStream input) {
		this(input, new RecognizerSharedState());
	}
	public Z3OutputParser(TokenStream input, RecognizerSharedState state) {
		super(input, state);
	}

	@Override public String[] getTokenNames() { return Z3OutputParser.tokenNames; }
	@Override public String getGrammarFileName() { return "/Users/jkuo/PealApp-lift/antlr/Z3Output.g"; }




	@Override
	public void reportError(RecognitionException e) {
		throw new RuntimeException(getErrorMessage(e, PealProgramParser.tokenNames)); 
	}




	// $ANTLR start "results"
	// /Users/jkuo/PealApp-lift/antlr/Z3Output.g:33:1: results returns [Map<String, Model> r] : ( 'Result of analysis [' id0= IDENT '=' id1= IDENT '?' id2= IDENT ( IDENT )? ']:' (m= model ) )+ ;
	public final Map<String, Model> results() throws RecognitionException {
		Map<String, Model> r = null;


		Token id0=null;
		Token id1=null;
		Token id2=null;
		Model m =null;

		r = new HashMap<String, Model>();
		try {
			// /Users/jkuo/PealApp-lift/antlr/Z3Output.g:35:2: ( ( 'Result of analysis [' id0= IDENT '=' id1= IDENT '?' id2= IDENT ( IDENT )? ']:' (m= model ) )+ )
			// /Users/jkuo/PealApp-lift/antlr/Z3Output.g:35:4: ( 'Result of analysis [' id0= IDENT '=' id1= IDENT '?' id2= IDENT ( IDENT )? ']:' (m= model ) )+
			{
			// /Users/jkuo/PealApp-lift/antlr/Z3Output.g:35:4: ( 'Result of analysis [' id0= IDENT '=' id1= IDENT '?' id2= IDENT ( IDENT )? ']:' (m= model ) )+
			int cnt2=0;
			loop2:
			while (true) {
				int alt2=2;
				int LA2_0 = input.LA(1);
				if ( (LA2_0==18) ) {
					alt2=1;
				}

				switch (alt2) {
				case 1 :
					// /Users/jkuo/PealApp-lift/antlr/Z3Output.g:36:2: 'Result of analysis [' id0= IDENT '=' id1= IDENT '?' id2= IDENT ( IDENT )? ']:' (m= model )
					{
					match(input,18,FOLLOW_18_in_results57); 
					id0=(Token)match(input,IDENT,FOLLOW_IDENT_in_results61); 
					match(input,16,FOLLOW_16_in_results63); 
					id1=(Token)match(input,IDENT,FOLLOW_IDENT_in_results67); 
					match(input,17,FOLLOW_17_in_results69); 
					id2=(Token)match(input,IDENT,FOLLOW_IDENT_in_results73); 
					// /Users/jkuo/PealApp-lift/antlr/Z3Output.g:36:63: ( IDENT )?
					int alt1=2;
					int LA1_0 = input.LA(1);
					if ( (LA1_0==IDENT) ) {
						alt1=1;
					}
					switch (alt1) {
						case 1 :
							// /Users/jkuo/PealApp-lift/antlr/Z3Output.g:36:64: IDENT
							{
							match(input,IDENT,FOLLOW_IDENT_in_results76); 
							}
							break;

					}

					match(input,19,FOLLOW_19_in_results80); 
					// /Users/jkuo/PealApp-lift/antlr/Z3Output.g:37:2: (m= model )
					// /Users/jkuo/PealApp-lift/antlr/Z3Output.g:37:3: m= model
					{
					pushFollow(FOLLOW_model_in_results86);
					m=model();
					state._fsp--;

					}

					 r.put((id0!=null?id0.getText():null), m);
					}
					break;

				default :
					if ( cnt2 >= 1 ) break loop2;
					EarlyExitException eee = new EarlyExitException(2, input);
					throw eee;
				}
				cnt2++;
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return r;
	}
	// $ANTLR end "results"



	// $ANTLR start "model"
	// /Users/jkuo/PealApp-lift/antlr/Z3Output.g:41:1: model returns [Model m] : ( 'sat' '(model' ( assignment )+ ')' | 'unsat' Z3ERROR );
	public final Model model() throws RecognitionException {
		Model m = null;


		Assignment assignment1 =null;

		 List<Assignment> l = new ArrayList<Assignment>(); 
		try {
			// /Users/jkuo/PealApp-lift/antlr/Z3Output.g:43:2: ( 'sat' '(model' ( assignment )+ ')' | 'unsat' Z3ERROR )
			int alt4=2;
			int LA4_0 = input.LA(1);
			if ( (LA4_0==20) ) {
				alt4=1;
			}
			else if ( (LA4_0==21) ) {
				alt4=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 4, 0, input);
				throw nvae;
			}

			switch (alt4) {
				case 1 :
					// /Users/jkuo/PealApp-lift/antlr/Z3Output.g:43:4: 'sat' '(model' ( assignment )+ ')'
					{
					match(input,20,FOLLOW_20_in_model113); 
					match(input,12,FOLLOW_12_in_model115); 
					// /Users/jkuo/PealApp-lift/antlr/Z3Output.g:43:19: ( assignment )+
					int cnt3=0;
					loop3:
					while (true) {
						int alt3=2;
						int LA3_0 = input.LA(1);
						if ( ((LA3_0 >= 10 && LA3_0 <= 11)) ) {
							alt3=1;
						}

						switch (alt3) {
						case 1 :
							// /Users/jkuo/PealApp-lift/antlr/Z3Output.g:43:20: assignment
							{
							pushFollow(FOLLOW_assignment_in_model118);
							assignment1=assignment();
							state._fsp--;

							l.add(assignment1);
							}
							break;

						default :
							if ( cnt3 >= 1 ) break loop3;
							EarlyExitException eee = new EarlyExitException(3, input);
							throw eee;
						}
						cnt3++;
					}

					match(input,13,FOLLOW_13_in_model124); 
					 m = new Model(Sat$.MODULE$, l);
					}
					break;
				case 2 :
					// /Users/jkuo/PealApp-lift/antlr/Z3Output.g:44:4: 'unsat' Z3ERROR
					{
					match(input,21,FOLLOW_21_in_model131); 
					match(input,Z3ERROR,FOLLOW_Z3ERROR_in_model133); 
					 m = new Model(Unsat$.MODULE$, l);
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return m;
	}
	// $ANTLR end "model"



	// $ANTLR start "assignment"
	// /Users/jkuo/PealApp-lift/antlr/Z3Output.g:48:1: assignment returns [Assignment a] : ( '(define-fun' id0= IDENT '()' id1= IDENT id2= value ')' | '(declare-fun' id0= IDENT '()' id1= IDENT ')' );
	public final Assignment assignment() throws RecognitionException {
		Assignment a = null;


		Token id0=null;
		Token id1=null;
		String id2 =null;

		try {
			// /Users/jkuo/PealApp-lift/antlr/Z3Output.g:49:2: ( '(define-fun' id0= IDENT '()' id1= IDENT id2= value ')' | '(declare-fun' id0= IDENT '()' id1= IDENT ')' )
			int alt5=2;
			int LA5_0 = input.LA(1);
			if ( (LA5_0==11) ) {
				alt5=1;
			}
			else if ( (LA5_0==10) ) {
				alt5=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 5, 0, input);
				throw nvae;
			}

			switch (alt5) {
				case 1 :
					// /Users/jkuo/PealApp-lift/antlr/Z3Output.g:49:3: '(define-fun' id0= IDENT '()' id1= IDENT id2= value ')'
					{
					match(input,11,FOLLOW_11_in_assignment151); 
					id0=(Token)match(input,IDENT,FOLLOW_IDENT_in_assignment155); 
					match(input,9,FOLLOW_9_in_assignment157); 
					id1=(Token)match(input,IDENT,FOLLOW_IDENT_in_assignment161); 
					pushFollow(FOLLOW_value_in_assignment165);
					id2=value();
					state._fsp--;

					match(input,13,FOLLOW_13_in_assignment166); 
					a = new Assignment((id0!=null?id0.getText():null), (id1!=null?id1.getText():null), id2);
					}
					break;
				case 2 :
					// /Users/jkuo/PealApp-lift/antlr/Z3Output.g:50:3: '(declare-fun' id0= IDENT '()' id1= IDENT ')'
					{
					match(input,10,FOLLOW_10_in_assignment173); 
					id0=(Token)match(input,IDENT,FOLLOW_IDENT_in_assignment177); 
					match(input,9,FOLLOW_9_in_assignment179); 
					id1=(Token)match(input,IDENT,FOLLOW_IDENT_in_assignment183); 
					match(input,13,FOLLOW_13_in_assignment184); 
					a = new Assignment((id0!=null?id0.getText():null), (id1!=null?id1.getText():null), "");
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return a;
	}
	// $ANTLR end "assignment"



	// $ANTLR start "value"
	// /Users/jkuo/PealApp-lift/antlr/Z3Output.g:53:1: value returns [String s] : ( IDENT | NUMBER | '(' '-' unary ')' | '(' '/' lhs= NUMBER rhs= NUMBER ')' );
	public final String value() throws RecognitionException {
		String s = null;


		Token lhs=null;
		Token rhs=null;
		Token IDENT2=null;
		Token NUMBER3=null;
		String unary4 =null;

		try {
			// /Users/jkuo/PealApp-lift/antlr/Z3Output.g:54:2: ( IDENT | NUMBER | '(' '-' unary ')' | '(' '/' lhs= NUMBER rhs= NUMBER ')' )
			int alt6=4;
			switch ( input.LA(1) ) {
			case IDENT:
				{
				alt6=1;
				}
				break;
			case NUMBER:
				{
				alt6=2;
				}
				break;
			case 8:
				{
				int LA6_3 = input.LA(2);
				if ( (LA6_3==14) ) {
					alt6=3;
				}
				else if ( (LA6_3==15) ) {
					alt6=4;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 6, 3, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 6, 0, input);
				throw nvae;
			}
			switch (alt6) {
				case 1 :
					// /Users/jkuo/PealApp-lift/antlr/Z3Output.g:54:4: IDENT
					{
					IDENT2=(Token)match(input,IDENT,FOLLOW_IDENT_in_value203); 
					s = (IDENT2!=null?IDENT2.getText():null);
					}
					break;
				case 2 :
					// /Users/jkuo/PealApp-lift/antlr/Z3Output.g:55:4: NUMBER
					{
					NUMBER3=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_value210); 
					s = (NUMBER3!=null?NUMBER3.getText():null);
					}
					break;
				case 3 :
					// /Users/jkuo/PealApp-lift/antlr/Z3Output.g:56:4: '(' '-' unary ')'
					{
					match(input,8,FOLLOW_8_in_value217); 
					match(input,14,FOLLOW_14_in_value219); 
					pushFollow(FOLLOW_unary_in_value221);
					unary4=unary();
					state._fsp--;

					match(input,13,FOLLOW_13_in_value223); 
					s = "(- " + unary4 + ")";
					}
					break;
				case 4 :
					// /Users/jkuo/PealApp-lift/antlr/Z3Output.g:57:4: '(' '/' lhs= NUMBER rhs= NUMBER ')'
					{
					match(input,8,FOLLOW_8_in_value230); 
					match(input,15,FOLLOW_15_in_value232); 
					lhs=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_value236); 
					rhs=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_value240); 
					match(input,13,FOLLOW_13_in_value242); 
					s = "(/ " + (lhs!=null?lhs.getText():null) + " " + (rhs!=null?rhs.getText():null) + ")";
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return s;
	}
	// $ANTLR end "value"



	// $ANTLR start "unary"
	// /Users/jkuo/PealApp-lift/antlr/Z3Output.g:60:1: unary returns [String s] : ( IDENT | NUMBER | value );
	public final String unary() throws RecognitionException {
		String s = null;


		Token IDENT5=null;
		Token NUMBER6=null;
		String value7 =null;

		try {
			// /Users/jkuo/PealApp-lift/antlr/Z3Output.g:61:2: ( IDENT | NUMBER | value )
			int alt7=3;
			switch ( input.LA(1) ) {
			case IDENT:
				{
				alt7=1;
				}
				break;
			case NUMBER:
				{
				alt7=2;
				}
				break;
			case 8:
				{
				alt7=3;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 7, 0, input);
				throw nvae;
			}
			switch (alt7) {
				case 1 :
					// /Users/jkuo/PealApp-lift/antlr/Z3Output.g:61:4: IDENT
					{
					IDENT5=(Token)match(input,IDENT,FOLLOW_IDENT_in_unary260); 
					s = (IDENT5!=null?IDENT5.getText():null);
					}
					break;
				case 2 :
					// /Users/jkuo/PealApp-lift/antlr/Z3Output.g:62:4: NUMBER
					{
					NUMBER6=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_unary267); 
					s = (NUMBER6!=null?NUMBER6.getText():null);
					}
					break;
				case 3 :
					// /Users/jkuo/PealApp-lift/antlr/Z3Output.g:63:4: value
					{
					pushFollow(FOLLOW_value_in_unary274);
					value7=value();
					state._fsp--;

					s = value7;
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return s;
	}
	// $ANTLR end "unary"

	// Delegated rules



	public static final BitSet FOLLOW_18_in_results57 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_IDENT_in_results61 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_16_in_results63 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_IDENT_in_results67 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_17_in_results69 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_IDENT_in_results73 = new BitSet(new long[]{0x0000000000080010L});
	public static final BitSet FOLLOW_IDENT_in_results76 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_19_in_results80 = new BitSet(new long[]{0x0000000000300000L});
	public static final BitSet FOLLOW_model_in_results86 = new BitSet(new long[]{0x0000000000040002L});
	public static final BitSet FOLLOW_20_in_model113 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_12_in_model115 = new BitSet(new long[]{0x0000000000000C00L});
	public static final BitSet FOLLOW_assignment_in_model118 = new BitSet(new long[]{0x0000000000002C00L});
	public static final BitSet FOLLOW_13_in_model124 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_21_in_model131 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_Z3ERROR_in_model133 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_11_in_assignment151 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_IDENT_in_assignment155 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_9_in_assignment157 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_IDENT_in_assignment161 = new BitSet(new long[]{0x0000000000000130L});
	public static final BitSet FOLLOW_value_in_assignment165 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_13_in_assignment166 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_10_in_assignment173 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_IDENT_in_assignment177 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_9_in_assignment179 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_IDENT_in_assignment183 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_13_in_assignment184 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IDENT_in_value203 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NUMBER_in_value210 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_8_in_value217 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_14_in_value219 = new BitSet(new long[]{0x0000000000000130L});
	public static final BitSet FOLLOW_unary_in_value221 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_13_in_value223 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_8_in_value230 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_15_in_value232 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_NUMBER_in_value236 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_NUMBER_in_value240 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_13_in_value242 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IDENT_in_unary260 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NUMBER_in_unary267 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_value_in_unary274 = new BitSet(new long[]{0x0000000000000002L});
}
