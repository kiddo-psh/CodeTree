import java.util.Scanner;

public class Main {
    static int[] result = new int[2];
    static int[][] arr;
    static boolean isWin(int r, int c, int n) {
        boolean flag = true;
        for (int i=1; i<=4; i++) {
            if(arr[r+i][c]!=n) {
                flag = false;
                break;
            }
            if(i==4) {
                result[1] = c+1;
                result[0] = r+3;
            }
        }
        if (flag) return true;

        flag = true; 
        for (int i=1; i<=4; i++) {
            if(arr[r][c+i]!=n) {
                flag = false;
                break;
            }
            if(i==4) {
                result[1] = c+3;
                result[0] = r+1;
            }
        }
        if (flag) return true;

        flag = true; 
        for (int i=1; i<=4; i++) {
            if(arr[r+i][c+i]!=n) {
                flag = false;
                break;
            }
            if(i==4) {
                result[1] = c+3;
                result[0] = r+3;
            }
        }
        return flag;
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
        // Please write your code here.
    }
}