import java.util.Scanner;

public class Main {
    static int[] result = new int[2];
    static int[][] arr;
    static int[] dr = {-1, 0, -1, -1};
    static int[] dc = {0,  1,  1, -1};
    static boolean isWin(int r, int c, int n) {
        boolean flag = true;
        for (int i=0; i<4; i++) {
            flag = true;
            for (int j=1; j<=4; j++) {
                int nr = r + j*dr[i];
                int nc = c + j*dc[i];
                if (!inRange(nr, nc) || arr[nr][nc] != n) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                result[0] = r + 1 + 2*dr[i];
                result[1] = c + 1 + 2*dc[i];
                return flag;
            }
        }
        return flag;
    }
    static boolean inRange(int r, int c) {
        return r>=0 && r<19 && c>=0 && c<19;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        arr = new int[19][19];
        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                if (arr[i][j] > 0) {
                    if (isWin(i, j, arr[i][j])) {
                        System.out.println(arr[i][j]);
                        System.out.println(result[0] + " " + result[1]);
                        return;
                    }
                }
            }
        }
        System.out.println(0);
        // Please write your code here.
    }
}