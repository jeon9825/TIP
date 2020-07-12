import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Conf implements Comparable<Conf> {
	int start;
	int end;

	public Conf(int start, int end) {
		this.start = start;
		this.end = end;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Conf))
			return false;
		Conf conf = (Conf) obj;
		return (this.end - conf.end == 0);
	}

	@Override
	public int compareTo(Conf c) {
		int r = this.end - c.end;
		if (r != 0)
			return r;
		return this.start - c.start;

	}

	@Override
	public String toString() {
		return "Conf [start=" + start + ", end=" + end + "]";
	}

}

public class BJ1931 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		Conf[] conference = new Conf[n];

		StringTokenizer tokenizer;
		for (int i = 0; i < conference.length; i++) {
			tokenizer = new StringTokenizer(reader.readLine());
			int start = Integer.parseInt(tokenizer.nextToken());
			int end = Integer.parseInt(tokenizer.nextToken());
			conference[i] = new Conf(start, end);
		}
		Arrays.sort(conference);

//		System.out.println(Arrays.toString(conference));

		int count = 0;
		int end = -1; // 끝나는 시간 기준
		for (int i = 0; i < conference.length; i++) {
			if (end <= conference[i].start) {
				count++;
				end = conference[i].end;
			}
		}
		System.out.println(count);
	}
}
