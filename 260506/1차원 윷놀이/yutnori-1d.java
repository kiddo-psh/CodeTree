import java.util.*;
import java.io.*;

public class Main {

    static int N, M, K, max;
    static int[] turns, markers;

    static void dfs(int currTurn) {
        if (currTurn == N) {
            max = Math.max(max, count());
            return;
        }

        for (int i=0; i<K; i++) {
            if (markers[i] >= M) {
                max = Math.max(1, max);
                continue;
            }

            markers[i] += turns[currTurn];
            dfs(currTurn+1);
            markers[i] -= turns[currTurn];
        }
    }

    static int count() {
        int cnt = 0;
        
        for (int m : markers) {
            if (m >= M) {
                cnt++;
            }
        }

        return cnt;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        max = Integer.MIN_VALUE;
        turns = new int[N];
        markers = new int[K];
        Arrays.fill(markers, 1);

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            turns[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0);

        System.out.println(max);
    }
}