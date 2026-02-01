import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] start = new int[n];
        int[] end = new int[n];
        for (int i = 0; i < n; i++) {
            start[i] = sc.nextInt();
            end[i] = sc.nextInt();
        }
        int result = 0;
        int[] lines = new int[101];
        for (int i=0; i<n; i++) {
            for (int j=start[i]; j<=end[i]; j++) {
                lines[j]++;
            }
        }
        for (int i=0; i<101; i++) {
            result = Math.max(result, lines[i]);
        }
        System.out.println(result);
    }
}