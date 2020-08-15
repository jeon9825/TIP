import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ1167 {
	static ArrayList<Nd> list[];
	static int n;

	static int max;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(reader.readLine());

		list = new ArrayList[n];
		for (int i = 0; i < list.length; i++) {
			list[i] = new ArrayList<>();
		}

		StringTokenizer tokenizer;
		for (int i = 0; i < n; i++) {
			tokenizer = new StringTokenizer(reader.readLine());
			int v = Integer.parseInt(tokenizer.nextToken()) - 1;
			while (true) {
				int u = Integer.parseInt(tokenizer.nextToken()) - 1;
				if (u == -2)
					break;
				int w = Integer.parseInt(tokenizer.nextToken());
				list[v].add(new Nd(u, w));
			}
		}

		int v = BFS(0);
		max = 0;
		BFS(v);
		System.out.println(max);
	}

	static int BFS(int start) {
		Queue<Nd> q = new LinkedList<>();
		boolean[] visited = new boolean[n];
		visited[start] = true;
		for (Nd nd : list[start]) {
			q.add(nd);
		}

		int maxU = 0;
		int maxW = 0;
		while (!q.isEmpty()) {
			Nd nd = q.poll();
			int u = nd.u;
			int w = nd.w;
			if (w > maxW) {
				maxW = w;
				maxU = u;
			}
			visited[u] = true;
			for (Nd n : list[u]) {
				int nu = n.u;
				int nw = n.w;
				if (!visited[nu])
					q.add(new Nd(nu, nw + w));
			}
		}

		if (max < maxW) {
			max = maxW;
		}
		return maxU;
	}

}

class Nd {
	int u;
	int w;

	public Nd(int u, int w) {
		this.u = u;
		this.w = w;
	}
}
