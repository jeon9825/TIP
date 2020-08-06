import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ1967 {
	static int n; // 노드의 개수

	static ArrayList<Node> list[];

	static PriorityQueue<Node> q;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(reader.readLine());

		list = new ArrayList[n];
		// list 초기화
		for (int i = 0; i < list.length; i++) {
			list[i] = new ArrayList<Node>();
		}

		StringTokenizer tokenizer;
		int p = 0;
		for (int i = 0; i < n - 1; i++) {
			tokenizer = new StringTokenizer(reader.readLine());

			int v = Integer.parseInt(tokenizer.nextToken()) - 1;
			int u = Integer.parseInt(tokenizer.nextToken()) - 1;
			int w = Integer.parseInt(tokenizer.nextToken());

			list[v].add(new Node(u, w));
			list[u].add(new Node(v, w));

			p = v + 1;
		}

		int start = getDia(0).u;

		int max = getDia(start).dis;
		System.out.println(max);

	}

	static Node getDia(int start) {
		Node max = new Node(-1, -1);

		q = new PriorityQueue<Node>();
		boolean visited[] = new boolean[n];

		for (Node node : list[start]) {
			q.add(node);
			visited[node.u] = true;
		}

		while (!q.isEmpty()) {
			Node node = q.poll();
			int nodeU = node.u;
			int nodeDis = node.dis;

			if (nodeDis > max.dis) {
				max = node;
			}

			for (Node n : list[nodeU]) {
				int nU = n.u;
				int nD = n.dis;

				if (!visited[nU]) {
					visited[nU] = true;
					q.add(new Node(nU, nodeDis + nD));
				}
			}
		}
		return max;

	}

	static int BFS(int start, int end) {
		q = new PriorityQueue<Node>();
		boolean visited[] = new boolean[n];

		for (Node node : list[start]) {
			q.add(node);
			visited[node.u] = true;
		}

		while (!q.isEmpty()) {
			Node node = q.poll();
			int nodeU = node.u;
			int nodeDis = node.dis;

			if (nodeU == end) {
				return nodeDis;
			}
			for (Node n : list[nodeU]) {
				int nU = n.u;
				int nD = n.dis;

				if (!visited[nU]) {
					visited[nU] = true;
					q.add(new Node(nU, nodeDis + nD));
				}
			}
		}
		return -1;
	}
}

class Node implements Comparable<Node> {
	int u;
	int dis;

	public Node(int u, int dis) {
		this.u = u;
		this.dis = dis;
	}

	@Override
	public int compareTo(Node o) {
		return this.dis - o.dis;
	}
}
