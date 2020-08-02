import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ1744 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		int[] num = new int[n];

		for (int i = 0; i < num.length; i++) {
			num[i] = Integer.parseInt(reader.readLine());
		}
		Arrays.sort(num);
		int sum = 0;
		int left = 0;
		int right = n - 1;
		for (; left < num.length - 1; left += 2) {
			if (num[left] < 1 && num[left + 1] < 1)
				sum += num[left] * num[left + 1];
			else
				break;
		}

		for (; right > 0; right -= 2) {
			if (num[right] > 1 && num[right - 1] > 1)
				sum += num[right] * num[right - 1];
			else
				break;
		}

		for (; right >= left; right--) {
			sum += num[right];
		}

		System.out.println(sum);
	}
}
