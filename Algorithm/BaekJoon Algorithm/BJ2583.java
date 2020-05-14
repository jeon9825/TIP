import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ2583 {
	static int dx[] = { -1, 0, 1, 0 };
	static int dy[] = { 0, 1, 0, -1 };
	static int[][] arr;
	static boolean[][] visited;
	static int n;
	static int m;
	static Stack<Dot> s;
	static PriorityQueue<Integer> pq = new PriorityQueue<>();

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
		m = Integer.parseInt(tokenizer.nextToken());
		n = Integer.parseInt(tokenizer.nextToken());
		int k = Integer.parseInt(tokenizer.nextToken());
		arr = new int[m][n];
		visited = new boolean[m][n];

		for (int i = 0; i < k; i++) {
			tokenizer = new StringTokenizer(reader.readLine());
			int lx = Integer.parseInt(tokenizer.nextToken());
			int ly = Integer.parseInt(tokenizer.nextToken());
			int rx = Integer.parseInt(tokenizer.nextToken());
			int ry = Integer.parseInt(tokenizer.nextToken());

			for (int j = ly; j < ry; j++) {
				for (int j2 = lx; j2 < rx; j2++) {
					arr[j][j2] = 1;
				}
			}
		}

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if (!visited[i][j] && arr[i][j] == 0) {
					DFS(j, i);
					visited[i][j] = true;
				}
			}
		}
		System.out.println(pq.size());
		while (!pq.isEmpty()) {
			System.out.print(pq.poll() + " ");
		}
	}

	public static void DFS(int x, int y) {
		s = new Stack<>();
		s.push(new Dot(x, y));
		int result = 1;
		while (!s.isEmpty()) {
			Dot now = s.pop();
			int nx = now.x;
			int ny = now.y;
			for (int i = 0; i < 4; i++) {
				int rx = nx + dx[i];
				int ry = ny + dy[i];

				if (rx < 0 || ry < 0 || rx >= n || ry >= m)
					continue;
				if (visited[ry][rx])
					continue;
				if (arr[ry][rx] == 1)
					continue;

				s.push(new Dot(rx, ry));
				result++;
				visited[ry][rx] = true;
			}
		}

		pq.offer(result > 1 ? result - 1 : result);
	}
}

class Dot {
	int x;
	int y;

	public Dot(int x, int y) {
		this.x = x;
		this.y = y;
	}

}
