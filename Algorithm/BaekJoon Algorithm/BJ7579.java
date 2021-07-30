package algorithm.day9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ7579 { // 앱

    static int n, m;
    static int[] memory;
    static int[] cost;
    static int sum;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        n = Integer.parseInt(tokenizer.nextToken());
        m = Integer.parseInt(tokenizer.nextToken());

        memory = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        cost = new int[n];
        tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < cost.length; i++) {
            cost[i] = Integer.parseInt(tokenizer.nextToken());
            sum += cost[i];
        }

        dp = new int[n][sum + 1];
        for (int i = cost[0]; i < dp[0].length; i++) {
            dp[0][i] = memory[0];
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                if (j >= cost[i]) {
                    dp[i][j] = Math.max(dp[i][j], memory[i] + dp[i - 1][j - cost[i]]);
                }
                dp[i][j] = Math.max(dp[i][j], dp[i - 1][j]);
            }
        }

        for (int i = 0; i < dp[0].length; i++) {
            if (dp[n - 1][i] >=m){
                System.out.println(i);
                return;
            }
        }
    }
}
