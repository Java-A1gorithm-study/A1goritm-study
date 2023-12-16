package Week7;

import java.util.*;
import java.io.*;
public class S1_11286 {
    static class Number implements Comparable<Number>{
        long absoluteValue;
        int sign;

        Number(long absoluteValue, int sign){
            this.absoluteValue = absoluteValue;
            this.sign = sign;
        }

        long getRealValue(){ // 부호까지 고려한 진짜 값 출력하는 메소드
            return (absoluteValue * sign);
        }

        @Override
        public int compareTo(Number that) { //힙 정렬시 사용할 정렬 기준을 다시 만듦
            if(this.absoluteValue == that.absoluteValue)
                return((int)(this.getRealValue() - that.getRealValue()));
            return((int)(this.absoluteValue - that.absoluteValue));
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Number> minHeap = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            long curr = Long.parseLong(br.readLine());
            if(curr == 0){
                if(minHeap.isEmpty()){ // 힙 비어있으며 0 출력하라고 해서 처리한 부분
                    bw.write(0 + "\n");
                    bw.flush();
                }
                else{
                    long result = minHeap.poll().getRealValue();
                    bw.write(result + "\n");
                    bw.flush();
                }
            }
            else{
                int sign = curr > 0 ? 1 : -1;
                minHeap.offer(new Number(Math.abs(curr), sign));
            }
        }
    }
}

