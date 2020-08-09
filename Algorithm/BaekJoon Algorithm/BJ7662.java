import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ7662 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(reader.readLine());
		StringTokenizer tokenizer;
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < t; i++) {
			int k = Integer.parseInt(reader.readLine());
			PriorityQueue<Pair2> maxHeap = new PriorityQueue<>(new ComparatorDescending());
			PriorityQueue<Pair2> minHeap = new PriorityQueue<>(new ComparatorAscending());
			boolean[] visited = new boolean[k];

			for (int j = 0; j < k; j++) {
				tokenizer = new StringTokenizer(reader.readLine());
				String op = tokenizer.nextToken();
				long n = Long.parseLong(tokenizer.nextToken());

				if (op.equals("I")) {
					Pair2 p = new Pair2(j, n);
					minHeap.add(p);
					maxHeap.add(p);
				} else {
					if (n == 1) {
						if (!maxHeap.isEmpty()) {
							Pair2 p = maxHeap.peek();
							if (!visited[p.idx]) {
								maxHeap.poll();
								visited[p.idx] = true;
							}
						}
					} else {
						if (!minHeap.isEmpty()) {
							Pair2 p = minHeap.peek();
							if (!visited[p.idx]) {
								minHeap.poll();
								visited[p.idx] = true;
							}

						}
					}
				}

				while (!minHeap.isEmpty()) {
					if (!visited[minHeap.peek().idx]) {
						break;
					} else {
						minHeap.poll();
					}
				}

				while (!maxHeap.isEmpty()) {
					if (!visited[maxHeap.peek().idx]) {
						break;
					} else {
						maxHeap.poll();
					}
				}
			}

			if (maxHeap.isEmpty() || minHeap.isEmpty()) {
				sb.append("EMPTY\n");
			} else {
				sb.append(maxHeap.peek().value + " " + minHeap.peek().value + "\n");
			}

		}
		System.out.println(sb.toString());
	}
}

class Pair2 {
	int idx;
	long value;

	Pair2(int idx, long value) {
		this.idx = idx;
		this.value = value;
	}
}

class ComparatorDescending implements Comparator<Pair2> {
	@Override
	public int compare(Pair2 p1, Pair2 p2) {
		// TODO Auto-generated method stub
		if (p1.value < p2.value) {
			return 1;
		} else {
			return -1;
		}
	}
}

class ComparatorAscending implements Comparator<Pair2> {
	@Override
	public int compare(Pair2 p1, Pair2 p2) {
		// TODO Auto-generated method stub
		if (p1.value < p2.value) {
			return -1;
		} else {
			return 1;
		}
	}
}
