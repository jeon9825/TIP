import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ1963 {

	static int a;
	static int b;
	static boolean[] visited = new boolean[10000];
	static Queue<Pair> q;
	static boolean[] prime = new boolean[10000];

	public static void main(String[] args) throws NumberFormatException, IOException {
		eratos();
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(reader.readLine());

		StringTokenizer tokenizer;
		for (int i = 0; i < t; i++) {
			tokenizer = new StringTokenizer(reader.readLine());
			a = Integer.parseInt(tokenizer.nextToken());
			b = Integer.parseInt(tokenizer.nextToken());
			setVisited();
			BFS();
		}
	}

	static void setVisited() {
		for (int i = 0; i < visited.length; i++) {
			visited[i] = false;
		}
	}

	public static void eratos() {
		// 0번째와 1번째를 소수 아님으로 처리
		prime[0] = false;
		prime[1] = false;
		// 2~ n 까지 소수로 설정
		for (int i = 2; i < prime.length; i++)
			prime[i] = true;

		// 2 부터 ~ i*i <= n
		// 각각의 배수들을 지워간다.
		for (int i = 2; (i * i) < prime.length; i++) {
			if (prime[i]) {
				for (int j = i * 2; j < prime.length; j += i)
					prime[j] = false;
				// i*i 미만은 이미 처리되었으므로 j의 시작값은 i*i로 최적화할 수 있다.
			}
		}
	}

	static void BFS() {
		q = new LinkedList<>();
		q.add(new Pair(a, 0));
		visited[a] = true;
		while (!q.isEmpty()) {
			Pair p = q.poll();
			int num = p.num;
			int time = p.time;

			if (num == b) {
				System.out.println(time);
				return;
			}

			int cur = num;
			int[] arrNum = new int[4];
			int i = 3;
			while (cur != 0) {
				arrNum[i--] = cur % 10;
				cur /= 10;
			}
			for (int j = 1; j < 10; j++) {
				int curNum = j * 1000 + arrNum[1] * 100 + arrNum[2] * 10 + arrNum[3];
				if (prime[curNum] && !visited[curNum]) {
					visited[curNum] = true;
					q.add(new Pair(curNum, time + 1));
				}
			}

			for (int j = 0; j < 10; j++) {
				int curNum = arrNum[0] * 1000 + j * 100 + arrNum[2] * 10 + arrNum[3];
				if (prime[curNum] && !visited[curNum]) {
					visited[curNum] = true;
					q.add(new Pair(curNum, time + 1));
				}
			}

			for (int j = 0; j < 10; j++) {
				int curNum = arrNum[0] * 1000 + arrNum[1] * 100 + j * 10 + arrNum[3];
				if (prime[curNum] && !visited[curNum]) {
					visited[curNum] = true;
					q.add(new Pair(curNum, time + 1));
				}
			}
			for (int j = 0; j < 10; j++) {
				int curNum = arrNum[0] * 1000 + arrNum[1] * 100 + arrNum[2] * 10 + j;
				if (prime[curNum] && !visited[curNum]) {
					visited[curNum] = true;
					q.add(new Pair(curNum, time + 1));
				}
			}
		}
		System.out.println("Impossible");
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
