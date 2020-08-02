import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ11725 {
	static List<Integer>[] node;
	static boolean[] visited;
	static int[] result;

	static Queue<Integer> q = new LinkedList<>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());

		StringTokenizer tokenizer;
		node = new ArrayList[n];
		for (int i = 0; i < n; i++)
			node[i] = new ArrayList<>();

		visited = new boolean[n];
		result = new int[n];
		for (int i = 0; i < n - 1; i++) {
			tokenizer = new StringTokenizer(reader.readLine());
			int p = Integer.parseInt(tokenizer.nextToken()) - 1;
			int c = Integer.parseInt(tokenizer.nextToken()) - 1;

			node[p].add(c);
			node[c].add(p);
		}

		solve(0);

		for (int i = 1; i < result.length; i++) {
			System.out.println(result[i] + 1);
		}
	}

	static void solve(int v) {
		visited[v] = true;
		for (int i : node[v]) {
			if (!visited[i]) {
				result[i] = v;
				solve(i);
			}
		}
	}
}