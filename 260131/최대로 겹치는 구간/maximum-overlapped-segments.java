import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] x1 = new int[n];
        int[] x2 = new int[n];
        int[] lines = new int[101];
        int result = 0;
        for (int i = 0; i < n; i++) {
            x1[i] = sc.nextInt();
            x2[i] = sc.nextInt();
            for (int j=x1[i]; j<x2[i]; j++) {
                lines[j]++;
            }
        }
        for (int i=0; i<101; i++) {
            result = Math.max(result, lines[i]);
        }
        System.out.println(result);
        // Please write your code here.
    }
}