package P2;

import java.util.Stack;


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
	
	public void parse() {
		// TODO: Initiate the parse
		Statements();
	}

	// All other methods are private methods
	
	private void Statements() {
		token = lexer.nextToken();
		if (token.tCode == TokenCode.END) {
			System.out.println("END");
		} else {
			Statement();
			token = lexer.nextToken();

			if(token.tCode != TokenCode.SEMICOL) {
				error();
			}
			
			Statements();
		}
	
	private void Statement() {
		if (token.tCode == TokenCode.ID) {
			System.out.println("PUSH " + token.lexeme); // PUSH command for ID token
			
			token = lexer.nextToken();
			
			if (token.tCode == TokenCode.ASSIGN) {
				Expr();
				System.out.println("ASSIGN");
			} else {
				error();
			}
			
		} else if (token.tCode == TokenCode.PRINT) {
			token = lexer.nextToken();
			
			if (token.tCode == TokenCode.ID) {
				System.out.println("PUSH " + token.lexeme);
			} else {
				error();
			}
			
			System.out.println("PRINT");
		} else {
			error();
		}
	}
	
	private void Expr() {
		Term();
		
		if ((token = lexer.nextToken()) != null) {
			if (token.tCode == TokenCode.PLUS) {
				Expr();
				System.out.println("ADD");
			} else if (token.tCode == TokenCode.MINUS) {
				Expr();
				System.out.println("SUB");
			}
		}
	}
	
	private void Term() {
		Factor();
		
		if ((token = lexer.nextToken()) != null) {
			if (token.tCode == TokenCode.MULT) {
				Term();
			}
		}
	}
	
	private void Factor() {
		token = lexer.nextToken();
		
		if (token.tCode == TokenCode.INT || token.tCode == TokenCode.ID) {
			System.out.println("PUSH " + token.lexeme);
		} else if (token.tCode == TokenCode.LPAREN) {
			Expr();
			
			token = lexer.nextToken();
			if (token.tCode != TokenCode.RPAREN) {
				error();
			}
		} else {
			error();
		}
	}
	
	private void error() {
		System.out.println("Syntax error!");
	}
}
