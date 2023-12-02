package Week2;

import java.awt.Point;
import java.util.LinkedList;
import java.util.Scanner;

public class Q10026 {
    //적록색약인 사람의 구역과 아닌 사람의 구역을 따로 구해줘야 함.
    //그래프, 연결 리스트 + 인접 행렬, Point 클래스
    // 인접 행렬보다 연결 리스트가 메모리 면에서는 더 효율적이다.
    // 인저 행렬은 모든 배열을 다 저장해야하지만, 연결 리스트는 배열 저장할 필요없이 뭐가 연결되어 있는지만 명시해주면 되기 때문이다.
    static int n;
    static char[][] normal; // 적록색약 X
    static char[][] unnormal; // 적록색약 O
    static int dx[] = {1,0,-1,0}; // 우, 좌를 확인할 때 필요함
    static int dy[] = {0,1,0,-1}; // 하, 상을 확인할 때 필요함
    static boolean[][] normal_visit;
    static boolean[][] unnormal_visit;

    public static void bfs(int x, int y, char g) {
        LinkedList<Point> queue = new LinkedList<Point>(); // 그래프를 연결 리스트로 구현
        normal_visit[x][y] = true;  // 현재 위치를 방문 처리
        queue.offer(new Point(x,y)); // queue에 좌표값을 넣음
        while(!queue.isEmpty()) {
            Point now = queue.poll(); // dequeue한 값을 현재 위치로
            for(int i = 0; i < 4; i++) { // 상,하,좌,우 탐색하는 반복문
                int nx = now.x + dx[i]; 
                int ny = now.y + dy[i];
                if(nx >= 0 && nx < n && ny >= 0 && ny < n) { // 범위를 벗어나지 않기 위한 if문
                    if(normal_visit[nx][ny] == false && normal[nx][ny] == g) {// 현재 위치를 방문하지 않았고
                        bfs(nx,ny, normal[nx][ny]);
                    }
                }
            }
        }
    }

    public static void bfs2(int x, int y, char g) {
        LinkedList<Point> queue = new LinkedList<Point>();
        unnormal_visit[x][y] = true;
        queue.offer(new Point(x,y));
        while(!queue.isEmpty()) {
            Point now = queue.poll();
            for(int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if(nx >= 0 && nx < n && ny >= 0 && ny < n) {
                    if(unnormal_visit[nx][ny] == false && unnormal[nx][ny] == g) {
                        bfs2(nx,ny, unnormal[nx][ny]);
                    }
                }
            }
        }
    }


    public static void main(String [] args) {
        Scanner scan = new Scanner(System.in);

        n = scan.nextInt();
        normal = new char[n][n];
        unnormal = new char[n][n];
        normal_visit = new boolean[n][n];
        unnormal_visit = new boolean[n][n];

        for (int i = 0; i < n; i++) { // R,G,B 입력받기
            String input = scan.next();
            for (int j = 0; j < input.length(); j++) {
                normal[i][j] = input.charAt(j);
                unnormal[i][j] = input.charAt(j);
                if(unnormal[i][j] == 'G') // 적록색약이면 G를 R 로 바꿔줌
                    unnormal[i][j] = 'R';
            }
        }

        int count = 0; // 적록색약이 아닌 사람의 구역의 수
        int count2 = 0; // 적록색약인 사람의 구역의 수

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(normal_visit[i][j] == false) {
                    bfs(i,j,normal[i][j]);
                    count++;
                }
                if(unnormal_visit[i][j] == false) {
                    bfs2(i,j,unnormal[i][j]);
                    count2++;
                }
            }
        }
        System.out.println(count + " " + count2);


    }

}
