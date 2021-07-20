package algorithm.day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1072 { // 게임

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        long X = Long.parseLong(tokenizer.nextToken());
        long Y = Long.parseLong(tokenizer.nextToken());

        long Z = (Y * 100) / X;

        if (Z >= 99) {
            System.out.println(-1);
            return;
        }

        long start = 0;
        long end = X;

        long result = 0;
        while (start <= end) {
            long mid = (start + end) / 2;

            long midZ = ((Y + mid) * 100) / (X + mid);
            if (midZ >= Z + 1) {
                // 뒤에 두 문장을 하는 것이 아니고
                // end = mid;만 하고
                // while문이 끝나면 end가 답이 됨.
                // 그럴경우 while문에 start < end로 .......바꿔줘야 함....
                result = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        System.out.println(result);
    }
}
