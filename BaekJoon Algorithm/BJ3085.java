import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ3085 {
	static int check(char[][] table) {
		int ans = 1;
		for (int i = 0; i < table.length; i++) {
			int cnt = 1;
			char c = table[i][0];
			for (int j = 1; j < table[i].length; j++) { // За
				if (c == table[i][j]) {
					cnt++;
				} else {
					cnt = 1;
					c = table[i][j];
				}

				if (ans < cnt)
					ans = cnt;
			}

			cnt = 1;
			c = table[0][i];
			for (int j = 1; j < table[i].length; j++) { // ї­
				if (c == table[j][i]) {
					cnt++;
				} else {
					cnt = 1;
					c = table[j][i];
				}

				if (ans < cnt)
					ans = cnt;
			}

		}
		return ans;
	}

	static void swapV(char[][] table, int i, int j) {
		char ch = table[i][j];
		table[i][j] = table[i][j + 1];
		table[i][j + 1] = ch;
	}

	static void swapH(char[][] table, int i, int j) {
		char ch = table[i][j];
		table[i][j] = table[i + 1][j];
		table[i + 1][j] = ch;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(reader.readLine());
		char[][] table = new char[N][N];
		for (int i = 0; i < table.length; i++) {
			String s = reader.readLine();
			for (int j = 0; j < table[i].length; j++) {
				table[i][j] = s.charAt(j);
			}
		}

		int maxCandy = Integer.MIN_VALUE;
		for (int i = 0; i < table.length; i++) {
			for (int j = 0; j < table[i].length; j++) {
				if (i < table.length - 1) {
					swapH(table, i, j);
					int answer = check(table);
					if (maxCandy < answer)
						maxCandy = answer;
					swapH(table, i, j);
				}
				if (j < table[i].length - 1) {
					swapV(table, i, j);
					int answer = check(table);
					if (maxCandy < answer)
						maxCandy = answer;
					swapV(table, i, j);
				}
			}
		}

		System.out.println(maxCandy);
	}
}
