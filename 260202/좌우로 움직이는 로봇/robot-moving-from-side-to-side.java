import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        
        int[] nMove = new int[1_000_001];
        int[] mMove = new int[1_000_001];

        int cur = 0;
        int p = 0;
        for (int i = 0; i < n; i++) {
            int t = sc.nextInt();
            char d = sc.next().charAt(0);
            // Please write your code here.
            while(t-- > 0) {
                if (d=='R') {
                    nMove[cur++] = ++p;
                } else {
                    nMove[cur++] = --p;
                }
            }
        }
        
        cur = 0;
        p = 0;
        for (int i = 0; i < m; i++) {
            int t = sc.nextInt();
            char d = sc.next().charAt(0);
            // Please write your code here.
            while(t-- > 0) {
                if (d=='R') {
                    mMove[cur++] = ++p;
                } else {
                    mMove[cur++] = --p;
                }
            }
        }

        // Please write your code here.
        int ans = 0;
        for (int i=1; i<=1_000_000; i++) {
            if (nMove[i-1] != mMove[i-1] && nMove[i] == mMove[i]) {
                ans++;
            }
        }

        System.out.println(ans);
    }
}