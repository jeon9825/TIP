import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ16397 {
	static int n;
	static int t;
	static int g;
	static int[] led = new int[100000];
	static boolean[] visited = new boolean[100000];
	static Queue<Pair> q;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
		n = Integer.parseInt(tokenizer.nextToken());
		t = Integer.parseInt(tokenizer.nextToken());
		g = Integer.parseInt(tokenizer.nextToken());

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

			if (time > t) {
				break;
			}

			if (num == g) {
				System.out.println(time);
				return;
			}

			int curNum = num + 1;
			if (curNum <= 99999 && !visited[curNum]) {
				visited[curNum] = true;
				q.add(new Pair(curNum, time + 1));
			}

			if (num != 0) {
				curNum = num * 2;
				if (curNum <= 99999) {
					int high = 1;
					while (true) {
						int k = curNum / high;
						if (k == 0) {
							break;
						} else {
							high *= 10;
						}
					}
					high /= 10;
					curNum -= high;

					if (curNum <= 99999 && !visited[curNum]) {
						visited[curNum] = true;
						q.add(new Pair(curNum, time + 1));
					}
				}
			}
		}
		System.out.println("ANG");
		return;
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