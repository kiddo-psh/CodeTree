
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	static int N, answer;
	static List<Integer>[] adj;
	
	static void dfs(int u, int p, int dist) {
		int cnt = 0;
		
		for (int v : adj[u]) {
			if (v == p) continue;
			cnt++;
			dfs(v, u, dist+1);
		}
		
		if (cnt==0) answer += dist;
	}
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		adj = new ArrayList[N+1];
		for (int i=1; i<=N; i++) adj[i] = new ArrayList<>();
	
		for (int i=0; i<N-1; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			adj[u].add(v); adj[v].add(u);
		}
		
		dfs(1, 0, 0);
		
		if (answer%2==0) System.out.println(0);
		else System.out.println(1);
		
		br.close();
	}
}
