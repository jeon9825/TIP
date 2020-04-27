import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1002 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());

		for (int i = 0; i < n; i++) {
			StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
			int x1 = Integer.parseInt(tokenizer.nextToken());
			int y1 = Integer.parseInt(tokenizer.nextToken());
			int r1 = Integer.parseInt(tokenizer.nextToken());
			int x2 = Integer.parseInt(tokenizer.nextToken());
			int y2 = Integer.parseInt(tokenizer.nextToken());
			int r2 = Integer.parseInt(tokenizer.nextToken());

			int sub = Math.abs(r1 - r2);
			int sum = r1 + r2;
			double d = Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2)); // 두 점 사이의 거리

			if (d == 0 && r1 == r2) {
				System.out.println(-1);
			} else if (sub < d && d < sum) {
				System.out.println(2);
			} else if (d == sum || d == sub) {
				System.out.println(1);
			} else if (d > sum || d < sub) {
				System.out.println(0);
			} else /* if (sub < d && d < sum) */ {
				System.out.println(2);
			}
		}
	}
}