import java.util.*;
public class Main {
    static int N, M;
    static int[] A, B;

    static boolean isBeautiful(int index) {
        int[] ret = new int[M];
        for (int i=index; i<index+M; i++) {
            ret[i-index] = A[i];
        }

        Arrays.sort(ret);
        for (int i=0; i<M; i++) {
            if (B[i] != ret[i]) return false;
        }

        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        A = new int[N];
        for (int i = 0; i < N; i++)
            A[i] = sc.nextInt();

        B = new int[M];
        for (int i = 0; i < M; i++) {
            B[i] = sc.nextInt();
        }

        Arrays.sort(B);

        int answer = 0;
        for (int i = 0; i < N-2; i++) {
            if (isBeautiful(i)) answer++;
        }

        System.out.println(answer);

    }
}