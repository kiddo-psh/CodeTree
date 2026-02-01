import java.util.Scanner;

public class Main {
    static int[] a = new int[1_000_001];
    static int[] b = new int[1_000_001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int cur = 0;
        for (int i=0; i<n; i++) {
            char c = sc.next().charAt(0);
            int d = sc.nextInt();
            for (int j=0; j<d; j++) {
                if (c=='R')
                    a[cur++] = 1;
                else 
                    a[cur++] = -1;
            }
        }
        cur = 0;
        for (int i=0; i<m; i++) {
            char c = sc.next().charAt(0);
            int d = sc.nextInt();
            for (int j=0; j<d; j++) {
                if (c=='R')
                    b[cur++] = 1;
                else 
                    b[cur++] = -1;
            }
        }

        int ap = 0;
        int bp = 0;
        int ans = -1;
        for (int i=0; i<1_000_001; i++) {
            if (a[i]==0 && b[i]==0) break;
            if (a[i] == 1) ap++;
            else if (a[i] == -1) ap--;
            if (b[i] == 1) bp++;
            else if (b[i] == -1) bp--;
            if (ap==bp) {
                ans = i+1;
                break;
            }
        }

        System.out.println(ans);
    }
}