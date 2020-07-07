import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ1343 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		char[] c = reader.readLine().toCharArray();
		StringBuilder builder = new StringBuilder();
		int n = 0; // X의 개수

		int i = 0;
		while (true) {
			if (i >= c.length) {
				if (n == 0) {
					System.out.println(builder.toString());
				} else {
					if (n % 2 != 0) {
						System.out.println(-1);
					} else {
						int A = n / 4;
						n -= 4 * A;
						int B = n / 2;
						n = 0;
						for (int j = 0; j < A; j++) {
							builder.append("AAAA");
						}
						for (int j = 0; j < B; j++) {
							builder.append("BB");
						}
						System.out.println(builder.toString());
					}
				}
				break;
			}

			if (c[i] == '.') {
				if (n != 0) { // X만 나오다가 .이 처음 나온 경우
					if (n % 2 != 0) {
						System.out.println(-1);
						break;
					} else {
						int A = n / 4;
						n -= 4 * A;
						int B = n / 2;
						n = 0;
						for (int j = 0; j < A; j++) {
							builder.append("AAAA");
						}
						for (int j = 0; j < B; j++) {
							builder.append("BB");
						}
					}
				}
				builder.append(".");
			} else { // X일 경우
				n++;
			}
			i++;
		}
	}
}
