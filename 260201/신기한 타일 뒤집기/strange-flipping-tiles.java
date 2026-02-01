import java.util.Scanner;
public class Main {
    static int[] lines = new int[200_001];
    static int cur = 100_000;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            char d = sc.next().charAt(0);
            for (int j=0; j<x; j++) {
                int idx = (d=='R') ? cur+j : cur-j;

                if (d=='R') {
                    lines[idx] = 2;
                } else {
                    lines[idx] = 1;
                }
            }
            cur += (d=='R') ? (x-1) : (1-x);
        }
        int wCount = 0;
        int bCount = 0;
        for (int i=0; i<200_001; i++) {
            if (lines[i] == 1) wCount++;
            else if (lines[i] == 2) bCount++;
        }
        System.out.println(wCount + " " + bCount);
    }
}