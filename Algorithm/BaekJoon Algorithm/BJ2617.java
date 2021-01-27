import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ2617 {

	static int DFS(int index, boolean[] visited, List<Integer>[] arr) {
		if (visited[index])
			return 0;
		visited[index] = true;

		int sum = 1;
		for (int p : arr[index]) {
			sum += DFS(p, visited, arr);
		}
		return sum;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
		int N = Integer.parseInt(tokenizer.nextToken());
		int M = Integer.parseInt(tokenizer.nextToken());

		List<Integer>[] parents = new ArrayList[N];
		List<Integer>[] children = new ArrayList[N];

		for (int i = 0; i < N; i++) {
			parents[i] = new ArrayList<>();
			children[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			tokenizer = new StringTokenizer(reader.readLine());
			int p = Integer.parseInt(tokenizer.nextToken()) - 1;
			int c = Integer.parseInt(tokenizer.nextToken()) - 1;
			parents[c].add(p);
			children[p].add(c);
		}

		int cnt = 0;
		for (int i = 0; i < N; i++) {
			if (DFS(i, new boolean[N], parents) - 1 > N / 2)
				++cnt;
			else if (DFS(i, new boolean[N], children) - 1 > N / 2)
				++cnt;
		}
		System.out.println(cnt);
	}

}
