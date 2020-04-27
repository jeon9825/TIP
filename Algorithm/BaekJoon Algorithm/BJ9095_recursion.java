import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ9095_recursion {
	static int go(int count, int sum, int goal) {
		if (sum == goal)
			return 1;
		if (sum > goal)
			return 0;
		int cnt = 0;
		for (int i = 1; i <= 3; i++) {
			cnt += go(count + 1, sum + i, goal);
		}
		return cnt;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(reader.readLine());
		for (int i = 0; i < T; i++) {
			int n = Integer.parseInt(reader.readLine());
			System.out.println(go(0, 0, n));
		}
	}
}
