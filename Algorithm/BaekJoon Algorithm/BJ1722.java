package algorithm.me;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1722 { // 순열의 순서

    static int N;
    static long[] dp;
    static boolean[] visited;
    static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(reader.readLine());
        dp = new long[N + 1];
        visited = new boolean[N + 1];
        result = new int[N];
        factorial(N);

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int a = Integer.parseInt(tokenizer.nextToken());

        if (a == 1) { // k번째 수 구하기
            long K = Long.parseLong(tokenizer.nextToken());

            query(N, K, 0);
        } else { // 이 숫자가 몇 번째인지 구하기
            for (int i = 0; i < result.length; i++) {
                result[i] = Integer.parseInt(tokenizer.nextToken());
            }
            query2(N, 0, 0);
        }
    }

    private static void query2(int n, int i, long k) {
        if (n == 1) {
            System.out.println(k + 1);
            return;
        }

        int num = result[i];

        long seq = 0;
        for (int j = 1; j < num; j++) {
            if (!visited[j]) {
                seq++;
            }
        }
        seq *= dp[n - 1];
        k += seq;

        visited[num] = true;
        query2(n - 1, i + 1, k);
    }

    private static void query(int n, long k, int i) {
        if (n == 1) { // 종료조건
            for (int j = 1; j < visited.length; j++) {
                if (!visited[j]) {
                    result[i++] = j;
                }
            }
            for (int j = 0; j < result.length; j++) {
                System.out.print(result[j] + " ");
            }
            return;
        }

        long seq = dp[n - 1];

        int num = 1;
        for (int j = 1; j < visited.length; j++) {
            if (!visited[j]) {
                num = j;
                break;
            }
        }

        while (true) {
            if (!visited[num]) {
                if (k <= seq) {
                    visited[num] = true;
                    result[i] = num;
                    query(n - 1, k, i + 1);
                    break;
                }
                k -= seq;
            }
            num++;
        }
    }

    static long factorial(int n) { // n!
        if (dp[n] > 0)
            return dp[n];
        if (n <= 1)
            return dp[n] = 1;
        return dp[n] = n * factorial(n - 1);
    }
}
