import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ4344 {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
		int c = Integer.parseInt(tokenizer.nextToken());
		for (int i = 0; i < c; i++) {
			tokenizer = new StringTokenizer(reader.readLine());
			int n = Integer.parseInt(tokenizer.nextToken());
			int[] student = new int[n];
			int sum = 0;
			for (int j = 0; j < student.length; j++) {
				student[j] = Integer.parseInt(tokenizer.nextToken());
				sum += student[j];
			}
			double ave = (double) sum / n;
			int cnt = 0;
			for (int j = 0; j < student.length; j++) {
				if (student[j] > ave)
					cnt++;
			}
			double rate = (double) cnt * 100 / n;
			System.out.printf("%.3f%%\n", rate);
		}
	}
}
