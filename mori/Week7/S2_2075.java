package mori.Week7;

import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class S2_2075 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 표 크기 받기(가로=세로)
        int size = Integer.parseInt(br.readLine());

//        int[][] map = new int[size][size];
//        // 지도 입력
//        for(int i = 0; i < size; i++) {
//            StringTokenizer st = new StringTokenizer(br.readLine());
//            for(int j = 0; j < size; j++) {
//                map[i][j] = Integer.parseInt(st.nextToken());
//            }
//        }

        //문제는 표로 나왔지만 굳이 2차원 배열로 받을 필요가 없었다. 표의 조건을 이용하거나 좌표값을 출력하거나 하는 게 아니라서.
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder()); // 이러면 내림차순 정렬됨.
        for(int i = 0; i < size; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < size; j++) {
                priorityQueue.add(Integer.parseInt(st.nextToken()));
            }
        }

        //N번째 큰 수를 구하자
        while(size > 1) {
            priorityQueue.poll(); // N-1번째 큰 수까지 버리기.
            size--;
        }
        bw.write(priorityQueue.poll()+""); // poll()로 반환과 동시에 버리기.
        bw.flush();
        br.close();
        bw.close();
    }

}
