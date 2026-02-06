import java.util.Scanner;
public class Main {
    static int ability[] = new int[6];
    static int result;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i=0; i<6; i++)
            ability[i] = sc.nextInt();
        result = Integer.MAX_VALUE;
        comb(0, 0, 0, 0, 0, 0, 0);
        System.out.println(result);
    }

    static void comb(int depth, int team1, int team2, int team3, int count1, int count2, int count3) {
        if (depth == 6) {
            int maxTeam = Math.max(team1, Math.max(team2, team3));
            int minTeam = Math.min(team1, Math.min(team2, team3));
            result = Math.min(result, maxTeam-minTeam);
        }
        
        if (count1 != 2) {
            comb (depth+1, team1+ability[depth], team2, team3, count1+1, count2, count3);
        }
        if (count2 != 2) {
            comb (depth+1, team1, team2+ability[depth], team3, count1, count2+1, count3);
        }
        if (count3 != 2) {
            comb (depth+1, team1, team2, team3+ability[depth], count1, count2, count3+1);
        }
    }
}