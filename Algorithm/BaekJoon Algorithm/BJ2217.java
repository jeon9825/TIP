import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ2217 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		int[] rope = new int[n];

		for (int i = 0; i < rope.length; i++) {
			rope[i] = Integer.parseInt(reader.readLine());
		}

		Arrays.sort(rope); // 정렬

		int max = Integer.MIN_VALUE;
		for (int i = 1; i <= rope.length; i++) {
			int m = rope[rope.length - i] * i;
			if (m > max)
				max = m;
		}
		System.out.println(max);
	}
}
