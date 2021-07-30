package algorithm.day9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ11049 { // 행렬 곱셈 순서

    static int[][] arr;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        arr = new int[n][2];
        StringTokenizer tokenizer;
        for (int i = 0; i < n; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            arr[i][0] = Integer.parseInt(tokenizer.nextToken());
            arr[i][1] = Integer.parseInt(tokenizer.nextToken());
        }

        dp = new int[n][n];
        System.out.println(solution(0, n - 1));
    }


    private static int solution(int start, int end) {
        if (start == end) return 0;

        if (dp[start][end] > 0) return dp[start][end];

        int min = Integer.MAX_VALUE;
        for (int i = start; i < end; ++i) {
            int n1 = solution(start, i);
            int n2 = solution(i + 1, end);
            int n3 = arr[start][0] * arr[i][1] * arr[end][1];
            min = Math.min(min, n1 + n2 + n3);
        }
        return dp[start][end] = min;
    }
}
