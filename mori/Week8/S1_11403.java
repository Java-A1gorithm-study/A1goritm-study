package mori.Week8;
import java.io.*;
import java.util.StringTokenizer;

public class S1_11403 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[][] graph = new int[N][N];

         //입력받음.
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //당연히 기존에 1이었던 곳은 그대로 1일것이다.
        //a에서 c로 바로 가는 간선은 없지만 a에서 b로 가는 간선이 있고 b에서 c로 가는 간선이 있으면 a에서 c로 갈 수 있다.
        //이 아이디어를 사용한다.
        for(int mid = 0; mid < N; mid++) {
            for(int start = 0; start < N; start++) {
                for(int end = 0; end < N; end++) {
                    if(graph[start][mid] == 1 && graph[mid][end] == 1) {
                        graph[start][end] = 1;
                    }
                }
            }
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                bw.write(graph[i][j]+" ");
            }
            bw.write("\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
