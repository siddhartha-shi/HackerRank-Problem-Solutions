package iOS;

import java.io.InputStreamReader;
import java.util.Scanner;

public class Q11_MoneyCollection {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(new InputStreamReader(System.in));
		int sum = 0;
		int n = scanner.nextInt();
		int k = scanner.nextInt();
		for (int i = 1; i <= n; i++) {
			if (k==1 && i == 1) {
				sum = 0;
			} else if ((sum+i == k)) {
				sum += i;
				sum -=1;
			} else {
				sum += i;
			}
		}
		System.out.println(sum%1000000007);
	}
}
