import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ9019 {
	static boolean[] visited;
	static int a;
	static int b;
	static Queue<Pair> q;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		StringTokenizer tokenizer;
		for (int i = 0; i < n; i++) {
			visited = new boolean[10000];
			tokenizer = new StringTokenizer(reader.readLine());
			a = Integer.parseInt(tokenizer.nextToken());
			b = Integer.parseInt(tokenizer.nextToken());
			BFS();
		}

	}

	static void BFS() {
		q = new LinkedList<>();
		q.add(new Pair(a, ""));
		visited[a] = true;
		while (!q.isEmpty()) {
			Pair p = q.poll();
			int num = p.num;
			String str = p.str;

			if (num == b) {
				System.out.println(str);
				return;
			}

			int curNum = (2 * num) % 10000;
			if (!visited[curNum]) {
				visited[curNum] = true;
				q.add(new Pair(curNum, str + "D"));
			}

			curNum = (num - 1) < 0 ? 9999 : num - 1;
			if (!visited[curNum]) {
				visited[curNum] = true;
				q.add(new Pair(curNum, str + "S"));
			}

			curNum = (num % 1000) * 10 + (num / 1000);
			if (!visited[curNum]) {
				visited[curNum] = true;
				q.add(new Pair(curNum, str + "L"));
			}

			curNum = (num % 10) * 1000 + (num / 10);
			if (!visited[curNum]) {
				visited[curNum] = true;
				q.add(new Pair(curNum, str + "R"));

			}
		}
	}
}

class Pair {
	int num;
	String str;

	Pair(int num, String str) {
		this.num = num;
		this.str = str;
	}
}