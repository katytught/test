grammar calc;
compUnit : (decl|funcDef) (decl|funcDef)*;
funcDef  : (FuncType|FFuncType) Idigit '(' (funcfParams)? ')' block;
FuncType : 'int';
FFuncType:'void';
funcfParams:funcfParam (',' funcfParam)*;
funcfParam:'int' Idigit ( '['']'('['exp']')*)?;
decl : constDecl|varDecl;
constDecl : 'const' FuncType constDef ( ',' constDef )* ';';
constDef  :Idigit ( '[' constExp ']' )* '=' constInitVal;
constInitVal : constExp
                |'{' (constInitVal (',' constInitVal )* )? '}';
constExp:addexp;
varDecl : FuncType varDef ( ',' varDef )* ';';
varDef : Idigit ( '[' constExp ']' )*| Idigit ( '[' constExp ']' )* '=' initVal;
initVal:exp
        |'{' (initVal (',' initVal )* )? '}';
block    : '{' (blockItem)* '}';
blockItem: decl|stmt;
stmt     : lval '=' exp ';'
           |block|(exp)? ';'
           |'if' '(' cond ')' stmt ('else' stmt)?
           |'while' '(' cond ')' stmt
           |'break' ';'
           |'continue'';'
           |'return' (exp)? ';';
cond : lorexp;
lorexp : landexp|lorexp Orfunc landexp;
Orfunc : '||';
landexp : eqexp|landexp Andfunc eqexp;
Andfunc :'&&';
eqexp: relexp|eqexp Judgefunc relexp;
relexp:addexp|relexp Comfunc addexp;
Comfunc : '<'|'>'|'<='|'>=';
Judgefunc : '=='|'!=';
exp       :addexp;
lval :Idigit ('[' exp ']')*;
primaryexp:'(' exp ')'|lval|Number;
addexp :mulexp|addexp Addfunc mulexp;
mulexp:unaryexp|mulexp Mulfunc unaryexp;
unaryexp:primaryexp|Idigit '(' (funcrParams)? ')'|Addfunc unaryexp;
funcrParams:exp (',' exp)*;

Idigit:Nondigit(Nondigit|Digit)*;
Nondigit:'_'|'a'..'z'|'A'..'Z';
Addfunc : '+'|'-'|'!';
Mulfunc : '*'|'/'|'%';
Number             : Decimalconst | Octalconst | Hexadecimalconst;
Decimalconst      : Nonzerodigit(Nonzerodigit|'0')*;
Octalconst        : '0'Octaldigit*;
Hexadecimalconst  : Hexadecimalprefix Hexadecimaldigit*;
Hexadecimalprefix : '0x' | '0X';
Nonzerodigit      : '1' | '2' | '3' | '4' | '5' | '6' | '7' | '8' | '9';
Octaldigit        : '0' | '1' | '2' | '3' | '4' | '5' | '6' | '7';
Digit              : '0' | Nonzerodigit;
Hexadecimaldigit  : '0' | '1' | '2' | '3' | '4' | '5' | '6' | '7' | '8' | '9'
                      | 'a' | 'b' | 'c' | 'd' | 'e' | 'f'
                      | 'A' | 'B' | 'C' | 'D' | 'E' | 'F';
WHITE_SPACE: ['\t'|'\n'|' '|'\r'] -> skip; // -> skip 表示解析时跳过该规则







