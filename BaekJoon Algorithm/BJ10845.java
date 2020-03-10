import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BJ10845 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(reader.readLine());
		Deque<Integer> queue = new ArrayDeque<>();
		StringTokenizer tokenizer;
		for (int i = 0; i < N; i++) {
			tokenizer = new StringTokenizer(reader.readLine());
			String command = tokenizer.nextToken();
			if (command.equals("push")) {
				int value = Integer.parseInt(tokenizer.nextToken());
				queue.add(value);
			} else if (command.equals("pop")) {
				if (!queue.isEmpty())
					System.out.println(queue.remove());
				else
					System.out.println(-1);
			} else if (command.equals("size")) {
				System.out.println(queue.size());
			} else if (command.equals("empty")) {
				if (queue.isEmpty())
					System.out.println(1);
				else
					System.out.println(0);

			} else if (command.equals("front")) {
				if (!queue.isEmpty())
					System.out.println(queue.peekFirst());
				else
					System.out.println(-1);
			} else if (command.equals("back")) {
				if (!queue.isEmpty())
					System.out.println(queue.peekLast());
				else
					System.out.println(-1);
			}
		}
	}
}
