import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Point implements Comparable<Point> {

	int x;
	int y;

	public Point() {
	}

	public Point(int x, int y) {
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
	public int compareTo(Point p) {
		int r = this.x - (p.x);
		if (r != 0)
			return r;
		return this.y - p.y;
	}

}

public class BJ11650 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(reader.readLine());
		Point[] p = new Point[N];
		for (int i = 0; i < p.length; i++) {
			StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
			int x = Integer.parseInt(tokenizer.nextToken());
			int y = Integer.parseInt(tokenizer.nextToken());
			p[i] = new Point(x, y);
		}
		Arrays.sort(p);
		for (int i = 0; i < p.length; i++) {
			System.out.println(p[i].toString());
		}
	}
}
