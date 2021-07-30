package algorithm.day10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ10714 {

    static int n;
    static int[] arr;
    static long[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(reader.readLine());
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(reader.readLine());
        }
        dp = new long[n + 1][n + 1];
        long max = 0;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i] + ioi(i, i)); // 자른 부분을 left, right로 넣는거임.
        }
        System.out.println(max);
    }

    static long ioi(int left, int right) { // 잘라진 left와 right가 나옴 ..
        if (goRight(right) == left)
            return 0;

        if (arr[goLeft(left)] > arr[goRight(right)]) // 뭘 자를까
            return joi(goLeft(left), right); // 왼쪽을 자르자
        else
            return joi(left, goRight(right)); // 오른쪽을 자르자
    }

    static long joi(int left, int right) {
        if (goRight(right) == left) // left~right가 끝과 끝이야 -> 하나를 한칸 더 옮기면 -> 같아! => 고를 수 없음
            return dp[left][right] = 0;

        if (dp[left][right] > 0)
            return dp[left][right];

        long leftMove = arr[goLeft(left)] + ioi(goLeft(left), right); // 왼쪽을 자를까
        long rightMove = arr[goRight(right)] + ioi(left, goRight(right)); // 오른쪽을 자를까

        return dp[left][right] = Math.max(leftMove, rightMove); // 큰걸 자르자
    }

    // 환형으로 가는 방법.... => 이거 생각하는게 제일 어렵다 %n은 알지만 left할 때 음수처리하는거 생각 계속 하기
    static int goRight(int index) {
        return (index + 1) % n;
    }

    static int goLeft(int index) {
        return (index - 1 + n) % n;
    }
}
