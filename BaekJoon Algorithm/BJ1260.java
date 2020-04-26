import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BJ1260 {
	static void DFS(ArrayList<Integer>[] graph, int start) {
		DFS(graph, start, new boolean[graph.length]);
		System.out.println();
	}

	static void DFS(ArrayList<Integer>[] graph, int start, boolean[] visited) {
		visited[start] = true;
		System.out.print(start + 1 + " ");
		Collections.sort(graph[start]);
		for (int adve : graph[start]) {
			if (!visited[adve]) {
				DFS(graph, adve, visited);
			}

		}
	}

	static void BFS(ArrayList<Integer>[] graph, int start) {
		boolean[] visited = new boolean[graph.length];
		ArrayDeque<Integer> queue = new ArrayDeque<>();
		queue.push(start);
		while (queue.size() > 0) {
			int v = queue.removeFirst();
			if (visited[v])
				continue;
			visited[v] = true;
			System.out.print(v + 1 + " ");
			Collections.sort(graph[v]);
			for (int adve : graph[v]) {
				if (!visited[adve]) {
					queue.add(adve);
				}
			}
		}
		System.out.println();
	}

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(tokenizer.nextToken()); // 정점의 개수
		int m = Integer.parseInt(tokenizer.nextToken()); // 간선의 개수
		int v = Integer.parseInt(tokenizer.nextToken()) - 1; // 탐색을 시작할 정점의 번호
		ArrayList<Integer>[] graph = new ArrayList[n];
		for (int i = 0; i < graph.length; i++) {
			graph[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i < m; i++) {
			tokenizer = new StringTokenizer(reader.readLine());
			int v1 = Integer.parseInt(tokenizer.nextToken()) - 1;
			int v2 = Integer.parseInt(tokenizer.nextToken()) - 1;
			graph[v1].add(v2);
			graph[v2].add(v1);
		}
		DFS(graph, v);
		BFS(graph, v);
	}
}
