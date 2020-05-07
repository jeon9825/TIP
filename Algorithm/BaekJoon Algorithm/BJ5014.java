import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ5014 {
	static int f;
	static int s;
	static int g;
	static int u;
	static int d;
	static int[] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
		f = Integer.parseInt(tokenizer.nextToken());
		s = Integer.parseInt(tokenizer.nextToken());
		g = Integer.parseInt(tokenizer.nextToken());
		u = Integer.parseInt(tokenizer.nextToken());
		d = Integer.parseInt(tokenizer.nextToken());
		arr = new int[f + 1];
		BFS(s, g);
	}

	static void BFS(int start, int end) {
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		arr[start] = 1;
		while (!q.isEmpty()) {
			int current = q.poll();
			if (current == end) {
				System.out.println(arr[current] - 1);
				return;
			}
			if (current + u <= f) {
				if (arr[current + u] == 0) {
					arr[current + u] = arr[current] + 1;
					q.add(current + u);
				}
			}
			if (current - d > 0) {
				if (arr[current - d] == 0) {
					arr[current - d] = arr[current] + 1;
					q.add(current - d);
				}
			}
		}
		System.out.println("use the stairs");
	}
}
