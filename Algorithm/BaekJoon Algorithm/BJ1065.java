import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ1065 {
	static boolean 한수(int i) {
		int i1 = i / 1000;
		int i2 = (i % 1000) / 100;
		int i3 = (i % 100) / 10;
		int i4 = i % 10;
		if (i1 != 0) {
			if (i2 + i3 == i1 + i4)
				return true;
			else
				return false;
		} else {
			if (i2 != 0) {
				if (i3 * 2 == i2 + i4)
					return true;
				else
					return false;
			} else
				return true;
		}
	}

	static int count(int N) {
		int count = 0;
		for (int i = 1; i <= N; i++) {
			if (한수(i)) {
				count++;
			}
		}
		return count;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(reader.readLine());
		System.out.println(count(N));
	}

}
