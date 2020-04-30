import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class BJ1874 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(reader.readLine());
		int[] t = new int[N];
		for (int i = 0; i < t.length; i++) {
			t[i] = Integer.parseInt(reader.readLine());
		}

		Stack<Integer> s = new Stack<>();
		int i = 0;
		int num = 1;
		boolean b = false;
		StringBuilder sb = new StringBuilder();
		while (i < t.length) {
			b = false;
			if (!s.isEmpty() && s.peek() == t[i]) {
				s.pop();
				sb.append("-\n");
				i++;
				b = true;
				continue;
			}
			s.push(num);
			sb.append("+\n");
			if (num > t.length)
				break;
			num++;
		}
		if (b == true)
			System.out.println(sb.toString());
		else
			System.out.println("NO");
	}
}
