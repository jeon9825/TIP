import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BJ1927 {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 0; i < n; i++) {
			int a = Integer.parseInt(reader.readLine());
			if (a == 0) {
				if (pq.isEmpty()) {
					System.out.println(0);
				} else {
					System.out.println(pq.poll());
				}
			} else {
				pq.offer(a);
			}
		}
	}
}
