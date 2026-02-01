import java.util.Scanner;
public class Main {
    static int[] lines = new int[200_001];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int cur = 100_000;
        char last = 'c';
        for (int i = 0; i < N; i++) {
            int x = sc.nextInt();
            char d = sc.next().charAt(0);
            for (int j=0; j<x; j++) {
                if (d == 'R') {
                    lines[cur+j]++;
                } else {
                    lines[cur-j]++;
                }
            }
            if (d=='R') cur+=x-1;
            else cur-=x-1;
            if (i==N-1) last = d;
        }
        int black = 0;
        int white = 0;
        int grey = 0;
        for (int i=0; i<200_001; i++) {
            if (lines[i] == 0) continue;
            if (lines[i] >= 4) grey++;
            else if (i < cur) black++;
            else if (i > cur) white++; 
            else if (i==cur && last == 'R') black++;
            else if (i==cur && last == 'L') white++;
        }
        System.out.println(white + " " + black + " " + grey);
    }
}