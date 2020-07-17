import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ1946 {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(reader.readLine());
		StringTokenizer tokenizer;
		for (int i = 0; i < t; i++) {
			int n = Integer.parseInt(reader.readLine());
			Applicant[] ap = new Applicant[n];
			for (int j = 0; j < ap.length; j++) {
				tokenizer = new StringTokenizer(reader.readLine());
				int test1 = Integer.parseInt(tokenizer.nextToken());
				int test2 = Integer.parseInt(tokenizer.nextToken());
				ap[j] = new Applicant(test1, test2);
			}

			Arrays.sort(ap);

			int count = ap.length;
			int test2 = ap[0].test2; // 서류 1등의 면접등수
			for (int j = 1; j < ap.length; j++) {
				int mytest2 = ap[j].test2; // 본인 면접 등수
				if (test2 < mytest2)
					count--;
				if (test2 > mytest2)
					test2 = mytest2;
			}

			System.out.println(count);
		}
	}
}

class Applicant implements Comparable<Applicant> {
	int test1;
	int test2;

	public Applicant(int test1, int test2) {
		this.test1 = test1;
		this.test2 = test2;
	}

	public int getTest1() {
		return test1;
	}

	public void setTest1(int test1) {
		this.test1 = test1;
	}

	public int getTest2() {
		return test2;
	}

	public void setTest2(int test2) {
		this.test2 = test2;
	}

	@Override
	public String toString() {
		return "Applicant [test1=" + test1 + ", test2=" + test2 + "]";
	}

	@Override
	public int compareTo(Applicant a) {
		return this.test1 - a.test1;
	}

}
