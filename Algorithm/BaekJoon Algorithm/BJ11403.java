import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ11403 {
	static Queue<Integer> q = new LinkedList<>();
	static int n;
	static int[][] arr;
	static int[][] result;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(reader.readLine());

		arr = new int[n][n];
		result = new int[n][n];
		StringTokenizer tokenizer;
		for (int i = 0; i < arr.length; i++) {
			tokenizer = new StringTokenizer(reader.readLine());
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j] = Integer.parseInt(tokenizer.nextToken());
			}
		}
		for (int i = 0; i < arr.length; i++) {
			BFS(i);
		}
		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result[i].length; j++) {
				System.out.print(result[i][j] + " ");
			}
			System.out.println();
		}
	}

	static void BFS(int start) {
		boolean[] visited = new boolean[n];
		for (int i = 0; i < arr[start].length; i++) {
			if (arr[start][i] == 1)
				q.add(i);
		}
		visited[start] = true;

		while (!q.isEmpty()) {
			int num = q.poll();
			result[start][num] = 1;

			if (!visited[num]) {
				for (int i = 0; i < arr[num].length; i++) {
					if (arr[num][i] == 1)
						q.add(i);
				}
				visited[num] = true;
			}
		}
	}
}
