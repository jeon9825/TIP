package algorithm.day10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ2342 { // DDR

    static Integer[] arr;
    static int[][][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> list = new ArrayList<>();

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        while (true) {
            int n = Integer.parseInt(tokenizer.nextToken());
            if (n == 0)
                break;
            list.add(n);
        }
        arr = list.toArray(new Integer[0]);

        dp = new int[arr.length][5][5];
        System.out.println(solution(0, 0, 0)); // index는 해결해야하는 문제
    }

    private static int solution(int index, int left, int right) {
        if (index >= arr.length)
            return 0;

        if (dp[index][left][right] > 0)
            return dp[index][left][right];

        // 왼쪽을 움직일 거야
        int moveLeft = score(left, arr[index]) + solution(index + 1, arr[index], right);
        // 오른쪽을 움직일 거야
        int moveRight = score(right, arr[index]) + solution(index + 1, left, arr[index]);

        // 뭐가 더 작아?
        return dp[index][left][right] = Math.min(moveLeft, moveRight);
    }

    static int score(int from, int to) {
        // 0. 지금 위치를 누르면 1
        if (from == to) return 1;
        // 1. 가운데 출발 2
        if (from == 0) return 2;
        // 3. 크로스 해서 밟으면 4
        if (Math.abs(from - to) == 2) return 4;
        // 4. 인접 스텝 밟으면 3
        return 3;
    }
}
