import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Student implements Comparable<Student> {
	String name;
	int kor;
	int eng;
	int math;

	public Student(String name, int kor, int eng, int math) {
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}

	@Override
	public int compareTo(Student o) {
		int r = o.kor - this.kor;
		if (r != 0)
			return r;
		r = this.eng - o.eng;
		if (r != 0)
			return r;
		r = o.math - this.math;
		if (r != 0)
			return r;
		return this.name.compareTo(o.name);
	}

	@Override
	public String toString() {
		return name;
	}

}

public class BJ10825 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		StringTokenizer tokenizer;
		Student[] s = new Student[n];

		for (int i = 0; i < s.length; i++) {
			tokenizer = new StringTokenizer(reader.readLine());
			String name = tokenizer.nextToken();
			int kor = Integer.parseInt(tokenizer.nextToken());
			int eng = Integer.parseInt(tokenizer.nextToken());
			int math = Integer.parseInt(tokenizer.nextToken());
			s[i] = new Student(name, kor, eng, math);
		}
		Arrays.sort(s);
		for (int i = 0; i < s.length; i++) {
			System.out.println(s[i].name);
		}
	}
}
