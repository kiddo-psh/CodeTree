import java.util.*;
public class Main {
    static int N, M;
    static List<Ball> balls;
    static int[][] count;
    
    static final int[] dr = {-1,0,0,1}; // 상 좌우 하
    static final int[] dc = {0,-1,1,0};

    static class Ball {
        int r, c, dir;
        public Ball(int r, int c, int dir) {
            this.r = r;
            this.c = c;
            this.dir = dir;
        }

        public void move() {
            int nr = r + dr[dir];
            int nc = c + dc[dir];
            if (!inRange(nr, nc)) {
                dir = 3-dir;
                return;
            }
            r = nr; c = nc;
        }
    }

    static boolean inRange(int r, int c) {
        return r>=0 && r<N && c>=0 && c<N;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while(T-- > 0) {
            N = sc.nextInt();
            M = sc.nextInt();
            
            count = new int[N][N];
            balls = new ArrayList<>();
            
            for (int i = 0; i < M; i++) {
                int r = sc.nextInt()-1;
                int c = sc.nextInt()-1;
                char d = sc.next().charAt(0);

                int dir = 0;
                if (d=='U') dir=0;
                else if (d=='D') dir=3;
                else if (d=='R') dir=2;
                else if (d=='L') dir=1;

                balls.add(new Ball(r, c, dir));
                count[r][c]++;
            }

            int LIMIT = 2 * N;

            for (int t = 0; t < LIMIT; t++) {

                // 1) 전부 이동(또는 방향전환) + 도착지 카운트
                for (Ball b : balls) {
                    count[b.r][b.c]--;
                    b.move();
                    count[b.r][b.c]++;
                }

                // 2) 충돌 제거: 도착지에 1개인 구슬만 생존
                List<Ball> next = new ArrayList<>();
                for (Ball b : balls) {
                    if (count[b.r][b.c] == 1) next.add(b);
                    if (count[b.r][b.c] >= 2) count[b.r][b.c] = 0;
                }
                balls = next;
            }
            
            System.out.println(balls.size());
        }
        sc.close();
    }
}