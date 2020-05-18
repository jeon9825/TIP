import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ2146 {
	static int[][] visited;
	static int[][] arr;
	static int n;
	static Queue<Island> q;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(reader.readLine());
		arr = new int[n][n];
		visited = new int[n][n];
		q = new LinkedList<>();
		StringTokenizer tokenizer;
		for (int i = 0; i < n; i++) {
			tokenizer = new StringTokenizer(reader.readLine());
			for (int j = 0; j < n; j++) {
				int v = Integer.parseInt(tokenizer.nextToken());
				if (v == 1) {
					q.add(new Island(j, i, 0));
				}
				arr[i][j] = v * (-1);
			}
		}
		int color = 1;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if (arr[i][j] == -1) {
					changeColor(i, j, color);
					color++;
				}
			}
		}

		BFS();
		System.out.println(min);
	}

	static void changeColor(int y, int x, int color) {
		arr[y][x] = color;
		for (int i = 0; i < 4; i++) {
			int rx = x + dx[i];
			int ry = y + dy[i];
			if (rx >= 0 && ry >= 0 && rx < n && ry < n) {
				if (arr[ry][rx] == -1) {
					arr[ry][rx] = color;
					changeColor(ry, rx, color);
				}
			}
		}
	}

	static void BFS() {
		while (!q.isEmpty()) {
			Island i = q.poll();
			int ix = i.x;
			int iy = i.y;
			int icount = i.count;
			for (int j = 0; j < 4; j++) {
				int rx = ix + dx[j];
				int ry = iy + dy[j];

				if (rx < 0 || ry < 0 || rx >= n || ry >= n) {
					continue;
				}
				if (arr[ry][rx] == 0) {
					q.add(new Island(rx, ry, icount + 1));
					arr[ry][rx] = arr[iy][ix];
					visited[ry][rx] = icount + 1;
				} else if (arr[ry][rx] != arr[iy][ix]) {
					int result = visited[ry][rx] + visited[iy][ix];
					min = Math.min(result, min);
				}
			}
		}
	}
}

class Island {
	int x;
	int y;
	int count;

	public Island(int x, int y, int count) {
		this.x = x;
		this.y = y;
		this.count = count;
	}

}