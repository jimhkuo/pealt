// $ANTLR 3.4 /Users/jkuo/PealApp-lift/antlr/PealProgram.g 2013-09-26 12:43:36

package peal.antlr;
import java.util.*;
import peal.domain.*;
import peal.antlr.util.*;
import peal.*;
import org.antlr.runtime.BitSet;
import peal.synthesis.*;
import peal.synthesis.analysis.*;
import peal.domain.operator.*;
import scala.math.BigDecimal;
import scala.util.*;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class PealProgramParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "IDENT", "NUMBER", "WS", "'!'", "'('", "')'", "'*'", "'+'", "','", "'<'", "'<='", "'='", "'ANALYSES'", "'CONDITIONS'", "'DOMAIN_SPECIFICS'", "'POLICIES'", "'POLICY_SETS'", "'always_false?'", "'always_true?'", "'default'", "'different?'", "'equivalent?'", "'implies?'", "'max'", "'min'", "'satisfiable?'"
    };

    public static final int EOF=-1;
    public static final int T__7=7;
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
    public static final int T__22=22;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int T__29=29;
    public static final int IDENT=4;
    public static final int NUMBER=5;
    public static final int WS=6;

    // delegates
    public Parser[] getDelegates() {
        return new Parser[] {};
    }

    // delegators


    public PealProgramParser(TokenStream input) {
        this(input, new RecognizerSharedState());
    }
    public PealProgramParser(TokenStream input, RecognizerSharedState state) {
        super(input, state);
    }

    public String[] getTokenNames() { return PealProgramParser.tokenNames; }
    public String getGrammarFileName() { return "/Users/jkuo/PealApp-lift/antlr/PealProgram.g"; }


    public Map<String, Pol> pols = new HashMap<String, Pol>();
    public Map<String, Condition> conds = new HashMap<String, Condition>();
    public Map<String, AnalysisGenerator> analyses = new HashMap<String, AnalysisGenerator>();
    public Map<String, PolicySet> pSets = new HashMap<String, PolicySet>();
    private Map<String, String> pSetScores = new HashMap<String, String>();
    private List<Rule> l = null;
    private boolean ignore = false;


    @Override
    public void reportError(RecognitionException e) {
    	throw new RuntimeException(getErrorMessage(e, PealProgramParser.tokenNames)); 
    }




    // $ANTLR start "program"
    // /Users/jkuo/PealApp-lift/antlr/PealProgram.g:46:1: program : ( 'POLICIES' )? ( pol )* ( 'POLICY_SETS' )? (id2= IDENT '=' pSet )+ ( 'CONDITIONS' )? (id0= IDENT '=' id2= IDENT '<=' num= NUMBER |id0= IDENT '=' num= NUMBER '<' id2= IDENT |id0= IDENT '=' '!' id1= IDENT )+ ( 'DOMAIN_SPECIFICS' ( IDENT | NUMBER | '+' | '*' | '=' | '(' | ')' | '<' | '<=' )* )? ( 'ANALYSES' (id0= IDENT '=' 'always_true?' id1= IDENT |id0= IDENT '=' 'always_false?' id1= IDENT |id0= IDENT '=' 'satisfiable?' id1= IDENT |id0= IDENT '=' 'equivalent?' id1= IDENT id2= IDENT |id0= IDENT '=' 'different?' id1= IDENT id2= IDENT |id0= IDENT '=' 'implies?' id1= IDENT id2= IDENT )+ )? ;
    public final void program() throws RecognitionException {
        Token id2=null;
        Token id0=null;
        Token num=null;
        Token id1=null;
        Pol pol1 =null;

        PolicySet pSet2 =null;


        try {
            // /Users/jkuo/PealApp-lift/antlr/PealProgram.g:47:2: ( ( 'POLICIES' )? ( pol )* ( 'POLICY_SETS' )? (id2= IDENT '=' pSet )+ ( 'CONDITIONS' )? (id0= IDENT '=' id2= IDENT '<=' num= NUMBER |id0= IDENT '=' num= NUMBER '<' id2= IDENT |id0= IDENT '=' '!' id1= IDENT )+ ( 'DOMAIN_SPECIFICS' ( IDENT | NUMBER | '+' | '*' | '=' | '(' | ')' | '<' | '<=' )* )? ( 'ANALYSES' (id0= IDENT '=' 'always_true?' id1= IDENT |id0= IDENT '=' 'always_false?' id1= IDENT |id0= IDENT '=' 'satisfiable?' id1= IDENT |id0= IDENT '=' 'equivalent?' id1= IDENT id2= IDENT |id0= IDENT '=' 'different?' id1= IDENT id2= IDENT |id0= IDENT '=' 'implies?' id1= IDENT id2= IDENT )+ )? )
            // /Users/jkuo/PealApp-lift/antlr/PealProgram.g:48:2: ( 'POLICIES' )? ( pol )* ( 'POLICY_SETS' )? (id2= IDENT '=' pSet )+ ( 'CONDITIONS' )? (id0= IDENT '=' id2= IDENT '<=' num= NUMBER |id0= IDENT '=' num= NUMBER '<' id2= IDENT |id0= IDENT '=' '!' id1= IDENT )+ ( 'DOMAIN_SPECIFICS' ( IDENT | NUMBER | '+' | '*' | '=' | '(' | ')' | '<' | '<=' )* )? ( 'ANALYSES' (id0= IDENT '=' 'always_true?' id1= IDENT |id0= IDENT '=' 'always_false?' id1= IDENT |id0= IDENT '=' 'satisfiable?' id1= IDENT |id0= IDENT '=' 'equivalent?' id1= IDENT id2= IDENT |id0= IDENT '=' 'different?' id1= IDENT id2= IDENT |id0= IDENT '=' 'implies?' id1= IDENT id2= IDENT )+ )?
            {
            // /Users/jkuo/PealApp-lift/antlr/PealProgram.g:48:2: ( 'POLICIES' )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==19) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // /Users/jkuo/PealApp-lift/antlr/PealProgram.g:48:3: 'POLICIES'
                    {
                    match(input,19,FOLLOW_19_in_program57); 

                    }
                    break;

            }


            // /Users/jkuo/PealApp-lift/antlr/PealProgram.g:49:2: ( pol )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==IDENT) ) {
                    int LA2_2 = input.LA(2);

                    if ( (LA2_2==15) ) {
                        switch ( input.LA(3) ) {
                        case 27:
                            {
                            int LA2_4 = input.LA(4);

                            if ( (LA2_4==8) ) {
                                int LA2_7 = input.LA(5);

                                if ( ((LA2_7 >= 8 && LA2_7 <= 9)) ) {
                                    alt2=1;
                                }


                            }


                            }
                            break;
                        case 28:
                            {
                            int LA2_5 = input.LA(4);

                            if ( (LA2_5==8) ) {
                                int LA2_8 = input.LA(5);

                                if ( ((LA2_8 >= 8 && LA2_8 <= 9)) ) {
                                    alt2=1;
                                }


                            }


                            }
                            break;
                        case 10:
                        case 11:
                            {
                            alt2=1;
                            }
                            break;

                        }

                    }


                }


                switch (alt2) {
            	case 1 :
            	    // /Users/jkuo/PealApp-lift/antlr/PealProgram.g:49:3: pol
            	    {
            	    pushFollow(FOLLOW_pol_in_program63);
            	    pol1=pol();

            	    state._fsp--;


            	    pols.put(pol1.getName(), pol1);

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            // /Users/jkuo/PealApp-lift/antlr/PealProgram.g:50:2: ( 'POLICY_SETS' )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==20) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // /Users/jkuo/PealApp-lift/antlr/PealProgram.g:50:3: 'POLICY_SETS'
                    {
                    match(input,20,FOLLOW_20_in_program71); 

                    }
                    break;

            }


            // /Users/jkuo/PealApp-lift/antlr/PealProgram.g:51:2: (id2= IDENT '=' pSet )+
            int cnt4=0;
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==IDENT) ) {
                    int LA4_2 = input.LA(2);

                    if ( (LA4_2==15) ) {
                        int LA4_3 = input.LA(3);

                        if ( (LA4_3==IDENT) ) {
                            int LA4_4 = input.LA(4);

                            if ( (LA4_4==IDENT||LA4_4==17) ) {
                                alt4=1;
                            }


                        }
                        else if ( ((LA4_3 >= 27 && LA4_3 <= 28)) ) {
                            alt4=1;
                        }


                    }


                }


                switch (alt4) {
            	case 1 :
            	    // /Users/jkuo/PealApp-lift/antlr/PealProgram.g:51:3: id2= IDENT '=' pSet
            	    {
            	    id2=(Token)match(input,IDENT,FOLLOW_IDENT_in_program79); 

            	    match(input,15,FOLLOW_15_in_program81); 

            	    pushFollow(FOLLOW_pSet_in_program83);
            	    pSet2=pSet();

            	    state._fsp--;


            	     pSets.put((id2!=null?id2.getText():null), pSet2);

            	    }
            	    break;

            	default :
            	    if ( cnt4 >= 1 ) break loop4;
                        EarlyExitException eee =
                            new EarlyExitException(4, input);
                        throw eee;
                }
                cnt4++;
            } while (true);


            // /Users/jkuo/PealApp-lift/antlr/PealProgram.g:52:2: ( 'CONDITIONS' )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==17) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // /Users/jkuo/PealApp-lift/antlr/PealProgram.g:52:3: 'CONDITIONS'
                    {
                    match(input,17,FOLLOW_17_in_program91); 

                    }
                    break;

            }


            // /Users/jkuo/PealApp-lift/antlr/PealProgram.g:53:2: (id0= IDENT '=' id2= IDENT '<=' num= NUMBER |id0= IDENT '=' num= NUMBER '<' id2= IDENT |id0= IDENT '=' '!' id1= IDENT )+
            int cnt6=0;
            loop6:
            do {
                int alt6=4;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==IDENT) ) {
                    int LA6_2 = input.LA(2);

                    if ( (LA6_2==15) ) {
                        switch ( input.LA(3) ) {
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
                        case 7:
                            {
                            alt6=3;
                            }
                            break;

                        }

                    }


                }


                switch (alt6) {
            	case 1 :
            	    // /Users/jkuo/PealApp-lift/antlr/PealProgram.g:54:2: id0= IDENT '=' id2= IDENT '<=' num= NUMBER
            	    {
            	    id0=(Token)match(input,IDENT,FOLLOW_IDENT_in_program101); 

            	    match(input,15,FOLLOW_15_in_program103); 

            	    id2=(Token)match(input,IDENT,FOLLOW_IDENT_in_program107); 

            	    match(input,14,FOLLOW_14_in_program109); 

            	    num=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_program113); 

            	    Condition cond = new LessThanThCondition(pSets.get((id2!=null?id2.getText():null)), BigDecimal.valueOf(Double.valueOf((num!=null?num.getText():null)))); conds.put((id0!=null?id0.getText():null), cond);

            	    }
            	    break;
            	case 2 :
            	    // /Users/jkuo/PealApp-lift/antlr/PealProgram.g:56:2: id0= IDENT '=' num= NUMBER '<' id2= IDENT
            	    {
            	    id0=(Token)match(input,IDENT,FOLLOW_IDENT_in_program127); 

            	    match(input,15,FOLLOW_15_in_program129); 

            	    num=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_program133); 

            	    match(input,13,FOLLOW_13_in_program135); 

            	    id2=(Token)match(input,IDENT,FOLLOW_IDENT_in_program139); 

            	    Condition cond = new GreaterThanThCondition(pSets.get((id2!=null?id2.getText():null)), BigDecimal.valueOf(Double.valueOf((num!=null?num.getText():null)))); conds.put((id0!=null?id0.getText():null), cond);

            	    }
            	    break;
            	case 3 :
            	    // /Users/jkuo/PealApp-lift/antlr/PealProgram.g:58:2: id0= IDENT '=' '!' id1= IDENT
            	    {
            	    id0=(Token)match(input,IDENT,FOLLOW_IDENT_in_program149); 

            	    match(input,15,FOLLOW_15_in_program151); 

            	    match(input,7,FOLLOW_7_in_program153); 

            	    id1=(Token)match(input,IDENT,FOLLOW_IDENT_in_program157); 

            	    Condition cond = new NotCondition((id1!=null?id1.getText():null)); conds.put((id0!=null?id0.getText():null), cond);

            	    }
            	    break;

            	default :
            	    if ( cnt6 >= 1 ) break loop6;
                        EarlyExitException eee =
                            new EarlyExitException(6, input);
                        throw eee;
                }
                cnt6++;
            } while (true);


            // /Users/jkuo/PealApp-lift/antlr/PealProgram.g:60:2: ( 'DOMAIN_SPECIFICS' ( IDENT | NUMBER | '+' | '*' | '=' | '(' | ')' | '<' | '<=' )* )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==18) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // /Users/jkuo/PealApp-lift/antlr/PealProgram.g:60:3: 'DOMAIN_SPECIFICS' ( IDENT | NUMBER | '+' | '*' | '=' | '(' | ')' | '<' | '<=' )*
                    {
                    match(input,18,FOLLOW_18_in_program167); 

                    ignore = true;

                    // /Users/jkuo/PealApp-lift/antlr/PealProgram.g:61:2: ( IDENT | NUMBER | '+' | '*' | '=' | '(' | ')' | '<' | '<=' )*
                    loop7:
                    do {
                        int alt7=2;
                        int LA7_0 = input.LA(1);

                        if ( ((LA7_0 >= IDENT && LA7_0 <= NUMBER)||(LA7_0 >= 8 && LA7_0 <= 11)||(LA7_0 >= 13 && LA7_0 <= 15)) ) {
                            alt7=1;
                        }


                        switch (alt7) {
                    	case 1 :
                    	    // /Users/jkuo/PealApp-lift/antlr/PealProgram.g:
                    	    {
                    	    if ( (input.LA(1) >= IDENT && input.LA(1) <= NUMBER)||(input.LA(1) >= 8 && input.LA(1) <= 11)||(input.LA(1) >= 13 && input.LA(1) <= 15) ) {
                    	        input.consume();
                    	        state.errorRecovery=false;
                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        throw mse;
                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop7;
                        }
                    } while (true);


                    }
                    break;

            }


            // /Users/jkuo/PealApp-lift/antlr/PealProgram.g:62:2: ( 'ANALYSES' (id0= IDENT '=' 'always_true?' id1= IDENT |id0= IDENT '=' 'always_false?' id1= IDENT |id0= IDENT '=' 'satisfiable?' id1= IDENT |id0= IDENT '=' 'equivalent?' id1= IDENT id2= IDENT |id0= IDENT '=' 'different?' id1= IDENT id2= IDENT |id0= IDENT '=' 'implies?' id1= IDENT id2= IDENT )+ )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==16) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // /Users/jkuo/PealApp-lift/antlr/PealProgram.g:62:3: 'ANALYSES' (id0= IDENT '=' 'always_true?' id1= IDENT |id0= IDENT '=' 'always_false?' id1= IDENT |id0= IDENT '=' 'satisfiable?' id1= IDENT |id0= IDENT '=' 'equivalent?' id1= IDENT id2= IDENT |id0= IDENT '=' 'different?' id1= IDENT id2= IDENT |id0= IDENT '=' 'implies?' id1= IDENT id2= IDENT )+
                    {
                    match(input,16,FOLLOW_16_in_program214); 

                    ignore = false;

                    // /Users/jkuo/PealApp-lift/antlr/PealProgram.g:63:2: (id0= IDENT '=' 'always_true?' id1= IDENT |id0= IDENT '=' 'always_false?' id1= IDENT |id0= IDENT '=' 'satisfiable?' id1= IDENT |id0= IDENT '=' 'equivalent?' id1= IDENT id2= IDENT |id0= IDENT '=' 'different?' id1= IDENT id2= IDENT |id0= IDENT '=' 'implies?' id1= IDENT id2= IDENT )+
                    int cnt9=0;
                    loop9:
                    do {
                        int alt9=7;
                        int LA9_0 = input.LA(1);

                        if ( (LA9_0==IDENT) ) {
                            int LA9_2 = input.LA(2);

                            if ( (LA9_2==15) ) {
                                switch ( input.LA(3) ) {
                                case 22:
                                    {
                                    alt9=1;
                                    }
                                    break;
                                case 21:
                                    {
                                    alt9=2;
                                    }
                                    break;
                                case 29:
                                    {
                                    alt9=3;
                                    }
                                    break;
                                case 25:
                                    {
                                    alt9=4;
                                    }
                                    break;
                                case 24:
                                    {
                                    alt9=5;
                                    }
                                    break;
                                case 26:
                                    {
                                    alt9=6;
                                    }
                                    break;

                                }

                            }


                        }


                        switch (alt9) {
                    	case 1 :
                    	    // /Users/jkuo/PealApp-lift/antlr/PealProgram.g:63:3: id0= IDENT '=' 'always_true?' id1= IDENT
                    	    {
                    	    id0=(Token)match(input,IDENT,FOLLOW_IDENT_in_program222); 

                    	    match(input,15,FOLLOW_15_in_program224); 

                    	    match(input,22,FOLLOW_22_in_program226); 

                    	    id1=(Token)match(input,IDENT,FOLLOW_IDENT_in_program230); 

                    	    AnalysisGenerator analysis = new AlwaysTrue((id0!=null?id0.getText():null), (id1!=null?id1.getText():null)); analyses.put((id0!=null?id0.getText():null), analysis);

                    	    }
                    	    break;
                    	case 2 :
                    	    // /Users/jkuo/PealApp-lift/antlr/PealProgram.g:64:3: id0= IDENT '=' 'always_false?' id1= IDENT
                    	    {
                    	    id0=(Token)match(input,IDENT,FOLLOW_IDENT_in_program238); 

                    	    match(input,15,FOLLOW_15_in_program240); 

                    	    match(input,21,FOLLOW_21_in_program242); 

                    	    id1=(Token)match(input,IDENT,FOLLOW_IDENT_in_program246); 

                    	    AnalysisGenerator analysis = new AlwaysFalse((id0!=null?id0.getText():null), (id1!=null?id1.getText():null)); analyses.put((id0!=null?id0.getText():null), analysis);

                    	    }
                    	    break;
                    	case 3 :
                    	    // /Users/jkuo/PealApp-lift/antlr/PealProgram.g:65:3: id0= IDENT '=' 'satisfiable?' id1= IDENT
                    	    {
                    	    id0=(Token)match(input,IDENT,FOLLOW_IDENT_in_program254); 

                    	    match(input,15,FOLLOW_15_in_program256); 

                    	    match(input,29,FOLLOW_29_in_program258); 

                    	    id1=(Token)match(input,IDENT,FOLLOW_IDENT_in_program262); 

                    	    AnalysisGenerator analysis = new Satisfiable((id0!=null?id0.getText():null), (id1!=null?id1.getText():null)); analyses.put((id0!=null?id0.getText():null), analysis);

                    	    }
                    	    break;
                    	case 4 :
                    	    // /Users/jkuo/PealApp-lift/antlr/PealProgram.g:66:3: id0= IDENT '=' 'equivalent?' id1= IDENT id2= IDENT
                    	    {
                    	    id0=(Token)match(input,IDENT,FOLLOW_IDENT_in_program271); 

                    	    match(input,15,FOLLOW_15_in_program273); 

                    	    match(input,25,FOLLOW_25_in_program275); 

                    	    id1=(Token)match(input,IDENT,FOLLOW_IDENT_in_program279); 

                    	    id2=(Token)match(input,IDENT,FOLLOW_IDENT_in_program283); 

                    	    AnalysisGenerator analysis = new Equivalent((id0!=null?id0.getText():null), (id1!=null?id1.getText():null), (id2!=null?id2.getText():null)); analyses.put((id0!=null?id0.getText():null), analysis);

                    	    }
                    	    break;
                    	case 5 :
                    	    // /Users/jkuo/PealApp-lift/antlr/PealProgram.g:67:3: id0= IDENT '=' 'different?' id1= IDENT id2= IDENT
                    	    {
                    	    id0=(Token)match(input,IDENT,FOLLOW_IDENT_in_program292); 

                    	    match(input,15,FOLLOW_15_in_program294); 

                    	    match(input,24,FOLLOW_24_in_program296); 

                    	    id1=(Token)match(input,IDENT,FOLLOW_IDENT_in_program300); 

                    	    id2=(Token)match(input,IDENT,FOLLOW_IDENT_in_program304); 

                    	    AnalysisGenerator analysis = new Different((id0!=null?id0.getText():null), (id1!=null?id1.getText():null), (id2!=null?id2.getText():null)); analyses.put((id0!=null?id0.getText():null), analysis);

                    	    }
                    	    break;
                    	case 6 :
                    	    // /Users/jkuo/PealApp-lift/antlr/PealProgram.g:68:3: id0= IDENT '=' 'implies?' id1= IDENT id2= IDENT
                    	    {
                    	    id0=(Token)match(input,IDENT,FOLLOW_IDENT_in_program314); 

                    	    match(input,15,FOLLOW_15_in_program316); 

                    	    match(input,26,FOLLOW_26_in_program318); 

                    	    id1=(Token)match(input,IDENT,FOLLOW_IDENT_in_program322); 

                    	    id2=(Token)match(input,IDENT,FOLLOW_IDENT_in_program326); 

                    	    AnalysisGenerator analysis = new Implies((id0!=null?id0.getText():null), (id1!=null?id1.getText():null), (id2!=null?id2.getText():null)); analyses.put((id0!=null?id0.getText():null), analysis);

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt9 >= 1 ) break loop9;
                                EarlyExitException eee =
                                    new EarlyExitException(9, input);
                                throw eee;
                        }
                        cnt9++;
                    } while (true);


                    }
                    break;

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
        return ;
    }
    // $ANTLR end "program"



    // $ANTLR start "pSet"
    // /Users/jkuo/PealApp-lift/antlr/PealProgram.g:73:1: pSet returns [PolicySet t] : (id1= IDENT | 'max' '(' id1= IDENT ',' id2= IDENT ')' | 'min' '(' id1= IDENT ',' id2= IDENT ')' );
    public final PolicySet pSet() throws RecognitionException {
        PolicySet t = null;


        Token id1=null;
        Token id2=null;

        try {
            // /Users/jkuo/PealApp-lift/antlr/PealProgram.g:74:2: (id1= IDENT | 'max' '(' id1= IDENT ',' id2= IDENT ')' | 'min' '(' id1= IDENT ',' id2= IDENT ')' )
            int alt11=3;
            switch ( input.LA(1) ) {
            case IDENT:
                {
                alt11=1;
                }
                break;
            case 27:
                {
                alt11=2;
                }
                break;
            case 28:
                {
                alt11=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;

            }

            switch (alt11) {
                case 1 :
                    // /Users/jkuo/PealApp-lift/antlr/PealProgram.g:74:4: id1= IDENT
                    {
                    id1=(Token)match(input,IDENT,FOLLOW_IDENT_in_pSet357); 

                    t = new BasicPolicySet(pols.get((id1!=null?id1.getText():null)));

                    }
                    break;
                case 2 :
                    // /Users/jkuo/PealApp-lift/antlr/PealProgram.g:75:4: 'max' '(' id1= IDENT ',' id2= IDENT ')'
                    {
                    match(input,27,FOLLOW_27_in_pSet364); 

                    match(input,8,FOLLOW_8_in_pSet366); 

                    id1=(Token)match(input,IDENT,FOLLOW_IDENT_in_pSet370); 

                    match(input,12,FOLLOW_12_in_pSet372); 

                    id2=(Token)match(input,IDENT,FOLLOW_IDENT_in_pSet376); 

                    match(input,9,FOLLOW_9_in_pSet378); 

                    t = new MaxPolicySet(PolicyResolver.getFromOr(pols, pSets, (id1!=null?id1.getText():null)), PolicyResolver.getFromOr(pols, pSets, (id2!=null?id2.getText():null)));

                    }
                    break;
                case 3 :
                    // /Users/jkuo/PealApp-lift/antlr/PealProgram.g:76:4: 'min' '(' id1= IDENT ',' id2= IDENT ')'
                    {
                    match(input,28,FOLLOW_28_in_pSet385); 

                    match(input,8,FOLLOW_8_in_pSet387); 

                    id1=(Token)match(input,IDENT,FOLLOW_IDENT_in_pSet391); 

                    match(input,12,FOLLOW_12_in_pSet393); 

                    id2=(Token)match(input,IDENT,FOLLOW_IDENT_in_pSet397); 

                    match(input,9,FOLLOW_9_in_pSet399); 

                    t = new MinPolicySet(PolicyResolver.getFromOr(pols, pSets, (id1!=null?id1.getText():null)), PolicyResolver.getFromOr(pols, pSets, (id2!=null?id2.getText():null)));

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
        return t;
    }
    // $ANTLR end "pSet"



    // $ANTLR start "pol"
    // /Users/jkuo/PealApp-lift/antlr/PealProgram.g:79:1: pol returns [Pol p] : id1= IDENT '=' o= operator '(' ( rule )* ')' 'default' (n= NUMBER |n= NUMBER '*' id2= IDENT |id2= IDENT |id2= IDENT '*' n= NUMBER ) ;
    public final Pol pol() throws RecognitionException {
        Pol p = null;


        Token id1=null;
        Token n=null;
        Token id2=null;
        PealProgramParser.operator_return o =null;

        Rule rule3 =null;


        l = new ArrayList<Rule>(); 
        try {
            // /Users/jkuo/PealApp-lift/antlr/PealProgram.g:81:2: (id1= IDENT '=' o= operator '(' ( rule )* ')' 'default' (n= NUMBER |n= NUMBER '*' id2= IDENT |id2= IDENT |id2= IDENT '*' n= NUMBER ) )
            // /Users/jkuo/PealApp-lift/antlr/PealProgram.g:81:4: id1= IDENT '=' o= operator '(' ( rule )* ')' 'default' (n= NUMBER |n= NUMBER '*' id2= IDENT |id2= IDENT |id2= IDENT '*' n= NUMBER )
            {
            id1=(Token)match(input,IDENT,FOLLOW_IDENT_in_pol424); 

            match(input,15,FOLLOW_15_in_pol426); 

            pushFollow(FOLLOW_operator_in_pol430);
            o=operator();

            state._fsp--;


            match(input,8,FOLLOW_8_in_pol432); 

            // /Users/jkuo/PealApp-lift/antlr/PealProgram.g:81:33: ( rule )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==8) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // /Users/jkuo/PealApp-lift/antlr/PealProgram.g:81:34: rule
            	    {
            	    pushFollow(FOLLOW_rule_in_pol435);
            	    rule3=rule();

            	    state._fsp--;


            	    l.add(rule3);

            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);


            match(input,9,FOLLOW_9_in_pol441); 

            match(input,23,FOLLOW_23_in_pol443); 

            // /Users/jkuo/PealApp-lift/antlr/PealProgram.g:81:73: (n= NUMBER |n= NUMBER '*' id2= IDENT |id2= IDENT |id2= IDENT '*' n= NUMBER )
            int alt13=4;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==NUMBER) ) {
                int LA13_1 = input.LA(2);

                if ( (LA13_1==10) ) {
                    alt13=2;
                }
                else if ( (LA13_1==IDENT||LA13_1==20) ) {
                    alt13=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 13, 1, input);

                    throw nvae;

                }
            }
            else if ( (LA13_0==IDENT) ) {
                int LA13_2 = input.LA(2);

                if ( (LA13_2==10) ) {
                    alt13=4;
                }
                else if ( (LA13_2==IDENT||LA13_2==20) ) {
                    alt13=3;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 13, 2, input);

                    throw nvae;

                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;

            }
            switch (alt13) {
                case 1 :
                    // /Users/jkuo/PealApp-lift/antlr/PealProgram.g:81:74: n= NUMBER
                    {
                    n=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_pol448); 

                    p = new Pol(l, OperatorResolver.apply((o!=null?input.toString(o.start,o.stop):null)), new Left<BigDecimal,Variable>(BigDecimal.valueOf(Double.valueOf((n!=null?n.getText():null)))), (id1!=null?id1.getText():null));

                    }
                    break;
                case 2 :
                    // /Users/jkuo/PealApp-lift/antlr/PealProgram.g:83:10: n= NUMBER '*' id2= IDENT
                    {
                    n=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_pol474); 

                    match(input,10,FOLLOW_10_in_pol476); 

                    id2=(Token)match(input,IDENT,FOLLOW_IDENT_in_pol480); 

                    p = new Pol(l, OperatorResolver.apply((o!=null?input.toString(o.start,o.stop):null)), new Right<BigDecimal,Variable>(new Variable(BigDecimal.valueOf(Double.valueOf((n!=null?n.getText():null))), (id2!=null?id2.getText():null))), (id1!=null?id1.getText():null));

                    }
                    break;
                case 3 :
                    // /Users/jkuo/PealApp-lift/antlr/PealProgram.g:85:10: id2= IDENT
                    {
                    id2=(Token)match(input,IDENT,FOLLOW_IDENT_in_pol506); 

                    p = new Pol(l, OperatorResolver.apply((o!=null?input.toString(o.start,o.stop):null)), new Right<BigDecimal,Variable>(new Variable(BigDecimal.valueOf(1), (id2!=null?id2.getText():null))), (id1!=null?id1.getText():null));

                    }
                    break;
                case 4 :
                    // /Users/jkuo/PealApp-lift/antlr/PealProgram.g:87:10: id2= IDENT '*' n= NUMBER
                    {
                    id2=(Token)match(input,IDENT,FOLLOW_IDENT_in_pol532); 

                    match(input,10,FOLLOW_10_in_pol534); 

                    n=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_pol538); 

                    p = new Pol(l, OperatorResolver.apply((o!=null?input.toString(o.start,o.stop):null)), new Right<BigDecimal,Variable>(new Variable(BigDecimal.valueOf(Double.valueOf((n!=null?n.getText():null))), (id2!=null?id2.getText():null))), (id1!=null?id1.getText():null));

                    }
                    break;

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
        return p;
    }
    // $ANTLR end "pol"



    // $ANTLR start "rule"
    // /Users/jkuo/PealApp-lift/antlr/PealProgram.g:94:1: rule returns [Rule r] : ( '(' IDENT NUMBER ')' | '(' id0= IDENT id1= IDENT ')' | '(' id0= IDENT n= NUMBER '*' id1= IDENT ')' | '(' id0= IDENT id1= IDENT '*' n= NUMBER ')' );
    public final Rule rule() throws RecognitionException {
        Rule r = null;


        Token id0=null;
        Token id1=null;
        Token n=null;
        Token IDENT4=null;
        Token NUMBER5=null;

        try {
            // /Users/jkuo/PealApp-lift/antlr/PealProgram.g:95:2: ( '(' IDENT NUMBER ')' | '(' id0= IDENT id1= IDENT ')' | '(' id0= IDENT n= NUMBER '*' id1= IDENT ')' | '(' id0= IDENT id1= IDENT '*' n= NUMBER ')' )
            int alt14=4;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==8) ) {
                int LA14_1 = input.LA(2);

                if ( (LA14_1==IDENT) ) {
                    int LA14_2 = input.LA(3);

                    if ( (LA14_2==NUMBER) ) {
                        int LA14_3 = input.LA(4);

                        if ( (LA14_3==9) ) {
                            alt14=1;
                        }
                        else if ( (LA14_3==10) ) {
                            alt14=3;
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 14, 3, input);

                            throw nvae;

                        }
                    }
                    else if ( (LA14_2==IDENT) ) {
                        int LA14_4 = input.LA(4);

                        if ( (LA14_4==9) ) {
                            alt14=2;
                        }
                        else if ( (LA14_4==10) ) {
                            alt14=4;
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 14, 4, input);

                            throw nvae;

                        }
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 14, 2, input);

                        throw nvae;

                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 14, 1, input);

                    throw nvae;

                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;

            }
            switch (alt14) {
                case 1 :
                    // /Users/jkuo/PealApp-lift/antlr/PealProgram.g:95:4: '(' IDENT NUMBER ')'
                    {
                    match(input,8,FOLLOW_8_in_rule570); 

                    IDENT4=(Token)match(input,IDENT,FOLLOW_IDENT_in_rule572); 

                    NUMBER5=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_rule574); 

                    match(input,9,FOLLOW_9_in_rule576); 

                    r = new Rule(new Predicate((IDENT4!=null?IDENT4.getText():null)),new Left<BigDecimal,Variable>(BigDecimal.valueOf(Double.valueOf((NUMBER5!=null?NUMBER5.getText():null)))));

                    }
                    break;
                case 2 :
                    // /Users/jkuo/PealApp-lift/antlr/PealProgram.g:96:4: '(' id0= IDENT id1= IDENT ')'
                    {
                    match(input,8,FOLLOW_8_in_rule583); 

                    id0=(Token)match(input,IDENT,FOLLOW_IDENT_in_rule587); 

                    id1=(Token)match(input,IDENT,FOLLOW_IDENT_in_rule591); 

                    match(input,9,FOLLOW_9_in_rule592); 

                    r = new Rule(new Predicate((id0!=null?id0.getText():null)),new Right<BigDecimal,Variable>(new Variable(BigDecimal.valueOf(1), (id1!=null?id1.getText():null))));

                    }
                    break;
                case 3 :
                    // /Users/jkuo/PealApp-lift/antlr/PealProgram.g:97:4: '(' id0= IDENT n= NUMBER '*' id1= IDENT ')'
                    {
                    match(input,8,FOLLOW_8_in_rule599); 

                    id0=(Token)match(input,IDENT,FOLLOW_IDENT_in_rule603); 

                    n=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_rule607); 

                    match(input,10,FOLLOW_10_in_rule609); 

                    id1=(Token)match(input,IDENT,FOLLOW_IDENT_in_rule613); 

                    match(input,9,FOLLOW_9_in_rule614); 

                    r = new Rule(new Predicate((id0!=null?id0.getText():null)),new Right<BigDecimal,Variable>(new Variable(BigDecimal.valueOf(Double.valueOf((n!=null?n.getText():null))), (id1!=null?id1.getText():null))));

                    }
                    break;
                case 4 :
                    // /Users/jkuo/PealApp-lift/antlr/PealProgram.g:98:4: '(' id0= IDENT id1= IDENT '*' n= NUMBER ')'
                    {
                    match(input,8,FOLLOW_8_in_rule621); 

                    id0=(Token)match(input,IDENT,FOLLOW_IDENT_in_rule625); 

                    id1=(Token)match(input,IDENT,FOLLOW_IDENT_in_rule629); 

                    match(input,10,FOLLOW_10_in_rule631); 

                    n=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_rule635); 

                    match(input,9,FOLLOW_9_in_rule637); 

                    r = new Rule(new Predicate((id0!=null?id0.getText():null)),new Right<BigDecimal,Variable>(new Variable(BigDecimal.valueOf(Double.valueOf((n!=null?n.getText():null))), (id1!=null?id1.getText():null))));

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
        return r;
    }
    // $ANTLR end "rule"


    public static class operator_return extends ParserRuleReturnScope {
    };


    // $ANTLR start "operator"
    // /Users/jkuo/PealApp-lift/antlr/PealProgram.g:101:1: operator : ( 'max' | 'min' | '+' | '*' );
    public final PealProgramParser.operator_return operator() throws RecognitionException {
        PealProgramParser.operator_return retval = new PealProgramParser.operator_return();
        retval.start = input.LT(1);


        try {
            // /Users/jkuo/PealApp-lift/antlr/PealProgram.g:101:10: ( 'max' | 'min' | '+' | '*' )
            // /Users/jkuo/PealApp-lift/antlr/PealProgram.g:
            {
            if ( (input.LA(1) >= 10 && input.LA(1) <= 11)||(input.LA(1) >= 27 && input.LA(1) <= 28) ) {
                input.consume();
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

            retval.stop = input.LT(-1);


        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "operator"

    // Delegated rules


 

    public static final BitSet FOLLOW_19_in_program57 = new BitSet(new long[]{0x0000000000100010L});
    public static final BitSet FOLLOW_pol_in_program63 = new BitSet(new long[]{0x0000000000100010L});
    public static final BitSet FOLLOW_20_in_program71 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_program79 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_program81 = new BitSet(new long[]{0x0000000018000010L});
    public static final BitSet FOLLOW_pSet_in_program83 = new BitSet(new long[]{0x0000000000020010L});
    public static final BitSet FOLLOW_17_in_program91 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_program101 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_program103 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_program107 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_program109 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_NUMBER_in_program113 = new BitSet(new long[]{0x0000000000050012L});
    public static final BitSet FOLLOW_IDENT_in_program127 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_program129 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_NUMBER_in_program133 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_program135 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_program139 = new BitSet(new long[]{0x0000000000050012L});
    public static final BitSet FOLLOW_IDENT_in_program149 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_program151 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_7_in_program153 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_program157 = new BitSet(new long[]{0x0000000000050012L});
    public static final BitSet FOLLOW_18_in_program167 = new BitSet(new long[]{0x000000000001EF32L});
    public static final BitSet FOLLOW_16_in_program214 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_program222 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_program224 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_program226 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_program230 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_IDENT_in_program238 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_program240 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_program242 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_program246 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_IDENT_in_program254 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_program256 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_program258 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_program262 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_IDENT_in_program271 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_program273 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_program275 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_program279 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_program283 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_IDENT_in_program292 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_program294 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_program296 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_program300 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_program304 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_IDENT_in_program314 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_program316 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_program318 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_program322 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_program326 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_IDENT_in_pSet357 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_pSet364 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_8_in_pSet366 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_pSet370 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_pSet372 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_pSet376 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_9_in_pSet378 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_pSet385 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_8_in_pSet387 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_pSet391 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_pSet393 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_pSet397 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_9_in_pSet399 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_pol424 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_pol426 = new BitSet(new long[]{0x0000000018000C00L});
    public static final BitSet FOLLOW_operator_in_pol430 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_8_in_pol432 = new BitSet(new long[]{0x0000000000000300L});
    public static final BitSet FOLLOW_rule_in_pol435 = new BitSet(new long[]{0x0000000000000300L});
    public static final BitSet FOLLOW_9_in_pol441 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_pol443 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_NUMBER_in_pol448 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NUMBER_in_pol474 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_10_in_pol476 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_pol480 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_pol506 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_pol532 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_10_in_pol534 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_NUMBER_in_pol538 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_8_in_rule570 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_rule572 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_NUMBER_in_rule574 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_9_in_rule576 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_8_in_rule583 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_rule587 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_rule591 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_9_in_rule592 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_8_in_rule599 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_rule603 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_NUMBER_in_rule607 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_10_in_rule609 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_rule613 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_9_in_rule614 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_8_in_rule621 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_rule625 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_rule629 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_10_in_rule631 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_NUMBER_in_rule635 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_9_in_rule637 = new BitSet(new long[]{0x0000000000000002L});

}