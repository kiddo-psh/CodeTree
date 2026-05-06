import java.util.*;

public class Main {
    
    static int N, K;
    static List<Integer> answer = new ArrayList<>();

    static void dfs(int currNum) {
        if (currNum == N) {
            printAnswer();
            return;
        }

        for (int i=1; i<=K; i++) {
            if (answer.size() >= 2) {
                if (i == answer.get(answer.size()-1) && answer.get(answer.size()-1) == answer.get(answer.size()-2)) {
                    continue;
                } else {
                    answer.add(i);
                    dfs(currNum+1);
                    answer.remove(answer.size()-1);
                }
            } else {
                answer.add(i);
                dfs(currNum+1);
                answer.remove(answer.size()-1);
            }
        }
    }

    static void printAnswer() {
        StringBuilder sb = new StringBuilder();
        for (int x : answer) {
            sb.append(x).append(" ");
        }
        System.out.println(sb);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        K = sc.nextInt();
        N = sc.nextInt();

        dfs(0);
    }
}