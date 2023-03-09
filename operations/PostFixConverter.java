package operations;
import java.util.Stack;

public class PostFixConverter {
	
	Stack<Double> st = new Stack<>();
	double result;
	
	public PostFixConverter(Stack<String>postFix) {	
	postFix=reverseStack(postFix);
		while(!isStackEmpty(postFix)) {
			switch(postFix.peek()){	
			case "+":	
				st.push(st.pop()+st.pop());
				postFix.pop();
				break;
			case "-":
				double tmp=st.pop();
				st.push(st.pop()-tmp);
				postFix.pop();
				break;
			case "*":
				st.push(st.pop()*st.pop());
				postFix.pop();
				break;
			case "/":
				double tmp2=st.pop();
				st.push(st.pop()/tmp2);
				postFix.pop();
				break;
			case "^":
				double tmp3=st.pop();
				st.push(Math.pow(st.pop(), tmp3));
				postFix.pop();
				break;
			default :
				double elem = Double.parseDouble(postFix.pop()+"");
				st.push(elem);
				break;
				}
		}
		result=st.pop();
	}
	
	boolean isStackEmpty(Stack<String> stack) {
		if(stack.empty())return true;
		return false;
	}
	
	Stack<String> reverseStack(Stack<String> stack){
		Stack<String> tempStack = new Stack<>();
		
		while(!stack.isEmpty()) {
			tempStack.push(stack.pop());
		}
		
		return tempStack;
	}
	public void printInfo() {
		System.out.println("");
		System.out.println("Result is "+result);

	}
}
