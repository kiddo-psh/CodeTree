import java.util.Scanner;

public class Main {
    static int[][] grid;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        grid = new int[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        char dir = sc.next().charAt(0);
        
        push(dir);

        for (int[] g : grid) {
            for (int x : g) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }

    static void push(char dir) {
        int[][] temp = new int[4][4];
        if (dir == 'D') {
            for (int col=0; col<4; col++) {
                int rowIndex = 3;
                int x = grid[3][col];
                int count = 0;
                for (int row=3; row>=0; row--) {
                    if (grid[row][col] == 0) { // 비어있으면 패스
                        continue;
                    }
                    if (x==grid[row][col]) { // 같은 숫자 체크
                        count++;
                        if (count==2) {
                            temp[rowIndex+1][col] += grid[row][col];
                            count = 0;
                            continue;
                        }
                    } else { // 다른 숫자.
                        x = grid[row][col];
                        count = 1;
                    }
                    temp[rowIndex--][col] = grid[row][col];
                }
            }
            grid = temp;
        }
        else if (dir == 'U') {
            for (int col=0; col<4; col++) {
                int rowIndex = 0;
                int x = grid[0][col];
                int count = 0;
                for (int row=0; row<4; row++) {
                    if (grid[row][col] == 0) { // 비어있으면 패스
                        continue;
                    }
                    if (x==grid[row][col]) { // 같은 숫자 체크
                        count++;
                        if (count==2) {
                            temp[rowIndex-1][col] += grid[row][col];
                            count = 0;
                            continue;
                        }
                    } else { // 다른 숫자.
                        x = grid[row][col];
                        count = 1;
                    }
                    temp[rowIndex++][col] = grid[row][col];
                }
            }
            grid = temp;
        } else if (dir == 'L') {
            for (int row=0; row<4; row++) {
                int colIndex = 0;
                int x = grid[row][0];
                int count = 0;
                for (int col=0; col<4; col++) {
                    if (grid[row][col] == 0) { // 비어있으면 패스
                        continue;
                    }
                    if (x==grid[row][col]) { // 같은 숫자 체크
                        count++;
                        if (count==2) {
                            temp[row][colIndex-1] += grid[row][col];
                            count = 0;
                            continue;
                        }
                    } else { // 다른 숫자.
                        x = grid[row][col];
                        count = 1;
                    }
                    temp[row][colIndex++] = grid[row][col];
                }
            }
            grid = temp;
        } else {
            for (int row=0; row<4; row++) {
                int colIndex = 3;
                int x = grid[row][3];
                int count = 0;
                for (int col=3; col>=0; col--) {
                    if (grid[row][col] == 0) { // 비어있으면 패스
                        continue;
                    }
                    if (x==grid[row][col]) { // 같은 숫자 체크
                        count++;
                        if (count==2) {
                            temp[row][colIndex+1] += grid[row][col];
                            count = 0;
                            continue;
                        }
                    } else { // 다른 숫자.
                        x = grid[row][col];
                        count = 1;
                    }
                    temp[row][colIndex--] = grid[row][col];
                }
            }
            grid = temp;
        }
    }
}