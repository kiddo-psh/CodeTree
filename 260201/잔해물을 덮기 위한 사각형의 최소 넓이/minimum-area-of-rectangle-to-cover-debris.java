import java.util.Scanner;

public class Main {
    static int[][] map = new int[2001][2001];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rect1_x1 = sc.nextInt();
        int rect1_y1 = sc.nextInt();
        int rect1_x2 = sc.nextInt();
        int rect1_y2 = sc.nextInt();
        int rect2_x1 = sc.nextInt();
        int rect2_y1 = sc.nextInt();
        int rect2_x2 = sc.nextInt();
        int rect2_y2 = sc.nextInt();
        for (int r=rect1_x1+1000; r<rect1_x2+1000; r++) {
            for (int c=rect1_y1+1000; c<rect1_y2+1000; c++) {
                map[r][c] = 1;
            }
        }
        for (int r=rect2_x1+1000; r<rect2_x2+1000; r++) {
            for (int c=rect2_y1+1000; c<rect2_y2+1000; c++) {
                map[r][c] = 0;
            }
        }
        int maxY = -1; int minY = 2002;
        int maxX = -1; int minX = 2002;
        for (int r=0; r<2001; r++) {
            for (int c=0; c<2001; c++) {
                if (map[r][c] == 1) {
                    maxY = Math.max(maxY, r);
                    minY = Math.min(minY, r);
                
                    maxX = Math.max(maxX, c);
                    minX = Math.min(minX, c);
                }
            }
        }
        System.out.println((maxY-minY+1)*(maxX-minX+1));
    }
}