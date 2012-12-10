import java.util.StringTokenizer;

public class MultiDigitPostfix {
	
	public int evaluate(String pfx, boolean hexa) throws Exception{
		Stack<Object> stack = new Stack<Object>();
		StringTokenizer st = new StringTokenizer(pfx);
		int result = 0;
		int rhs = 0;
		int lhs = 0;

		//So lange der String noch mehr Token hat
		while (st.hasMoreTokens()) {
			String token = st.nextToken();
			//Wenn der naechste Token eine Zahl ist
			if (isNumber(token) || token.equalsIgnoreCase("A") 
								|| token.equalsIgnoreCase("B")
								|| token.equalsIgnoreCase("C")
								|| token.equalsIgnoreCase("D")
								|| token.equalsIgnoreCase("E")
								|| token.equalsIgnoreCase("F")) {
				stack.push(token);
			} else{
				//Nehme die ersten beiden Token (Zahlen) vom Stack
				if(hexa) {
					rhs = Integer.parseInt(stack.pop().toString(), 16);
					lhs = Integer.parseInt(stack.pop().toString(), 16);
				}else {
					rhs = Integer.parseInt(stack.pop().toString());
					lhs = Integer.parseInt(stack.pop().toString());
				}

				//Identifiziere den Operator und berechne das Ergebnis
				if(token.equals("*")) {
					result = lhs*rhs;
				} else if(token.equals("/")) {
					result = lhs/rhs;
				} else if(token.equals("+")) {
					result = lhs+rhs;
				} else if(token.equals("-")) {
					result = lhs-rhs;
				} else if(token.equals("^")) {
					result = (int) Math.pow(lhs, rhs);
				}
				stack.push(result);
			}
		}
		System.out.println("Evaluation Ergebnis: " + result);
		return result;
	}
	
	//Aufgabe 3 ( http://geekswithblogs.net/venknar/archive/2010/07/09/algorithm-for-infix-to-postfix.aspx )
	public String infixToPostfix(String ifx) throws Exception {
		Stack<Character> stack = new Stack<Character>();
		char[] characters = ifx.toCharArray();
		String postfix = "";
		
		for(char t:characters) {
			if(Character.isDigit(t) || Character.isAlphabetic(t)) {
				postfix += t;
			}else if(t == '(') {
				stack.push(t);
			}else if(t == '+' || t == '-' || t == '*' || t == '/' || t == '^') {
				if(stack.empty()) {
					postfix += " ";
					stack.push(t);
				}else {
					while(!stack.empty() && higherPriority(stack.top(), t)) {
						postfix += " ";
						postfix += stack.pop();
					}
					postfix += " ";
					stack.push(t);
				}
			}else if(t == ')') {
				while(!stack.empty() && stack.top() != '(') {
					postfix += " ";
					postfix += stack.pop();
				}
				stack.pop();
			}	
		}
		while(!stack.empty()) {
			postfix += " ";
			postfix += stack.pop();
		}
		System.out.println("Infix to postfix Ergebnis: " + postfix);
		return postfix;
	}
	
	//Returns true if c is higher priority than c2
	private boolean higherPriority(char c, char c2) {
		if(c == '^' && c2 != '^') {
			return true;
		}else if((c == '*' || c == '/') && (c2 == '+' || c2 == '-')) {
			return true;
		}else {
			return false;
		}
	}
	
	//Returns true if input is a number
	private boolean isNumber(String input) {
	   try {
		  Integer.parseInt( input );
	      return true;
	   }catch(NumberFormatException nfe){  
	      return false;  
	   }  
	}
}
