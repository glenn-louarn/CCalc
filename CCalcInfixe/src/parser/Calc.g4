grammar Calc;

// syntactic rules

program  : funcDef* body
         ;
funcDef  : '(' 'defun' head body ')'
         ;
head     : '(' functionId variableId* ')'
         ;
body     : varDef* expression EOF
         ;
varDef   : '(' '=' variableId expression ')'
         ;
expression : INTEGER                        # IntLit
           | BOOLEAN                        # BoolLit
           | variableId                     # Var
           | ('!' | '-') expression        # UnExp
           | expression ('*' | '/') expression # BinExp
           | expression ('+' | '-') expression # BinExp
           | expression ('<' | '>' | '<=' | '>=') expression # BinExp
           | expression ('==' | '!=') expression # BinExp
           | expression ('&&') expression # BinExp
           | expression ('||') expression # BinExp
           | <assoc = right> expression '?' expression ':' expression # CondExp
           | '(' expression ')' # ParExp
           | '(' functionId expression* ')' # FunCall
           ;
variableId : IDENTIFIER
           ;
functionId : IDENTIFIER
           ;

// lexical rules
BOOLEAN : 'true' | 'false';

IDENTIFIER : ('a'..'z')('a'..'z' | '0'..'9')*
         ;
INTEGER  : '0' | ('1'..'9')('0'..'9')*
         ;
WS
    :   [ \t\r\n]+ -> channel(HIDDEN)
    ;
LINE_COMMENT
  :  '//' ~'\n'* '\n'
  ;