import java.util.Scanner;
public class Main {
    static int[][] map = new int[201][201];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();
            for (int r=x1+100; r<x2+100; r++) {
                for (int c=y1+100; c<y2+100; c++) {
                    map[r][c] = i%2+1;
                }
            }
        }
        int result = 0;
        for (int r=0; r<201; r++) {
            for (int c=0; c<201; c++) {
                if(map[r][c] == 2) result++;
            }
        }

        System.out.println(result);
        // Please write your code here.
    }
}