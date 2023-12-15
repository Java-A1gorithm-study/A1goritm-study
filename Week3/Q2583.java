package Week3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Q2583 {
    static int M,N,K;
    static int[][] arr;
    static boolean[][] visited;
    static int count; // 영역의 넓이
    static int nowX, nowY;



    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>(); // 영역의 넓이 저장

        M = scan.nextInt();
        N = scan.nextInt();
        K = scan.nextInt();

        arr = new int[M][N]; // 선언과 동시에 0으로 초기화
        visited = new boolean[M][N];

        for(int i=0; i<K; i++){ // 직사각형 개수만큼 반복
            int x1 = scan.nextInt();
            int y1 = scan.nextInt();
            int x2 = scan.nextInt();
            int y2 = scan.nextInt();

            for(int y= y1; y< y2; y++){ // 직사각형 칠하기, 이렇게 입력받으면 상하반전이 일어나는데 영역 개수, 넓이는 같음
                for(int x=x1; x<x2; x++){
                    arr[y][x] = 1;
                }
            }
        }
        // 배열 확인용
        for(int i=0; i<M; i++){
            for(int j=0; j<N; j++){
                System.out.print(arr[i][j]);
            }
            System.out.println();

        }

        for(int i=0; i<M; i++) { // 여기를 N으로 해줘서 ArrayIndexOutOfBoundsException 에러가 발생함
            for(int j=0; j<N; j++) {

                if(visited[i][j] == false && arr[i][j] == 0) {
                    count = 1;
                    DFS(i, j);
                    list.add(count);
                }

            }
        }

        Collections.sort(list);
        System.out.println(list.size());
        for(int num : list) {
            System.out.println(num);
        }


        // 배열 확인용
        for(int i=0; i<M; i++){
            for(int j=0; j<N; j++){
                System.out.print(arr[i][j]);
            }
            System.out.println();

        }

     }

    static void DFS(int y, int x) {
       visited[y][x] = true;
        arr[y][x] = 1;

        int[] dirX = {0,0,-1,1};
        int[] dirY = {-1,1,0,0};

        for(int i=0; i<4; i++) {// for문을 돌면서 상 > 하 > 좌 > 우 순으로 주변 탐색
            nowX = dirX[i] + x;
            nowY = dirY[i] + y;

            if( Range_check() && visited[nowY][nowX] == false && arr[nowY][nowX] == 0) {
                visited[nowY][nowX] = true;
                arr[nowY][nowX] = 1;
                count++;
                DFS(nowY, nowX);
            }
        }
    }

    static boolean Range_check() { // 단지의 범위를 체크하는 메소드
        return (nowX >= 0 && nowX < N && nowY >= 0 && nowY < M);
    }

}
