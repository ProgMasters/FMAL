package P2;

import java.beans.Statement;


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
	
	// All other methods are private methods
	
	public void parse() {
		// TODO: Initiate the parse
		Statements();
	}
	
	private void Statements() {
		token = lexer.nextToken();
		if (token.tCode == TokenCode.END) {
			System.out.println("END");
		} else {
			Statement();
			Statements();
		}
	}
	
	private void Statement() {
		token = lexer.nextToken();
		if (token.tCode == TokenCode.ID) {
			System.out.println("PUSH " + token.lexeme); // PUSH command for ID token
			
			token = lexer.nextToken();
			
			if (token.tCode == TokenCode.ASSIGN) {
				token = lexer.nextToken();
				Expr();
			} else {
				error();
			}
			
		} else if (token.tCode == TokenCode.PRINT) {
			token = lexer.nextToken();
			
			if (token.tCode == TokenCode.ID) {
				System.out.println(")
			}
		} else {
			error();
		}
	}
	
	private void Expr() {
		
	}
	
	private void Term() {
		
	}
	
	private void Factor() {
		
	}
	
	private void error() {
		System.out.println("Syntax error!");
	}
}
