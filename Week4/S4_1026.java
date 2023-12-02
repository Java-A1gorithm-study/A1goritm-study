package Week4;

import java.util.Arrays;
import java.util.Scanner;

public class S4_1026 {
    public static void main(String[] args) {
        /* 아이디어
        정수 배열 A와 B
        S는 A B 배열의 순차적인 곱으로 이루어진 값인데 이게 최소가 되야함.
        B의 순번은 정해져있음.ex) B = [1, 3, 7, 9, 13]
        내가 바꿀 수 이는 A의 순번임.
         */
        Scanner sc = new Scanner(System.in);
        //A와 B를 입력받고, 크기는 n에 저장.
        int n = sc.nextInt();
        int[] A = new int[n];
        int[] B = new int[n];
        //A 입력
        for(int i = 0; i < n; i++) {
            A[i] = sc.nextInt();
        }
        //B 입력
        for(int i = 0; i < n; i++) {
            B[i] = sc.nextInt();
        }

        //문제에서 B의 순번을 바꿀 수 없다고 하지만 결국 A의 순번을 바꾼다는건
        //B의 순번을 바꿔도 상관없다는 얘기라서.
        //곱의 합이 가장 작으려면 작은값 x 큰값 으로 순서를 만들어주면 된다.
        Arrays.sort(A);
        Arrays.sort(B);
        //합 저장 변수
        int sum=0;

        for(int i = 0; i < n; i++) {
            sum = sum + A[i] * B[n-i-1];
        }
        System.out.println(sum);
    }
}
