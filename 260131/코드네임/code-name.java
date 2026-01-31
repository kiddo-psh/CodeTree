import java.util.*;
class Agent implements Comparable<Agent> {
    String codeName;
    int score;
    public Agent(String codeName, int score) {
        this.codeName = codeName;
        this.score = score;
    }
    @Override
    public int compareTo(Agent o) {
        return Integer.compare(this.score, o.score);
    }
    @Override
    public String toString() {
        return new StringBuilder()
        .append(codeName).append(" ")
        .append(score).toString();
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Agent[] agentList = new Agent[5];
        for (int i=0; i<5; i++) {
            String s = sc.next();
            int n = sc.nextInt();
            agentList[i] = new Agent(s, n);
        }
        Arrays.sort(agentList);
        System.out.println(agentList[0]);
    }
}