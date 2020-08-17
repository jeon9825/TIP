import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ2579 {
//	static int n;
//	static int max = Integer.MIN_VALUE;
//	static int[] arr;

//	static void go(int index, int count, boolean[] visited) {
//		if (index == n - 1) {
//			if (count != 2)
//				visited[index] = true;
//			else if (count == 2)
//				visited[index] = false;
//
//			int sum = 0;
//			for (int i = 0; i < visited.length; i++) {
//				if (visited[i]) {
////					System.out.print(i + " ");
//					sum += arr[i];
//				}
//			}
////			System.out.println(sum + " " + count);
//			max = Math.max(max, sum);
//			return;
//		} else if (index >= n) {
//			return;
//		}
//
//		visited[index] = true;
//		if (count < 1 && index <= n - 2) {
//			go(index + 1, count + 1, visited);
//		}
//		if (index <= n - 3)
//			go(index + 2, 0, visited);
//
//		visited[index] = false;
//		if (index <= n - 2)
//			go(index + 1, 0, visited);
//		if (index <= n - 3)
//			go(index + 2, 0, visited);
//
//	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());

		int[] arr = new int[n];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(reader.readLine());
		}

//		go(0, 0, new boolean[n]);

		int[] dp = new int[n];

		dp[0] = arr[0];
		if (n == 1) {
			System.out.println(dp[0]);
			return;
		}
		dp[1] = arr[1] + arr[0];
		if (n == 2) {
			System.out.println(dp[1]);
			return;
		}

		dp[2] = Math.max(arr[0] + arr[2], arr[1] + arr[2]);
		for (int i = 3; i < n; i++) {
			dp[i] = Math.max(dp[i - 3] + arr[i] + arr[i - 1], dp[i - 2] + arr[i]);
		}

		System.out.println(dp[n - 1]);
//		System.out.println(max);
	}
}
