import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Serial implements Comparable<Serial> {
	String s;
	int sum;

	public String getS() {
		return s;
	}

	public void setS(String s) {
		this.s = s;
	}

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

	public Serial(String s) {
		this.s = s;
		this.sum=sum(s);
	}

	public int sum(String s) {
		int sum = 0;
		String s1 = s.replaceAll("[A-Z]", "");
		for (int i = 0; i < s1.length(); i++) {
			sum += s1.charAt(i)-'0';
		}
		return sum;
	}

	@Override
	public int compareTo(Serial o) {
		// TODO Auto-generated method stub
		int r = this.getS().length() - o.getS().length();
		if (r != 0)
			return r;
		r = this.sum-o.sum;
		if (r != 0)
			return r;
		return this.getS().compareTo(o.getS());
	}

	@Override
	public String toString() {
		return s;
	}
}

public class BJ1431 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		Serial[] s = new Serial[n];
		for (int i = 0; i < s.length; i++) {
			String str = reader.readLine();
			s[i] = new Serial(str);
		}
		Arrays.sort(s);
		for (int i = 0; i < s.length; i++) {
			System.out.println(s[i]);
		}
	}
}
