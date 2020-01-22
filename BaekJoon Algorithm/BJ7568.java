import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

class Person implements Comparable<Person> {
	private int weight;
	private int height;
//	private int n;

	public Person(int weight, int height) {
		this.weight = weight;
		this.height = height;
//		this.n = n;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + height;
		result = prime * result + weight;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Person))
			return false;
		Person other = (Person) obj;
		if (height != other.height)
			return false;
		if (weight != other.weight)
			return false;
		return true;
	}

	@Override
	public int compareTo(Person p) {
		if (this.height - p.height > 0 && this.weight - p.weight > 0)
			return 1;
		else if (this.height - p.height < 0 && this.weight - p.weight < 0)
			return -1;
		return 0;
	}

}

public class BJ7568 {

	@SuppressWarnings("unused")
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		Person[] p = new Person[n];

		for (int i = 0; i < n; i++) {

			StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
			int weight = Integer.parseInt(tokenizer.nextToken());
			int height = Integer.parseInt(tokenizer.nextToken());

			p[i] = new Person(weight, height);
		}

		for (int i = 0; i < p.length; i++) {
			int rank = 1;
			for (int j = 0; j < p.length; j++) {
				if (p[i].compareTo(p[j]) < 0)
					rank++;
			}
			System.out.print(rank + " ");
		}
	}

}
