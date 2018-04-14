package android;

import java.util.Scanner;

public class Q01_Psychometric {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = in.nextInt();
		}
		int lowerLimit = in.nextInt();
		int[] lowerBound = new int[lowerLimit];
		for (int i = 0; i < lowerLimit; i++) {
			lowerBound[i] = in.nextInt();
		}
		int upperLimit = in.nextInt();
		int[] upperBound = new int[upperLimit];
		for (int i = 0; i < upperLimit; i++) {
			upperBound[i] = in.nextInt();
		}
		int[] resultArray = new int[lowerLimit];
		for (int i = 0; i < lowerLimit; i++) {
			int count = 0;
			for (int j = 0; j < n; j++) {
				if (lowerBound[i] <= arr[j] && arr[j] <= upperBound[i]) {
					count++;
				}
			}
			resultArray[i] = count;
		}
		for (int i : resultArray) {
			System.out.println(i);
		}
	}
}
