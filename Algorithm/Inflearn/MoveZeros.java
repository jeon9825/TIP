import java.io.IOException;
import java.util.Arrays;

public class MoveZeros {
	public static void main(String[] args) throws NumberFormatException, IOException {
		int[] nums = { 0, 3, 2, 0, 8, 5 };
		int[] ans = new int[nums.length];

		int index = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != 0) {
				ans[index++] = nums[i];
			}
		}

		System.out.println(Arrays.toString(ans));
	}
}
