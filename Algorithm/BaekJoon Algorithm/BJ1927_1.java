package algorithm.day3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BJ1927 {

    static List<Integer> heap;

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        heap = new ArrayList<>();
        heap.add(0); // index 0 추가

        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(reader.readLine());

            if (x > 0) {
                input(x);
            } else { // x == 0
                System.out.println(remove());
            }
        }
    }

    private static void input(int x) {
        heap.add(x);
        int current = heap.size() - 1;
        int parentIdx = current / 2;
        while (true) {
            if (parentIdx == 0)
                break;

            int parent = heap.get(parentIdx);
            int me = heap.get(current);
            if (parent <= me)
                break;

            heap.set(parentIdx, me);
            heap.set(current, parent);

            current = parentIdx;
            parentIdx = current / 2;
        }
    }

    private static int remove() {
        if (heap.size() == 1)
            return 0;

        int result = heap.get(1);

        heap.set(1, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);

        int current = 1;
        while (current < heap.size()) {
            int me = heap.get(current);

            int leftIdx = current * 2;
            int rightIdx = current * 2 + 1;

            if (leftIdx >= heap.size()) {
                break;
            }

            int minValue = heap.get(leftIdx);
            int minIdx = leftIdx;

            if (rightIdx < heap.size() && heap.get(rightIdx) < minValue) {
                minValue = heap.get(rightIdx);
                minIdx = rightIdx;
            }

            if (minValue < me) {
                heap.set(current, minValue);
                heap.set(minIdx, me);
                current = minIdx;
            } else {
                break;
            }
        }

        return result;
    }
}
