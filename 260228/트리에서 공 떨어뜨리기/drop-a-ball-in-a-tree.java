
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    static Node[] left, right;
    static class Node {
        int n, cnt;
        public Node (int n, int cnt) {
            this.n = n; this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        left = new Node[N+1]; right = new Node[N+1];

        for (int i=1; i<=N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            left[i] = new Node(l, 0);
            right[i] = new Node(r, 0);
        }

        int answer = 0;
        K = Integer.parseInt(br.readLine());
        while (K-- > 0) {
            int cur = 1;
            while (!isLeaf(cur)) {
                if (onlyLeft(cur)) {cur*=2; left[cur].cnt++;}
                else if (onlyRight(cur)) {cur=cur*2+1; right[cur].cnt++;}
                else {
                    if (left[cur].cnt <= right[cur].cnt) {
                        cur *= 2;
                        left[cur].cnt++;
                    } else {
                        cur = cur * 2 + 1;
                        right[cur].cnt++;
                    }
                }
            }
            answer = cur;
        }
        System.out.print(answer);
        br.close();
    }

    static boolean isLeaf(int node) {
        return left[node].n==-1 && right[node].n==-1;
    }

    static boolean onlyLeft(int node) {
        return right[node].n == -1 && left[node].n != -1;
    }

    static boolean onlyRight(int node) {
        return left[node].n == -1 && right[node].n != -1;
    }
}
