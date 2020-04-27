import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ4153 {

	static void bigger(int[] n) {
		int max = n[0];

		for (int i = 1; i < n.length; i++) {
			max = max < n[i] ? n[i] : max;
		}

		if (max == n[0]) {
			n[0] = n[2];
			n[2] = max;
		} else if (max == n[1]) {
			n[1] = n[2];
			n[2] = max;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
			int[] n = new int[3];
			for (int i = 0; i < n.length; i++) {
				n[i] = Integer.parseInt(tokenizer.nextToken());
			}

			if (n[0] == 0 && n[1] == 0 && n[2] == 0)
				break;

			bigger(n); // Arrays.sort(n); À¸·Î ÇÏ¸é µÊ ...¤Ì.¤Ì

			if (Math.pow(n[0], 2) + Math.pow(n[1], 2) == Math.pow(n[2], 2)) {
				System.out.println("right");
			} else {
				System.out.println("wrong");
			}
		}
	}
}
