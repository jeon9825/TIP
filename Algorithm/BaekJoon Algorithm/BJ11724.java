import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ11724 {
	static int n;
	static boolean[] visited;
	static int[][] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
		n = Integer.parseInt(tokenizer.nextToken());
		int m = Integer.parseInt(tokenizer.nextToken());
		arr = new int[n][n];
		visited = new boolean[n];
		for (int i = 0; i < m; i++) {
			tokenizer = new StringTokenizer(reader.readLine());
			int r = Integer.parseInt(tokenizer.nextToken());
			int c = Integer.parseInt(tokenizer.nextToken());
			arr[r - 1][c - 1] = 1;
			arr[c - 1][r - 1] = 1;
		}

		int result = 0;
		for (int i = 0; i < visited.length; i++) {
			if (!visited[i]) {
				result++;
				visited[i] = true;
				DFS(i);
			}
		}
		System.out.println(result);
	}

	static void DFS(int u) {
		Stack<Integer> s = new Stack<>();
		s.push(u);
		while (!s.isEmpty()) {
			int n = s.pop();
			for (int i = 0; i < arr[n].length; i++) {
				if (arr[n][i] == 0)
					continue;
				if (visited[i])
					continue;

				s.push(i);
				visited[i] = true;
			}
		}
	}
}
