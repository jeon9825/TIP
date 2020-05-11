import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ7576 {
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int[][] arr;
	static int w;
	static int h;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer;
		tokenizer = new StringTokenizer(reader.readLine());
		w = Integer.parseInt(tokenizer.nextToken());
		h = Integer.parseInt(tokenizer.nextToken());
		arr = new int[h][w];

		for (int i = 0; i < arr.length; i++) {
			tokenizer = new StringTokenizer(reader.readLine());
			for (int j = 0; j < arr[0].length; j++) {
				arr[i][j] = Integer.parseInt(tokenizer.nextToken());
			}
		}

		BFS();
	}

	static void BFS() {
		Queue<Dot> q = new LinkedList<>();
		for (int i = 0; i < arr[0].length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if (arr[j][i] == 1)
					q.add(new Dot(i, j));
			}
		}

		while (!q.isEmpty()) {
			Dot d = q.poll();
			for (int i = 0; i < 4; i++) {
				int rx = d.x + dx[i];
				int ry = d.y + dy[i];

				if (rx < 0 || ry < 0 || ry >= h || rx >= w) {
					continue;
				}
				if (arr[ry][rx] != 0) {
					continue;
				}
				q.add(new Dot(rx, ry));
				arr[ry][rx] = arr[d.y][d.x] + 1;
			}
		}

		int result = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				if (arr[i][j] == 0) {
					System.out.println(-1);
					return;
				}
				result = Math.max(result, arr[i][j]);
			}
		}
		System.out.println(result - 1);
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
