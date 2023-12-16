package Week7;

import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Q11286 {
    static int N; // 연산의 개수
    static int x; // 입력받는 정수
    /*
    * 참고 사이트:
    * 기본 개념 >> https://velog.io/@gillog/Java-Priority-Queue%EC%9A%B0%EC%84%A0-%EC%88%9C%EC%9C%84-%ED%81%90
    * 백준 코드 >> https://dy-coding.tistory.com/entry/%EB%B0%B1%EC%A4%80-11286%EB%B2%88-%EC%A0%88%EB%8C%93%EA%B0%92-%ED%9E%99-java
    *
    * 우선 순위 큐 선언
    * 1. 낮은 숫자가 우선 순위인 int형 우선 순위 큐
    * PriorityQueue<Integer> priorityQueueLowest = new PriorityQueue<>();
    *
    * 2. 높은 숫자가 우선 순위인 int형 우선 순위 큐
    * PriorityQueue<Integer> priorityQueueHighest = new PriorityQueue<>(Collections.reverseOrder());
    * */
    static PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>(){
        // 오라클에서는 우선순위 큐라는 api를 제공함
        /*
        * Comparator는 interface의 일종으로 java.util 폴더에 있음
        * Comparator를 이용하기 위해 이 인터페이스 안에 있는 compare 추상메소드를 구현해줘야 함
        * Comparator 안에서 유일한 추상메소드인 compare을 오버라이딩하면서 구현
        * */
        @Override
        public int compare(Integer a, Integer b){
            int A = Math.abs(a);
            int B = Math.abs(b);
            /*
            *  compare 함수를 구현할 때 return 값으로 양수를 주면 순서를 바꾸겠다는 것이고 음수면 바꾸지 않겠다는 것
            * 이때 return 값으로 무조건 1.-1을 주어야 하는 것이 아니고 음수나 양수면 가능
            * */

            if(A>B)
                return A-B;

            else if(A == B){ // 절댓값이 같을 때 음수를 앞으로 보내줌
                if(a>b) return 1;
                else return -1;
            }

            else
                return -1;
        }
    });
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        N = Integer.parseInt(br.readLine());

        for(int i=0; i<N ;i++){
            x = Integer.parseInt(br.readLine());

            if(x != 0){
                pq.offer(x);
            }
            else{
                if(!pq.isEmpty())
                    sb.append(pq.poll()).append("\n");
                else
                    sb.append("0\n");
            }
        }

        System.out.print(sb);
    }
}
