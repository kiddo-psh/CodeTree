
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static List<Integer>[] adj;
	static boolean[] visited;
	
	static boolean isTree(int u, int p) {
		visited[u] = true;
		
		for (int v : adj[u]) {
			if (v == p) continue;
			if (visited[v]) return false;
			if (!isTree(v, u)) return false;
		}
		
		return true;
	}
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		visited = new boolean[N+1];
		adj = new ArrayList[N+1];
		for (int i=1; i<=N; i++) adj[i] = new ArrayList<>();
		
		for (int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			adj[u].add(v);
			adj[v].add(u);
		}
		
		int answer = 0;
		for (int i=1; i<=N; i++) {
			if (visited[i]) continue;
			if (isTree(i, 0)) answer++;
		}
		System.out.println(answer);
		br.close();
	}
}
