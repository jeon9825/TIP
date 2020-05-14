import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ1012 {
	static int dx[] = { -1, 0, 1, 0 };
	static int dy[] = { 0, 1, 0, -1 };
	static int[][] arr;
	static boolean[][] visited;
	static int m; // 가로
	static int n; // 세로
	static Stack<Dot> s;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(reader.readLine());
		StringTokenizer tokenizer;
		for (int i = 0; i < t; i++) {
			tokenizer = new StringTokenizer(reader.readLine());
			m = Integer.parseInt(tokenizer.nextToken());
			n = Integer.parseInt(tokenizer.nextToken());
			arr = new int[n][m];
			visited = new boolean[n][m];
			s = new Stack<>();
			int k = Integer.parseInt(tokenizer.nextToken());
			for (int j = 0; j < k; j++) {
				tokenizer = new StringTokenizer(reader.readLine());
				int x = Integer.parseInt(tokenizer.nextToken());
				int y = Integer.parseInt(tokenizer.nextToken());
				arr[y][x] = 1;
			}

			int result = 0;
			for (int j = 0; j < arr.length; j++) {
				for (int l = 0; l < arr[0].length; l++) {
					if (!visited[j][l] && arr[j][l] == 1) {
						visited[j][l] = true;
						DFS(j, l);
						result++;
					}
				}
			}
			System.out.println(result);
		}
	}

	static void DFS(int y, int x) {
		s.push(new Dot(x, y));
		while (!s.isEmpty()) {
			Dot now = s.pop();
			int nx = now.x;
			int ny = now.y;
			for (int i = 0; i < 4; i++) {
				int rx = nx + dx[i];
				int ry = ny + dy[i];

				if (rx < 0 || ry < 0 || rx >= m || ry >= n)
					continue;
				if (visited[ry][rx])
					continue;
				if (arr[ry][rx] == 0)
					continue;

				s.push(new Dot(rx, ry));
				visited[ry][rx] = true;
			}

		}
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
