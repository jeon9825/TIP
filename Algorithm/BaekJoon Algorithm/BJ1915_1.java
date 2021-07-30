package algorithm.day9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1915 { // 가장 큰 정사각형

    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        int n = Integer.parseInt(tokenizer.nextToken());
        int m = Integer.parseInt(tokenizer.nextToken());

        arr = new int[n][m];

        int max = 0;
        for (int i = 0; i < n; i++) {
            String line = reader.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = line.charAt(j) - '0';
                if (arr[i][j] == 1)
                    max = arr[i][j];
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (arr[i][j] == 1) {
                    arr[i][j] += Math.min(Math.min(arr[i][j - 1], arr[i - 1][j]), arr[i - 1][j - 1]);
                    max = Math.max(arr[i][j], max);
                }
            }
        }

        System.out.println(max * max);
    }
}
