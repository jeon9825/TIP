import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class BJ2164 {

	static int lastCard(ArrayDeque<Integer> q) {
		while (q.size() != 1) {
			q.pop();
			q.add(q.pop());
		}
		return q.pop();
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(reader.readLine());
		ArrayDeque<Integer> q = new ArrayDeque<>();

		for (int i = 0; i < N; i++) {
			q.add(i + 1);
		}

		System.out.println(lastCard(q));
	}

}
