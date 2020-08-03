import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ13913 {
	static int n;
	static int k;

	static int[] sb = new int[100001];
	static int[] visited = new int[100001];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

		n = Integer.parseInt(tokenizer.nextToken());
		k = Integer.parseInt(tokenizer.nextToken());

		BFS();

	}

	static void BFS() {
		Queue<Integer> q = new LinkedList<>();
		q.add(n);
		visited[n] = 1;

		while (!q.isEmpty()) {
			int now = q.poll();

			if (now == k) {
				System.out.println(visited[now] - 1);

				Stack<Integer> stack = new Stack<>();
				stack.push(k);
				int index = k;
				while (index != n) {
					stack.push(sb[index]);
					index = sb[index];
				}
				StringBuilder builder = new StringBuilder();
				while (!stack.isEmpty()) {
					builder.append(stack.pop() + " ");
				}

				System.out.println(builder.toString());
				return;
			}

			for (int i = 0; i < 3; i++) {
				int next;

				if (i == 0)
					next = now + 1;
				else if (i == 1)
					next = now - 1;
				else
					next = now * 2;

				if (next < 0 || next > 100000)
					continue;

				if (visited[next] == 0) {
					q.add(next);
					visited[next] = visited[now] + 1;
					sb[next] = now;
				}
			}
		}
	}
}
