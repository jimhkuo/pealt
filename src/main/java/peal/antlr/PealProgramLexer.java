// $ANTLR 3.4 /Users/jkuo/PealApp-lift/antlr/PealProgram.g 2013-07-11 18:50:25

package peal.antlr;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class PealProgramLexer extends Lexer {
    public static final int EOF=-1;
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
    public static final int COMPARE=4;
    public static final int IDENT=5;
    public static final int NEWLINE=6;
    public static final int NUMBER=7;
    public static final int WS=8;

    // delegates
    // delegators
    public Lexer[] getDelegates() {
        return new Lexer[] {};
    }

    public PealProgramLexer() {} 
    public PealProgramLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public PealProgramLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);
    }
    public String getGrammarFileName() { return "/Users/jkuo/PealApp-lift/antlr/PealProgram.g"; }

    // $ANTLR start "T__9"
    public final void mT__9() throws RecognitionException {
        try {
            int _type = T__9;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/jkuo/PealApp-lift/antlr/PealProgram.g:11:6: ( '(' )
            // /Users/jkuo/PealApp-lift/antlr/PealProgram.g:11:8: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__9"

    // $ANTLR start "T__10"
    public final void mT__10() throws RecognitionException {
        try {
            int _type = T__10;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/jkuo/PealApp-lift/antlr/PealProgram.g:12:7: ( ')' )
            // /Users/jkuo/PealApp-lift/antlr/PealProgram.g:12:9: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__10"

    // $ANTLR start "T__11"
    public final void mT__11() throws RecognitionException {
        try {
            int _type = T__11;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/jkuo/PealApp-lift/antlr/PealProgram.g:13:7: ( '*' )
            // /Users/jkuo/PealApp-lift/antlr/PealProgram.g:13:9: '*'
            {
            match('*'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__11"

    // $ANTLR start "T__12"
    public final void mT__12() throws RecognitionException {
        try {
            int _type = T__12;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/jkuo/PealApp-lift/antlr/PealProgram.g:14:7: ( '+' )
            // /Users/jkuo/PealApp-lift/antlr/PealProgram.g:14:9: '+'
            {
            match('+'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__12"

    // $ANTLR start "T__13"
    public final void mT__13() throws RecognitionException {
        try {
            int _type = T__13;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/jkuo/PealApp-lift/antlr/PealProgram.g:15:7: ( ',' )
            // /Users/jkuo/PealApp-lift/antlr/PealProgram.g:15:9: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__13"

    // $ANTLR start "T__14"
    public final void mT__14() throws RecognitionException {
        try {
            int _type = T__14;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/jkuo/PealApp-lift/antlr/PealProgram.g:16:7: ( '<' )
            // /Users/jkuo/PealApp-lift/antlr/PealProgram.g:16:9: '<'
            {
            match('<'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__14"

    // $ANTLR start "T__15"
    public final void mT__15() throws RecognitionException {
        try {
            int _type = T__15;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/jkuo/PealApp-lift/antlr/PealProgram.g:17:7: ( '<=' )
            // /Users/jkuo/PealApp-lift/antlr/PealProgram.g:17:9: '<='
            {
            match("<="); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__15"

    // $ANTLR start "T__16"
    public final void mT__16() throws RecognitionException {
        try {
            int _type = T__16;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/jkuo/PealApp-lift/antlr/PealProgram.g:18:7: ( '=' )
            // /Users/jkuo/PealApp-lift/antlr/PealProgram.g:18:9: '='
            {
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__16"

    // $ANTLR start "T__17"
    public final void mT__17() throws RecognitionException {
        try {
            int _type = T__17;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/jkuo/PealApp-lift/antlr/PealProgram.g:19:7: ( 'ANALYSES' )
            // /Users/jkuo/PealApp-lift/antlr/PealProgram.g:19:9: 'ANALYSES'
            {
            match("ANALYSES"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__17"

    // $ANTLR start "T__18"
    public final void mT__18() throws RecognitionException {
        try {
            int _type = T__18;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/jkuo/PealApp-lift/antlr/PealProgram.g:20:7: ( 'always_false?' )
            // /Users/jkuo/PealApp-lift/antlr/PealProgram.g:20:9: 'always_false?'
            {
            match("always_false?"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__18"

    // $ANTLR start "T__19"
    public final void mT__19() throws RecognitionException {
        try {
            int _type = T__19;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/jkuo/PealApp-lift/antlr/PealProgram.g:21:7: ( 'always_true?' )
            // /Users/jkuo/PealApp-lift/antlr/PealProgram.g:21:9: 'always_true?'
            {
            match("always_true?"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__19"

    // $ANTLR start "T__20"
    public final void mT__20() throws RecognitionException {
        try {
            int _type = T__20;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/jkuo/PealApp-lift/antlr/PealProgram.g:22:7: ( 'default' )
            // /Users/jkuo/PealApp-lift/antlr/PealProgram.g:22:9: 'default'
            {
            match("default"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__20"

    // $ANTLR start "T__21"
    public final void mT__21() throws RecognitionException {
        try {
            int _type = T__21;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/jkuo/PealApp-lift/antlr/PealProgram.g:23:7: ( 'difference?' )
            // /Users/jkuo/PealApp-lift/antlr/PealProgram.g:23:9: 'difference?'
            {
            match("difference?"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__21"

    // $ANTLR start "T__22"
    public final void mT__22() throws RecognitionException {
        try {
            int _type = T__22;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/jkuo/PealApp-lift/antlr/PealProgram.g:24:7: ( 'equivalence?' )
            // /Users/jkuo/PealApp-lift/antlr/PealProgram.g:24:9: 'equivalence?'
            {
            match("equivalence?"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__22"

    // $ANTLR start "T__23"
    public final void mT__23() throws RecognitionException {
        try {
            int _type = T__23;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/jkuo/PealApp-lift/antlr/PealProgram.g:25:7: ( 'max' )
            // /Users/jkuo/PealApp-lift/antlr/PealProgram.g:25:9: 'max'
            {
            match("max"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__23"

    // $ANTLR start "T__24"
    public final void mT__24() throws RecognitionException {
        try {
            int _type = T__24;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/jkuo/PealApp-lift/antlr/PealProgram.g:26:7: ( 'min' )
            // /Users/jkuo/PealApp-lift/antlr/PealProgram.g:26:9: 'min'
            {
            match("min"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__24"

    // $ANTLR start "T__25"
    public final void mT__25() throws RecognitionException {
        try {
            int _type = T__25;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/jkuo/PealApp-lift/antlr/PealProgram.g:27:7: ( 'satisfiable?' )
            // /Users/jkuo/PealApp-lift/antlr/PealProgram.g:27:9: 'satisfiable?'
            {
            match("satisfiable?"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__25"

    // $ANTLR start "NUMBER"
    public final void mNUMBER() throws RecognitionException {
        try {
            int _type = NUMBER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/jkuo/PealApp-lift/antlr/PealProgram.g:78:8: ( ( '.' | '0' .. '9' | '-' | 'E' )+ )
            // /Users/jkuo/PealApp-lift/antlr/PealProgram.g:78:10: ( '.' | '0' .. '9' | '-' | 'E' )+
            {
            // /Users/jkuo/PealApp-lift/antlr/PealProgram.g:78:10: ( '.' | '0' .. '9' | '-' | 'E' )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0 >= '-' && LA1_0 <= '.')||(LA1_0 >= '0' && LA1_0 <= '9')||LA1_0=='E') ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // /Users/jkuo/PealApp-lift/antlr/PealProgram.g:
            	    {
            	    if ( (input.LA(1) >= '-' && input.LA(1) <= '.')||(input.LA(1) >= '0' && input.LA(1) <= '9')||input.LA(1)=='E' ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "NUMBER"

    // $ANTLR start "COMPARE"
    public final void mCOMPARE() throws RecognitionException {
        try {
            int _type = COMPARE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/jkuo/PealApp-lift/antlr/PealProgram.g:79:9: ( ( '>' | '>=' | '<' | '<=' ) )
            // /Users/jkuo/PealApp-lift/antlr/PealProgram.g:79:11: ( '>' | '>=' | '<' | '<=' )
            {
            // /Users/jkuo/PealApp-lift/antlr/PealProgram.g:79:11: ( '>' | '>=' | '<' | '<=' )
            int alt2=4;
            int LA2_0 = input.LA(1);

            if ( (LA2_0=='>') ) {
                int LA2_1 = input.LA(2);

                if ( (LA2_1=='=') ) {
                    alt2=2;
                }
                else {
                    alt2=1;
                }
            }
            else if ( (LA2_0=='<') ) {
                int LA2_2 = input.LA(2);

                if ( (LA2_2=='=') ) {
                    alt2=4;
                }
                else {
                    alt2=3;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;

            }
            switch (alt2) {
                case 1 :
                    // /Users/jkuo/PealApp-lift/antlr/PealProgram.g:79:12: '>'
                    {
                    match('>'); 

                    }
                    break;
                case 2 :
                    // /Users/jkuo/PealApp-lift/antlr/PealProgram.g:79:18: '>='
                    {
                    match(">="); 



                    }
                    break;
                case 3 :
                    // /Users/jkuo/PealApp-lift/antlr/PealProgram.g:79:25: '<'
                    {
                    match('<'); 

                    }
                    break;
                case 4 :
                    // /Users/jkuo/PealApp-lift/antlr/PealProgram.g:79:31: '<='
                    {
                    match("<="); 



                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "COMPARE"

    // $ANTLR start "NEWLINE"
    public final void mNEWLINE() throws RecognitionException {
        try {
            int _type = NEWLINE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/jkuo/PealApp-lift/antlr/PealProgram.g:80:8: ( ( '\\r' )? '\\n' )
            // /Users/jkuo/PealApp-lift/antlr/PealProgram.g:80:9: ( '\\r' )? '\\n'
            {
            // /Users/jkuo/PealApp-lift/antlr/PealProgram.g:80:9: ( '\\r' )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0=='\r') ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // /Users/jkuo/PealApp-lift/antlr/PealProgram.g:80:9: '\\r'
                    {
                    match('\r'); 

                    }
                    break;

            }


            match('\n'); 

             _channel = HIDDEN;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "NEWLINE"

    // $ANTLR start "IDENT"
    public final void mIDENT() throws RecognitionException {
        try {
            int _type = IDENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/jkuo/PealApp-lift/antlr/PealProgram.g:81:7: ( ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' )* )
            // /Users/jkuo/PealApp-lift/antlr/PealProgram.g:81:9: ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' )*
            {
            if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            // /Users/jkuo/PealApp-lift/antlr/PealProgram.g:81:30: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0 >= '0' && LA4_0 <= '9')||(LA4_0 >= 'A' && LA4_0 <= 'Z')||(LA4_0 >= 'a' && LA4_0 <= 'z')) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // /Users/jkuo/PealApp-lift/antlr/PealProgram.g:
            	    {
            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "IDENT"

    // $ANTLR start "WS"
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/jkuo/PealApp-lift/antlr/PealProgram.g:82:4: ( ( ' ' | '\\t' | '\\n' | '\\r' | '\\f' )+ )
            // /Users/jkuo/PealApp-lift/antlr/PealProgram.g:82:6: ( ' ' | '\\t' | '\\n' | '\\r' | '\\f' )+
            {
            // /Users/jkuo/PealApp-lift/antlr/PealProgram.g:82:6: ( ' ' | '\\t' | '\\n' | '\\r' | '\\f' )+
            int cnt5=0;
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0 >= '\t' && LA5_0 <= '\n')||(LA5_0 >= '\f' && LA5_0 <= '\r')||LA5_0==' ') ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // /Users/jkuo/PealApp-lift/antlr/PealProgram.g:
            	    {
            	    if ( (input.LA(1) >= '\t' && input.LA(1) <= '\n')||(input.LA(1) >= '\f' && input.LA(1) <= '\r')||input.LA(1)==' ' ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt5 >= 1 ) break loop5;
                        EarlyExitException eee =
                            new EarlyExitException(5, input);
                        throw eee;
                }
                cnt5++;
            } while (true);


             _channel = HIDDEN;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "WS"

    public void mTokens() throws RecognitionException {
        // /Users/jkuo/PealApp-lift/antlr/PealProgram.g:1:8: ( T__9 | T__10 | T__11 | T__12 | T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | NUMBER | COMPARE | NEWLINE | IDENT | WS )
        int alt6=22;
        alt6 = dfa6.predict(input);
        switch (alt6) {
            case 1 :
                // /Users/jkuo/PealApp-lift/antlr/PealProgram.g:1:10: T__9
                {
                mT__9(); 


                }
                break;
            case 2 :
                // /Users/jkuo/PealApp-lift/antlr/PealProgram.g:1:15: T__10
                {
                mT__10(); 


                }
                break;
            case 3 :
                // /Users/jkuo/PealApp-lift/antlr/PealProgram.g:1:21: T__11
                {
                mT__11(); 


                }
                break;
            case 4 :
                // /Users/jkuo/PealApp-lift/antlr/PealProgram.g:1:27: T__12
                {
                mT__12(); 


                }
                break;
            case 5 :
                // /Users/jkuo/PealApp-lift/antlr/PealProgram.g:1:33: T__13
                {
                mT__13(); 


                }
                break;
            case 6 :
                // /Users/jkuo/PealApp-lift/antlr/PealProgram.g:1:39: T__14
                {
                mT__14(); 


                }
                break;
            case 7 :
                // /Users/jkuo/PealApp-lift/antlr/PealProgram.g:1:45: T__15
                {
                mT__15(); 


                }
                break;
            case 8 :
                // /Users/jkuo/PealApp-lift/antlr/PealProgram.g:1:51: T__16
                {
                mT__16(); 


                }
                break;
            case 9 :
                // /Users/jkuo/PealApp-lift/antlr/PealProgram.g:1:57: T__17
                {
                mT__17(); 


                }
                break;
            case 10 :
                // /Users/jkuo/PealApp-lift/antlr/PealProgram.g:1:63: T__18
                {
                mT__18(); 


                }
                break;
            case 11 :
                // /Users/jkuo/PealApp-lift/antlr/PealProgram.g:1:69: T__19
                {
                mT__19(); 


                }
                break;
            case 12 :
                // /Users/jkuo/PealApp-lift/antlr/PealProgram.g:1:75: T__20
                {
                mT__20(); 


                }
                break;
            case 13 :
                // /Users/jkuo/PealApp-lift/antlr/PealProgram.g:1:81: T__21
                {
                mT__21(); 


                }
                break;
            case 14 :
                // /Users/jkuo/PealApp-lift/antlr/PealProgram.g:1:87: T__22
                {
                mT__22(); 


                }
                break;
            case 15 :
                // /Users/jkuo/PealApp-lift/antlr/PealProgram.g:1:93: T__23
                {
                mT__23(); 


                }
                break;
            case 16 :
                // /Users/jkuo/PealApp-lift/antlr/PealProgram.g:1:99: T__24
                {
                mT__24(); 


                }
                break;
            case 17 :
                // /Users/jkuo/PealApp-lift/antlr/PealProgram.g:1:105: T__25
                {
                mT__25(); 


                }
                break;
            case 18 :
                // /Users/jkuo/PealApp-lift/antlr/PealProgram.g:1:111: NUMBER
                {
                mNUMBER(); 


                }
                break;
            case 19 :
                // /Users/jkuo/PealApp-lift/antlr/PealProgram.g:1:118: COMPARE
                {
                mCOMPARE(); 


                }
                break;
            case 20 :
                // /Users/jkuo/PealApp-lift/antlr/PealProgram.g:1:126: NEWLINE
                {
                mNEWLINE(); 


                }
                break;
            case 21 :
                // /Users/jkuo/PealApp-lift/antlr/PealProgram.g:1:134: IDENT
                {
                mIDENT(); 


                }
                break;
            case 22 :
                // /Users/jkuo/PealApp-lift/antlr/PealProgram.g:1:140: WS
                {
                mWS(); 


                }
                break;

        }

    }


    protected DFA6 dfa6 = new DFA6(this);
    static final String DFA6_eotS =
        "\6\uffff\1\26\1\uffff\6\23\1\22\1\uffff\1\24\1\40\5\uffff\10\23"+
        "\1\22\2\uffff\5\23\1\57\1\60\6\23\2\uffff\16\23\1\uffff\1\107\3"+
        "\23\1\113\3\uffff\3\23\1\uffff\6\23\1\uffff\2\23\2\uffff";
    static final String DFA6_eofS =
        "\127\uffff";
    static final String DFA6_minS =
        "\1\11\5\uffff\1\75\1\uffff\1\116\1\154\1\145\1\161\2\141\1\60\1"+
        "\uffff\1\12\1\11\5\uffff\1\101\1\167\2\146\1\165\1\170\1\156\1\164"+
        "\1\60\2\uffff\1\114\2\141\1\146\1\151\2\60\1\151\1\131\1\171\1\165"+
        "\1\145\1\166\2\uffff\1\163\1\123\1\163\1\154\1\162\1\141\1\146\1"+
        "\105\1\137\1\164\1\145\1\154\1\151\1\123\1\146\1\60\1\156\1\145"+
        "\1\141\1\60\3\uffff\1\143\1\156\1\142\1\uffff\1\145\1\143\1\154"+
        "\1\77\2\145\1\uffff\2\77\2\uffff";
    static final String DFA6_maxS =
        "\1\172\5\uffff\1\75\1\uffff\1\116\1\154\1\151\1\161\1\151\1\141"+
        "\1\172\1\uffff\1\12\1\40\5\uffff\1\101\1\167\2\146\1\165\1\170\1"+
        "\156\1\164\1\172\2\uffff\1\114\2\141\1\146\1\151\2\172\1\151\1\131"+
        "\1\171\1\165\1\145\1\166\2\uffff\1\163\1\123\1\163\1\154\1\162\1"+
        "\141\1\146\1\105\1\137\1\164\1\145\1\154\1\151\1\123\1\164\1\172"+
        "\1\156\1\145\1\141\1\172\3\uffff\1\143\1\156\1\142\1\uffff\1\145"+
        "\1\143\1\154\1\77\2\145\1\uffff\2\77\2\uffff";
    static final String DFA6_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\1\5\1\uffff\1\10\7\uffff\1\23\2\uffff\1"+
        "\22\1\25\1\26\1\7\1\6\11\uffff\1\24\1\7\15\uffff\1\17\1\20\24\uffff"+
        "\1\12\1\13\1\14\3\uffff\1\11\6\uffff\1\15\2\uffff\1\16\1\21";
    static final String DFA6_specialS =
        "\127\uffff}>";
    static final String[] DFA6_transitionS = {
            "\1\24\1\21\1\uffff\1\24\1\20\22\uffff\1\24\7\uffff\1\1\1\2\1"+
            "\3\1\4\1\5\2\22\1\uffff\12\22\2\uffff\1\6\1\7\1\17\2\uffff\1"+
            "\10\3\23\1\16\25\23\6\uffff\1\11\2\23\1\12\1\13\7\23\1\14\5"+
            "\23\1\15\7\23",
            "",
            "",
            "",
            "",
            "",
            "\1\25",
            "",
            "\1\27",
            "\1\30",
            "\1\31\3\uffff\1\32",
            "\1\33",
            "\1\34\7\uffff\1\35",
            "\1\36",
            "\12\37\7\uffff\4\23\1\37\25\23\6\uffff\32\23",
            "",
            "\1\21",
            "\2\24\1\uffff\2\24\22\uffff\1\24",
            "",
            "",
            "",
            "",
            "",
            "\1\42",
            "\1\43",
            "\1\44",
            "\1\45",
            "\1\46",
            "\1\47",
            "\1\50",
            "\1\51",
            "\12\37\7\uffff\4\23\1\37\25\23\6\uffff\32\23",
            "",
            "",
            "\1\52",
            "\1\53",
            "\1\54",
            "\1\55",
            "\1\56",
            "\12\23\7\uffff\32\23\6\uffff\32\23",
            "\12\23\7\uffff\32\23\6\uffff\32\23",
            "\1\61",
            "\1\62",
            "\1\63",
            "\1\64",
            "\1\65",
            "\1\66",
            "",
            "",
            "\1\67",
            "\1\70",
            "\1\71",
            "\1\72",
            "\1\73",
            "\1\74",
            "\1\75",
            "\1\76",
            "\1\77",
            "\1\100",
            "\1\101",
            "\1\102",
            "\1\103",
            "\1\104",
            "\1\105\15\uffff\1\106",
            "\12\23\7\uffff\32\23\6\uffff\32\23",
            "\1\110",
            "\1\111",
            "\1\112",
            "\12\23\7\uffff\32\23\6\uffff\32\23",
            "",
            "",
            "",
            "\1\114",
            "\1\115",
            "\1\116",
            "",
            "\1\117",
            "\1\120",
            "\1\121",
            "\1\122",
            "\1\123",
            "\1\124",
            "",
            "\1\125",
            "\1\126",
            "",
            ""
    };

    static final short[] DFA6_eot = DFA.unpackEncodedString(DFA6_eotS);
    static final short[] DFA6_eof = DFA.unpackEncodedString(DFA6_eofS);
    static final char[] DFA6_min = DFA.unpackEncodedStringToUnsignedChars(DFA6_minS);
    static final char[] DFA6_max = DFA.unpackEncodedStringToUnsignedChars(DFA6_maxS);
    static final short[] DFA6_accept = DFA.unpackEncodedString(DFA6_acceptS);
    static final short[] DFA6_special = DFA.unpackEncodedString(DFA6_specialS);
    static final short[][] DFA6_transition;

    static {
        int numStates = DFA6_transitionS.length;
        DFA6_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA6_transition[i] = DFA.unpackEncodedString(DFA6_transitionS[i]);
        }
    }

    class DFA6 extends DFA {

        public DFA6(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 6;
            this.eot = DFA6_eot;
            this.eof = DFA6_eof;
            this.min = DFA6_min;
            this.max = DFA6_max;
            this.accept = DFA6_accept;
            this.special = DFA6_special;
            this.transition = DFA6_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__9 | T__10 | T__11 | T__12 | T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | NUMBER | COMPARE | NEWLINE | IDENT | WS );";
        }
    }
 

}