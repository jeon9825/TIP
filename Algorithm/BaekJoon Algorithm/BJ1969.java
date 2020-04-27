import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1969 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(tokenizer.nextToken());
		int m = Integer.parseInt(tokenizer.nextToken());
		char[][] sArr = new char[n + 1][m];
		for (int i = 0; i < sArr.length - 1; i++) {
			String s = reader.readLine();
			for (int j = 0; j < sArr[i].length; j++) {
				sArr[i][j] = s.charAt(j);
			}
		}
		int max;
		int[] index;
		int sum = 0;
		for (int i = 0; i < m; i++) {
			index = new int[4]; // ATGC ¼ø

			for (int j = 0; j < sArr.length; j++) {
				if (sArr[j][i] == 'A') {
					index[0]++;
				}
				if (sArr[j][i] == 'T') {
					index[1]++;
				}
				if (sArr[j][i] == 'G') {
					index[2]++;
				}
				if (sArr[j][i] == 'C') {
					index[3]++;
				}

			}
			max = Integer.MIN_VALUE;
			int idx = -1;
			for (int j2 = 0; j2 < index.length; j2++) {
				if (max < index[j2]) {
					idx = j2;
					max = index[j2];
				}
			}
			char c = 'a';

			if (idx == 0) {
				c = 'A';
			} else if (idx == 1) {
				c = 'T';
			} else if (idx == 2) {
				c = 'G';
			} else if (idx == 3) {
				c = 'C';
			}

			sArr[n][i] = c;
			for (int j = 0; j < sArr.length; j++) {
				if (sArr[n][i] != sArr[j][i])
					sum++;
			}

		}
		for (int i = 0; i < sArr[n].length; i++) {
			System.out.print(sArr[n][i]);
		}
		System.out.println();
		System.out.println(sum);

	}

}
