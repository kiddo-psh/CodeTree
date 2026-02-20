import java.util.Scanner;

public class Main {
    static int k, n;
    static int[] num;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        k = sc.nextInt();
        n = sc.nextInt();
        num = new int[n];
        visited = new boolean[n];
        dfs(0, num);
    }

    static void dfs(int depth, int[] num) {
        if (depth==n) {
            for (int x : num) {
                System.out.print(x + " ");
            }
            System.out.println();
            return;
        }

        for (int i=1; i<=k; i++) {
            num[depth] = i;
            dfs (depth+1, num);
        }
    }
}