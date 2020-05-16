import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ1707 {
	static int n;
	static int[] visited;
	static ArrayList[] arr;
	static Stack<Integer> s;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int k = Integer.parseInt(reader.readLine());
		StringTokenizer tokenizer;
		for (int i = 0; i < k; i++) {
			tokenizer = new StringTokenizer(reader.readLine());
			n = Integer.parseInt(tokenizer.nextToken());
			int m = Integer.parseInt(tokenizer.nextToken());
			arr = new ArrayList[n];
			for (int j = 0; j < n; j++) {
				arr[j] = new ArrayList<Integer>();
			}
			visited = new int[n];
			for (int j = 0; j < m; j++) {
				tokenizer = new StringTokenizer(reader.readLine());
				int r = Integer.parseInt(tokenizer.nextToken());
				int c = Integer.parseInt(tokenizer.nextToken());
				arr[r - 1].add(c - 1);
				arr[c - 1].add(r - 1);
			}
			s = new Stack<>();

			for (int j = 0; j < n; j++) {
				if (visited[j] == 0) {
					DFS(j, 1);
				}
			}
			boolean ok = true;
			for (int j = 0; j < n; j++) {
				for (int j2 = 0; j2 < arr[j].size(); j2++) {
					if (visited[j] == visited[(int) arr[j].get(j2)]) {
						ok = false;
					}
				}
			}

//			System.out.println(Arrays.toString(visited));
			System.out.println(ok ? "YES" : "NO");
		}
		reader.close();
	}

	static void DFS(int u, int color) {
		s.push(u);
		visited[u] = color;
		while (!s.isEmpty()) {
			int n = s.pop();

			for (int i = 0; i < arr[n].size(); i++) {
				int next = (int) arr[n].get(i);
				if (visited[next] == 0) {
					DFS(next, 3 - color);
				}
			}
		}
	}
}
