import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ1005 {
	static int n;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(reader.readLine());
		StringTokenizer tokenizer;
		for (int i = 0; i < t; i++) {
			tokenizer = new StringTokenizer(reader.readLine());
			n = Integer.parseInt(tokenizer.nextToken());
			int k = Integer.parseInt(tokenizer.nextToken());

			int[] time = new int[n];
			tokenizer = new StringTokenizer(reader.readLine());
			for (int j = 0; j < time.length; j++) {
				time[j] = Integer.parseInt(tokenizer.nextToken());
			}

			ArrayList<Integer>[] list = new ArrayList[n];
			for (int j = 0; j < n; j++)
				list[j] = new ArrayList<Integer>();

			int[] indegree = new int[n];
			for (int j = 0; j < k; j++) {
				tokenizer = new StringTokenizer(reader.readLine());

				int v1 = Integer.parseInt(tokenizer.nextToken()) - 1;
				int v2 = Integer.parseInt(tokenizer.nextToken()) - 1;

				list[v1].add(v2);
				indegree[v2]++;
			}

			int w = Integer.parseInt(reader.readLine()) - 1;

			System.out.println(topologicalSort(indegree, time, list, w));
		}
	}

	static int topologicalSort(int[] indegree, int[] time, List<Integer> list[], int w) {
		Queue<Integer> q = new LinkedList<Integer>();
		int[] result = new int[n];
		for (int i = 0; i < result.length; i++) {
			result[i] = time[i];

			if (indegree[i] == 0)
				q.offer(i);
		}

		// 건물의 총 소요시간 = 이전까지의 소요시간 + 현재 건물 소요시간
		// Max 해주는 이유는 이전 테크가 다 올라야 현재 건물을 지을 수 있기 때문
		while (!q.isEmpty()) {
			int node = q.poll();

			for (Integer i : list[node]) {
				result[i] = Math.max(result[i], result[node] + time[i]);
				indegree[i]--;

				if (indegree[i] == 0)
					q.offer(i);
			}
		}
		return result[w];
	}
}
