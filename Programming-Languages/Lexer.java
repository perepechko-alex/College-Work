//Alex Perepechko
//Programming Languages
//Lexical Analyzer

import java.util.List;
import java.util.ArrayList;
import java.util.regex.*;

public class Lexer {
	//Regex ident = new Regex("([a-zA-Z_$][a-zA-Z\\d_$]*\\.)*[a-zA-Z_$][a-zA-Z\\d_$]*");

    public static enum Type {
        STATEMENT, RELATOINAL, PUNCTUATION, VAR, READ, WRITE, CONDITIONAL, LOOP, NUM, LPAREN, RPAREN, LBRACE,
        RBRACE,LBRACK, RBRACK, OPERATOR, ATOM, IDENTIFIER;
    }

    public static class Token {
        public final Type t;
        public final String c; // contents mainly for atomic tokens

        public Token(Type t, String c) {
            this.t = t;
            this.c = c;
        }
        public String toString() {
            if(t == Type.VAR) {
                return "IDENTIFIER<" + c + ">";
            }
            return t.toString();
        }
    }

    public static String getVar(String s, int i) {
        int j = i;
        for( ; j < s.length(); ) {
            if(Character.isLetter(s.charAt(j))) {
                j++;
            } else {
                return s.substring(i, j);
            }
        }
        return s.substring(i, j);
    }

    public static List<Token> lex(String input) {
        List<Token> result = new ArrayList<Token>();
        for(int i = 0; i < input.length(); ) {

            switch(input.charAt(i)) {
            case '(':
                result.add(new Token(Type.LPAREN, "("));
                i++;
                break;
            case ')':
                result.add(new Token(Type.RPAREN, ")"));
                i++;
                break;
            case '{':
            	 result.add(new Token(Type.LBRACE, "{"));
                 i++;
                 break;
            case '}':
            	 result.add(new Token(Type.RBRACE, "}"));
                 i++;
                 break;
            case '*': case '/': case '+': case '-':
            	result.add(new Token(Type.OPERATOR, "[*|/|+|-]"));
                i++;
                break;
            case '0': case '1': case '2': case '3': case '4': case '5': case '6': case '7': case '8': case '9':
              	result.add(new Token(Type.NUM, "-?[0-9]+"));
              	i++;
              	break;
            case ';': case ',': case ':': case '.':
            	result.add(new Token(Type.PUNCTUATION, "[;|,|:|.]"));
            	i++;
            	break;

            case '=':  case '>': case '<': case '!':
            	result.add(new Token(Type.RELATOINAL, "[=|>|<|!]"));
            	i++;
            	break;

            case '[':
            	result.add(new Token(Type.LBRACK, "["));
            	i++;
            	break;

            case ']':
            	result.add(new Token(Type.RBRACK, "]"));
            	i++;
            	break;

            default:
                if(Character.isWhitespace(input.charAt(i)))
                    i++;

                else {
                    String atom = getVar(input, i);
                    i += atom.length();
                    String patternString = 	"([a-zA-Z_$][a-zA-Z\\d_$]*\\.)*[a-zA-Z_$][a-zA-Z\\d_$]*";
                	Pattern pattern = Pattern.compile(patternString);
                	Matcher matcher = pattern.matcher(atom);

                	if (matcher.find() && atom.contains("for") == false && atom.contains("if") == false
                		&& atom.contains("write") == false && atom.contains("read") == false &&
                		atom.contains("then") == false && atom.contains("else") == false
                		&& atom.contains("while") == false && atom.contains("is") == false
                		&& atom.contains("not") == false && atom.contains("begin") == false
                		&& atom.contains("end") == false)
                    	{
                    		result.add(new Token(Type.VAR, atom)); //identifier
                    	}
                    if(atom.indexOf("if") != -1 || atom.indexOf("then") != -1 || atom.indexOf("else") != -1)
                    	result.add(new Token(Type.CONDITIONAL, atom));

                    if(atom.indexOf("for") != -1 || atom.indexOf("while") != -1)
                    	result.add(new Token(Type.LOOP, atom));

                    if (atom.indexOf("read") != -1)
                    	result.add(new Token(Type.READ, atom));

                    if (atom.indexOf("write") != -1)
                    	result.add(new Token(Type.WRITE, atom));

                    if (atom.indexOf("is") != -1 || atom.indexOf("not") != -1)
                    	result.add(new Token(Type.RELATOINAL, atom));

                    if (atom.indexOf("begin") != -1 || atom.indexOf("end") != -1)
                    	result.add(new Token(Type.STATEMENT, atom));


                }
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        if(args.length < 1) {
            System.out.println("Please Enter Arguments");
            return;
        }
        List<Token> tokens = lex(args[0]);
        for(Token t : tokens) {
            System.out.println(t);
        }
    }
}
