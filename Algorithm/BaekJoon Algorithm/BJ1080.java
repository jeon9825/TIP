import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1080 {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(tokenizer.nextToken());
		int m = Integer.parseInt(tokenizer.nextToken());

		char[][] arr = new char[n][m];
		boolean[][] check = new boolean[n][m]; // 값이 같으면 true, 다르면 false

		for (int i = 0; i < arr.length; i++) {
			arr[i] = reader.readLine().toCharArray();
		}

		int diff = 0;
		for (int i = 0; i < arr.length; i++) {
			char[] inputs = reader.readLine().toCharArray();
			for (int j = 0; j < arr[i].length; j++) {
				if (inputs[j] != arr[i][j]) {
					check[i][j] = true;
					diff++;
				}
			}
		}

		if (diff == 0)
			System.out.println(0);
		else
			System.out.println(ans(check));
	}

	static int ans(boolean[][] check) {
		int n = check.length;
		int m = check[0].length;

		if (n < 3 || m < 3) // 둘중에 하나가 3보다 작으면 reverse 할 수 없어 오류
			return -1;

		int count = 0;
		for (int i = 0; i <= n - 3; i++) {
			for (int j = 0; j <= m - 3; j++) {

				if (i == n - 3 && !(check[i][j] == check[i + 1][j] && check[i][j] == check[i + 2][j]))
					return -1;
				if (j == m - 3 && !(check[i][j] == check[i][j + 1] && check[i][j] == check[i][j + 2]))
					return -1;

				if (check[i][j]) {
					reverse(check, i, j);
					count++;
				}
			}
		}

		boolean flag = check[n - 3][m - 3];
		for (int i = n - 2; i < n; i++) {
			for (int j = m - 2; j < m; j++) {
				if (flag != check[i][j])
					return -1;
			}

		}
		return count;
	}

	static void reverse(boolean[][] check, int x, int y) {
		for (int i = x; i < x + 3; i++) {
			for (int j = y; j < y + 3; j++) {
				check[i][j] = !check[i][j];
			}
		}
	}
}
