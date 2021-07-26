package algorithm.me;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BJ11279 { // 최대 힙

    static class MaxHeap {

        private List<Integer> list = new ArrayList<>();

        public MaxHeap() {
            list.add(0);
        }

        public void insert(int x) {
            list.add(x);

            int index = list.size() - 1;
            int parentIdx = index / 2;
            while (parentIdx > 0) {
                int current = list.get(index);
                int parent = list.get(parentIdx);

                if (parent < current) {
                    list.set(parentIdx, current);
                    list.set(index, parent);
                }
                index = parentIdx;
                parentIdx = index / 2;
            }
        }

        public int remove() {
            if (list.size() == 1)
                return 0;

            int result = list.get(1);
            list.set(1, list.get(list.size() - 1));
            list.remove(list.size() - 1);

            int current = 1;
            int leftIdx = current * 2;
            int rightIdx = current * 2 + 1;
            while (leftIdx < list.size()) {
                int max = list.get(leftIdx);
                int maxIdx = leftIdx;

                if (rightIdx < list.size()) {
                    int right = list.get(rightIdx);
                    if (max < right) {
                        max = right;
                        maxIdx = rightIdx;
                    }
                }

                if (list.get(current) < max) {
                    list.set(maxIdx, list.get(current));
                    list.set(current, max);
                }
                current = maxIdx;
                leftIdx = current * 2;
                rightIdx = current * 2 + 1;
            }
            return result;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        MaxHeap mh = new MaxHeap();

        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(reader.readLine());
            if (x == 0) {
                System.out.println(mh.remove());
            } else {
                mh.insert(x);
            }
        }
    }

}
