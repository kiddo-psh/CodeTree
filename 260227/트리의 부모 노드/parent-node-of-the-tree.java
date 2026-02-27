import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static final int ROOT = 1;
	static List<Integer>[] adj;
	static int[] parent;
	
	static void dfs(int u, int p) {
		parent[u] = p;
		
		for (int v : adj[u]) {
			if (v == p) continue;
			dfs(v, u);
		}
	}
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		parent = new int[N+1];
		adj = new ArrayList[N+1];
		for (int i=1; i<=N; i++) adj[i] = new ArrayList<>();
		
		for (int i=0; i<N-1; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			adj[u].add(v);
			adj[v].add(u);
		}
		
		dfs(ROOT, 0);
		
		StringBuilder output = new StringBuilder();
		for (int i=2; i<=N; i++) {
			output.append(parent[i]).append("\n");
		}
		System.out.println(output);
		
		br.close();
	}
}
