import java.util.Scanner;
public class Main {
    static int result = 0;
    public static void findMax(int[] arr, int n){
        if(n==arr.length) return;
        if(result < arr[n]) result = arr[n];
        findMax(arr, n+1);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        findMax(arr, 0);
        System.out.println(result);
        // Please write your code here.
    }
}