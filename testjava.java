import java.util.HashMap;
import java.util.Scanner;

public class LongestSubarray {
    
    // Function to find the length of the longest subarray
    public static int longestSubarray(int[] arr, int n) {
        if (arr == null || n == 0) {
            return 0;
        }

        // Map to store the first occurrence of each cumulative sum (positive sum - negative sum)
        HashMap<Integer, Integer> sumMap = new HashMap<>();
        
        int maxLength = 0;
        int sumPosNeg = 0;  // This is the sum of positive - negative numbers

        // Initialize the map with the base case
        sumMap.put(0, -1); // To handle subarrays that start from index 0
        
        // Traverse the array
        for (int i = 0; i < n; i++) {
            if (arr[i] > 0) {
                sumPosNeg += arr[i]; // Add to positive sum
            } else if (arr[i] < 0) {
                sumPosNeg += arr[i]; // Add to negative sum
            }

            // Check if this cumulative sum has been seen before
            if (sumMap.containsKey(sumPosNeg)) {
                // If seen before, calculate the length of the subarray
                int len = i - sumMap.get(sumPosNeg);
                if (len > maxLength) {
                    maxLength = len;
                }
            } else {
                // First time we encounter this cumulative sum, store its index
                sumMap.put(sumPosNeg, i);
            }
        }
        
        return maxLength;
    }

    public static void main(String[] args) {
        // Use Scanner to read input from standard input (STDIN)
        Scanner scanner = new Scanner(System.in);
        
        // Read the size of the array
        int n = scanner.nextInt();
        
        // Read the elements of the array
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        
        // Call the function to find the longest subarray
        int result = longestSubarray(arr, n);
        
        // Output the result to standard output (STDOUT)
        System.out.println(result);
        
        // Close the scanner after use
        scanner.close();
    }
}
