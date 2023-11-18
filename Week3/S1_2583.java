package Week3;

import java.util.*;

public class S1_2583 {

    //아이디어
    //기존에는 탐색을 하라고 맵에 대한 정보를 칸마다 줬다면, 이번엔 영역
    //끝점과 끝점을 줬으니 그 안에 있는 영역을 돌면서 다 방문처리
    //탐색하지 않는 주어지는 직사각형의 영역은 겹칠 수 있다. 그러니 가중치는 1까지만 주기
    //좌표의 기준이 좌측 하단이 0,0이지만 상관은 없다. 어쩌피 우리는 좌표의 값에 따라
    //탐색을 순차적으로 해야 하는게 아니니까. 그렇게 되면 위쪽으로 한번 뒤집은 모양이 될거다



    //원래 int 배열로 받았는데
    //boolean으로 하는게 메모리적으로 효율적이라고 해서
    static boolean[][] adj;

    //영역 넓이 구해야 하니까
    static int count;

    //이건 dfs()에서 사용하기 위해 정적 변수로 빼줬음
    static int m, n;



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //지도 크기 입력
        m = sc.nextInt();
        n = sc.nextInt();

        //계속 가로 세로 헷갈려서 이렇게 만들었다.
        adj = new boolean[m][n];


        /*
        참고로 이차원 배열에서 [m][n]는
        x   x   x   x
        x   x   x   x
        x   x   x   x
        [3][4]인거다. 세로가 m 가로가 n인거임
        */

        //직사각형의 개수 k개
        int k = sc.nextInt();

        //int라면 알아서 0으로 초기화해주지만 boolean은 그렇지 않음
        //이렇게 생각해보면 번거로움 거치면서 굳이 boolean 써야하나..?
        for (boolean[] row1 : adj) {
            Arrays.fill(row1, false);
        }



        //지도 입력 시작. 직사각형의 개수만큼 반복
        for(int i = 0; i<k; i++) {
//            Pair xy1 = new Pair(sc.nextInt(), sc.nextInt());
//            Pair xy2 = new Pair(sc.nextInt(), sc.nextInt());
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();
            //직사각형 좌표 만큼
            for(int x = x1; x < x2; x++) {
                for(int y = y1; y < y2; y++) {
                    adj[y][x] = true;
                }
            }
        }


        //어쩌피 오름차순 정렬해야하기도 하고 arrays sort 보단
        //collections sort가 최악의 경우에 시간복잡도가 좋다고 하니,
        //array를 만들어도 되지만 그냥 list에 count 저장해놓고 쓴단 마인드.
        ArrayList<Integer> list = new ArrayList<>();

        //생각해야한다.
        //i는 뭐지? j는 뭐지?
        //visited 배열에서 입력받은 m, n이 순서대로 i, j니까 맞다.
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(!adj[i][j]) {
                    count = 0; // 매번 재귀함수 돌기 전 count는 초기화
                    dfs(i, j);
                    list.add(count);
                }
            }
        }
        //반복문이 끝나면, 오름차순 정렬 후 출력
        Collections.sort(list);

        //ArrayList의 출력방법은 여러가지가 있지만,
        //list.size()와 for-each문을 사용해보려고 한다

        //1. 영역 개수 출력
        System.out.println(list.size());
        //2. 각 영역의 넓이를 오름차순 출력
        for(int a : list) {
            System.out.print(a+" ");
        }
    }

    //dfs 재귀함수 로직
    static void dfs(int y, int x) {
        adj[y][x] = true;

        //상하좌우 탐색을 위한
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        //넓이 세기
        count++;

        for(int p = 0; p < 4; p++) {
            int nx = x + dx[p];
            int ny = y + dy[p];

            // dfs에 붙는 조건문
            //생각해야 한다. 여기서 nx, ny는 뭐지?
            // 배열에서의 m은 세로다. n은 가로다.
            // 예제를 보면 5 x 7 모눈 종이에 직사각형의 좌표가 (6,2) 이렇게 주어졌다.
            // 사실상 모눈 종이 기준으로 보면 x가 가로, y가 세로지만
            // 우리가 배열을 입력받고 생성하는 건 세로, 가로니까 헷갈릴 수 있다.
            // 따라서 이건 이제 y랑 x 위치를 바꿔주면 해결된다.
            // 좌표를 입력받을 때 반대로 했던 것도 이걸 위함이다.
            if(nx>=0 && nx < n && ny>=0 && ny < m) {
                if(!adj[ny][nx]) {
                    dfs(ny, nx);
                }
            }

        }
    }
}

