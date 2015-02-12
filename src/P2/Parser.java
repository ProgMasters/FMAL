package P2;

public class Parser {
	
	/*
	 * 	Statements -> Statement ; Statements | end
	 *	Statement -> id = Expr | print id
 	 * 	Expr- > Term | Term + Expr | Term – Expr
 	 * 	Term -> Factor | Factor * Term
 	 * 	Factor -> int | id | ( Expr )
	 */
	
	private Lexer lexer = new Lexer();
	private Token token;
	
	public Parser(Lexer lexer) {
		this.lexer = lexer;
	}
	
	//All other methods are private methods
	
	public void parse() {
		//TODO: Initiate the parse
	}
}
