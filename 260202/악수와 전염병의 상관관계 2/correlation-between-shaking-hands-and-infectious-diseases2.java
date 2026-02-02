import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int P = sc.nextInt();
        int T = sc.nextInt();
        int[][] shakes = new int[T][3];
        for (int i = 0; i < T; i++) {
            shakes[i][0] = sc.nextInt();
            shakes[i][1] = sc.nextInt();
            shakes[i][2] = sc.nextInt();
        }
        Arrays.sort(shakes, (a, b) -> Integer.compare(a[0], b[0]));
        int[] p = new int[N+1];
        p[P] = 1;

        int cnt = 0;
        for (int i=0; i<T; i++) {
            if (cnt == K) break;

            int x = shakes[i][1];
            int y = shakes[i][2];
            
            if (p[x]==1 || p[y]==1) {
                p[x] = 1;
                p[y] = 1;
                cnt++;
            } 
        }
        StringBuilder output = new StringBuilder();
        for (int i=1; i<=N; i++) {
            output.append(p[i]);
        } 
        System.out.println(output);
    }
}