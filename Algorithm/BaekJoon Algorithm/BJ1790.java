import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1790 {
	static int length(int n) { // n의 길이
		int result = 0;
		while (n > 0) {
			result++;
			n /= 10;
		}
		return result;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
		int N = Integer.parseInt(tokenizer.nextToken());
		int k = Integer.parseInt(tokenizer.nextToken());

		int result = 0;
//		StringBuilder builder = new StringBuilder();
		int i;
		for (i = 1; i <= N; i++) {
//			builder.append(i);
			result += length(i);
			if (result >= k)
				break;
		}

		if (k > result)
			System.out.println(-1);
		else {
			String s = String.valueOf(i);
			int index = s.length() - 1 - (result - k); //이거 구하기가 어려움.........
			System.out.println(s.charAt(index));
//			System.out.println(builder.toString().charAt(k - 1)); // index는 0부터 시작
		}
	}
}
