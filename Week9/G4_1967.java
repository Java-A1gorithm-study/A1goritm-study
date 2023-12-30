package Week9;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class G4_1967 {

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

        int n = Integer.parseInt(br.readLine());

        ArrayList<Node>[] tree = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());

            tree[start].add(new Node(end, dist));
            tree[end].add(new Node(start, dist));
        }

        int result = 0;

        for (int i = 1; i <= n; i++) {
            boolean[] isVisited = new boolean[n + 1];
            isVisited[i] = true;
            result = DFS(i, 0, result, tree, isVisited);
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(Integer.toString(result));
        bw.flush();
        br.close();
        bw.close();

    }

    static int DFS(int start, int dist, int result, ArrayList<Node>[] tree, boolean[] isVisited){
        for(Node node : tree[start]){
            if(isVisited[node.value])
                continue;
            isVisited[node.value] = true;
            result = DFS(node.value, dist + node.dist, result, tree, isVisited);
        }

        return result < dist ? dist : result;
    }
}
