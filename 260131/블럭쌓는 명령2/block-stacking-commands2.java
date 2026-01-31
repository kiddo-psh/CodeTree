import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] blocks = new int[N+1];
        for (int i = 0; i < K; i++) {
            int A = sc.nextInt();
            int B = sc.nextInt();
            for (int j=A; j<=B; j++) {
                blocks[j]++;
            }
        }
        int result = 0;
        for (int i=0; i<N; i++) {
            result = Math.max(result, blocks[i]);
        }
        System.out.println(result);
    }
}