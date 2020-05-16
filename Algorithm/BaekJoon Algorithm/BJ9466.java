import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ9466 {
	static boolean[] visited;
	static boolean[] done;
	static int[] student;
	static int n;
	static int cnt;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(reader.readLine());
		for (int i = 0; i < t; i++) {
			n = Integer.parseInt(reader.readLine());
			student = new int[n];
			visited = new boolean[n];
			done = new boolean[n];

			StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
			for (int j = 0; j < student.length; j++) {
				student[j] = Integer.parseInt(tokenizer.nextToken()) - 1;
			}

			cnt = 0;
			for (int j = 0; j < student.length; j++) {
				if (!visited[j]) {
					DFS(j);
				}
			}
			System.out.println(n - cnt);
		}
	}

	static void DFS(int i) {
		if (visited[i])
			return;

		visited[i] = true;
		int stu = student[i];

		if (!visited[stu]) {
			DFS(stu);
		} else if (!done[stu]) {
			for (int j = stu; j != i; j = student[j]) {
				cnt++;
			}
			cnt++;
		}
		done[i] = true;
	}
}
