import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ1753 {
	static int v;

	static ArrayList<Weight> list[];
	static int[] distance;

	final static int INF = 3000001;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer;
		tokenizer = new StringTokenizer(reader.readLine());

		v = Integer.parseInt(tokenizer.nextToken());
		int e = Integer.parseInt(tokenizer.nextToken());

		int k = Integer.parseInt(reader.readLine()) - 1;

		list = new ArrayList[v];
		for (int i = 0; i < list.length; i++) {
			list[i] = new ArrayList<Weight>();
		}

		for (int i = 0; i < e; i++) {
			tokenizer = new StringTokenizer(reader.readLine());

			int u1 = Integer.parseInt(tokenizer.nextToken()) - 1;
			int u2 = Integer.parseInt(tokenizer.nextToken()) - 1;
			int w = Integer.parseInt(tokenizer.nextToken());

			list[u1].add(new Weight(u2, w));
		}

		distance = new int[v];
		for (int i = 0; i < distance.length; i++) {
			distance[i] = INF;
		}

		solve(k);
		for (int i = 0; i < distance.length; i++) {
			if (distance[i] >= INF)
				System.out.println("INF");
			else
				System.out.println(distance[i]);
		}
	}

	static void solve(int start) {
		PriorityQueue<Weight> q = new PriorityQueue<>();

		distance[start] = 0;
		q.add(new Weight(start, 0));

		while (!q.isEmpty()) {
			Weight w1 = q.poll();
			int index1 = w1.u;
			int weight1 = w1.w;
			for (int i = 0; i < list[index1].size(); i++) {
				Weight w2 = list[index1].get(i);
				int index2 = w2.u;
				int weight2 = w2.w;
				if (distance[index2] > weight1 + weight2) {
					distance[index2] = weight1 + weight2;
					q.add(new Weight(index2, distance[index2]));
				}
			}
		}
	}
}

class Weight implements Comparable<Weight> {
	int u;
	int w;

	Weight(int u, int w) {
		this.u = u;
		this.w = w;
	}

	public int compareTo(Weight we) {
		return this.w - we.w;
	}
}
