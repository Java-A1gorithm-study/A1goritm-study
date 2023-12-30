package Week9;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class S1_1991 {

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static class Node{
        char value;
        Node left;
        Node right;

        Node(char value, Node left, Node right){
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Node head = new Node('A', null, null);

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            char curr = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            insertNode(head, curr, left, right);
        }

        preOrder(head);
        bw.write("\n");
        inOrder(head);
        bw.write("\n");
        postOrder(head);

        bw.flush();
        br.close();
        bw.close();
    }

    public static void insertNode(Node head, char curr, char left, char right){
        if (head.value == curr) {
            head.left = (left == '.' ? null : new Node(left,null,null));
            head.right = (right == '.' ? null : new Node(right,null,null));
        }
        else {
            if(head.left != null) insertNode(head.left, curr, left, right);
            if(head.right != null) insertNode(head.right, curr, left, right);
        }
    }

    public static void preOrder(Node node) throws IOException{
        if(node ==null)
            return;

        bw.write(node.value);
        preOrder(node.left);
        preOrder(node.right);
    }

    public static void inOrder(Node node) throws IOException{
        if(node ==null)
            return;

        inOrder(node.left);
        bw.write(node.value);
        inOrder(node.right);
    }

    public static void postOrder(Node node) throws IOException{
        if(node ==null)
            return;

        postOrder(node.left);
        postOrder(node.right);
        bw.write(node.value);
    }

}
