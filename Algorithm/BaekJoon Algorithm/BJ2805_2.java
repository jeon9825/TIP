package algorithm.day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ2805_1 {
    static int[] trees;

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        int N = Integer.parseInt(tokenizer.nextToken());
        int M = Integer.parseInt(tokenizer.nextToken());

        trees = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int start = 0;
        int end = 0;
        for (int i = 0; i < trees.length; i++) {
            end = Math.max(trees[i], end);
        }

        int mid = 0;
        long result = 0;

        while (true) {
            mid = (start + end) / 2;
            long sum = calc(mid);

            if (sum == M) {
                result = mid;
                break;
            } else if (sum < M) {
                end = mid - 1; // mid 값은 필요 없 어.~.

            } else {
                start = mid + 1;
                result = mid;
            }
            if (start > end)
                break;
        }

        System.out.println(result);
    }

    static long calc(long value) {
        long result = 0;
        for (int t : trees) {
            if (t > value) {
                result += t - value;
            }
        }
        return value;
    }
}
