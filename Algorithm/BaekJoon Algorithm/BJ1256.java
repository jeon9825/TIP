package algorithm.day5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1256 { // 사전
    static int N, M, K;

    static int[][] D = new int[201][201];

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        N = Integer.parseInt(tokenizer.nextToken());
        M = Integer.parseInt(tokenizer.nextToken());
        K = Integer.parseInt(tokenizer.nextToken());

        if (combination(N + M, M) < K) {
            System.out.println(-1);
            return;
        }
        query(N, M, K, new StringBuilder());
    }

    private static void query(int n, int m, int k, StringBuilder builder) { // n+m 개 중에서 m개를 고르는
        if (n + m == 0) {
            System.out.println(builder.toString());
            return;
        } else if (n == 0) {
            builder.append("z");
            query(n, m - 1, k - 1, builder);
        } else if (m == 0) {
            builder.append("a");
            query(n - 1, m, k - 1, builder);
        } else {
            int leftCount = combination(n + m - 1, m);
            if (k <= leftCount) {
                builder.append("a");
                query(n - 1, m, k, builder);
            } else {
                builder.append("z");
                query(n, m - 1, k - leftCount, builder);
            }
        }
    }

    private static int combination(int n, int m) { // nCm
        if (D[n][m] != 0) {
            return D[n][m];
        }
        if (m == 0 || m == n)
            return D[n][m] = 1;
        return D[n][m] = Math.min((int) 1e9, combination(n - 1, m - 1) + combination(n - 1, m));
    }

}
