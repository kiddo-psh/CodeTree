import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[10_001];
        for (int i = 0; i < n; i++) {
            int pos = sc.nextInt();
            char c = sc.next().charAt(0);
            if(c=='G') arr[pos] = 1;
            else arr[pos] = 2;
        }
        int sum = 0;
        for (int i=1; i<=k+1; i++) {
            sum += arr[i];
        }
        int ans = sum;
        for (int i=1; i<10_000-k; i++) {
            sum -= arr[i];
            sum += arr[i+k+1];
            ans = Math.max(sum, ans);
        }

        System.out.println(ans);
    }
}