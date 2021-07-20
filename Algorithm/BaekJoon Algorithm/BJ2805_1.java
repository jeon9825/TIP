package algorithm.day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ2805 { // 나무 자르기

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        int N = Integer.parseInt(tokenizer.nextToken());
        int M = Integer.parseInt(tokenizer.nextToken());

        int[] tree = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int start = 0;
        int end = 0;
        for (int i = 0; i < tree.length; i++) {
            end = Math.max(tree[i], end);
        }

        int result = 0;
        while (start <= end) {
            int mid = (start + end) / 2;

            long sum = 0;
            for (int i = 0; i < tree.length; i++) {
                sum += (tree[i] - mid < 0 ? 0 : tree[i] - mid);
            }

            if (sum >= M) {
                start = mid + 1;
                result = Math.max(result, mid);
            } else {
                end = mid - 1;
            }
        }

        System.out.println(result);
    }
}
