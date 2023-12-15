package Week6;

import java.io.*;
import java.util.PriorityQueue;
import java.util.Collections;

public class S1_11286 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int repeat = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(); // 아무것도 지정하지 않으면 오름차순
        while(repeat > 0) {
            int num = Integer.parseInt(br.readLine());
            if(num == 0) { // 조건 분기 1. 입력이 0이라면
                if(priorityQueue.peek() != null) { // 첫번째 값 반환했는데 없으면
                    bw.write(0+"\n");
                } else {
                    int value = priorityQueue.poll(); // 첫번째 값 반환과 동시에 제거
                    bw.write(value+"\n");
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
