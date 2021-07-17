package apps.linear.postfix;

import java.util.StringTokenizer;
import java.util.NoSuchElementException;
import java.io.PrintWriter;

/**
 * This class evaluates a postfix expression. It can be made to evaluate in
 * parts, so progress can be monitored.
 * 
 * @author Sesh Venugopal
 *
 */
public class PostfixEvaluator {
	
	/**
	 * Tokenizer for expression. 
	 */
	StringTokenizer exprTok;
	
	/**
	 * Evaluation status keeper.
	 */
	StatusKeeper exprStatus;
	
	/**
	 * Evaluation stack keeper.
	 */
	StackKeeper postStack;
	
	/**
	 * Initializes a new instance with empty status and empty evaluation stack.
	 */
	public PostfixEvaluator() {
		postStack = new StackKeeper();
		exprStatus = new StatusKeeper();
	}
	
	/**
	 * Primes the evaluator by priming the status and evaluation stack, and
	 * sending an expresion to evaluate.
	 * 
	 * @param expr
	 */
	public void init(String expr) {
		postStack.init();
		exprStatus.init();
		exprTok = new StringTokenizer(expr);
	}
	
	/**
	 * Runs this evaluator to completion.
	 * 
	 * @param pw PrintWriter used to write output.
	 * @return Result of evaluating expression.
	 * @throws IllegalExpressionException If expression is not legal postfix.
	 */
	public float runAll(PrintWriter pw) 
	throws IllegalExpressionException {
		runSome(exprTok.countTokens(), pw);
		if (postStack.size() > 1) {
			throw new IllegalExpressionException("insufficient operators");
		}
		return postStack.getTop();
	}
	
	/**
	 * Runs this evaluator for a given number of evaluation steps - each step
	 * processes one additional token of the expression.
	 * 
	 * @param howManySteps Number of steps.
	 * @param pw PrintWriter used to write output.
	 * @throws IllegalExpressionException If expression if not legal postfix.
	 */
	public void runSome(int howManySteps, PrintWriter pw) 
	throws IllegalExpressionException {
		int step=0;
		while (exprTok.hasMoreTokens()) {
			if (step == howManySteps) {
				return;
			}
			
			String nextTok = exprTok.nextToken();
			exprStatus.update(nextTok);
			try {
				postStack.update(nextTok);
			} catch (NoSuchElementException f) {
				printStatus(pw);
				throw new IllegalExpressionException("insufficient operands");
			}
			step++;
		}
	}
	
	/**
	 * Prints the status of evaluation.
	 * 
	 * @param pw PrintWriter used to write status.
	 */
	/**
	 * @param pw
	 */
	public void printStatus(PrintWriter pw) {
		pw.println();
		exprStatus.printStatus(pw);
		pw.println();
		
		postStack.printStack(pw);
		pw.println();
	}
}

