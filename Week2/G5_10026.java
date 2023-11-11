package Week2;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class G5_10026 {
    //구조체 하나 만들어줌. 큐에 넣기 위한
    //여기서 y와 x의 위치를 반대로 한 것은 배열의 구조를 쉽게 보기 위함
    //자기가 편한대로 하면 돼용
    static class Pair {
        int y, x;
        public Pair(int y, int x) {
            this.y = y;
            this.x = x;
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 4방향 이동 상하좌우, 좌우상하 다 상관 없음
        int dy[] = {-1,1,0,0};
        int dx[] = {0,0,1,-1};

        //주어진 지도, 방문 처리
        char [][] adj = new char[104][104]; // RGB 받을거라 char 형으로
        int [][] visited = new int[104][104]; //정상용 방문처리
        int [][] visited$ = new int[104][104]; //색약용 방문처리

        //C에서 했던 배열 하나하나를 0으로 초기화 해주는 작업을 안해도 되는 이유는 자바의 구조를 이해해볼 것
        //힙에 2차원 배열이 생길 때, 원래 0으로 자동 초기화된다는 점


        //bfs를 위한 큐
        Queue<Pair> q = new LinkedList<Pair>();


        // bfs를 위한 세팅 끗
        // --
        // --

        int n = sc.nextInt(); // 지도 크기 n

        // 지도 입력
        for(int i = 0; i<n; i++) {
            String s = sc.next();
            for(int j = 0; j<n; j++) {
                if(s.charAt(j) == 'R') adj[i][j] = 'R';
                else if(s.charAt(j) == 'G') adj[i][j] = 'G';
                else if(s.charAt(j) == 'B') adj[i][j] = 'B';
            }
        }

        //정상인 사람이 보는 관점에서의 bfs

        int area = 0; // 정상적인 사람이 보는 색깔 구역 개수

        for(int i = 0; i<n; i++) {
            for(int j = 0; j<n; j++) {
                if(visited[i][j] == 0) { // 방문하지 않았다면
                    visited[i][j] = 1; // 시작점을 방문처리
                    char standard = adj[i][j]; // 기준을 정하기
                    area++; // 색깔 구역 개수 ++
                    q.add(new Pair(i, j)); //큐에 넣기. Pair 형식
                    //왜 시작점을 큐에 넣었냐? 아래에 적어놓기
                    // ->
                    while(!q.isEmpty()) {
                        Pair pi = q.poll(); // 큐 맨 앞에 있는 거 꺼내서 저장 후 pop
                        int y = pi.y; // 편하게 보기
                        int x = pi.x;

                        for(int w=0; w<4; w++) {
                            int ny = y + dy[w];
                            int nx = x + dx[w];

                            //맵을 벗어난 경우, 탐색할 가치가 없는 경우, 이미 방문한 경우를 확인
                            if(ny>=n || ny<0 || nx>=n || nx<0 ) continue;
                            //여기서 탐색할 가치가 없다 함은 standard랑 값이 다른 경우
                            if(adj[ny][nx] != standard) continue;
                            if(visited[ny][nx] == 1) continue;

                            visited[ny][nx] = 1;
                            q.add(new Pair(ny, nx));
                        }
                    }
                }

            }
        }
        System.out.print(area+" ");

        //색약인 사람이 보는 관점에서의 bfs

        area = 0; // 색약인 사람이 보는 색깔 구역 개수

        for(int i = 0; i<n; i++) {
            for(int j = 0; j<n; j++) {
                if(visited$[i][j] == 0) { // 방문하지 않았다면
                    visited$[i][j] = 1; // 시작점을 방문처리
                    area++; // 색깔 구역 개수 ++
                    q.add(new Pair(i, j)); //큐에 넣기. Pair 형식
                    //왜 시작점을 큐에 넣었냐? 아래에 적어놓기
                    // ->
                    while(!q.isEmpty()) {
                        Pair pi = q.poll(); // 큐 맨 앞에 있는 거 꺼내서 저장 후 pop
                        int y = pi.y; // 편하게 보기
                        int x = pi.x;

                        for(int w=0; w<4; w++) {
                            int ny = y + dy[w];
                            int nx = x + dx[w];

                            //맵을 벗어난 경우, 탐색할 가치가 없는 경우, 이미 방문한 경우를 확인
                            if(ny>=n || ny<0 || nx>=n || nx<0 ) continue;
                            //여기선 기준 정해주진 않았으니까, 로직을 새롭게
                            if(adj[y][x] == 'B') {
                                if(adj[ny][nx] != 'B') continue;
                            } else {
                                if(adj[ny][nx]== 'B') continue;
                            }
                            if(visited$[ny][nx] == 1) continue;

                            visited$[ny][nx] = 1;
                            q.add(new Pair(ny, nx));
                        }
                    }
                }

            }
        }
        System.out.print(area);
    }
}
