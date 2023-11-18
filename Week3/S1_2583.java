package Week3;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class S1_2583 {
    // 칸을 셀 때 왼쪽 아래 꼭짓점을 기준으로 삼음.
    // 좌표를 2차원 배열의 인덱스로 바꾸는 과정이 필요함.
    static int[] dirRow = {-1, 0, 1, 0};
    static int[] dirCol = {0, 1, 0, -1};

    static int DFS(int[][] map, int row, int col, boolean[][] isVisited, int currRow, int currCol, int count){
        isVisited[currRow][currCol] = true;

        for (int i = 0; i < 4; i++) {
            int nextRow = currRow + dirRow[i];
            int nextCol = currCol + dirCol[i];

            if(nextRow < 0 || nextCol < 0 || nextRow >= row || nextCol >= col)
                continue;
            if(isVisited[nextRow][nextCol])
                continue;
            if(map[nextRow][nextCol] == 1)
                continue;
            count = DFS(map, row, col, isVisited, nextRow, nextCol, count + 1);
        }

        return count;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] map = new int[row][col];

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            //왼쪽 아래 꼭짓점은 칸의 기준이 됨.
            int leftCol = Integer.parseInt(st.nextToken());
            int leftRow = row - Integer.parseInt(st.nextToken()) - 1;
            //오른쪽 위 꼭짓점은 기준 조정 필요.
            int rightCol = Integer.parseInt(st.nextToken()) - 1;
            int rightRow = row - Integer.parseInt(st.nextToken());

            for (int j = rightRow; j <= leftRow; j++) {
                for (int l = leftCol; l <= rightCol; l++) {
                    map[j][l] = 1;
                }
            }
        }

        boolean[][] isVisited = new boolean[row][col];

        ArrayList<Integer> area = new ArrayList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(map[i][j] == 0 && !isVisited[i][j]){
                    int count = DFS(map, row, col, isVisited, i, j, 1);
                    area.add(count);
                }
            }
        }

        Collections.sort(area);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int size = area.size();
        bw.write(size + "\n");
        for (int i = 0; i < size; i++) {
            bw.write(area.get(i) + " ");
        }
        bw.flush();
    }
}
