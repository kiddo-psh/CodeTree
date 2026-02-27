import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N, max, node;
	static final int ROOT = 0;
	static int[] leafCount;
	static List<Integer>[] adj;
	
	static int dfs (int u, int p) {
		int count = 0;
		
		for (int v : adj[u]) {
			if (v == p) continue;
			count += dfs(v, u);
		}
		
		if (count == 0) return 1;
		
		return leafCount[u] = count;
	}
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		leafCount = new int[N];
		adj = new ArrayList[N];
		for(int i=0; i<N; i++) adj[i] = new ArrayList<>();
		
		st = new StringTokenizer(br.readLine());
		for (int u=0; u<N; u++) {
			int v = Integer.parseInt(st.nextToken());
			if (v == -1) continue;
			adj[u].add(v);
			adj[v].add(u);
		}
		int del = Integer.parseInt(br.readLine());
		
		dfs(ROOT, -1);
		
		System.out.println(leafCount[ROOT] - leafCount[del]);
		br.close();
	}
}
