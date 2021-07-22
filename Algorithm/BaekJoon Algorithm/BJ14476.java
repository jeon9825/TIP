package algorithm.day4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ14476 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        int[] nums = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[] LtoR = new int[n];
        int[] RtoL = new int[n];
        LtoR[0] = nums[0];
        for (int i = 1; i < n; i++) {
            LtoR[i] = gcd(LtoR[i - 1], nums[i]);
        }

        RtoL[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            RtoL[i] = gcd(RtoL[i + 1], nums[i]);
        }

        int maxGcd = -1;
        int valueK = 0;
        for (int k = 0; k < n; k++) {
            int a = 0, b = 0;
            if (k != 0)
                a = LtoR[k - 1];
            if (k != n - 1)
                b = RtoL[k + 1];

            if (b < a) {
                int tmp = a;
                a = b;
                b = tmp;
            }
            int gcdK = gcd(a, b);
            if (nums[k] % gcdK != 0 && maxGcd < gcdK) {
                maxGcd = gcdK;
                valueK = nums[k];
            }
        }
        System.out.println(maxGcd == -1 ? maxGcd : (maxGcd + " " + valueK));
    }

    // gcd(a,b) == gcd(b, a%b) stop when a % b == 0
    static int gcd(int a, int b) {
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
}
