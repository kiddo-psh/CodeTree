import java.util.Scanner;
public class Main {
    public static boolean isCarry(int a, int b, int c) {
        while (a>0 || b>0 || c>0) {
            if (a%10 + b%10 + c%10 >= 10) return true;
            a/=10;
            b/=10;
            c/=10;
        }
        return false;
    } 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int ans = -1;
        int sum = 0;
        for (int i=0; i<n-2; i++) {
            for (int j=i+1; j<n-1; j++) {
                for (int k=j+1; k<n; k++) {
                    if (!isCarry(arr[i], arr[j], arr[k])) {
                        sum = arr[i] + arr[j] + arr[k];
                        ans = Math.max(ans, sum);
                    }
                }
            }
        }
        System.out.println(ans);
        // Please write your code here.
    }
}