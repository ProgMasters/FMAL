package P2;

enum TokenCode { 
	ID, ASSIGN, SEMICOL, INT, 
	PLUS, MINUS, MULT, LPAREN, 
	RPAREN, PRINT, END, ERROR
}

public class Token {
	public String lexeme;
	public TokenCode tCode;
	
	
}
