import java.util.Scanner;
public class Main {
    static int[] arr;
    static int n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        
        int result = Integer.MAX_VALUE;
        for (int i=0; i<n; i++) {
            int sum = dist(i);
            result = Math.min(sum, result);
        }

        System.out.println(result);
    }

    static int dist(int idx) {
        int sum = 0;
        for (int i=0; i<n; i++) {
            int d = ((i - idx) >= 0) ? (i-idx) : n-(idx-i);
            sum += d * (arr[i]);
        }
        return sum;
    }
}