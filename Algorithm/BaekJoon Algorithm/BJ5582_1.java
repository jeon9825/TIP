package algorithm.me;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ5582 { // 공통부분 문자열 다시 풀어보기

    static String line1;
    static String line2;
    static int dp[][];
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        line1 = reader.readLine();
        line2 = reader.readLine();

        dp = new int[line1.length()][line2.length()];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        solution(0, 0);
        System.out.println(max);
//        for (int i = 0; i < dp.length; i++) {
//            System.out.println(Arrays.toString(dp[i]));
//        }
    }

    static int solution(int index1, int index2) {
        if (index1 >= line1.length() || index2 >= line2.length())
            return 0;

        if (dp[index1][index2] >= 0)
            return dp[index1][index2];

        solution(index1 + 1, index2);
        solution(index1, index2 + 1);

        if (line1.charAt(index1) == line2.charAt(index2)) { // 같을 때
            dp[index1][index2] = 1 + solution(index1 + 1, index2 + 1);
            max = Math.max(max, dp[index1][index2]);
            return dp[index1][index2];
        } else {
            return dp[index1][index2] = 0;
        }
    }
}
