import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ9095 {

	static int count(int N) {
		int count = 0;
		for (int a = 1; a < 4; a++) {
			if (a == N) {
				count++;
			}
			for (int b = 1; b < 4; b++) {
				if (a + b == N) {
					count++;
				}
				for (int c = 1; c < 4; c++) {
					if (a + b + c == N) {
						count++;
					}
					for (int d = 1; d < 4; d++) {
						if (a + b + c + d == N) {
							count++;
						}
						for (int e = 1; e < 4; e++) {
							if (a + b + c + d + e == N) {
								count++;
							}
							for (int f = 1; f < 4; f++) {
								if (a + b + c + d + e + f == N) {
									count++;
								}
								for (int g = 1; g < 4; g++) {
									if (a + b + c + d + e + f + g == N) {
										count++;
									}
									for (int h = 1; h < 4; h++) {
										if (a + b + c + d + e + f + g + h == N) {
											count++;
										}
										for (int i = 1; i < 4; i++) {
											if (a + b + c + d + e + f + g + h + i == N) {
												count++;
											}
											for (int j = 1; j < 4; j++) {
												if (a + b + c + d + e + f + g + h + i + j == N) {
													count++;
												}

											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
		return count;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(reader.readLine());
		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(reader.readLine());
			System.out.println(count(N));
		}
	}
}
