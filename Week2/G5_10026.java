package Week2;
import java.util.*;
import java.io.*;
public class G5_10026 {
    static int[] dirRow = {-1, 0, 1, 0};
    static int[] dirCol = {0, 1, 0, -1};
    static void searchArea(char[][] picture, int n, int row, int col, boolean isColorBlind, boolean[][] isVisited){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {row, col});
        isVisited[row][col] = true;

        while(!q.isEmpty()){
            int[] curr = q.poll();
            int currRow = curr[0];
            int currCol = curr[1];
            for (int i = 0; i < 4; i++) {
                int nextRow = currRow + dirRow[i];
                int nextCol = currCol + dirCol[i];
                if(nextRow < 0 || nextCol < 0 || nextRow >= n || nextCol >= n)
                    continue;
                if(isVisited[nextRow][nextCol])
                    continue;

                if(isColorBlind){ //적록색약이면
                    if(picture[currRow][currCol] == 'R' && picture[nextRow][nextCol] == 'B')
                        continue;
                    if(picture[currRow][currCol] == 'G' && picture[nextRow][nextCol] == 'B')
                        continue;
                    if(picture[currRow][currCol] == 'B' && picture[nextRow][nextCol] != 'B')
                        continue;
                }
                else{ //적록색약이 아니면
                    if(picture[row][col] != picture[nextRow][nextCol])
                        continue;
                }

                q.add(new int[]{nextRow, nextCol});
                isVisited[nextRow][nextCol] = true;
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[][] picture = new char[n][n];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                picture[i][j] = line.charAt(j);
            }
        }

        boolean[][] isVisited = new boolean[n][n];
        int areaForNormal = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(isVisited[i][j])
                    continue;
                areaForNormal++;
                searchArea(picture, n, i, j, false, isVisited);
            }
        }

        for (int i = 0; i < n; i++) {
            Arrays.fill(isVisited[i], false);
        }

        int areaForColorBlind = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(isVisited[i][j])
                    continue;
                areaForColorBlind++;
                searchArea(picture, n,  i, j, true, isVisited);
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(areaForNormal + " " + areaForColorBlind);
        bw.flush();
    }
}
