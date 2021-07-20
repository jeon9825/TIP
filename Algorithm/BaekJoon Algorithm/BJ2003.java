package algorithm.day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ2003 { // 수들의 합2

    static int N, M;
    static int[] A;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        N = Integer.parseInt(tokenizer.nextToken());
        M = Integer.parseInt(tokenizer.nextToken());

        A = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        // 투포인터
        int left = 0;
        int right = 0;

        int result = 0; // 결과

        while (right < N) {
            int sum = 0;
            for (int i = left; i <= right; i++) {
                sum += A[i];
            }

            if (sum >= M) {
                if (sum == M)
                    result++;
                left++;
                if (left > right)
                    right = left;
            } else { // sum < M
                right++;
            }
        }

        System.out.println(result);
    }
}
