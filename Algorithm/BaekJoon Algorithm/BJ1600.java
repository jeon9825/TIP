import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ1600 {
	static int dx[] = { -1, 0, 1, 0 };
	static int dy[] = { 0, 1, 0, -1 };
	static int[] hx = { -2, -2, 2, 2, 1, -1, 1, -1 };
	static int[] hy = { 1, -1, 1, -1, 2, 2, -2, -2 };
	static int[][] arr;
	static boolean[][][] visited;
	static int k;
	static int h;
	static int w;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		k = Integer.parseInt(reader.readLine());
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
		w = Integer.parseInt(tokenizer.nextToken());
		h = Integer.parseInt(tokenizer.nextToken());
		arr = new int[h][w];
		for (int i = 0; i < arr.length; i++) {
			tokenizer = new StringTokenizer(reader.readLine());
			for (int j = 0; j < arr[0].length; j++) {
				arr[i][j] = Integer.parseInt(tokenizer.nextToken());
			}
		}
		visited = new boolean[h][w][k + 1];

		for (int i = 0; i < k; i++) {
			visited[0][0][i] = true;
		}

		BFS();
	}

	static void BFS() {
		Queue<Dot2> q = new LinkedList<>();
		q.add(new Dot2(0, 0, 0, k));

		while (!q.isEmpty()) {
			Dot2 cur = q.poll();
			int curX = cur.x;
			int curY = cur.y;
			int cnt = cur.count;
			int curK = cur.k;

			if (curX == w - 1 && curY == h - 1) {
				System.out.println(cnt);
				return;
			}

			if (curX >= w || curY >= h || curX < 0 || curY < 0) // 범위 초과
				continue;
			if (arr[curY][curX] == 1) // 장애물일 경우
				continue;
			if (visited[curY][curX][curK]) // 방문했을 경우
				continue;

			visited[curY][curX][curK] = true;
			for (int i = 0; i < 4; i++) {
				int nextX = curX + dx[i];
				int nextY = curY + dy[i];
				q.add(new Dot2(nextX, nextY, cnt + 1, curK));
			}

			if (curK == 0) // 말처럼 사용할 수 없는 경우
				continue;

			for (int i = 0; i < 8; i++) {
				int nextX = curX + hx[i];
				int nextY = curY + hy[i];
				q.add(new Dot2(nextX, nextY, cnt + 1, curK - 1));
			}

		}
		System.out.println("-1");
	}
}

class Dot2 {
	int x;
	int y;
	int count;
	int k;

	public Dot2(int x, int y, int count, int k) {
		this.x = x;
		this.y = y;
		this.count = count;
		this.k = k;
	}

}
