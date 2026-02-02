import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] A = new int[1_000_000];
        Arrays.fill(A, -1);
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            int v = sc.nextInt(); // 속도
            int t = sc.nextInt(); // 시간
            for (int j=0; j<t; j++) {
                A[cnt++] += v;
            }
        }

        int[] B = new int[1_000_000];
        Arrays.fill(B, -1);
        cnt = 0;
        for (int i = 0; i < m; i++) {
            int v = sc.nextInt(); // 속도
            int t = sc.nextInt(); // 시간
            for (int j=0; j<t; j++) {
                B[cnt++] += v;
            }
        }

        char first = 'x';
        int ans = -1;
        int aCur = 0;
        int bCur = 0;
        for (int i=0; i<1_000_000; i++) {
            if (A[i] == -1) break;

            aCur += A[i];
            bCur += B[i];

            if (aCur > bCur) {
                if (first == 'B' || first == 'x') {
                    first = 'A';
                    ans++;
                }
            } else if (aCur < bCur) {
                if (first == 'A' || first == 'x') {
                    first = 'B';
                    ans++;
                }
            } 
        }

        System.out.println(ans);
        // Please write your code here.
    }
}