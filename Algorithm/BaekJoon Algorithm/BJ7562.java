import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ7562 {
	static int[] dx = { -2, -1, 1, 2, -2, -1, 1, 2 };
	static int[] dy = { 1, 2, 2, 1, -1, -2, -2, -1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer;

		int t = Integer.parseInt(reader.readLine()); // 테스트 케이스의 개수

		for (int i = 0; i < t; i++) {
			int n = Integer.parseInt(reader.readLine());
			int[][] arr = new int[n][n];

			tokenizer = new StringTokenizer(reader.readLine());
			int startX = Integer.parseInt(tokenizer.nextToken());
			int startY = Integer.parseInt(tokenizer.nextToken());
			Pos start = new Pos(0, startX, startY);

			tokenizer = new StringTokenizer(reader.readLine());
			int endX = Integer.parseInt(tokenizer.nextToken());
			int endY = Integer.parseInt(tokenizer.nextToken());
			Pos end = new Pos(0, endX, endY);

			BFS(arr, start, end);
		}
	}

	static void BFS(int[][] arr, Pos start, Pos end) {
		Queue<Pos> q = new LinkedList<>();
		int size = arr.length;
		boolean[][] visited = new boolean[size][size];

		q.add(start);
		visited[start.x][start.y] = true;

		while (!q.isEmpty()) {
			Pos p = q.poll();

			if (p.equals(end)) {
				System.out.println(p.time);
				return;
			}

			for (int i = 0; i < 8; i++) {
				int rx = p.x + dx[i];
				int ry = p.y + dy[i];
				int time = p.time;

				if (rx < 0 || ry < 0 || rx >= size || ry >= size)
					continue;

				if (!visited[rx][ry]) {
					q.add(new Pos(time + 1, rx, ry));
					visited[rx][ry] = true;
				}
			}
		}
	}
}

class Pos {
	int x;
	int y;
	int time;

	public Pos(int time, int x, int y) {
		this.time = time;
		this.x = x;
		this.y = y;
	}

	@Override
	public boolean equals(Object obj) {
		Pos p = (Pos) obj;
		return this.x == p.x && this.y == p.y;
	}

}
