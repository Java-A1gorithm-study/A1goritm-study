package Week7;

import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//강의 번호, 강의 시작 시간, 강의 종료 시간
//강의 번호는 순서대로 주어지진 않지만, 유일하다.
// 강의 시간의 범위가 0 ~ 10억이니까 long으로 잡는 것도 좋아보임.
        /* 알고리즘 공부할 때 배웠던 Scheduling Classes 관련 내용
        보통 생각나는 Greedy한 Choice는 4가지가 있을 것이다.
        1. 시작 시간이 가장 이른 class를 먼저 선택
        2. 길이(종료 시간 - 시작 시간)이 짧은 class를 먼저 선택
        3. 서로 겹치는 class 개수가 가장 적은 것을 먼저 선택
        4. 종료 시간이 이른 class 부터 선택
        해보면서 그 시점에서 최선인 것 같은 것을 선택하면 됨.
        반례를 생각해봤을 때 best choice는 4번이었다.
       이 문제의 경우에도 이와 비슷하게 생각할 수 있을 거 같다.
         */
public class G5_1374 {
    static class Pair implements Comparable<Pair> {
        int start, end;
        public Pair(int start, int end) {
            this.start = start;
            this.end = end;
        }

        //
        public int compareTo(Pair pair) {
            return Integer.compare(this.end, pair.end); // c값, 즉 끝나는 시간을 기준으로 정렬
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Pair[] lecture = new Pair[N];

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            st.nextToken(); // 강의 번호를 입력받지만 딱히 필요 없는 값.
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            lecture[i] = new Pair(start, end);
        }

        //그리디 알고리즘. 종료 시간이 빠른 거부터 정렬
        Arrays.sort(lecture);

        //lecture 출력해보기
//        for(int i = 0; i < N; i++) {
//            System.out.print(lecture[i].start+" ");
//            System.out.println(lecture[i].end);
//        }

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(); // 기본 정렬 기준은 오름차순
        priorityQueue.add(lecture[0].end);

        for(int i = 1; i < N; i++) { // 일단 강의 하나 집어넣고 반복문 돌리는거라 인덱스 1번부터 돌아야함.
            if(!priorityQueue.isEmpty() && priorityQueue.peek() <= lecture[i].start) {
                // 넣으려는 강의의 시작 시간이 현재 강의실에 들어가 있는 강의의 종료 시간보다 느리다. 즉 겹치지 않는다.
                // 그러면 같은 강의실에서 강의 진행할 수 있다. 어쩌피 나는 이 우선순위 큐의 크기를 답으로 낼거라서
                // 기존에 들어가있는 강의를 뺀다.
                priorityQueue.poll();
            }
            priorityQueue.add(lecture[i].end); // 그다음 현재 강의를 추가한다.
        }

        bw.write(priorityQueue.size()+""); // 겹쳐서 도저히 같은 강의실에서 수업이 불가능한 강의들이 들어가있음.
        bw.flush();
        br.close();
        bw.close();
    }
}
