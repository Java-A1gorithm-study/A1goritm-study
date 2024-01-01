package mori.Week8;
import java.io.*;
import java.util.StringTokenizer;

//11403보다 플로이드 와샬 알고리즘에 더 적합한 문제라는 생각이 든다.
//하지만 차이점이라면 방향 그래프가 아니라는 점이다.
public class S1_1389 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N+1][N+1]; // 인덱스를 편하게 1부터 하려고. 0은 비어있을 것.

        int count = 0;

        for(int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                map[i][j] = 500000000; // 5억 정도면 infinte 느낌일듯?

                if(i == j) {
                    map[i][j] = 0; // 동일 인물간의 관계는 0이다.
                }
            }

        }

        while(count < M) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st2.nextToken());
            int b = Integer.parseInt(st2.nextToken());
            map[a][b] = 1;
            map[b][a] = 1; // 방향성이 없다. 따라서 둘 다 1로 바꿔줘야 함.
            count++;
        }





        // 배열 확인용
//        for(int i = 1; i <= N; i++) {
//            for (int j = 1; j <= N; j++) {
//                bw.write(map[i][j] + " ");
//            }
//            bw.write("\n");
//        }

        for(int mid = 1; mid <= N; mid++) {
            for(int start = 1; start <= N; start++) {
                for(int end = 1; end <= N; end++) {
                    if(map[start][end] > map[start][mid] + map[mid][end]) {
                        map[start][end] = map[start][mid] + map[mid][end];
                    }
                }
            }
        }
        int max = 500000000; // 가질 수 없는 큰 값 하나 지정
        int index = 0;

        //사람마다 케빈 베이컨 수를 구하기
        for(int i = 1; i <= N; i++) {
            int total = 0;
            for(int j =1; j <= N; j++) {
                total += map[i][j];
            }
            if(max > total) {
                max = total;
                index = i;
            }
        }
        bw.write(index+"\n");
        bw.flush();
        br.close();
        bw.close();
    }
}
