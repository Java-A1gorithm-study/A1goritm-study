package Week9;
import java.io.*;
import java.util.StringTokenizer;

public class G5_1240 {

    static class Node {
        int value;
        int dist;

        Node(int value, int dist) {
            this.value = value;
            this.dist = dist;
        }


    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 노드의 개수
        int testcase = Integer.parseInt(st.nextToken()); // 알고싶은 쌍의 개수

        //3 4 사이의 거리는 2 이렇게 주어지니까
        //이차원 배열로 해도 괜찮겠다고 생각듦
        //일단은 거리 찾는 건 방문처리하면서 bfs든 dfs든 탐색하면 될듯함
        //근데 1991번 풀었던 것처럼 해야하지 않나?



    }
}
