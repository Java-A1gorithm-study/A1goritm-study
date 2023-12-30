package Week8;

import java.io.*;
import java.util.StringTokenizer;

public class S1_11403 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[][] matrix = new int[N][N];

        for(int i=0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine()); //이게 여기 있어야 오류가 안남
            for(int j=0; j <N; j++){
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 플로이드 와샹 알고리즘
        // 참고 링크 1: https://m.blog.naver.com/PostView.nhn?blogId=ndb796&logNo=221234427842&proxyReferer=https:%2F%2Fwww.google.com%2F
        // 참고 링크 2: https://steady-coding.tistory.com/94
        // i에서 j까지 갈 수 있는가?
        // i에서 k로 가고, k에서 j로 갈 수 있는가?
        // 위에 2개의 질문은 동일함.
        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    // 단순히 갈 수 있는 경로가 있는지만 체크함.
                    if (matrix[i][k] == 1 && matrix[k][j] == 1) {
                        matrix[i][j] = 1;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++){
            for(int j =0; j<N; j++){
                sb.append(matrix[i][j] + " ");
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
