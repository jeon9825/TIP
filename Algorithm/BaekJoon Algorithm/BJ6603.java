import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ6603 {
	static int[] S;
	static boolean[] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer;
		while (true) {
			tokenizer = new StringTokenizer(reader.readLine());
			int k = Integer.parseInt(tokenizer.nextToken());
			if (k == 0)
				break;

			S = new int[k];
			visited = new boolean[k];
			for (int i = 0; i < S.length; i++) {
				S[i] = Integer.parseInt(tokenizer.nextToken());
			}

			select(0, 0);
			System.out.println();
		}
	}

	public static void select(int start, int depth) {
		if (depth == 6) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < visited.length; i++) {
				if (visited[i])
					sb.append(S[i] + " ");
			}
			System.out.println(sb.toString());
			return;
		}
		for (int i = start; i < S.length; i++) {
			visited[i] = true;
			select(i + 1, depth + 1);
			visited[i] = false;
		}
	}
}
