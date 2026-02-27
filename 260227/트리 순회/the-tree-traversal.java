
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder output = new StringBuilder();
    static int N;
    static Node[] adj;
    static class Node {
        char val;
        Node left, right;
        public Node(char val){this.val = val;}
        public void setLeft(Node left) {this.left = left;}
        public void setRight(Node right) {this.right = right;}
    }

    static void preorder(Node node) {
        if (node.left != null) preorder(node.left);
        output.append(node.val);
        if (node.right != null) preorder(node.right);
    }

    static void inorder(Node node) {
        output.append(node.val);
        if (node.left != null) inorder(node.left);
        if (node.right != null) inorder(node.right);
    }

    static void postorder(Node node) {
        if (node.left != null) postorder(node.left);
        if (node.right != null) postorder(node.right);
        output.append(node.val);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        adj = new Node[N+1];

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            char p = st.nextToken().charAt(0);
            char l = st.nextToken().charAt(0);
            char r = st.nextToken().charAt(0);

            if (adj[p-'A'] == null) adj[p-'A'] = new Node(p);
            if (l != '.') {
                adj[l - 'A'] = new Node(l);
                adj[p - 'A'].setLeft(adj[l - 'A']);
            }
            if (r != '.') {
                adj[r - 'A'] = new Node(r);
                adj[p - 'A'].setRight(adj[r - 'A']);
            }
        }

        Node ROOT = adj[0];
        inorder(ROOT); output.append("\n");
        preorder(ROOT); output.append("\n");
        postorder(ROOT);

        System.out.println(output);
    }
}
