package algorithm.day8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1932 { // 정수 삼각형

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[] tree = new int[((n + 1) * n / 2) + 1];
        int index = 1;
        StringTokenizer tokenizer;
        for (int i = 0; i < n; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            for (int j = 0; j <= i; j++) {
                tree[index++] = Integer.parseInt(tokenizer.nextToken());
            }
        }


        index = tree.length - n - 1;
        for (int i = n - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                tree[index] += Math.max(tree[index + i], tree[index + i + 1]);
                index--;
            }
        }
        System.out.println(tree[1]);
    }
}
