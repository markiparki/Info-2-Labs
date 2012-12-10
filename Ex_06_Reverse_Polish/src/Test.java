/**
 * Ex06
 * @author jw & ma
 * @since 19.11.2012
 */

public class Test {
	
	public Test() throws Exception {
		/*Stack testStack = new Stack();
		
		System.out.println("> Push 1,2,3");
		testStack.push("1");
		System.out.println(testStack.toString());
		testStack.push("2");
		System.out.println(testStack.toString());
		testStack.push("3");
		System.out.println(testStack.toString());
		*/
		Postfix pf = new Postfix();
		try {
			//System.out.println(pf.evaluate("12-1+"));
			//pf.evaluatePostfixUserInput();
		}catch(Exception e) {}

		System.out.println(pf.evaluate(pf.infixToPostfix("1+3+4")));
	}
	
	public static void main (String[] args) throws Exception{
		new Test();
	}
}