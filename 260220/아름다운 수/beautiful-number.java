import java.util.Scanner;
public class Main {
    static int n, answer;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        answer = 0;
        dfs(0);
        System.out.println(answer);
    }

    static void dfs(int depth) {
        if (depth>n) {return;}
        if (depth==n) {
            answer++;
            return;
        }

        for (int i=1; i<=4; i++) {
            dfs(depth+i);
        }
    }
}