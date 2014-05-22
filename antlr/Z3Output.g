grammar Z3Output;

options {
language = Java;
}

@header {
package peal.antlr;
import java.util.*;
import peal.domain.z3.*;
import peal.*;
import org.antlr.runtime.BitSet;
import peal.synthesis.*;
import peal.synthesis.analysis.*;
import peal.domain.operator.*;
}

@members {


@Override
public void reportError(RecognitionException e) {
	throw new RuntimeException(getErrorMessage(e, PealProgramParser.tokenNames)); 
}

}

@lexer::header {
package peal.antlr;
}

//it builds a map of results
results returns	[Map<String, Model> r]
@init {r = new HashMap<String, Model>();}
	: (
	'Result of analysis [' id0=IDENT '=' id1=IDENT '?' id2=IDENT (IDENT)? ']:'
	(m=model) { r.put($id0.text, $m.m);}
	)+
	;
	
model returns [Model m]
@init{ List<Assignment> l = new ArrayList<Assignment>(); }
	: 'sat' '(model' (assignment {l.add($assignment.a);})+ ')' { $m = new Model(Sat$.MODULE$, l);}
	| 'unsat' Z3ERROR { $m = new Model(Unsat$.MODULE$, l);}
//	: '(model' (define[$m])+ ')'
	;

assignment 	returns [Assignment a]
	:'(define-fun' id0=IDENT '()' id1=IDENT id2=value')' {$a = new Assignment($id0.text, $id1.text, $id2.s);}	
	|'(declare-fun' id0=IDENT '()' id1=IDENT')' {$a = new Assignment($id0.text, $id1.text, "");}	
	;	

value returns [String s]
	: IDENT {$s = $IDENT.text;}
	| NUMBER {$s = $NUMBER.text;}
	| '(' '-' unary ')' {$s = "(- " + $unary.s + ")";}
	| '(' '/' lhs=NUMBER rhs=NUMBER ')' {$s = "(/ " + $lhs.text + " " + $rhs.text + ")";}
	;	

unary returns [String s]
	: IDENT {$s = $IDENT.text;}
	| NUMBER {$s = $NUMBER.text;}
	| value {$s = $value.s;}
	;

//OPERATOR : ('-' | '/' );	
NUMBER : ('.'|'0'..'9'|'-'|'E')+;
IDENT : ('a'..'z' | 'A'..'Z')( '!' | '_' | 'a'..'z' | 'A'..'Z' | '0'..'9')*;
WS : (' ' | '\t' | '\n' | '\r' | '\f')+ { $channel = HIDDEN;};
Z3ERROR	: '(error "line ' NUMBER ' column ' NUMBER': model is not available")';
//STRING 	: IDENT WS (IDENT | WS | '=' | '"' | '?')+;
