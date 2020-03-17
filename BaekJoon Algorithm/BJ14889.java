import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ14889 {
	static int min = Integer.MAX_VALUE;

	static int go(int[][] s, int n, int index, ArrayList<Integer> first, ArrayList<Integer> second) {
		if (index == n) {
			if (first.size() != n / 2)
				return -1;
			if (second.size() != n / 2)
				return -1;

			int t1 = 0;
			for (int i = 0; i < first.size(); i++) {
				for (int j = 0; j < first.size(); j++) {
					if (i == j)
						continue;
					t1 += s[first.get(i)][first.get(j)];
				}
			}
			int t2 = 0;
			for (int i = 0; i < second.size(); i++) {
				for (int j = 0; j < second.size(); j++) {
					if (i == j)
						continue;
					t2 += s[second.get(i)][second.get(j)];
				}
			}
			return Math.abs(t1 - t2);
		}
		if (first.size() > n / 2)
			return -1;
		if (second.size() > n / 2)
			return -1;

		int ans = Integer.MAX_VALUE;
		first.add(index);
		int t1 = go(s, n, index + 1, first, second);
		if (ans > t1 && t1 != -1)
			ans = t1;
		first.remove(first.size() - 1);

		second.add(index);
		int t2 = go(s, n, index + 1, first, second);
		if (ans > t2 && t2 != -1)
			ans = t2;
		second.remove(second.size() - 1);

		return ans;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(reader.readLine());
		int[][] s = new int[N][N];
		StringTokenizer tokenizer;

		for (int i = 0; i < s.length; i++) {
			tokenizer = new StringTokenizer(reader.readLine());
			for (int j = 0; j < s[i].length; j++) {
				s[i][j] = Integer.parseInt(tokenizer.nextToken());
			}
		}
		ArrayList<Integer> first = new ArrayList<>();
		ArrayList<Integer> second = new ArrayList<>();

		System.out.println(go(s, s.length, 0, first, second));
	}
}
