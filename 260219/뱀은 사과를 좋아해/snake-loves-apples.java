import java.util.*;
public class Main {
    static int n, m, k;
    static int[][] map;

    static class Point {
        int r, c;
        Point next;

        public Point(int r, int c, Point next) {
            this.r = r;
            this.c = c;
            this.next = next;
        }

        public void set(int r, int c, Point next) {
            this.r = r;
            this.c = c;
            this.next = next;
        }
    }

    static boolean inRange(int r, int c) {
        return r>=0 && r<n && c>=0 && c<n;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();
        
        map = new int[n][n];

        for (int i = 0; i < m; i++) {
            int x = sc.nextInt()-1;
            int y = sc.nextInt()-1;
            map[y][x] = 1;
        }

        List<Point> snake = new ArrayList<>();
        Point head = new Point(0, 0, null);
        Point tail = new Point(0, 0, null);
        snake.add(head);
        snake.add(tail);
        map[0][0] = 9;

        int time = 0;
        for (int i = 0; i < k; i++) {
            char d = sc.next().charAt(0);
            int p = sc.nextInt();
            for (int dist=0; dist<p; dist++) {
                int nr = head.r + dr[d-'A'];
                int nc = head.c + dc[d-'A'];

                time++;
                if (!inRange(nr, nc)) { // 격자 밖
                    System.out.print(time);
                    return;
                }

                // 머리 움직이기
                head.set(nr, nc, null);
                map[nr][nc] = 9;
                
                // 사과 먹기
                if (map[nr][nc] == 1) {
                    if (tail.next==null) {
                        tail.set(nr, nc, head);
                    } else {
                        Point point = new Point(tail.r, tail.c, tail.next);
                        tail.set(nr, nc, point);
                        snake.add(point);
                    }
                }

                map[tail.r][tail.c] = 0;
                if (tail.next != null) tail = tail.next;

                if (map[nr][nc] == 9) { // 몸이 꼬임
                    System.out.print(time);
                    return;
                }

            }
        }

        System.out.print(time);
    }

    static int[] dr = new int[26];
    static int[] dc = new int[26];

    static {
        dr['R'-'A'] = 0;
        dc['R'-'A'] = 1;

        dr['L'-'A'] = 0;
        dc['L'-'A'] = -1;

        dr['U'-'A'] = -1;
        dc['U'-'A'] = 0;

        dr['D'-'A'] = 1;
        dc['D'-'A'] = 0;
    }
}