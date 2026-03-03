
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N, maxDist, farNode;
	static List<Integer> leaves = new ArrayList<>();
	static final int ROOT = 1;
	static List<Integer>[] adj;
	
	static void dfs(int u, int p, int depth) {
		if (depth > maxDist) {
			maxDist = depth;
			farNode = u;
		}
		
		for (int v : adj[u]) {
			if (v==p) continue;
			dfs(v, u, depth+1);
		}
	}
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		adj = new ArrayList[N+1];
		for (int i=1; i<=N; i++) adj[i] = new ArrayList<>();
		
		for (int i=0; i<N-1; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			adj[u].add(v);
			adj[v].add(u);
		}
		
		dfs(ROOT, 0, 0);
		dfs(farNode,0,0);		
		
		int answer = -1;
		
		if (maxDist%2==0) answer = maxDist/2;
		else answer = maxDist/2+1;
		
		System.out.println(answer);
		br.close();
	}
}
