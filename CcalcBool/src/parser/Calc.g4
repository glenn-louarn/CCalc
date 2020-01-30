grammar Calc;

// syntactic rules

program  : funcDef* body
         ;
funcDef  : '(' 'defun' head body ')'
         ;
head     : '(' functionId variableId* ')'
         ;
body     : varDef* expression
         ;
varDef   : '(' '=' variableId expression ')'
         ;
expression : INTEGER                        # IntLit
           | BOOL                           # BoolLit
           | variableId                     # Var
           | '(' '-' expression tail        # MinusExp
           | '(' OP expression expression ')' # BinExp
           | '(' 'if' expression expression expression ')' # CondExp
           | '(' functionId expression* ')' # FunCall
           ;
variableId : IDENTIFIER
           ;
functionId : IDENTIFIER
           ;
tail       : ')'
           | expression ')'
           ;

// lexical rules

OP       : '+' | '*' | '/' | '==' | '<'
         ;
BOOL     : 'true' | 'false'
         ;
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