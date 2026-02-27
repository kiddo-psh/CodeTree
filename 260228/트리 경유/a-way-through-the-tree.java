
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder output = new StringBuilder();
    static int N, Q;
    static int[] bt;

    static void query(int node) {
        boolean isPossible = true;
        int next = node;
        int cause = -1;
        while (next != 0) {
            next /= 2;
            if (bt[next] == 1) {
                isPossible = false;
                cause = next;
            }
        }

        if (isPossible) {
            bt[node] = 1;
            System.out.println(0);
        } else {
            System.out.println(cause);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        bt = new int[N+1];

        for (int i=0; i<Q; i++) {
            query(Integer.parseInt(br.readLine()));
        }

        br.close();
    }
}
