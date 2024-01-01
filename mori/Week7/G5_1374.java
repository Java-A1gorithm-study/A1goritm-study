package mori.Week7;

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

        @Override
        public int compareTo(Pair pair) { // 내가 계속 틀렸던 이유는 이 부분이었다.
            return Integer.compare(this.start, pair.start); // 시작 시간을 기준으로 정렬해야한다.
            // 이유를 좀 더 생각해봤다.
            /*
            내가 짠 알고리즘은 결국 가장 빠른 종료 시간의 강의와 새로 넣는 강의의 시작 시간을 비교하는 것이었다.
            새로 넣는 강의의 시작 시간이 종료 시간과 같거나 뒤인 경우 이것은 한 강의실에서 수업할 수 있다고 판단한다.
            여기에서 종료 시간을 기준으로 오름차순 정렬한다고 생각하자.
            그렇게 하면 겹치지 않도록 최대한 많은 강의를 들을 수는 있겠지만
            최소한의 강의실을 구하는 방법은 아닐 것이다.
            라고 하지만 반례를 찾기가 쉽지 않네..
            이건 스터디 때 얘기해보면 좋을 거 같다.
            4 9
            3 10
            11 12
            12 13
            11 14

           이런 경우를 생각해냈다.
           이런 경우 종료 시간을 기준으로 정렬해버리면
           A강의실 4 9(poll됨) 11 12
           B강의실 3 10(poll됨) 12 13
           11 14를 넣으면 C강의실을 만들어야한다.
           하지만 11 12 12 13은 사실 한 강의실에 할당할 수 있는데 불필요하게 사용되고 있었다.
           이는 바로앞에 종료 시간은 더 빠른데 시작 시간은 더 느린 케이스인 4 9 3 10이 들어가 있어서 그렇다.
           결국 이 문제를 막으려면 시작 시간이 빠른 걸로 정렬을 해야 다음과 같은 문제를 방지할 수 있다.
             */
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

        // compareTo에서 작성했던 기준. 시작 시간을 기준으로 정렬한다.
        Arrays.sort(lecture);

        //lecture 출력해보기
//        for(int i = 0; i < N; i++) {
//            System.out.print(lecture[i].start+" ");
//            System.out.println(lecture[i].end);
//        }

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(); // 기본 정렬 기준은 오름차순
        priorityQueue.add(lecture[0].end);

        for(int i = 1; i < N; i++) { // 일단 강의 하나 집어넣고 반복문 돌리는거라 인덱스 1번부터 돌아야함.
            if(priorityQueue.peek() <= lecture[i].start) {
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
