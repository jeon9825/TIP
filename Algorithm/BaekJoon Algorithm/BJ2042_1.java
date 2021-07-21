package algorithm.day3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2042_1 {

    static int N, M, K;
    static long[] nums;
    static long[] tree;
    static int S;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        N = Integer.parseInt(tokenizer.nextToken());
        M = Integer.parseInt(tokenizer.nextToken());
        K = Integer.parseInt(tokenizer.nextToken());

        nums = new long[N];

        for (int i = 0; i < N; i++) {
            nums[i] = Long.parseLong(reader.readLine());
        }
        S = 1;
        while (S < N) {
            S *= 2;
        }
        tree = new long[S * 2]; // 트리의 크기를 최소한으로 만들어준다.

        initBU();
    }

    static void initBU() {
        // Leaf에 값 반영
        for (int i = 0; i < N; i++) {
            tree[S + i] = nums[i];
        }
        // 내부모드 채움
        for (int i = S - 1; i > 0; i--) { // 꼭 끝에서부터 돌아야 함.
            tree[i] = tree[i * 2] + tree[i * 2 + 1];
        }
    }

    static long query(int left, int right, int node, int queryLeft, int queryRight) {
        // 연관이 없음
        if (queryRight < left || right < queryLeft) {
            return 0; // 결과에 영향이 없는 값 return
        }
        // 판단 가능
        else if (queryLeft <= left && right <= queryRight) {
            return tree[node];// 현재 노드 값 return
        }
        // 판단 불가
        else {
            // 자식에게 위임
            int mid = (left + right) / 2; //이진트리라 범위를 반씩 가져감...
            long leftResult = query(left, mid, node * 2, queryLeft, queryRight);
            long rightResult = query(mid + 1, right, node * 2 + 1, queryLeft, queryRight);
            // 자식에서 올라온 합을 리턴
            return leftResult + rightResult;
        }
    }

    static void update(int left, int right, int node, int target, long diff) {
        if (target < left || right < target) { // 연관 없음
            return;
        } else { //연관있음 -> 현재 노드에 diff 반영 -> 자식에서 diff 전달
            tree[node] += diff;
            if (left != right) {
                int mid = (left + right) / 2;
                update(left, mid, node * 2, target, diff);
                update(mid + 1, right, node * 2 + 1, target, diff);
            }
        }
    }
}
