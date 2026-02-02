import java.util.Scanner;
public class Main {

    static int n, m;
    static String[] arr;
    static int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1};

    static int isLEE(int r, int c) {
        int cnt = 0;
        boolean flag = true;
        for (int i=0; i<8; i++) {
            flag = true;
            for (int j=1; j<=2; j++) {
                int nr = r + j*dr[i];
                int nc = c + j*dc[i];
                if (!inRange(nr, nc) || arr[nr].charAt(nc) != 'E') {
                    flag = false;
                    break;
                }
            }
            if (flag) cnt++;
        }
        return cnt;
    }

    static boolean inRange(int r, int c) {
        return r>=0 && r<n && c>=0 && c<m;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.next();
        }

        int ans = 0;
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (arr[i].charAt(j)=='L') {
                    ans+=isLEE(i, j);
                }
            }
        }
        System.out.println(ans);
        // Please write your code here.
    }
}