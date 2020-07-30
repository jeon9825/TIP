import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ2644 {
	static int[][] arr;
	static boolean[][] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());

		arr = new int[n][n];
		visited = new boolean[n][n];

		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
		int p1 = Integer.parseInt(tokenizer.nextToken()) - 1;
		int p2 = Integer.parseInt(tokenizer.nextToken()) - 1;

		int t = Integer.parseInt(reader.readLine());
		for (int i = 0; i < t; i++) {
			tokenizer = new StringTokenizer(reader.readLine());
			int p = Integer.parseInt(tokenizer.nextToken()) - 1;
			int c = Integer.parseInt(tokenizer.nextToken()) - 1;

			arr[p][c] = 1;
			arr[c][p] = 1;
		}

		BFS(p1, p2);
	}

	static void BFS(int p1, int p2) {
		Queue<Relation> q = new LinkedList<>();
		q.add(new Relation(p1, 0));

		while (!q.isEmpty()) {
			Relation r = q.poll();
			int rNum = r.num;
			int rTime = r.time;
			if (rNum == p2) {
				System.out.println(rTime);
				return;
			}
			for (int i = 0; i < arr.length; i++) {
				if (!visited[rNum][i] && arr[rNum][i] == 1) {
					q.add(new Relation(i, rTime + 1));
					visited[rNum][i] = true;
				}
			}
		}

		System.out.println(-1);
	}
}

class Relation {
	int num;
	int time;

	public Relation(int num, int time) {
		this.num = num;
		this.time = time;
	}
}