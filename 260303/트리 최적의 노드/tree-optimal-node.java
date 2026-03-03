
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static List<Integer> leaves = new ArrayList<>();
	static final int ROOT = 1;
	static List<Integer>[] adj;
	
	static int dfs(int u, int p, int depth) {
		int max = -1;
		boolean isLeaf = true;
		for (int v : adj[u]) {
			if (v==p) continue;
			isLeaf = false;
			int n = dfs(v, u, depth+1);
			max = Math.max(max, n);
			if (u == ROOT) {
				leaves.add(n);
			}
		}
		if (isLeaf) {
			return depth;
		}
		else return max;
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
		Collections.sort(leaves, (a,b)-> Integer.compare(b, a));
		
		int answer = -1;
		int max1 = leaves.get(0), max2 = leaves.size()>=2 ? leaves.get(1) : 0;
		if ((max1+max2)%2==0) answer = (max1+max2)/2;
		else answer = (max1+max2)/2+1;
		System.out.println(answer);
		br.close();
	}
}
