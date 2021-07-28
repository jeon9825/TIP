package algorithm.day8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ11659 { // 구간 합 구하기 4

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(tokenizer.nextToken());
        int m = Integer.parseInt(tokenizer.nextToken());
        int[] arr = new int[n + 1];
        int[] dp = new int[n + 1];
        tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 1; i < arr.length; i++) {
            arr[i] = Integer.parseInt(tokenizer.nextToken());
            dp[i] = dp[i - 1] + arr[i];
        }

        for (int i = 0; i < m; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            int a = Integer.parseInt(tokenizer.nextToken());
            int b = Integer.parseInt(tokenizer.nextToken());
            System.out.println(dp[b] - dp[a - 1]);
        }
    }
}
