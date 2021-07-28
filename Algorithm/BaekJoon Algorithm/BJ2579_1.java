package algorithm.day8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ2579 { // 계단 오르기

    static int n;
    static int[] stairs;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(reader.readLine());
        stairs = new int[n];
        for (int i = 0; i < stairs.length; i++) {
            stairs[i] = Integer.parseInt(reader.readLine());
        }
        dp = new int[n][4];
        System.out.println(solution(n - 1, false, false));

    }

    static int solution(int index, boolean 전계단, boolean 전전계단) {
        if (index < 0)
            return 0;

        int index2 = (전계단 ? 1 : 0) + (전전계단 ? 2 : 0);
        if (dp[index][index2] != 0)
            return dp[index][index2];

        int 점수1 = 0, 점수2 = 0;
        if ((전계단))  // 안가기
            점수1 = solution(index - 1, false, 전계단);
        if (!(전전계단 && 전계단) || (index == n - 1)) //가기
            점수2 = stairs[index] + solution(index - 1, true, 전계단);

        return dp[index][index2] = Math.max(점수1, 점수2);
    }
}
