import java.util.Scanner;

public class Main {
    static int n, a1, b1, c1, a2, b2, c2;
    static boolean check(int i, int j, int k) {
        if (d(i,a1)<=2 && d(j,b1)<=2 && d(k,c1)<=2) {
            return true;
        }
        if (d(i,a2)<=2 && d(j,b2)<=2 && d(k,c2)<=2) {
            return true;
        }
        return false;
    }

    static int d(int x, int y) {
        if (x >= y) return Math.min((x-y), (n-x+y));
        else return Math.min((y-x), (n-y+x));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        a1 = sc.nextInt();
        b1 = sc.nextInt();
        c1 = sc.nextInt();
        a2 = sc.nextInt();
        b2 = sc.nextInt();
        c2 = sc.nextInt();

        int ans = 0;
        for(int i=1; i<=n; i++) {
            for (int j=1; j<=n; j++) {
                for (int k=1; k<=n; k++) {
                    if(check(i,j,k)) ans++;
                }
            }
        }
        System.out.println(ans);
        // Please write your code here.
    }
}