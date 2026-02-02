import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        int sum = 0;
        int ans = 0;
        for (int i=0; i<n-2; i++) {
            for (int j=i+2; j<n; j++) {
                sum = arr[i] + arr[j];
                ans = Math.max(ans, sum);
            }
        }
        System.out.println(ans);
    }
}