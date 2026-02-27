
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N, maxNode, maxDist;
    static List<Edge>[] adj;

    static class Edge{
        int to, w;
        public Edge(int to, int w) {
            this.to = to;
            this.w = w;
        }
    }

    static void dfs(int u, int p, int dist) {
        boolean hasChild = false;

        for (Edge e : adj[u]) {
            int v = e.to;
            if (v == p) continue;
            hasChild = true;
            dfs(v, u, dist+e.w);
        }

        if (!hasChild && maxDist < dist) {
            maxDist = dist;
            maxNode = u;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        adj = new ArrayList[N+1];
        for (int i=0; i<=N; i++) adj[i] = new ArrayList<>();

        for (int i=0; i<N-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            adj[u].add(new Edge(v, w));
            adj[v].add(new Edge(u, w));
        }

        final int ROOT = 1;
        maxNode = ROOT;
        maxDist = 0;
        dfs (ROOT, 0, 0);
        dfs (maxNode, 0, 0);

        System.out.println(maxDist);
    }
}
