package Week9;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class G5_1240 {

    static class Node{
        int value;
        int dist;

        Node(int value, int dist){
            this.value = value;
            this.dist = dist;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ArrayList<Node>[] tree = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());

            tree[start].add(new Node(end, dist));
            tree[end].add(new Node(start, dist));
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            int result = getDist(start, end, n, tree);
            bw.write(result + "\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }

    static int getDist(int start, int end, int n, ArrayList<Node>[] tree){
        boolean[] isVisited = new boolean[n + 1];

        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(start, 0));
        isVisited[start] = true;

        int dist = 0;
        while(!q.isEmpty()) {
            Node curr = q.poll();
            if (curr.value == end) {
                dist = curr.dist;
                break;
            }

            for (Node temp : tree[curr.value]) {
                if(isVisited[temp.value])
                    continue;
                q.offer(new Node(temp.value, curr.dist + temp.dist));
                isVisited[temp.value] = true;
            }
        }

        return dist;
    }
}
