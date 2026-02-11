import java.util.Scanner;

public class Main {
    static int n, m;
    static int[] bombs;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        bombs = new int[n];
        for (int i = 0; i < n; i++) {
            bombs[i] = sc.nextInt();
        }

        while(boom()){}

        System.out.println(bombs.length);
        for (int b : bombs) {
            System.out.println(b);
        }
        // Please write your code here.
    }

    static boolean boom() {
        if (bombs.length==0) return false;
        boolean flag = false;
        int count = 1;
        int shurink = 0;
        int x = bombs[0];
        for (int i=1; i<n; i++) {
            if (x != bombs[i]) {
                if (count >= m) {
                    flag = true;
                    shurink += count;
                    for (int j=i-1; j>=i-count; j--) {
                        bombs[j] = 0;
                    }
                }
                x = bombs[i];
                count = 1;
            } else {
                count++;
            }
        }
        if (count >= m) {
            flag = true;
            shurink += count;
            for (int j=n-1; j>=n-count; j--) {
                bombs[j] = 0;
            }
        }
        n -= shurink;
        int[] temp = new int[n];
        int tempIdx = 0;
        for (int i=0; i<bombs.length; i++) {
            if (bombs[i]==0) continue;
            temp[tempIdx++] = bombs[i];
        }
        bombs = temp;

        return flag;
    }
}