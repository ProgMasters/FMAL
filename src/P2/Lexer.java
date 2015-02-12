package P2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import P2.Token.TokenCode;

public class Lexer {
	public static Scanner in = new Scanner(System.in);
	private static Queue<Token> tokenList = new LinkedList<Token>(); //Queue which stores all the tokens;
	
	//Constructor, simply gets the input
	public Lexer() {
		getInput();
	}
	
	//Returns the next token in the tokenList
	public Token nextToken() {
		return tokenList.poll();
			
	}
	
	private void getInput() {
		String input = "";
		while(in.hasNext()) {
			input += in.next() + " ";
		}
		
		lex(input);
	}
	
	//Does all the calculation wich token is to use
	private static void lex(String tokens) {
		for(int i = 0; i < tokens.length(); i++) {
			
			switch(tokens.charAt(i)) {
			case '(':
				tokenList.add(new Token(TokenCode.LPAREN, "("));
				break;
			case ')':
				tokenList.add(new Token(TokenCode.RPAREN, ")"));
				break;
			case '+':
				tokenList.add(new Token(TokenCode.PLUS, "+"));
				break;
			case '-':
				tokenList.add(new Token(TokenCode.MINUS, "-"));
				break;
			case '*':
				tokenList.add(new Token(TokenCode.MULT, "*"));
				break;
			case '=':
				tokenList.add(new Token(TokenCode.ASSIGN, "="));
				break;
			case ';':
				tokenList.add(new Token(TokenCode.SEMICOL, ";"));
				break;
			case ' ':
				break;
			default:
				String token = "", first = "";
				first += tokens.charAt(i); //gets the first char of the token to decide which token it should be
				
				if(first.matches("[0-9]")) {	//if the token should be INT
					while(i < tokens.length() ) {
						
						if((tokens.charAt(i + 1) == '+' || tokens.charAt(i + 1) == '-' || tokens.charAt(i + 1) == '*' || tokens.charAt(i + 1) == '(' ||
								tokens.charAt(i + 1) == ')' || tokens.charAt(i + 1) == '=' || tokens.charAt(i + 1) == ';' || tokens.charAt(i + 1) == ' ' ||
								i == token.length() - 1)){
							tokenList.add(new Token(TokenCode.INT, token));
							break;
						}
						
						if(token.matches("[0-9]+[A-Za-z]")){	//if there is invalid token e.x. 1temp
							tokenList.add(new Token(TokenCode.ERROR, "ERROR"));
							break;
						}
						
						token += tokens.charAt(i);
						i++;
					}	
				}

				else if(first.matches("[A-Za-z]")) { 	//if the token should be ID or PRINT or END
					while(i < tokens.length()) {
						token += tokens.charAt(i);
						
						if(i == tokens.length() -1 || tokens.charAt(i + 1) == '+' || tokens.charAt(i + 1) == '-' || tokens.charAt(i + 1) == '*' || 
								tokens.charAt(i + 1) == '(' || tokens.charAt(i + 1) == ')' || tokens.charAt(i + 1) == '=' || tokens.charAt(i + 1) == ';'  ||
								tokens.charAt(i + 1) == ' '){
							
							if(token.matches("print")) {
								tokenList.add(new Token(TokenCode.PRINT, token));
								break;
							}
							
							else if(token.matches("end")) {
								tokenList.add(new Token(TokenCode.END, token));
								break;
							}
							else {
								tokenList.add(new Token(TokenCode.ID, token));
								break;
							}
						}
						
						if(token.matches("[A-Za-z]+[0-9]")) {	//Invalid token
							tokenList.add(new Token(TokenCode.ERROR, "ERROR"));
							break;
						}
						
						i++;
						
					}
				}
				else {	//Else the token i not recognized
					tokenList.add(new Token(TokenCode.ERROR, "ERROR"));
					break;
				}
				
			}
		}
	}
	
	public static void main(String[] args) {
		Lexer lex = new Lexer();
		
		while(!lex.tokenList.isEmpty()) {
			System.out.println("token " + lex.nextToken());
		}
	}
}