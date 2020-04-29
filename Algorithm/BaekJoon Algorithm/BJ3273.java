import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ3273 {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		int[] num = new int[n];
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
		for (int i = 0; i < num.length; i++) {
			num[i] = Integer.parseInt(tokenizer.nextToken());
		}
		int sum = Integer.parseInt(reader.readLine());
		Arrays.sort(num);
		int count = 0;
		for (int i = 0; i < num.length; i++) {
			for (int j = i + 1; j < num.length; j++) {
				if (sum < num[i] + num[j])
					break;
				else if (sum == num[i] + num[j])
					count++;
			}
		}
		System.out.println(count);
	}
}
