import java.util.*;
public class Main {
    static int k;
    static int[] candies;

    static int addCandy(int idx) {
        int sum = candies[idx];
        for (int i=1; i<=k && idx-i >= 0; i++) {
            sum += candies[idx-i];
        }
        
        for (int i=1; i<=k && idx+i <= 100; i++) {
            sum += candies[idx+i];
        }
        return sum;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        k = sc.nextInt();
        candies = new int[101];
        for (int i = 0; i < n; i++) {
            int cnt = sc.nextInt();
            int idx = sc.nextInt();
            candies[idx] += cnt;
        }

        if (k>50) {
            int ret = 0;
            for (int i=0; i<=100; i++) {
                ret += candies[i];
            }
            System.out.println(ret);
            return;
        }
        
        int answer=0;
        for (int i=0; i<101; i++) {
            int sum = addCandy(i);
            answer = Math.max(sum, answer);
        }

        System.out.println(answer);
    }
}