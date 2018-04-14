package iOS;

import java.util.Scanner;

public class Q19_MaximumDifferenceInAnArray {
	
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
        //int arr[] = {1, 2, 90, 10, 110};
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
			arr[i] = in.nextInt();
		}
        System.out.println(maxDiff(arr, n));
    }
    
    static int maxDiff(int arr[], int arr_size) 
    {
        int max_diff = arr[1] - arr[0];
        int i, j;
        for (i = 0; i < arr_size; i++) 
        {
            for (j = i + 1; j < arr_size; j++) 
            {
                if (arr[j] - arr[i] > max_diff)
                    max_diff = arr[j] - arr[i];
            }
        }
        return max_diff;
    }
}
