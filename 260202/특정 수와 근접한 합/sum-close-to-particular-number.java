import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int s = sc.nextInt();
        int[] arr = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            sum += arr[i];
        }

        int min = Integer.MAX_VALUE;
        for (int i=0; i<n-1; i++) {
            for (int j=i+1; j<n; j++) {
                int d = arr[i] + arr[j];
                if (Math.abs(s-sum+d) < min) {
                    min = Math.abs(s-sum+d);
                }
            }
        }
        System.out.println(min);

        // Please write your code here.
    }
}