package Week2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class S2_4963 {

    static class Pair {
        int y, x;
        public Pair(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        //상하좌우 대각선탐색
        int[] dy = {-1,1,0,0,-1,-1,1,1};
        int[] dx = {0,0,1,-1,-1,1,-1,1};


        //bfs를 위한 큐
        Queue<Pair> q = new LinkedList<Pair>();


        while(true) {
            int w = sc.nextInt();
            int h = sc.nextInt();
            if(w == 0 && h == 0) break; // 탈출 조건 0 0 을 읽었을 때
            int[][] adj = new int[h][w];
            int [][] visited = new int[h][w];

            int count = 0; // 섬 개수 세기, 매번 초기화
            //지도 입력
            for(int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    adj[i][j] = sc.nextInt();
                }
            }
            for(int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if(visited[i][j] == 0 && adj[i][j] == 1) {
                        visited[i][j] = 1;
                        count++;
                        q.add(new Pair(j, i));

                        while (!q.isEmpty()) {
                            Pair pi = q.poll(); // 큐 맨 앞에 있는 거 꺼내서 저장 후 pop
                            int y = pi.y; // 편하게 보기
                            int x = pi.x;

                            for (int p = 0; p < 8; p++) {
                                int ny = y + dy[p];
                                int nx = x + dx[p];

                                //맵을 벗어난 경우, 탐색할 가치가 없는 경우, 이미 방문한 경우를 확인
                                if (ny >= h || ny < 0 || nx >= w || nx < 0) continue;
                                if (adj[ny][nx] == 0) continue;
                                if (visited[ny][nx] == 1) continue;

                                visited[ny][nx] = 1;
                                q.add(new Pair(ny, nx));

                            }

                        }
                    }
                }
            }
            System.out.println(count);
            }
        }
    }
