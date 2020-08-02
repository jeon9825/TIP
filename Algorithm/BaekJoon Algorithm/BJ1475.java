import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ1475 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(reader.readLine());
		int[] num = new int[10];

		if (N == 0)
			num[0] = 1;

		while (N > 0) {
			int digit = N % 10;
			num[digit]++;
			N /= 10;
		}

		int max = (num[6] + num[9] + 1) / 2;
		for (int i = 0; i < num.length; i++) {
			if (i != 6 && i != 9)
				max = Math.max(num[i], max);
		}
		System.out.println(max);
	}

}
