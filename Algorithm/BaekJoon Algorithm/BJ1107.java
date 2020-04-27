import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ1107 {

	static int possible(int channel, boolean[] remote) {
		if (channel == 100) {
			return 0;
		}

		int length = 0;
		while (true) {
			int c = channel % 10;
			if (remote[c] == false)
				return 0;

			channel /= 10;
			length++;
			if (channel <= 0) {
				break;
			}
		}
		return length;
	}

	static int length(int i) {
		String s = String.valueOf(i);
		return s.length();
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		boolean[] remote = new boolean[10];
		for (int i = 0; i < remote.length; i++) {
			remote[i] = true;
		}

		int channel = Integer.parseInt(reader.readLine());
		int n = Integer.parseInt(reader.readLine());
		if (n > 0) {
			StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
			for (int i = 0; i < n; i++) {
				int no = Integer.parseInt(tokenizer.nextToken());
				remote[no] = false;
			}
		}

		int min = Math.abs(100 - channel); // 초기화 +,-로만 이동했을 최소값

		for (int i = 0; i < 1000000; i++) {
			int length = possible(i, remote); // 누르지 못하면 0을 반환함.
			if (length > 0) {
				int ans = possible(i, remote) + Math.abs(i - channel);
				if (min > ans)
					min = ans;
			}
		}
		System.out.println(min);
	}
}
