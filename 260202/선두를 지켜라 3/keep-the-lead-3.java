import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] a = new int[1_000_001];
        int[] b = new int[1_000_001];
        int cur = 0; int p = 0;
        for (int i = 0; i < n; i++) {
            int v = sc.nextInt();
            int t = sc.nextInt();
            while (t-- > 0) {
                p += v;
                a[++cur] = p;
            }
        }
        cur = 0; p = 0;
        for (int i = 0; i < m; i++) {
            int v = sc.nextInt();
            int t = sc.nextInt();
            while (t-- > 0) {
                p += v;
                b[++cur] = p;
            }
        }
        // Please write your code here.
        int leader = 0; // a-1 b-2 ab-3
        int ans = 0;
        for (int i=1; i<=cur; i++) {
            
                // a로 선두 바뀜
                if (a[i] > b[i] && leader != 1) {
                    ans++;
                    leader = 1;
                } else if (a[i] < b[i] && leader != 2) {
                    ans++;
                    leader = 2;
                } else if (a[i] == b[i] && leader != 3) {
                    ans++;
                    leader = 3;
                }
        }
        System.out.println(ans);
    }
}