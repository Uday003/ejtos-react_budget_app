import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static int longestSubArray(int[] arr, int n) {
        if (arr == null || n == 0) {
            return 0;
        }
        HashMap<Integer, Integer> sumMap = new HashMap<>();
        
        int maxLength = 0;
        int sumPosNeg = 0;
        sumMap.put(0, -1);
        for (int i = 0; i < n; i++) {
            if (arr[i] > 0) {
                sumPosNeg += arr[i];
            } else if (arr[i] < 0) {
                sumPosNeg += arr[i];
            }

            if (sumMap.containsKey(sumPosNeg)) {
                int len = i - sumMap.get(sumPosNeg);
                if (len > maxLength) {
                    maxLength = len;
                }
            } else {
                sumMap.put(sumPosNeg, i);
            }
        }
        
        return maxLength;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        int result = longestSubArray(arr, n);
        
        System.out.println(result);
        
        scanner.close();
    }
}
