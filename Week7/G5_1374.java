package Week7;

import java.util.*;
import java.io.*;
public class G5_1374 {
    static class ClassTime implements Comparable<ClassTime>{
        int classNumber;
        int start;
        int end;

        ClassTime(int classNumber, int start, int end){
            this.classNumber = classNumber;
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(ClassTime that){ //시작시간, 종료시간 순으로
            if(this.start == that.start)
                return this.end - that.end;
            return this.start - that.start;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;

        ArrayList<ClassTime> classes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int classNumber = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            classes.add(new ClassTime(classNumber, start, end));
        }

        Collections.sort(classes); //시작과 종료가 빠른 순으로 정렬

        PriorityQueue<Integer> pq = new PriorityQueue<>(); // ClasTime으로 선언하면 안돼.

        int max = 0;

        for (int i = 0; i < n; i++) {
            while(!pq.isEmpty() && pq.peek() <= classes.get(i).start)
                pq.poll();
            pq.add(classes.get(i).end);
            max = Math.max(max, pq.size());
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(Integer.toString(max));
        bw.flush();
        br.close();
        bw.close();
    }
}
