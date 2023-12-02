package Week2;

import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Q4963 {
    static int w;
    static int h;
    static int[][] arr;
    static boolean[][] visited ;
    static int dx[] = {1,1,0,-1, -1,-1,0,1}; // 우,우상, 상, 좌상, 좌, 좌하, 하, 우하를 확인
    static int dy[] = {0,-1,-1,-1, 0,1,1,1};

    public static void bfs(int x, int y) {
        LinkedList<Point> queue = new LinkedList<>(); // 그래프를 연결 리스트로 구현
        visited[x][y] = true;  // 현재 위치를 방문 처리
        queue.offer(new Point(x,y)); // queue에 좌표값을 넣음

        while(!queue.isEmpty()) {
            Point now = queue.poll();
            for(int i = 0; i < 8; i++) {
                int nextX = now.x + dx[i];
                int nextY = now.y + dy[i];

                if(nextX >= 0 && nextX < w && nextY >= 0 && nextY < h) continue; // map 영역을 벗어나지 않도록
                if(visited[nextX][nextY] == false) continue; // 방문했다면 continue
                if(arr[nextX][nextY] == 0) continue; // 바다인지

                queue.add(new Point(nextX,nextY));
                visited[nextX][nextY] = true;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList <Integer> result = new ArrayList<>(); // 정답을 저장할 배열

        while(true){
            w = scan.nextInt();
            h = scan.nextInt();

            if(w ==0 && h == 0) break;
            arr = new int[h][w];
            visited = new boolean[h][w];

            for (int i = 0; i < h; i++) { // map 입력
                for (int j = 0; j < w; j++) {
                    arr[i][j] = scan.nextInt();
                }
            }

            int count =0; // 섬의 개수 count
            for(int i=0; i<h; i++){
                for(int j=0; j<w; j++){
                    if(arr[i][j] == 1){
                        if(visited[i][j])  continue;
                        bfs(i,j);
                        count++;
                    }
                }
            }

            System.out.println(count);
        }
    }
}
