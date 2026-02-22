import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static ArrayList<Ball> balls;

    static final int[] dr = {-1, 0, 0, 1}; // U L R D
    static final int[] dc = {0, -1, 1, 0};

    static class Ball {
        int r, c, dir;
        Ball(int r, int c, int dir) { this.r = r; this.c = c; this.dir = dir; }

        void move() {
            int nr = r + dr[dir];
            int nc = c + dc[dir];
            if (nr < 0 || nr >= N || nc < 0 || nc >= N) {
                dir = 3 - dir; // U<->D, L<->R
                return; // 방향 바꾸는 데 1초 소요 -> 이번 초엔 위치 그대로
            }
            r = nr; c = nc;
        }
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);
        StringBuilder sb = new StringBuilder();
        int T = fs.nextInt();

        while (T-- > 0) {
            N = fs.nextInt();
            M = fs.nextInt();
            balls = new ArrayList<>(M);

            for (int i = 0; i < M; i++) {
                int r = fs.nextInt() - 1;
                int c = fs.nextInt() - 1;
                char d = fs.nextChar();
                int dir = (d == 'U') ? 0 : (d == 'D') ? 3 : (d == 'R') ? 2 : 1;
                balls.add(new Ball(r, c, dir));
            }

            int LIMIT = 2 * N; // (상한은 문제에 따라 조정 가능)

            int size = N * N;
            int[] temp = new int[size];
            int[] touched = new int[Math.min(size, M)];
            int touchedCnt;

            for (int t = 0; t < LIMIT && balls.size() > 1; t++) {
                touchedCnt = 0;

                // 1) move + count
                for (int i = 0; i < balls.size(); i++) {
                    Ball b = balls.get(i);
                    b.move();
                    int idx = b.r * N + b.c;
                    if (temp[idx] == 0) touched[touchedCnt++] = idx;
                    temp[idx]++;
                }

                // 2) survivors
                ArrayList<Ball> next = new ArrayList<>(balls.size());
                for (int i = 0; i < balls.size(); i++) {
                    Ball b = balls.get(i);
                    int idx = b.r * N + b.c;
                    if (temp[idx] == 1) next.add(b);
                }
                balls = next;

                // 3) reset only touched cells
                for (int i = 0; i < touchedCnt; i++) {
                    temp[touched[i]] = 0;
                }
            }

            sb.append(balls.size()).append('\n');
        }

        System.out.print(sb.toString());
    }

    // 빠른 입력(Scanner 교체)
    static class FastScanner {
        private final InputStream in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;

        FastScanner(InputStream is) { in = is; }

        private int read() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }

        int nextInt() throws IOException {
            int c, sgn = 1, val = 0;
            do c = read(); while (c <= ' '); // skip
            if (c == '-') { sgn = -1; c = read(); }
            while (c > ' ') {
                val = val * 10 + (c - '0');
                c = read();
            }
            return val * sgn;
        }

        char nextChar() throws IOException {
            int c;
            do c = read(); while (c <= ' ');
            return (char) c;
        }
    }
}