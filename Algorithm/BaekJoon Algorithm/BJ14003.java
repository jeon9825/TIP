package algorithm.day9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ14003 { // 가장 긴 증가하는 수열 5

    static int n;
    static int[] input;
    static int[] index;
    static List<Integer> list;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(reader.readLine());
        input = new int[n + 1];
        index = new int[n + 1]; // index 배열
        list = new ArrayList<>(); // 정답, 백트랙킹하면서 값을 찾아감.

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 1; i < input.length; i++) {
            input[i] = Integer.parseInt(tokenizer.nextToken());
        }

        list.add(Integer.MIN_VALUE);

        for (int i = 1; i <= n; i++) {
            int num = input[i];
            int left = 1;
            int right = list.size() - 1;

            // index 배열 채우는 과정 !!
            // 확인하려는 숫자가 수열의 마지막 수보다 큰 경우
            // 수열에 추가
            if (num > list.get(list.size() - 1)) {
                list.add(num);
                index[i] = list.size() - 1;
            } else {
                while (left < right) {
                    int mid = (left + right) / 2;

                    if (list.get(mid) >= num) right = mid;
                    else left = mid + 1;
                }
                list.set(right, num);
                index[i] = right;
            }
        }

        int idx = list.size() - 1;
        System.out.println(idx); // 최장길이 출력

        Stack<Integer> stack = new Stack<>();
        for (int i = n; i > 0; i--) {
            if (index[i] == idx) {
                stack.push(input[i]);
                --idx;
            }
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }

    }

}
