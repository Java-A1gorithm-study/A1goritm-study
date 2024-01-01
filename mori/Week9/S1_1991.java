package mori.Week9;
import java.io.*;
import java.util.StringTokenizer;

public class S1_1991 {
    static class Node {
        char value;
        Node left;
        Node right;

        Node(char value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    static void preOrder(Node node) { // 전위 부모 -> 왼쪽 -> 오른쪽
        if(node == null)
            return;
        System.out.print(node.value); // 부모
        preOrder(node.left); // 왼쪽
        preOrder(node.right); // 오른쪽
    }

    static void inOrder(Node node) { // 중위 왼쪽 -> 부모 -> 오른쪽
        if(node == null)
            return;
        inOrder(node.left); // 왼쪽
        System.out.print(node.value); // 부모
        inOrder(node.right); // 오른쪽
    }

    static void postOrder(Node node) { // 후위 왼쪽 -> 오른쪽 -> 부모
        if(node == null)
            return;
        postOrder(node.left); // 왼쪽
        postOrder(node.right); // 오른쪽
        System.out.print(node.value); // 부모
    }

    static void insertNode(Node head, char parent, char left, char right) {
        if(head.value == parent) {
            if(left == '.')
                head.left = null;
            else
                head.left = new Node(left, null, null);
            if(right == '.')
                head.right = null;
            else
                head.right = new Node(right, null, null);

        } else {
            if(head.left != null)
                insertNode(head.left, parent, left, right);
            if(head.right != null)
                insertNode(head.right, parent, left, right);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int level = Integer.parseInt(br.readLine());

        Node head = new Node('A', null, null);

        for(int i = 0; i < level; i++) {
            st = new StringTokenizer(br.readLine());
            char parent = st.nextToken().charAt(0);
            char childLeft = st.nextToken().charAt(0);
            char childRight = st.nextToken().charAt(0);

            insertNode(head, parent, childLeft, childRight);
        }

        preOrder(head);
        System.out.println();
        inOrder(head);
        System.out.println();
        postOrder(head);
        System.out.println();
    }
}
