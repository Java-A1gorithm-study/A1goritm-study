package Week2;

import java.awt.*;
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class S2_4963 {
    static int[] dirRow = {-1, -1, 0, 1, 1, 1, 0, -1}; // 대각선까지 8방향 탐색
    static int[] dirCol = {0, 1, 1, 1, 0, -1, -1, -1};
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static void searchIsland(int row, int col, int[][] map, int i, int j, boolean[][] isVisited){
        Queue<Point> q = new LinkedList<>(); // 새로 배운 Point 클래스 활용
        q.add(new Point(i, j)); //처음 시작 칸 큐에 넣기
        isVisited[i][j] = true; //방문처리

        while(!q.isEmpty()){
            Point curr = q.poll(); //poll은 fornt와 pop 연산 합친 것.
            int currRow = curr.x;
            int currCol = curr.y;

            for (int k = 0; k < 8; k++) {
                int nextRow = currRow + dirRow[k];
                int nextCol = currCol + dirCol[k];

                if(nextRow < 0 || nextCol < 0 || nextRow >= row || nextCol >= col) // 인덱스 검사
                    continue;
                if(map[nextRow][nextCol] == 0) // 바다이면 탐색 안 함
                    continue;
                if(isVisited[nextRow][nextCol]) // 땅인데 이미 방문한 거는 다시 탐색 안 함
                    continue;

                q.add(new Point(nextRow, nextCol)); // 큐에 넣고
                isVisited[nextRow][nextCol] = true; // 방문처리
            }
        }
    }

    public static void main(String[] args) throws  IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int col = Integer.parseInt(st.nextToken());
            int row = Integer.parseInt(st.nextToken());

            if(col == 0) // while문 탈출 조건
                break;

            int[][] map = new int[row][col]; // 지도 입력받기
            for (int i = 0; i < row; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < col; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            boolean[][] isVisited = new boolean[row][col]; // 방문 배열 만들기 매번 new 함.

            int result = 0; // 매번 result 0으로 초기화 함.
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if(map[i][j] == 1){
                        if(isVisited[i][j]) // 이거 꼭 하기
                            continue;
                        searchIsland(row, col, map, i, j, isVisited);
                        result++;
                    }
                }
            }
            bw.write(result + "\n");
        }

        bw.flush();

    }
}
