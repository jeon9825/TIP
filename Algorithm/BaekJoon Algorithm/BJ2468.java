import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ2468 {
	static int n;
	static int[][] arr;
	static boolean[][] result;
	static int dx[] = { -1, 0, 1, 0 };
	static int dy[] = { 0, 1, 0, -1 };
	static boolean[][] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(reader.readLine());
		arr = new int[n][n];

		boolean[] height = new boolean[101];
		StringTokenizer tokenizer;
		for (int i = 0; i < arr.length; i++) {
			tokenizer = new StringTokenizer(reader.readLine());
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j] = Integer.parseInt(tokenizer.nextToken());
				if (!height[arr[i][j]])
					height[arr[i][j]] = true;
			}
		}
		reader.close();

		int max = 0;
		for (int i = 1; i < height.length; i++) {
			if (height[i]) {
				result = new boolean[n][n];
				visited = new boolean[n][n];
				for (int j = 0; j < arr.length; j++) {
					for (int j2 = 0; j2 < arr[j].length; j2++) {
						if (arr[j][j2] >= i)
							result[j][j2] = true;
					}
				}
				int count = 0;
				for (int j = 0; j < result.length; j++) {
					for (int j2 = 0; j2 < result[j].length; j2++) {
						if (result[j][j2] && !visited[j][j2]) {
							visited[j][j2] = true;
							BFS(j, j2);
							count++;
						}
					}
				}
				max = Math.max(max, count);
			}
		}
		System.out.println(max);
	}

	static void BFS(int y, int x) {
		Queue<Area> q = new LinkedList<>();
		q.add(new Area(x, y));

		while (!q.isEmpty()) {
			Area a = q.poll();
			for (int i = 0; i < 4; i++) {
				int rx = a.x + dx[i];
				int ry = a.y + dy[i];
				if (rx < 0 || ry < 0 || ry >= n || rx >= n) {
					continue;
				}
				if (visited[ry][rx] || !result[ry][rx]) {
					continue;
				}
				q.add(new Area(rx, ry));
				visited[ry][rx] = true;
			}
		}
	}
}

class Area {
	int x;
	int y;

	public Area(int x, int y) {
		this.x = x;
		this.y = y;
	}
}