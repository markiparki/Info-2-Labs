import java.util.Scanner;

/**
 * Ex06
 * 
 * @author jw & ma
 * @since 19.11.2012
 */

public class Postfix {

	//Aufgabe 2
	public int evaluate(String pfx) throws Exception{
		Stack<Object> stack = new Stack<Object>();
		int result = 0;
		int rhs = 0;
		int lhs = 0;
		
		char[] c = pfx.toCharArray();

		//Fuer jedes Element im Array
		for (char token:c) {
			//Wenn der nächste Token eine Zahl ist
			if (Character.isDigit(token)) {
				stack.push(token);
			} else{
				//Nehme die ersten beiden Elemente vom Stack
				rhs = Integer.parseInt(stack.pop().toString());
				lhs = Integer.parseInt(stack.pop().toString());

				//Identifiziere den Operator und berechne das Ergebnis
				if(token == '*') {
					result = lhs*rhs;
				} else if(token == '/') {
					result = lhs/rhs;
				} else if(token == '+') {
					result = lhs+rhs;
				} else if(token == '-') {
					result = lhs-rhs;
				}
				stack.push(result);
			}
		}
		return result;
	}
	
	//Aufgabe 3 ( http://geekswithblogs.net/venknar/archive/2010/07/09/algorithm-for-infix-to-postfix.aspx )
	public String infixToPostfix(String ifx) throws Exception {
		Stack<Character> stack = new Stack<Character>();
		char[] characters = ifx.toCharArray();
		String postfix = "";
		
		for(char t:characters) {
			if(Character.isDigit(t)) {
				postfix += t;
			}else if(t == '(') {
				stack.push(t);
			}else if(t == '+' || t == '-' || t == '*' || t == '/') {
				if(stack.empty()) {
					stack.push(t);
				}else {
					while(!stack.empty() && highPriority(stack.top()) && !highPriority(t)) {
						postfix += stack.pop();
					}
					stack.push(t);
				}
			}else if(t == ')') {
				while(!stack.empty() && stack.top() != '(') {
					postfix += stack.pop();
				}
				stack.pop();
			}	
		}
		while(!stack.empty()) {
			postfix += stack.pop();
		}
		return postfix;
	}
	
	private boolean highPriority(char c) {
		return (c == '*' || c == '/');
	}
	
	//Aufgabe 4
	public void evaluatePostfixUserInput() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Postfix: ");
		String userInput = sc.nextLine();
		try {
			System.out.println("Result: " + evaluate(userInput));
			sc.close();
		}catch(Exception e) {
			System.out.println("Input falsch formatiert.");
			sc.close();
		}
	}
}