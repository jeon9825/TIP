package algorithm.day9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ5582 { // 공통 부분 문자열

    static String line1;
    static String line2;
    static int[][] dp;
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        line1 = reader.readLine();
        line2 = reader.readLine();

        dp = new int[line1.length()][line2.length()];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        solution(0, 0, 0);

//        for (int i = 0; i < dp.length; i++) {
//            System.out.println(Arrays.toString(dp[i]));
//        }
        System.out.println(max);
    }

    static int solution(int index1, int index2, int pre) {
        if (dp[index1][index2] >= 0)
            return dp[index1][index2];

        if (index1 + 1 < line1.length())
            solution(index1 + 1, index2, pre);
        if (index2 + 1 < line2.length())
            solution(index1, index2 + 1, pre);

        if (line1.charAt(index1) == line2.charAt(index2)) {
            if (index1 + 1 < line1.length() && index2 + 1 < line2.length()) {
                dp[index1][index2] = 1 + solution(index1 + 1, index2 + 1, pre + 1);
            } else {
                dp[index1][index2] = 1;
            }
            max = Math.max(dp[index1][index2], max);
            return dp[index1][index2];
        }

        // 이전값 넣고싶다..
        return dp[index1][index2] = pre;
    }
}
