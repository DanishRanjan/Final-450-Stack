import java.util.*;

public class balancedBracket {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		Stack<Character> st = new Stack<>();
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (ch == '(' || ch == '{' || ch == '[') {
				st.push(ch);
			} else if (ch == ')') {
				boolean val = handleClosing(st, '(');
				if (val == false) {
					System.out.println(val);
					return;
				}

			} else if (ch == '}') {
				boolean val = handleClosing(st, '{');
				if (val == false) {
					System.out.println(val);
					return;
				}

			} else if (ch == ']') {
				boolean val = handleClosing(st, '[');
				if (val == false) {
					System.out.println(val);
					return;
				}
			}
		}
		if (st.size() == 0) { //if stack size is zero after all pop and push , then its balanced bracket
			System.out.println(true);
		} else {
			System.out.println(false);
		}

	}

	public static boolean handleClosing(Stack<Character> st, char correspondingOpeningCharacter) {
		if (st.size() == 0) { // extra opening Bracket case
			return false;
		} else if (st.peek() != correspondingOpeningCharacter) { // peek k time iska counter part nhi mila
			return false;
		} else {
			st.pop();
			return true;
		}
	}
}
