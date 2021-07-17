package apps.linear.postfix;

import java.util.NoSuchElementException;
import java.io.PrintWriter;
import structures.linear.Stack;

/**
 * This class implements a stack that is used to evaluate an expression, and stores
 * floating point numbers. It is only visible in its package.
 * 
 * @author Sesh Venugopal
 *
 */
class StackKeeper {
	
	/**
	 * The set of admissible binary operators. 
	 */
	static final char[] operators = {'+', '-', '*', '/'};
	
	/**
	 * The evaluation stack that keeps operands and results of evaluating sub-expressions.
	 */
	Stack<Float> evalStack;
	
	/**
	 * Initializes a new instance by creating an empty evaluation stack of floating point numbers. 
	 */
	StackKeeper() {
		evalStack = new Stack<Float>();
	}
	
	/**
	 * Resets the evaluation stack to empty.
	 */
	void init() {
		evalStack.clear();
	}
	
	/**
	 * Updates the evaluation process with a given token. If the token is an operand,
	 * it is pushed on the evaluation stack. If it is an operator, an evaluation is done
	 * with the operator.
	 * 
	 * @param token Token used for update.
	 */
	void update(String token) {
		if (isOperator(token)) {
			evaluate(token.charAt(0));
		} else {
			evalStack.push(Float.valueOf(token));
		}
	}
	
	/**
	 * Helper method for update. Performs an evaluation by applying the binary
	 * operator which is accepted as parameter, to the top two operands on the
	 * evaluation stack. Pops the top two operands, and pushes the result of the
	 * evaluation.
	 * 
	 * @param op Binary operator to be used in evaluation.
	 */
	private void evaluate(char op) {
		
		Float topval = evalStack.pop();
		Float nextval = evalStack.pop();
		
		float tempval=0;
		switch (op) {
		case '+':
			tempval = nextval + topval;
			break;
		case '-':
			tempval = nextval - topval;
			break;
		case '*':
			tempval = nextval * topval;
			break;
		case '/':
			tempval = nextval / topval;
			break;
		}
		
		evalStack.push(tempval);
	}
	
	/**
	 * Tells whether a given token is an operator or not.
	 * 
	 * @param instr Token to be checked.
	 * @return True if token is an operator, false otherwise.
	 */
	boolean isOperator(String instr) {
		if (instr.length() > 1) {
			return false;
		}
		
		char c = instr.charAt(0);
		for (int i=0; i < operators.length; i++) {
			if (c == operators[i]) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Prints the evaluation stack.
	 * 
	 * @param pw PrintWriter used to print the stack.
	 */
	void printStack(PrintWriter pw) {
		pw.println("             ------------>");
		pw.print("     Stack :");
		
		Stack<Float> tempStack = new Stack<Float>();
		Float obj = evalStack.first();
		while (obj != null) {
			tempStack.push(obj);
			obj = evalStack.next();
		}
		
		obj = tempStack.first();
		while (obj != null) {
			pw.print(String.format(" | %.2f", obj));
			obj = tempStack.next();
		}
		pw.println();
		pw.println("             ------------>");
	}
	
	/**
	 * Returns the top of stack without removing it.
	 * 
	 * @return Top of stack.
	 * @throws NoSuchElementException If the stack is empty.
	 */
	float getTop() {
		Float top = evalStack.first();
		if (top == null) {
			throw new NoSuchElementException();
		}
		return top;
	}
	
	/**
	 * Gets the number of elements in the stack.
	 * 
	 * @return Number of elements in stack.
	 */
	int size() {
		return evalStack.size();
	}
}
