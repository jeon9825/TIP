package algorithm.me;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2094 { // 강수량

    static int n;
    static int[][] precipitation;
    static int[] tree;
    static int S;

    //case 1: x년도의 강수량이 있을때 y+1 ~ x-1 사이의 최댓값이 x년도의 강수량보다 작은가
    //
    //case 2: y년도의 강수량이 있을때 y+1 ~ x-1 사이의 최댓값이 y년도의 강수량보다 작은가
    //
    //case 3: x년도의 강수량이 있고, y년도의 강수량이 있을때 y ~ x 사이의 모든값이 주어져있는가

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer;
        n = Integer.parseInt(reader.readLine());
        precipitation = new int[n + 1][2];
        for (int i = 1; i < precipitation.length; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            precipitation[i][0] = Integer.parseInt(tokenizer.nextToken()); // year 연도
            precipitation[i][1] = Integer.parseInt(tokenizer.nextToken()); // precipitaion 강수량
        }
        S = 1;
        while (S < n) {
            S *= 2;
        }
        tree = new int[S * 2];
        init();
//        System.out.println(Arrays.toString(tree));

        int m = Integer.parseInt(reader.readLine());
        for (int i = 0; i < m; i++) {
//            System.out.println("=============================");
            tokenizer = new StringTokenizer(reader.readLine());

            int Y = Integer.parseInt(tokenizer.nextToken());
            int X = Integer.parseInt(tokenizer.nextToken());

            int ret = solution(Y, X);
            if (ret == 1) // maybe 1
                System.out.println("maybe");
            else if (ret == -1) // false 0
                System.out.println("false");
            else // true 0
                System.out.println("true");
        }

    }

    private static int solution(int y, int x) {
        int yIndex = binarySearch(1, precipitation.length, y);
        int xIndex = binarySearch(1, precipitation.length, x);

        int queryLeft = yIndex + 1;
        int queryRight = xIndex - 1;

        int xPre = 0; // x년도 강수량
        int yPre = 0; // y년도 강수량

        if (yIndex > 0 && xIndex > 0) { // 둘 다 있으면
            xPre = precipitation[xIndex][1]; // x년도 강수량
            yPre = precipitation[yIndex][1]; // y년도 강수량
            if (xPre > yPre) {
                return -1;
            }
        }

        if (yIndex <= 0) { // y년도가 없으면
            queryLeft = yIndex * -1 - 1;
        } else {
            yPre = precipitation[yIndex][1];
        }

        if (xIndex <= 0) {// x년도가 없으면
            queryRight = xIndex * -1 - 1;
            queryRight--;
        } else {
            xPre = precipitation[xIndex][1];
        }

//        System.out.println("queryLeft = " + queryLeft);
//        System.out.println("queryRight = " + queryRight);

        int betweenMax = query(1, S, 1, queryLeft, queryRight); // y+1년도부터 x-1년도 강수량의 최대값과 x년도 강수량과 비교
//        System.out.println("betweenMax = " + betweenMax);
//        System.out.println("xPre = " + xPre);
//        System.out.println("yPre = " + yPre);
        if (xIndex > 0 && betweenMax >= xPre) {
            return -1;
        }
        if (yIndex > 0 && betweenMax >= yPre) {
            return -1;
        }

        if (yIndex > 0 && xIndex > 0 && xIndex - yIndex == x - y) {
            return 0;
        }

        return 1;
    }

    private static int query(int left, int right, int node, int queryLeft, int queryRight) {
//        System.out.print("queryLeft = " + queryLeft);
//        System.out.println(" queryRight = " + queryRight);
//        System.out.print("left = " + left);
//        System.out.println(" right = " + right);
        if (right < left)
            return 0;

        if (right < queryLeft || left > queryRight) {
            return 0;
        } else if (queryLeft <= left && right <= queryRight) {
            return tree[node];
        } else {
            int mid = (left + right) / 2;
            int leftMax = query(left, mid, node * 2, queryLeft, queryRight);
            int rightMax = query(mid + 1, right, node * 2 + 1, queryLeft, queryRight);
            return Math.max(leftMax, rightMax);
        }
    }

    private static int binarySearch(int fromIndex, int toIndex, long key) { // key값을  가진 index 찾기
        int low = fromIndex;
        int high = toIndex - 1;

        while (low <= high) {
            int mid = (low + high) >>> 1;
            long midVal = precipitation[mid][0];

            if (midVal < key)
                low = mid + 1;
            else if (midVal > key)
                high = mid - 1;
            else
                return mid; // key found
        }
        return -(low + 1);  // key not found.

    }

    private static void init() {
        for (int i = 1; i < precipitation.length; i++) {
            tree[S + i - 1] = precipitation[i][1];
        }
        for (int i = S - 1; i > 0; i--) {
            tree[i] = Math.max(tree[i * 2], tree[i * 2 + 1]); // 최고강수량
        }
    }
}
