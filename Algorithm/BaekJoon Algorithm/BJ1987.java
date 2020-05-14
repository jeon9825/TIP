import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ1987 {
	// A:65 Z:90
	static int dx[] = { -1, 0, 1, 0 };
	static int dy[] = { 0, 1, 0, -1 };
	static int[][] arr;
	static boolean[] visited = new boolean[26];
	static int r; // 세로
	static int c; // 가로
	static Stack<Dot3> s = new Stack<>();
	static int ans;

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
		r = Integer.parseInt(tokenizer.nextToken());
		c = Integer.parseInt(tokenizer.nextToken());
		arr = new int[r][c];

		for (int i = 0; i < arr.length; i++) {
			String s = new String(reader.readLine());
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j] = s.charAt(j) - 65;
			}
		}

		DFS(0, 0, 1);
		System.out.println(ans);
	}

	public static void DFS(int x, int y, int time) {
		s.push(new Dot3(x, y, time));
		visited[arr[y][x]] = true;
		ans = Math.max(ans, time);

		while (!s.isEmpty()) {
			Dot3 now = s.pop();
			int nx = now.x;
			int ny = now.y;
			int nt = now.time;
			for (int i = 0; i < 4; i++) {
				int rx = nx + dx[i];
				int ry = ny + dy[i];

				if (rx < 0 || ry < 0 || rx >= c || ry >= r)
					continue;
				if (visited[arr[ry][rx]]) {
					continue;
				}
				visited[arr[ry][rx]] = true;
				DFS(rx, ry, nt + 1);
				visited[arr[ry][rx]] = false;
			}

		}
	}
}

class Dot3 {
	int x;
	int y;
	int time;

	public Dot3(int x, int y, int time) {
		this.x = x;
		this.y = y;
		this.time = time;
	}

}
