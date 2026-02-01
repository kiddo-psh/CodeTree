import java.util.Scanner;
public class Main {
    static int[] lines = new int[2001];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int cur = 1000;
        for (int i = 0; i < N; i++) {
            int x = sc.nextInt();
            char dir = sc.next().charAt(0);
            for (int j=0; j<x; j++) {
                if (dir=='R') {
                    lines[cur++]++;
                } else {
                    lines[--cur]++;
                }
            }
        }
        int result = 0;
        for (int i=0; i<lines.length; i++) {
            if (lines[i] >= 2) {
                result++;
            }
        }

        System.out.println(result);
    }
}