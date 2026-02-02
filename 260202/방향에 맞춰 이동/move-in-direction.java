import java.util.Scanner;
public class Main {
    static final int[] dy = {0, -1, 1, 0}; // W S N E
    static final int[] dx = {-1, 0, 0, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int y = 0; int x = 0;
        for (int i = 0; i < n; i++) {
            char direction = sc.next().charAt(0);
            int distance = sc.nextInt();
            if (direction == 'W') {
                y += distance * dy[0];
                x += distance * dx[0];
            } else if (direction == 'S') {
                y += distance * dy[1];
                x += distance * dx[1];
            } else if (direction == 'N') {
                y += distance * dy[2];
                x += distance * dx[2];
            } else if (direction == 'E') {
                y += distance * dy[3];
                x += distance * dx[3];
            }
        }
        System.out.println(x + " " + y);
    }
}