import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class BJ4949 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			String s = reader.readLine();
			if (s.equals("."))
				break;

			char[] src = s.replaceAll("[^\\[\\]()]", "").toCharArray();
			Stack<Character> stack = new Stack<>();
			boolean b = true;

			for (int i = 0; i < src.length; i++) {
				char c = src[i];
				if (c == '(' || c == '[')
					stack.push(c);
				else {
					if (stack.isEmpty()) {
						b = false;
						break;
					}
					char start = stack.pop();
					if (!((start == '(' && c == ')') || (start == '[' && c == ']'))) {
						b = false;
						break;
					}
				}
			}

			if (!stack.isEmpty())
				b = false;
			System.out.println(b ? "yes" : "no");
		}
	}
}
