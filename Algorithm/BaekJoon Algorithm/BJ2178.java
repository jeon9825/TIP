import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ2178 {
	static int dx[] = { -1, 0, 1, 0 };
	static int dy[] = { 0, 1, 0, -1 };
	static int[][] arr;
	static boolean[][] visited;
	static int n;
	static int m;

	static public void BFS(int x, int y) {
		Queue<Dot> q = new LinkedList<Dot>();
		q.add(new Dot(x, y));
		while (!q.isEmpty()) {
			Dot d = q.poll();
			for (int i = 0; i < 4; i++) {
				int rx = d.x + dx[i];
				int ry = d.y + dy[i];
				if (rx < 0 || ry < 0 || ry >= m || rx >= n) {
					continue;
				}
				if (visited[rx][ry] || arr[rx][ry] == 0) {
					continue;
				}
				q.add(new Dot(rx, ry));
				arr[rx][ry] = arr[d.x][d.y] + 1;
				visited[rx][ry] = true;
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
		n = Integer.parseInt(tokenizer.nextToken());
		m = Integer.parseInt(tokenizer.nextToken());
		arr = new int[n][m];
		visited = new boolean[n][m];
		for (int i = 0; i < arr.length; i++) {
			String s = reader.readLine();
			for (int j = 0; j < arr[0].length; j++) {
				arr[i][j] = s.charAt(j) - 48;
			}
		}
		
		visited[0][0] = true;
		BFS(0, 0);
		System.out.println(arr[n - 1][m - 1]);
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
