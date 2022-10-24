import java.util.Arrays;
import java.util.Scanner;

public class BJ_1920 {
    public static int binarySearch(int[] arr, int num) {
        int min = 0;
        int mid;
        int max = arr.length - 1;
        // arr[arr.length] 배열의 범위에서 벗어난다.

        while (min <= max) {
            mid = (min + max) / 2;
            if (arr[mid] == num) {
                return 1;
            } else if (arr[mid] < num) {
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] nArr = new int[n];
        for (int i = 0; i < n; i++) {
            nArr[i] = scanner.nextInt();
        }
        Arrays.sort(nArr);

        int m = scanner.nextInt();
        int[] mArr = new int[m];
        for (int i = 0; i < m; i++) {
            mArr[i] = scanner.nextInt();
        }

        for (int i = 0; i < m; i++) {
            // 이분탐색과 관련된 함수...
            System.out.println(binarySearch(nArr, mArr[i]));
        }

        scanner.close();
    }
}