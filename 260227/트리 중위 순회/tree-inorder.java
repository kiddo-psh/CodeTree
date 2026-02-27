

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder output = new StringBuilder();
    static int MAX_N;
    static int K;
    static int[] bt;
    static int[] inorder;

    static void makeTree(int node, int idx, int len) {
        bt[node] = inorder[idx];
        if (len == 0) return;
        makeTree(node*2, idx-len, len/2);
        makeTree(node*2+1, idx+len, len/2);
    }

    static void printTree() {
        int target = 2;

        for (int i=1; i<=MAX_N; i++) {
            if (i == target) {output.append("\n"); target*=2;}
            output.append(bt[i]).append(" ");
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());
        MAX_N = (int)Math.pow(2, K) - 1;
        bt = new int[MAX_N + 1];
        inorder = new int[MAX_N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=1; i<=MAX_N; i++) {
            inorder[i] = Integer.parseInt(st.nextToken());
        }

        int mid = (MAX_N + 1) / 2;
        makeTree(1, mid, mid/2);
        printTree();

        System.out.println(output);
        br.close();
    }
}
