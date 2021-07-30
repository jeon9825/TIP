package algorithm.day10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ1102 { // 발전소

    static int n;
    static int[][] w;
    static int p;
    static char[] onOff;
    static int[][] dp;
    static final int INF = 1000000000;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(reader.readLine());

        w = new int[n][n];
        for (int i = 0; i < n; i++) { // w[i][j] 발전소 i를 이용해서 발전소 j를 재시작할 때 드는 비용
            w[i] = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        // 고장나지 않은 발전소를 이용해서 고장난 발전소를 재시작하면 된다
        onOff = reader.readLine().toCharArray();
        // 몇번이 꺼져있는지 확인해보자고
        p = Integer.parseInt(reader.readLine());

        int visited = 0;
        int cnt = 0;
        for (int i = 0; i < onOff.length; i++) {
            if (onOff[i] == 'Y') {
                visited = (visited | (1 << i));
                cnt++;
            }
        }

        dp = new int[n][1 << n];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], INF);
        }

        int answer = TSP(cnt, visited);

        if (answer == INF) {
            System.out.println(-1);
        } else {
            System.out.println(answer);
        }
    }


    static int TSP(int cnt, int visited) {
        if (cnt >= p)
            return 0;

        if (dp[cnt][visited] != INF)
            return dp[cnt][visited];

        for (int i = 0; i < n; i++) {
            if ((visited & (1 << i)) == 0)
                continue;

            for (int j = 0; j < n; j++) {
                if ((visited & 1 << j) != 0)
                    continue;
                if (i == j)
                    continue;

                dp[cnt][visited] = Math.min(dp[cnt][visited],
                        w[i][j] + TSP(cnt + 1, visited | (1 << j)));
            }
        }
        return dp[cnt][visited];
    }
}
