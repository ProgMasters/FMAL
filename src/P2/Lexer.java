package P2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import java.util.regex.*;

import P2.Token.TokenCode;

public class Lexer {
	public static Scanner in = new Scanner(System.in);
	private static Queue<Token> tokenList = new LinkedList<Token>();
	
	public Lexer() {
		getInput();
	}
	
	public Token nextToken() {
		Token token = tokenList.poll();
		return token;
			
	}
	
	private void getInput() {
		String input = "";
		while(in.hasNext()) {
			input += in.next() + " ";
		}
		lex(input);
	}
	
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
				first += tokens.charAt(i);
				
				if(first.matches("[0-9]")) {
					while(i < tokens.length() ) {
						if((tokens.charAt(i + 1) == '+' || tokens.charAt(i + 1) == '-' || tokens.charAt(i + 1) == '*' || tokens.charAt(i + 1) == '(' ||
								tokens.charAt(i + 1) == ')' || tokens.charAt(i + 1) == '=' || tokens.charAt(i + 1) == ';' || tokens.charAt(i + 1) == ' ' ||
								i == token.length() - 1)){
							tokenList.add(new Token(TokenCode.INT, token));
							break;
						}
						
						if(token.matches("[0-9]+[A-Za-z]")){
							tokenList.add(new Token(TokenCode.ERROR, ""));
							break;
						}
						
						token += tokens.charAt(i);
						i++;
					}	
				}

				else if(first.matches("[A-Za-z]")) {
					while(i < tokens.length()) {
						if((tokens.charAt(i + 1) == '+' || tokens.charAt(i + 1) == '-' || tokens.charAt(i + 1) == '*' || tokens.charAt(i + 1) == '(' ||
								tokens.charAt(i + 1) == ')' || tokens.charAt(i + 1) == '=' || tokens.charAt(i + 1) == ';' || tokens.charAt(i + 1) == ' ' ||
								i == token.length() - 1)){
							tokenList.add(new Token(TokenCode.ID, token));
							break;
						}
						
						if(token.matches("[A-Za-z]+[0-9]")) {
							tokenList.add(new Token(TokenCode.ERROR, ""));
							break;
						}

						token += tokens.charAt(i);
						i++;
					}
				}
				else {
					tokenList.add(new Token(TokenCode.ERROR, ""));
					break;
				}
				
			}
		}
	}
	
	public static void main(String[] args) {
		Lexer lex = new Lexer();
		System.out.println("token " + lex.nextToken());
		System.out.println("token " + lex.nextToken());	
		System.out.println("token " + lex.nextToken());
		System.out.println("token " + lex.nextToken());
		System.out.println("token " + lex.nextToken());
		System.out.println("token " + lex.nextToken());	
		System.out.println("token " + lex.nextToken());
		System.out.println("token " + lex.nextToken());
		System.out.println("token " + lex.nextToken());
		System.out.println("token " + lex.nextToken());
		System.out.println("token " + lex.nextToken());
		System.out.println("token " + lex.nextToken());	
		System.out.println("token " + lex.nextToken());
		System.out.println("token " + lex.nextToken());	
	}
}