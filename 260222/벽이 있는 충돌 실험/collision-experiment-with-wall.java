
import java.util.*;
public class Main {
    static int N, M;
    static List<Ball> balls;
    static int[][] count;
    
    static final int[] dr = {1,0,0,-1}; // 상 좌우 하
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
                int c = sc.nextInt()-1;
                int r = sc.nextInt()-1;
                char d = sc.next().charAt(0);

                int dir = 0;
                if (d=='U') dir=0;
                else if (d=='D') dir=3;
                else if (d=='R') dir=2;
                else if (d=='L') dir=1;

                balls.add(new Ball(r, c, dir));
                count[r][c]++;
            }

            for (int i=0; i<2*N; i++) {
                //모든 구슬 이동
                for (int j=0; j<balls.size(); j++) {
                		count[balls.get(j).r][balls.get(j).c]--;
                		
                		balls.get(j).move();
                		
                		count[balls.get(j).r][balls.get(j).c]++;
                }
                
                //충돌 체크
                for (int j=0; j<N; j++) {
                	for(int k=0; k<N; k++) {
                		if (count[j][k]>=2) {
                            count[j][k]=0;
                			for (int l=balls.size()-1; l>=0; l--) {
                				if (balls.get(l).r==j && balls.get(l).c==k) {
                					balls.remove(l);
                				}
                			}
                		}
                	}
                }
            }
            
            System.out.println(balls.size());
        }
        sc.close();
    }
}