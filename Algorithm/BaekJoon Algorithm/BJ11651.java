import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Point2 implements Comparable<Point2> {

	int x;
	int y;

	public Point2() {
	}

	public Point2(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public String toString() {
		return x + " " + y;
	}

	@Override
	public int compareTo(Point2 p) {
		int r = this.y - (p.y);
		if (r != 0)
			return r;
		return this.x - p.x;
	}

}

public class BJ11651 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(reader.readLine());
		Point2[] p = new Point2[N];
		for (int i = 0; i < p.length; i++) {
			StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
			int x = Integer.parseInt(tokenizer.nextToken());
			int y = Integer.parseInt(tokenizer.nextToken());
			p[i] = new Point2(x, y);
		}
		Arrays.sort(p);
		for (int i = 0; i < p.length; i++) {
			System.out.println(p[i].toString());
		}
	}
}
