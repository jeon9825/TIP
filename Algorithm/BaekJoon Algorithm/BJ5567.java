import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ5567 {
	static List<Integer>[] edges;
	static boolean[] visited;

	static void DFS(int index, int distance) {
		visited[index] = true;
		if (distance == 2)
			return;
		for (int f : edges[index]) {
			DFS(f, distance + 1);
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int V = Integer.parseInt(reader.readLine());
		edges = new ArrayList[V];
		visited = new boolean[V];

		for (int i = 0; i < V; i++) {
			edges[i] = new ArrayList<>();
		}
		int E = Integer.parseInt(reader.readLine());
		for (int i = 0; i < E; i++) {
			StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
			int a = Integer.parseInt(tokenizer.nextToken()) - 1;
			int b = Integer.parseInt(tokenizer.nextToken()) - 1;
			edges[a].add(b);
			edges[b].add(a);
		}
		DFS(0, 0);
		int count = 0;
		for (boolean b : visited) {
			if (b)
				++count;
		}
		System.out.println(count - 1);
	}
}
