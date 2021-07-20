package algorithm.day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ2003_1 { // 수들의 합2

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
        int sum = A[0];

        int count = 0; // 결과

        while (true) {
            if (sum == M) {
                count++;
                sum -= A[left++];
            } else if (sum > M) {
                sum -= A[left++];
            } else {
                if (right + 1 == N)
                    break;
                sum += A[++right];
            }
        }

        System.out.println(count);
    }
}
