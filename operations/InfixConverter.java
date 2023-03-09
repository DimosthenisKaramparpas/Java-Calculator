package operations;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InfixConverter{
	Stack<String> inFix = new Stack<>();
	Stack<String> operators = new Stack<>();
	public Stack<String> postFix = new Stack<>();

	public InfixConverter(String str) {
	String[] s = StringtoArray(str);
	inFix.push("#");
	for (int i=s.length-1;i>=0;i--) {
		inFix.push(""+ s[i]);
	}
	int n=inFix.size();
	for(int i=0;i<n;i++) {
		System.out.println(i+1);
		System.out.println("1in"+inFix);
		System.out.println("1post"+postFix);
		System.out.println("1op"+operators);

		String elem=inFix.pop();
		System.out.println("elem"+elem);

		if(isStackEmpty(inFix)) {
			while (!isStackEmpty(operators)) {
				postFix.push(operators.pop());
			}
		}
		else if(isOperand(elem)) {
			postFix.push(elem);
		}
		
		else if(containsChar(elem,"(")) {
			operators.push(elem);
		}
		else if(containsChar(elem,")")) {
			while(!containsChar(operators.peek(),"(")) {
				postFix.push(operators.pop());
			}
			operators.pop();
		}
		else if(isOperator(elem)) {
			boolean x=false;
			while(!isStackEmpty(operators)) {
				
				if(preced(elem)<preced(operators.peek())) {
					postFix.push(operators.pop());
					continue;
				}
				else {
					operators.push(elem);
					x=true;
					break;
				}
			}
			if(isStackEmpty(operators))x=false;
			if(x==false) {
				operators.push(elem);
			}

		}
		else {

			while (!isStackEmpty(operators)) {
				postFix.push(operators.pop());
			}
		}
		System.out.println("2in"+inFix);
		System.out.println("2post"+postFix);
		System.out.println("2op"+operators);

	}
	}
	
	
	
	
	
	public boolean containsChar(String s, String search) {
	    if (s.length() == 0)
	        return false;
	    else
	        return s.contains(search);
	}
	public void printInfo() {
		System.out.println("");
		System.out.println("postFix "+postFix);

	}
	boolean isOperand(String elem) {
		if (elem == null) {
	        return false;
	    }
	    try {
	        double d = Double.parseDouble(elem);
	    } catch (NumberFormatException nfe) {
	        return false;
	    }
	    return true;
	}
	boolean isOperator(String elem) {
		String operatorsString = new String("/*-+^");
		if(containsChar(operatorsString,elem)) {
			return true;
			}
		return false;
	}
	boolean isStackEmpty(Stack<String> stack) {
		if(stack.empty())return true;
		return false;
	}
	int preced(String ch) {
		if(ch.contains("+") || ch.contains("-")) {
		      return 1;              
		   }else if(ch.contains("*") || ch.contains("/")) {
		      return 2;            
		   }else if(ch.contains("^")) {
		      return 3;            
		   }else {
		      return 0;
		   }
			
	}
	 String[] StringtoArray(String input) {
		
		List<String> result = new ArrayList<>();

	    
	    String currentNumber = "";

	    boolean inParentheses = false;
	    int i=1000;
	    for (char c : input.toCharArray()) {
	      
	    	i++;
	      if (Character.isDigit(c)) {
	        currentNumber += c;
	      } else {
	        if (currentNumber.length() > 0) {
	          result.add(currentNumber);
	          currentNumber = "";
	        }

	        if (c == '(') {
	          i=0;
	          inParentheses = true;
	    
	        }
	        if (c == ')') {
	          inParentheses = false;
	     
	     
	          currentNumber = "";
	        }
	        
	        if (c == '-' && ((inParentheses && i==1)|| i==1001)) {
	        	currentNumber += c;
	        }

	        else result.add(Character.toString(c));
	      }
	    }

	    if (currentNumber.length() > 0 && !inParentheses) {
	      result.add(currentNumber);
	    }
	    System.out.println(result);
	    
	    return result.toArray(new String[0]);
	}
}
