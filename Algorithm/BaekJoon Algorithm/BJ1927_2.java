package algorithm.day3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BJ1927_2 {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        MinHeap heap = new MinHeap();

        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(reader.readLine());

            if (x > 0) {
                heap.insert(x);
            } else { // x == 0
                System.out.println(heap.delete());
            }
        }
    }

    static class MinHeap {
        List<Integer> list;

        public MinHeap() {
            list = new ArrayList<>();
            list.add(0);
        }

        public void insert(int val) {
            list.add(val);

            int current = list.size() - 1;
            int parent = current / 2;
            while (true) {
                if (parent == 0 || list.get(parent) <= list.get(current))
                    break;

                int tmp = list.get(parent);
                list.set(parent, list.get(current));
                list.set(current, tmp);

                current = parent;
                parent = current / 2;
            }
        }

        public int delete() {
            if (list.size() == 1)
                return 0;

            int top = list.get(1);

            list.set(1, list.get(list.size() - 1));
            list.remove(list.size() - 1);

            int currentPos = 1;
            while (true) {
                int leftPos = currentPos * 2;
                int rightPos = currentPos * 2 + 1;

                if (leftPos >= list.size()) {
                    break;
                }

                int minValue = list.get(leftPos);
                int minPos = leftPos;

                if (rightPos < list.size() && minValue > list.get(rightPos)) {
                    minValue = list.get(rightPos);
                    minPos = rightPos;
                }

                if (list.get(currentPos) > minValue) {
                    int tmp = list.get(currentPos);
                    list.set(currentPos, list.get(minPos));
                    list.set(minPos, tmp);
                    currentPos = minPos;
                } else {
                    break;
                }
            }
            return top;
        }
    }
}
