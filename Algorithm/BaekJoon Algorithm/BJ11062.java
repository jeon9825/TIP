package algorithm.day10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ11062 { // 카드 게임

    static int n;
    static int[] arr;
    static int[][][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(reader.readLine());
        for (int i = 0; i < t; i++) {
            n = Integer.parseInt(reader.readLine());
            arr = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            dp = new int[2][n + 1][n + 1];
            System.out.println(solution(0, 0, n - 1));
        }
    }

    static int solution(int flag, int start, int end) { // flag : 0이 근우, 1이 명우
        if (start == end) {
            if (flag == 0)
                return dp[flag][start][end] = arr[start];
            else
                return dp[flag][start][end] = 0;
        }

        if (dp[flag][start][end] > 0)
            return dp[flag][start][end];

        if (flag == 0) {
            return dp[flag][start][end]
                    = Math.max(arr[start] + solution(1, start + 1, end),
                    arr[end] + solution(1, start, end - 1));
        } else {
            return dp[flag][start][end] = Math.min(solution(0, start + 1, end),
                    solution(0, start, end - 1));
        }
    }
}
