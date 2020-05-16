import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ10451 {
	static int n;
	static boolean[] visited;
	static int[] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(reader.readLine());
		for (int j = 0; j < t; j++) {
			n = Integer.parseInt(reader.readLine());
			StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
			arr = new int[n];
			visited = new boolean[n];
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(tokenizer.nextToken()) - 1;
			}

			int result = 0;
			for (int i = 0; i < visited.length; i++) {
				if (!visited[i]) {
					result++;
					DFS(i);
				}
			}
			System.out.println(result);
		}
	}

	static void DFS(int u) {
		Stack<Integer> s = new Stack<>();
		visited[u] = true;
		s.push(u);
		while (!s.isEmpty()) {
			int num = arr[s.pop()];
			if (visited[num])
				return;

			s.push(num);
			visited[num] = true;
		}
	}
}
