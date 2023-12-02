package Week4;

import java.util.Arrays;
import java.util.Collections;

import java.util.Comparator;
import java.util.Scanner;

public class Q1026 {

    public static void main(String [] args){
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();

        Integer [] A = new Integer[N];
        Integer[] B = new Integer[N];

        int result =0;

        for(int i=0; i<N; i++){
            A[i] = scan.nextInt();
        }
        for(int i=0; i<N; i++){
            B[i] = scan.nextInt();
        }

        Arrays.sort(A); // 오름차순 정렬
        Arrays.sort(B, Comparator.reverseOrder()); // 오름차순 정렬, Comparator.reverseOrder()는 Integer 타입만 가능하다.

        for(int i=0; i<N;i++){
            result += A[i]*B[i];
        }

        System.out.println(result);
    }
}
