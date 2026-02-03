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

        for (int i=n-2; i>=0; i--) {
            countG = 0; countH = 0;
            for (int j=0; j<=i; j++) {
                if (lines[j].c=='G') countG++;
                else if (lines[j].c=='H')countH++;
            }
            for (int j=i+1; j<n; j++) {
                if(lines[j].c == 'G') countG++;
                else if (lines[j].c=='H')countH++;

                if(lines[j-i-1].c == 'G') countG--;
                else if (lines[j-i-1].c=='H')countH--;

                if (countH==countG || countH==0 || countG==0) {
                    System.out.println(countG + ", " +countH);
                    System.out.println(j + ", " + (j-i));
                    System.out.println(lines[j].p - lines[j-i].p);
                    return;
                }
            }
        }
        System.out.println(0);
    }
}