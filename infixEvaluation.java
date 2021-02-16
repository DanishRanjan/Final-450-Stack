import java.util.*;

public class infixEvaluation {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		String exp = sc.nextLine();
		Stack<Integer> operands = new Stack<>();
		Stack<Character> operators = new Stack<>();
		for (int i = 0; i < exp.length(); i++) {
			char ch = exp.charAt(i);
			if (ch == '(') {
				operators.push(ch);
			} else if (Character.isDigit(ch)) {
				operands.push(ch - '0');
			} else if (ch == ')') {
				while (operators.peek() != '(') {
					char operator = operators.pop();
					int v2 = operands.pop();
					int v1 = operands.pop();
					int opv = operation(v1, v2, operator);
					operands.push(opv);
				}
				operators.pop();
			} else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
				while (operators.size() > 0 && operators.peek() != '('
						&& precedence(ch) <= precedence(operators.peek())) {
					char operator = operators.pop();
					int v2 = operands.pop();
					int v1 = operands.pop();
					int opv = operation(v1, v2, operator);
					operands.push(opv);
				}
				operators.push(ch);
			}
		}
		while (operators.size() != 0) {
			char operator = operators.pop();
			int v2 = operands.pop();
			int v1 = operands.pop();
			int opv = operation(v1, v2, operator);
			operands.push(opv);
		}
		System.out.println(operands.peek());
	}

	public static int operation(int v1, int v2, int operator) {
		if (operator == '+') {
			return v1 + v2;
		} else if (operator == '-') {
			return v1 - v2;
		} else if (operator == '*') {
			return v1 * v2;
		} else {
			return v1 / v2;
		}
	}

	public static int precedence(char operator) {
		if (operator == '+') {
			return 1;
		} else if (operator == '-') {
			return 1;
		} else if (operator == '*') {
			return 2;
		} else {
			return 2;
		}
	}
}
