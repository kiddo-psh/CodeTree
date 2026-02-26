import java.io.*;
import java.util.*;

public class Main {
	static int N, M, T;
	static Marble[] bucket;
	static List<Marble> list;
	
	static class Marble {
		int idx, r, c, w, d;
		public Marble (int idx, int r, int c, int w, int d) {
			this.idx = idx;
			this.r = r; this.c = c;
			this.w = w;	this.d = d;
		}
		public void move() {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if (!inRange(nr, nc)) {
				d = 3 - d;
				return;
			}
			r = nr;	c = nc;
		}
		public String toString() {
			StringBuilder sb = new StringBuilder();
			sb.append("좌표 = {").append(r).append(", ").append(c).append("}, 무게=").append(w)
			.append("  속도="+d).append("  방향=").append(d).append("\n");
			return sb.toString();
		}
	}
	
	static final int[] dr = {-1, 0, 0, 1};
	static final int[] dc = {0, 1, -1, 0};
	
	static boolean inRange(int r, int c) {
		return r>=0 && r<N && c>=0 && c<N;
	}
	
    public static void main(String[] args) throws IOException {
    		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
    		T = Integer.parseInt(st.nextToken());
    		
    		bucket = new Marble[N*N+1];
    		list = new ArrayList<>();
    		
    		for (int i=1; i<=M; i++) {
    			st = new StringTokenizer(br.readLine());
    			int R = Integer.parseInt(st.nextToken())-1;
    			int C = Integer.parseInt(st.nextToken())-1;
    			char dir = st.nextToken().charAt(0);
    			int D = dir=='U' ? 0 : dir=='D' ? 3 : dir=='L' ? 2 : 1;
    			int W = Integer.parseInt(st.nextToken());
    			
    			list.add(new Marble(i, R, C, W, D));
    		}
    		
    		while(T-->0 && list.size()>1) {
    			//dbg(list);
    			for (Marble m : list) {
    				m.move();
    				int index = m.r * N + m.c;
    				
    				if (bucket[index]==null) {
    					bucket[index] = m;
    				} else {
    					int W = bucket[index].w + m.w;
    					int I = -1, D = -1;
    					if (bucket[index].idx >= m.idx) {
    						I = bucket[index].idx;
    						D = bucket[index].d;
    					} else {
    						I = m.idx;
    						D = m.d;
    					}
    					bucket[index] = new Marble(I, m.r, m.c, W, D);
    				}
    			}
    			
    			ArrayList<Marble> next = new ArrayList<>();
    			for (int i=0; i<=N*N; i++) {
    				Marble m = bucket[i];
    				if (m==null) continue;
    				next.add(m);
    				bucket[i] = null;
    			}
    			list = next;
    		}
    		//dbg(list);
    		int max = -1;
    		for (Marble m : list) max = Math.max(max, m.w);
    		
		System.out.println(list.size() + " " + max);
		br.close();
	}
    static void dbg(Object...objects) {
    		System.out.println(Arrays.deepToString(objects));
    }
}