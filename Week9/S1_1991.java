package Week9;

import java.io.*;
import java.util.StringTokenizer;

public class S1_1991 {

    static Node head = new Node('A', null, null);

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


    public static void addNode(Node temp, char root, char left, char right) {


        if (temp.value == root) { // .을 입력받아 빈 노드로 만드는 과정
            temp.left = (left == '.' ? null : new Node(left,null,null));
            temp.right = (right == '.' ? null : new Node(right,null,null));
        }
        else {
            if(temp.left != null) addNode(temp.left, root, left, right);
            if(temp.right != null) addNode(temp.right, root, left, right);
        }
    }

    public static void preOrder(Node node) {
        if(node ==null) return;
        System.out.print(node.value);
        preOrder(node.left);
        preOrder(node.right);
    }

    public static void inOrder(Node node) {
        if(node ==null) return;
        inOrder(node.left);
        System.out.print(node.value);
        inOrder(node.right);
    }

    public static void postOrder(Node node) {
        if(node ==null) return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.value);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            char root = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            addNode(head, root,left,right);
        }

        preOrder(head);
        System.out.println();
        inOrder(head);
        System.out.println();
        postOrder(head);
        System.out.println();
    }


}
