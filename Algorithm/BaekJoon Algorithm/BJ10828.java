import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BJ10828 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(reader.readLine());
		Deque<Integer> stack = new ArrayDeque<>();
		StringTokenizer tokenizer;
		for (int i = 0; i < N; i++) {
			tokenizer = new StringTokenizer(reader.readLine());
			String command = tokenizer.nextToken();
			if (command.equals("push")) {
				int value = Integer.parseInt(tokenizer.nextToken());
				stack.push(value);
			} else if (command.equals("pop")) {
				if (!stack.isEmpty())
					System.out.println(stack.pop());
				else
					System.out.println(-1);
			} else if (command.equals("size")) {
				System.out.println(stack.size());
			} else if (command.equals("empty")) {
				if (stack.isEmpty())
					System.out.println(1);
				else
					System.out.println(0);

			} else if (command.equals("top"))
				if (!stack.isEmpty())
					System.out.println(stack.peek());
				else
					System.out.println(-1);
		}
	}

}
