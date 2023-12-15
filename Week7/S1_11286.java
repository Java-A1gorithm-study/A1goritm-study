package Week7;

import java.io.*;
import java.util.PriorityQueue;

public class S1_11286 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int repeat = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((o1, o2) ->
                Math.abs(o1) == Math.abs(o2) ? Integer.compare(o1, o2) : Integer.compare(Math.abs(o1), Math.abs(o2))); // 아무것도 지정하지 않으면 오름차순, 여기에 정렬 기준 추가해주면 된다. Comparator 인터페이스 이용
        while(repeat > 0) {
            int num = Integer.parseInt(br.readLine());
            if(num == 0) { // 조건 분기 1. 입력이 0이라면
                if(priorityQueue.isEmpty()) { // 큐 비어있으면
                    bw.write(0+"\n");
                } else {
                    bw.write(priorityQueue.poll()+"\n"); // 첫번째 값 반환과 동시에 제거
                }
            } else { // 조건 분기 2. 값이 들어오면
                priorityQueue.add(num); // 값 넣기
            }
            repeat--;
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
