package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BJ1713 {

    static class Student implements Comparable<Student> {
        int num;
        int count;
        int time;

        public Student(int num, int count, int time) {
            this.num = num;
            this.count = count;
            this.time = time;
        }

        @Override
        public int compareTo(Student o) {
            int r = this.count - o.count;
            if (r != 0) return r;
            return this.time - o.time;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(reader.readLine());
        int t = Integer.parseInt(reader.readLine());
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        Student[] students = new Student[101];
        List<Student> list = new ArrayList<>();

        for (int i = 0; i < t; i++) {
            int num = Integer.parseInt(tokenizer.nextToken());
            if (students[num] != null) {
                students[num].count++;
            } else {
                if (list.size() >= N) {
                    Collections.sort(list);
                    int no = list.get(0).num;
                    students[no] = null;
                    list.remove(0);
                }
                students[num] = new Student(num, 1, i);
                list.add(students[num]);
            }
        }

        for (int i = 0; i < 101; i++) {
            if (students[i] != null)
                System.out.print(i + " ");

        }
    }
}
