import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        
        int sum = 0;
        for (int i=0; i<k; i++) {
            sum += arr[i];
        }

        int ans = sum;
        for (int i=0; i<n-k; i++) {
            sum -= arr[i];
            sum += arr[i+k];
            ans = Math.max(ans, sum);
        }

        System.out.println(ans);
    }
}