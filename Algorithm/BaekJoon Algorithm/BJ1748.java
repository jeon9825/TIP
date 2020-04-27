import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ1748 {
	static int length(int n) { // nÀÇ ±æÀÌ
		int result = 0;
		while (n > 0) {
			result++;
			n /= 10;
		}
		return result;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(reader.readLine());
		int result = 0;
		for (int i = 1; i <= N; i++) {
			result += length(i);
		}
		System.out.println(result);
	}
}
