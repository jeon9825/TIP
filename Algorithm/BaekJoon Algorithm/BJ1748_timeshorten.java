import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ1748_timeshorten {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(reader.readLine());
		int result = 0;
		for (int start = 1, length = 1; start <= N; start *= 10, length++) {
			int end = start * 10 - 1; // 1~9, 10~99, 100~ 999 에서 start 는 1, 10, 100, end는 9,99,999...
			if (end > N)
				end = N;
			result += (end - start + 1) * length; // 개수 * 길이
		}
		System.out.println(result);
	}
}
