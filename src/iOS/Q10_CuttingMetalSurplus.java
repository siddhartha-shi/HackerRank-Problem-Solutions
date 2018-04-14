package iOS;

import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Q10_CuttingMetalSurplus {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(new InputStreamReader(System.in));

		int i = 1;
		int costpercut = scanner.nextInt();
		int price = scanner.nextInt();
		int n = scanner.nextInt();
		int[] arr = new int[n];
		for (int j = 0; j < n; j++) {
			arr[j] = scanner.nextInt();
		}
		Arrays.sort(arr);
		int maxItem = arr[arr.length - 1];
		int k = 0;

		int max = 1;
		while (i <= maxItem) {
			int val = 0;
			for (int j = k; j < arr.length; j++) {
				val = (price * i * (arr[j] / i)) - (costpercut * (arr[j] / i)) + val;
			}
			i++;
			for (int j = 0; j < arr.length; j++) {
				if (i > arr[j]) {
					k = j;
				}
			}
			if (val > max) {
				max = val;
			}
		}
		System.out.println(max);
	}
}
