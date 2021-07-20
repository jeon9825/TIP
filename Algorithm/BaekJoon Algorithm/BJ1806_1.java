package algorithm.day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1806_1 {

    static int N, S;
    static int[] A;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        N = Integer.parseInt(tokenizer.nextToken());
        S = Integer.parseInt(tokenizer.nextToken());

        tokenizer = new StringTokenizer(reader.readLine());
        A = new int[N + 1];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(tokenizer.nextToken());
        }

        // 투포인터
        int left = 0;
        int right = 0;

        int sum = A[0];
        int minLength = Integer.MAX_VALUE;


        while (true) {

            if (sum >= S) {
                minLength = Math.min(right - left + 1, minLength);
                sum -= A[left++];
            } else {
                sum += A[++right];
            }

            if (left == N || right == N)
                break;
        }

        if (minLength == Integer.MAX_VALUE)
            System.out.println(0);
        else
            System.out.println(minLength);
    }

}
