import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ2309 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int[] dwarf = new int[9];
		int sum = 0;
		for (int i = 0; i < dwarf.length; i++) {
			dwarf[i] = Integer.parseInt(reader.readLine());
			sum += dwarf[i];
		}

		Arrays.sort(dwarf);

		for (int i = 0; i < dwarf.length; i++) {
			for (int j = i + 1; j < dwarf.length; j++) {
				if (sum - dwarf[i] - dwarf[j] == 100) {
					for (int k = 0; k < dwarf.length; k++) {
						if (k == i || k == j)
							continue;
						System.out.println(dwarf[k]);
					}
					return; // System.exit(0);
				}
			}
		}
	}
}
