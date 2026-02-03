import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] ability = new int[6];
        int sum = 0;
        for (int i = 0; i < 6; i++) {
            ability[i] = sc.nextInt();
            sum += ability[i];
        }

        int answer = Integer.MAX_VALUE;
        for (int i=0; i<4; i++) {
            for (int j=i+1; j<5; j++) {
                for (int k=j+1; k<6; k++) {
                    int team1 = ability[i] + ability[j] + ability[k];
                    int team2 = sum - team1;
                    answer = Math.min(answer, Math.abs(team1-team2));
                }
            }
        }
        System.out.println(answer);
        // Please write your code here.
    }
}