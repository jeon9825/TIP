package algorithm.day9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ9252 {

    static String line1;
    static String line2;
    static String[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        line1 = reader.readLine();
        line2 = reader.readLine();

        dp = new String[line1.length()][line2.length()];
        String lcs = solution(0, 0);
        System.out.println(lcs.length());
        System.out.println(lcs);
    }

    private static String solution(int index1, int index2) {
        if (index1 >= line1.length() || index2 >= line2.length())
            return "";

        if (dp[index1][index2] != null)
            return dp[index1][index2];

        if (line1.charAt(index1) == line2.charAt(index2)) {
            return line1.charAt(index1) + solution(index1 + 1, index2 + 1);
        }

        String s1 = solution(index1 + 1, index2);
        String s2 = solution(index1, index2 + 1);
        return dp[index1][index2] = (s1.length() > s2.length()) ? s1 : s2;
    }
}
