import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ2206 {
	static int n;
	static int m;

	static int[][] arr;
	static boolean[][][] visited;

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	static Queue<Map> q = new LinkedList<>();

	static int ans = Integer.MAX_VALUE;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
		n = Integer.parseInt(tokenizer.nextToken());
		m = Integer.parseInt(tokenizer.nextToken());

		arr = new int[n][m];
		visited = new boolean[n][m][2];

		for (int i = 0; i < arr.length; i++) {
			String s = reader.readLine();
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j] = s.charAt(j) - '0';
			}
		}

		if (BFS())
			System.out.println(ans);
		else
			System.out.println(-1);
	}

	static boolean BFS() {
		q.add(new Map(0, 0, 1, false));
		visited[0][0][0] = true;

		while (!q.isEmpty()) {
			Map map = q.poll();

			if (map.n == n - 1 && map.m == m - 1) {
				ans = Math.min(map.t, ans);
				return true;
			}

			for (int i = 0; i < 4; i++) {
				int mn = map.n + dx[i];
				int mm = map.m + dy[i];
				int mt = map.t;
				boolean mc = map.crashed;

				if (mn < 0 || mm < 0 || mn >= n || mm >= m)
					continue;

				if (mn == n - 1 && mm == m - 1) {
					ans = Math.min(map.t + 1, ans);
					return true;
				}

				if (mc) { // 벽을 부심
					if (!visited[mn][mm][1] && arr[mn][mm] == 0) {// 벽이 없고 방문하지 않았을 때
						visited[mn][mm][1] = true;
						q.add(new Map(mn, mm, mt + 1, mc));
					}
				} else { // 벽을 부시지 않음
					if (arr[mn][mm] == 1) { // 벽임
						if (!visited[mn][mm][1]) {
							visited[mn][mm][1] = true;
							q.add(new Map(mn, mm, mt + 1, !mc));
						}
					}
					if (arr[mn][mm] == 0) {
						if (!visited[mn][mm][0]) {
							visited[mn][mm][0] = true;
							q.add(new Map(mn, mm, mt + 1, mc));
						}
					}
				}
			}
		}
		return false;
	}
}

class Map {
	int n;
	int m;
	int t;
	boolean crashed;

	public Map(int n, int m, int t, boolean crashed) {
		this.n = n;
		this.m = m;
		this.t = t;
		this.crashed = crashed;
	}
}
