import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class BJ10773 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(reader.readLine()); // 연산의 개수
		Deque<Integer> stack = new ArrayDeque<>();
		for (int i = 0; i < K; i++) {
			int value = Integer.parseInt(reader.readLine());
			if (value == 0) {
				stack.pop();
			} else {
				stack.push(value);
			}
		}
		int sum = 0;
		for (Integer integer : stack) {
			sum += integer;
		}
		System.out.println(sum);

	}
}
