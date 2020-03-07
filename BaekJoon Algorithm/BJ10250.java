import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ10250 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(reader.readLine());
		StringTokenizer tokenizer;
		for (int i = 0; i < T; i++) {
			tokenizer = new StringTokenizer(reader.readLine());
			int H = Integer.parseInt(tokenizer.nextToken());
			int W = Integer.parseInt(tokenizer.nextToken());
			int N = Integer.parseInt(tokenizer.nextToken());
			int floor;
			int num;
			if ((N % H) == 0) {
				floor = H;
				num = N / H;
			} else {
				floor = N % H;
				num = N / H + 1;
			}
			System.out.printf("%d%02d\n", floor, num);
		}
	}
}
