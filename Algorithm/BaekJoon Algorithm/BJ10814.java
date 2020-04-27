import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Person implements Comparable<Person> {
	int i;
	int age;
	String name;

	public Person(int i, int age, String name) {
		this.i = i;
		this.age = age;
		this.name = name;
	}

	@Override
	public int compareTo(Person o) {
		int r = this.age - o.age;
		if (r != 0)
			return r;
		return this.i - o.i;
	}

	@Override
	public String toString() {
		return age + " " + name;
	}
}

public class BJ10814 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(reader.readLine());
		StringTokenizer tokenizer;
		Person[] p = new Person[N];
		for (int i = 0; i < p.length; i++) {
			tokenizer = new StringTokenizer(reader.readLine());
			int age = Integer.parseInt(tokenizer.nextToken());
			String name = tokenizer.nextToken();
			p[i] = new Person(i, age, name);
		}
		Arrays.sort(p);
		for (int i = 0; i < p.length; i++) {
			System.out.println(p[i].toString());
		}
	}

}
