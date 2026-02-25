import java.io.*;
import java.util.*;

public class Main {
	static int N, M, T, K;
	static final int[] dr = {-1, 0, 0, 1};
	static final int[] dc = {0, 1, -1, 0};
	
	static boolean inRange(int r, int c) {
		return r>=0 && r<N && c>=0 && c<N;
	}
	
	static class Marble implements Comparable<Marble> {
		int r, c, d, v, idx;
		public Marble(int r, int c, int d, int v, int idx) {
			this.r = r; this.c = c;
			this.d = d; this.v = v;
			this.idx = idx;
		}
		
		public void move() {
			for (int i = 0; i < v; i++) {
				int nr = r + dr[d];
				int nc = c + dc[d];

				if (!inRange(nr, nc)) {
					d = 3 - d;
					nr = r + dr[d];
					nc = c + dc[d];
				}

				r = nr;
				c = nc;
			}
		}
		
		public int compareTo(Marble o) {
			if (this.v == o.v) return Integer.compare(o.idx, this.idx);
			return Integer.compare(o.v, this.v);
		}
	}
	
	static ArrayList<Marble>[] bucket;
	static List<Marble> list = new ArrayList<>();
	
    @SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		bucket = new ArrayList[N*N+1];
		for (int i=0; i<=N*N; i++) {
			bucket[i] = new ArrayList<>();
		}
		
		for (int i=1; i<=M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken())-1;
			int c = Integer.parseInt(st.nextToken())-1;
			char dir = st.nextToken().charAt(0);
			int d = dir=='U' ? 0 : dir=='D' ? 3 : dir=='R' ? 1 : 2;
			int v = Integer.parseInt(st.nextToken());
			
			list.add(new Marble(r, c, d, v, i));
		}
		
		while(T-->0 && list.size()>1) {
			for (Marble m : list) {
				m.move();
				int index = m.r*N+m.c;
				bucket[index].add(m);
			}
			
			ArrayList<Marble> next = new ArrayList<>();
			for (ArrayList<Marble> marbles : bucket) {
				if (marbles.size()>=K) {
					Collections.sort(marbles);
					for (int i=0; i<K; i++) {
						next.add(marbles.get(i));
					}
				} else {
					for (Marble m : marbles) {
						next.add(m);
					}
				}
				marbles.clear();
			}
			list = next;
		}
		System.out.println(list.size());
		br.close();
	}
}