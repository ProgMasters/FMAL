package P2;

import java.beans.Statement;


public class Parser {
	
	/*
	 * 	Statements -> Statement ; Statements | end
	 *	Statement -> id = Expr | print id
 	 * 	Expr- > Term | Term + Expr | Term � Expr
 	 * 	Term -> Factor | Factor * Term
 	 * 	Factor -> int | id | ( Expr )
	 */
	
	private Lexer lexer = new Lexer();
	private Token token;
	
	public Parser(Lexer lexer) {
		this.lexer = lexer;
	}
	
	// All other methods are private methods
	
	private void parse() {
		// TODO: Initiate the parse
		Statements();
	}
	
	private void Statements() {
		token = lexer.nextToken();
		if(token.tCode == TokenCode.END) {
			
		}
	}
	
	private void Statement() {
		
	}
	
	private void Expr() {
		
	}
	
	private void Term() {
		
	}
	
	private void Factor() {
		
	}
	
	private void error() {
		
	}
}
