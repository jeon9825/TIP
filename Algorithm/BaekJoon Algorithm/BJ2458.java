package algorithm.day7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2458 { // 키순서 ...플로이드 워셜

    static int n;
    static int[][] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        n = Integer.parseInt(tokenizer.nextToken());
        dist = new int[n + 1][n + 1];

        int m = Integer.parseInt(tokenizer.nextToken());
        for (int i = 0; i < m; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            int a = Integer.parseInt(tokenizer.nextToken());
            int b = Integer.parseInt(tokenizer.nextToken());

            dist[a][b] = 1;
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (i == j)
                        dist[i][j] = 1;
                    if (dist[i][k] == 1 && dist[k][j] == 1)
                        dist[i][j] = 1;
                }
            }
        }

        int answer = 0;
        for (int i = 1; i <= n; i++) {
            int count = 0;
            for (int j = 0; j <= n; j++) {
                if (dist[i][j] == 1 || dist[j][i] == 1)
                    count++;
            }
            if (count == n)
                answer++;
        }
        System.out.println(answer);
    }
}
