import java.util.Scanner;

public class Main {
    static int[][] map = new int[201][201];
    static int x1, x2, y1, y2;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            x1 = sc.nextInt();
            y1 = sc.nextInt();
            x2 = sc.nextInt();
            y2 = sc.nextInt();

            for (int y = y1; y < y2; y++) {
                for (int x = x1; x < x2; x++) {
                    map[y][x] = 1;
                }
            }
        }
        int result = 0;
        for (int y = 0; y < 201; y++) {
            for (int x = 0; x < 201; x++) {
                if(map[y][x] == 1) {
                    result++;
                }
            }
        }

        System.out.println(result);
    }
}