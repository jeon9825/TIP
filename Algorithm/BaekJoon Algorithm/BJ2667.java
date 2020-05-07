import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class BJ2667 {
	static int dx[] = { -1, 0, 1, 0 };
	static int dy[] = { 0, 1, 0, -1 };
	static int[][] arr;
	static boolean[][] visited;
	static int n;
	static int result;
	static PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(reader.readLine());
		arr = new int[n][n];
		visited = new boolean[n][n];
		for (int i = 0; i < arr.length; i++) {
			String s = reader.readLine();
			for (int j = 0; j < arr[0].length; j++) {
				arr[i][j] = s.charAt(j) - '0';
			}
		}
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				if (arr[i][j] == 1 && !visited[i][j]) {
					visited[i][j] = true;
					BFS(i, j);
				}
			}
		}
		System.out.println(pq.size());
		while (!pq.isEmpty()) {
			System.out.println(pq.poll());
		}
	}

	static public void BFS(int x, int y) {
		Queue<Dot> q = new LinkedList<Dot>();
		q.add(new Dot(x, y));
		int count = 1;
		while (!q.isEmpty()) {
			Dot d = q.poll();
			for (int i = 0; i < 4; i++) {
				int rx = d.x + dx[i];
				int ry = d.y + dy[i];
				if (rx < 0 || ry < 0 || ry >= n || rx >= n) {
					continue;
				}
				if (visited[rx][ry] || arr[rx][ry] == 0) {
					continue;
				}
				q.add(new Dot(rx, ry));
				count++;
				visited[rx][ry] = true;
			}
		}
		pq.offer(count);
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