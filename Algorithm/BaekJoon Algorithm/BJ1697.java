import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ1697 {
	static boolean[] visited = new boolean[100001];
	static int n;
	static int k;
	static Queue<Pair> q;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
		n = Integer.parseInt(tokenizer.nextToken());
		k = Integer.parseInt(tokenizer.nextToken());
		BFS();
	}

	static void BFS() {
		q = new LinkedList<>();
		q.add(new Pair(n, 0));
		visited[n] = true;
		while (!q.isEmpty()) {
			Pair p = q.poll();
			int num = p.num;
			int time = p.time;

			if (num == k) {
				System.out.println(time);
				return;
			}

			int curNum = 2 * num;
			if (curNum <= 100000 && !visited[curNum]) {
				visited[curNum] = true;
				q.add(new Pair(curNum, time + 1));
			}
			curNum = num - 1;
			if (curNum >= 0 && !visited[curNum]) {
				visited[curNum] = true;
				q.add(new Pair(curNum, time + 1));
			}
			curNum = num + 1;
			if (curNum <= 100000 && !visited[curNum]) {
				visited[curNum] = true;
				q.add(new Pair(curNum, time + 1));
			}
		}
	}
}

class Pair {
	int num;
	int time;

	public Pair(int num, int time) {
		super();
		this.num = num;
		this.time = time;
	}

}