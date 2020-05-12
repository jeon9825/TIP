import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ14502 {
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int[][] arr;
	static int[][] copy;
	static boolean[][] visited;
	static int n;
	static int m;
	static Queue<Dot> q = new LinkedList<>();
	static int max = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer;
		tokenizer = new StringTokenizer(reader.readLine());
		n = Integer.parseInt(tokenizer.nextToken()); // 세로 y
		m = Integer.parseInt(tokenizer.nextToken()); // 가로 x
		arr = new int[n][m];
		copy = new int[n][m];
		visited = new boolean[n][m];
		for (int i = 0; i < arr.length; i++) {
			tokenizer = new StringTokenizer(reader.readLine());
			for (int j = 0; j < arr[0].length; j++) {
				arr[i][j] = Integer.parseInt(tokenizer.nextToken());
			}
		}
		setWall(0, 0);
		System.out.println(max);
	}

	static void setWall(int start, int depth) {
		if (depth == 3) {
			copy();
			int safeArea = BFS();
			max = Math.max(max, safeArea);
			return;
		}

		for (int i = start; i < n * m; i++) {
			int x = i / m;
			int y = i % m;

			if (arr[x][y] == 0) {
				arr[x][y] = 1;
				setWall(i + 1, depth + 1);
				arr[x][y] = 0;
			}
		}
	}

	static void copy() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				copy[i][j] = arr[i][j];
			}
		}
	}

	static int BFS() {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				if (arr[i][j] == 2)
					q.add(new Dot(j, i));
			}
		}
		while (!q.isEmpty()) {
			Dot d = q.poll();
			for (int i = 0; i < 4; i++) {
				int rx = d.x + dx[i];
				int ry = d.y + dy[i];

				if (rx < 0 || ry < 0 || ry >= n || rx >= m) {
					continue;
				}
				if (!visited[ry][rx] && copy[ry][rx] == 0) {
					q.add(new Dot(rx, ry));
					copy[ry][rx] = 2;
				}
			}
		}

		int result = 0;
		for (int i = 0; i < copy.length; i++) {
			for (int j = 0; j < copy[0].length; j++) {
				if (copy[i][j] == 0) {
					result++;
				}
			}
		}
		return result;
	}
}

class Dot {
	int x;
	int y;

	Dot(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return "Dot [x=" + x + ", y=" + y + "]";
	}

}
