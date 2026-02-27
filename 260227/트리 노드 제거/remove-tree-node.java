
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N, del, ROOT;
	static List<Integer>[] adj;
	
	static int dfs (int u, int p) {
		int count = 0;
		
		for (int v : adj[u]) {
			if (v == del) continue;
			if (v == p) continue;
			count += dfs(v, u);
		}
		
		if (count == 0) {
			return 1;
		}
		
		return count;
	}
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		adj = new ArrayList[N];
		for(int i=0; i<N; i++) adj[i] = new ArrayList<>();
		
		st = new StringTokenizer(br.readLine());
		for (int u=0; u<N; u++) {
			int v = Integer.parseInt(st.nextToken());

			adj[u].add(v); 
			if (v == -1) {
				ROOT = u;
				continue;
			}
			adj[v].add(u);
		}
		
		del = Integer.parseInt(br.readLine());
		if (del == ROOT) {
			System.out.println(0);
			return;
		}
		
		System.out.println(dfs(ROOT, -1));
		br.close();
	}
}
