

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
	static boolean visited[];
	static int visitCount = 0;
	
	// 도달 못 하거나, 사이클 
	static boolean isCycle(int u, int p) {
		visited[u] = true;
		visitCount++;
		
		for (int v : adj[u]) {
			if (v == p) continue;
			if (visited[v]) return true;
			isCycle(v, u);
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
		for(int i=0; i<=N; i++) adj[i] = new ArrayList<>();
		visited = new boolean[N+1];
		
		Set<Integer> nodes = new HashSet<>();
		
		for (int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			adj[u].add(v); adj[v].add(u);
			
			nodes.add(u); nodes.add(v);
		}
		
		if(isCycle(1, 0) || visitCount!=nodes.size()) {
			System.out.println(0);
			return;
		}
		
		System.out.println(1);
		br.close();
	}
}
