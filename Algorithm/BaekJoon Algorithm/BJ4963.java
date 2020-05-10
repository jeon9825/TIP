import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ4963 {
	static int[] dx = { -1, -1, -1, 0, 1, 1, 1, 0 };
	static int[] dy = { -1, 0, 1, 1, 1, 0, -1, -1 };
	static int[][] arr;
	static boolean[][] visited;
	static int w;
	static int h;

	static void setVisited() {
		for (int i = 0; i < visited.length; i++) {
			for (int j = 0; j < visited[0].length; j++) {
				visited[i][j] = false;
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer;
		while (true) {
			tokenizer = new StringTokenizer(reader.readLine());
			w = Integer.parseInt(tokenizer.nextToken());
			h = Integer.parseInt(tokenizer.nextToken());
			if (w == 0 && h == 0)
				break;
			arr = new int[h][w];

			for (int i = 0; i < arr.length; i++) {
				tokenizer = new StringTokenizer(reader.readLine());
				for (int j = 0; j < arr[0].length; j++) {
					arr[i][j] = Integer.parseInt(tokenizer.nextToken());
				}
			}

			visited = new boolean[h][w];
			setVisited();

			int result = 0;
			for (int i = 0; i < arr[0].length; i++) {
				for (int j = 0; j < arr.length; j++) {
					if (arr[j][i] == 1 && !visited[j][i]) {
						result++;
						BFS(i, j);
					}
				}
			}
			System.out.println(result);
		}
	}

	static void BFS(int x, int y) {
		Queue<Dot> q = new LinkedList<>();
		q.add(new Dot(x, y));
		visited[y][x] = true;

		while (!q.isEmpty()) {
			Dot d = q.poll();
			for (int i = 0; i < 8; i++) {
				int rx = d.x + dx[i];
				int ry = d.y + dy[i];

				if (rx < 0 || ry < 0 || ry >= h || rx >= w) {
					continue;
				}
				if (visited[ry][rx] || arr[ry][rx] == 0) {
					continue;
				}
				q.add(new Dot(rx, ry));
				visited[ry][rx] = true;
			}
		}
	}
}

class Dot {
	int x;
	int y;

	Dot(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
