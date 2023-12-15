package Week3;

import java.util.Scanner;

public class Q2644 {
    static int Edge_arr[][]; // 간선 체크 배열, 즉 노드 간 연결이 되어 있는지 체크
    static boolean Node_arr[]; // 노드 체크 배열
    static int n; // 전체 사람의 수
    static int count = 0; // 두 사람의 촌수
    static int startPeople,endPeople; // 촌수를 계산해야 하는 두 사람
    static int x,y; // 부모 자식간의 관계를 나타내는 두 번호
    static int m; // 부모 자식들 간 관계의 개수
    public static void main(String [] args){
        Scanner scan = new Scanner(System.in);

        Edge_arr = new int[101][101];
        Node_arr = new boolean[101];

        n = scan.nextInt();
        startPeople = scan.nextInt();
        endPeople = scan.nextInt();
        m = scan.nextInt();

        for(int i =0; i<m; i++){ // 그래프 생성
            x = scan.nextInt();
            y = scan.nextInt();
            Edge_arr[x][y] = Edge_arr[y][x] = 1; // 노드 간 연결되어 있으면 1
        }

        DFS(startPeople);
        System.out.println(count);
    }

    public static void DFS(int start){
        Node_arr[start] = true; // 첫 노드 방문 처리

        if (start == endPeople) {
            return;
        }
        count++;

        for(int i=1; i<=n; i++) {
            if(Edge_arr[start][i] == 1 && Node_arr[i] == false) {
                DFS(i);
            }
        }

    }
}
