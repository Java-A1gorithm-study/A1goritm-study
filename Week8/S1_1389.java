package Week8;

import java.io.*;
import java.util.StringTokenizer;

public class S1_1389 {

    static final int INF = 987654321;

    /*
    * 무방향, 연결 그래프이다.
    * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int [][] matrix = new int[N+1][N+1]; // 입력값이 인덱스 값보다 1씩 크므로


        // 초기값 설정을 꼭 INF로 해줘야 하는지? 그냥 0으로 하면 안되나?
        // 최단 거리를 갱신해야하므로 초기화해줘야 한다.

        // 초기값 설정
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                matrix[i][j] = INF;

                if (i == j) {
                    matrix[i][j] = 0;
                }
            }
        }


        for(int i =0; i<M; i++){
            st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            //무방향 그래프이므로 양방향
            matrix[A][B] = 1;
            matrix[B][A] = 1;
        }

        // 플로이드 와샬 알고리즘
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    // 최단경로 초기화, 앞 문제 11403와 다른 부분임
                    if (matrix[i][j] > matrix[i][k] + matrix[k][j]) {
                        matrix[i][j] = matrix[i][k] + matrix[k][j];
                    }
                }
            }
        }

        int res = INF;
        int idx = -1;

        // 케빈 베이컨의 수가 가장 작은 인덱스를 탐색
        for (int i = 1; i <= N; i++) {
            int total = 0; // 케빈 베이컨의 수를 세는 변수
            for (int j = 1; j <= N; j++) {
                total += matrix [i][j];
            }

            if (res > total) {
                res = total;
                idx = i;
            }
        }

        bw.write(idx + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
