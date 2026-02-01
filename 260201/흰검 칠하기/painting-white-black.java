import java.util.Scanner;
public class Main {
    static final int MAX_I = 200_001;
    static int cur = 100_000;
    static int[] white = new int[MAX_I];
    static int[] black = new int[MAX_I];
    static int[] state = new int[MAX_I];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for (int i = 0; i < N; i++) {
            int x = sc.nextInt();
            char d = sc.next().charAt(0);
            for (int j=0; j<x; j++) {
                int idx = (d=='R') ? cur+j : cur-j;

                if (state[idx] == 3) continue;

                if (d=='R') {
                    black[idx]++;
                    state[idx] = 2;
                }
                else {
                    white[idx]++;
                    state[idx] = 1;
                }

                if (white[idx]>=2 && black[idx]>=2) state[idx] = 3;
            }
            cur += (d=='R') ? (x-1) : (1-x);
        }

        int wCount = 0;
        int bCount = 0;
        int gCount = 0;
        for (int i=0; i<MAX_I; i++) {
            if (state[i] == 3) gCount++;
            else if (state[i] == 2) bCount++;
            else if (state[i] == 1) wCount++;
        }
        System.out.println(wCount + " " + bCount + " " + gCount);
    }
}