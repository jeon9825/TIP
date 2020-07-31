import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ1389 {
	static int n;
	static int[][] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

		n = Integer.parseInt(tokenizer.nextToken()); // 유저 수

		arr = new int[n][n];

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j] = n;
			}
		}
		int m = Integer.parseInt(tokenizer.nextToken()); // 관계 수
		for (int i = 0; i < m; i++) {
			tokenizer = new StringTokenizer(reader.readLine());
			int a = Integer.parseInt(tokenizer.nextToken()) - 1;
			int b = Integer.parseInt(tokenizer.nextToken()) - 1;
			arr[a][b] = 1;
			arr[b][a] = 1;
		}

		for (int k = 0; k < n; k++) {
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr[i].length; j++) {
					if (arr[i][k] + arr[k][j] < arr[i][j])
						arr[i][j] = arr[i][k] + arr[k][j];
				}
			}
		}

		int min = Integer.MAX_VALUE;
		int index = -1;
		for (int i = 0; i < arr.length; i++) {
			int sum = 0;
			for (int j = 0; j < arr[i].length; j++) {
				if (i == j)
					continue;
				sum += arr[i][j];
			}
			if (sum < min) {
				min = sum;
				index = i;
			}
		}
		System.out.println(index + 1);
	}
}

class Friend {
	int num;
	int dis;

	public Friend(int num, int dis) {
		this.num = num;
		this.dis = dis;
	}
}
