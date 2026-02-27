
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
	static int M;
	static List<Integer>[] adj;
	static int[] indegree;
	static boolean visited[];
	static int visitCount = 0;
	
	// 도달 못 하거나, 사이클 
	static boolean isCycle(int u) {
		visited[u] = true;
		visitCount++;
		
		for (int v : adj[u]) {
			if (visited[v]) return true;
			if (isCycle(v)) return true;
		}
		
		return false;
	}
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		M = Integer.parseInt(br.readLine());
		final int N = 10_000;
		adj = new ArrayList[N+1];
		indegree = new int[N+1];
		for(int i=0; i<=N; i++) adj[i] = new ArrayList<>();
		visited = new boolean[N+1];
		
		Set<Integer> nodes = new HashSet<>();
		
		for (int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			adj[u].add(v);
			indegree[v]++;
			
			nodes.add(u); nodes.add(v);
		}
		
		int ROOT = -1;
		for (int node : nodes) {
			if (indegree[node] == 0) {
				if (ROOT != -1) {System.out.println(0); return;}
				ROOT = node;
			}
		}
		
		if(isCycle(ROOT) || visitCount!=nodes.size()) {
			System.out.println(0); return;
		}
		
		System.out.println(1);
		br.close();
	}
}
