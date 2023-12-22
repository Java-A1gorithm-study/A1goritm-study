package Week7;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Q2075 {
    static int N;
    static PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
    /*
    *  생각보다 간단한 문제임
    * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        /* 위 코드는 br.readLine으로 읽어온 줄을 공백(공백이 default 값임)으로 토큰화 해서 st에 넣겠다는 뜻이다.
        *
        * */

        N = Integer.parseInt(br.readLine());
        for(int i=0; i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine()); //이게 여기 있어야 오류가 안남
            for(int k=0; k<N; k++){
                int x = Integer.parseInt(st.nextToken()); // st에 있는 토큰들을 하나씩 x에 넣는다.
                pq.add(x);

            }
        }

        for(int j=1; j<N; j++){
            pq.remove();
        }

        System.out.println(pq.peek());
    }

}
