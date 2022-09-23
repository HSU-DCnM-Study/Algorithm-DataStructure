import java.util.Scanner;

class BJ_1000 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String temp = scanner.nextLine();
        String[] arr = temp.split(" ", 2);
        int answer = Integer.parseInt(arr[0]) + Integer.parseInt(arr[1]);
        System.out.println(answer);

        scanner.close();
    }
}