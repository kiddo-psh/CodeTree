import java.util.Scanner;
public class Main {
    static int[][] map = new int[201][201];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            for (int r=x+100; r<x+108; r++) {
                for (int c=y+100; c<y+108; c++) {
                    map[r][c] = 1;
                }
            }
        }
        int result = 0;
        for(int r = 0; r<201; r++) {
            for (int c=0; c<201; c++) {
                if (map[r][c]==1) result++;
            }
        }
        System.out.println(result);
        // Please write your code here.
    }
}