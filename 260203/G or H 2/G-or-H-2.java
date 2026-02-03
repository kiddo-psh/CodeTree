import java.util.*;

public class Main {
    static class People implements Comparable<People> {
        int p;
        char c;
        public People(int p, char c) {
            this.p = p;
            this.c = c;
        }
        @Override
        public int compareTo(People o) {
            return this.p - o.p;
        }
    }
    static int countG;
    static int countH;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        People[] lines = new People[n];
        for (int i = 0; i < n; i++) {
            int position = sc.nextInt();
            char ch = sc.next().charAt(0);
            lines[i] = new People(position, ch);
        }

        Arrays.sort(lines);
        int ans = 0;
        for (int i=n-1; i>=0; i--) { // 부분 크기
            for (int j=0; j<n-i; j++) { // 슬라이딩 시작점
                countH = 0; countG = 0;
                for (int k=j; k<=j+i; k++) { // 윈도우 계산
                    if (lines[k].c=='G') countG++;
                    else if (lines[k].c=='H') countH++;
                } 
                if (countG==countH || countG==0 || countH==0) {
                    ans = Math.max(ans, lines[j+i].p - lines[j].p);
                }
            }
        }
        System.out.println(ans);
    }
}