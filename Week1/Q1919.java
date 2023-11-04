package Week1;

import java.util.ArrayList;
import java.util.Scanner;

public class Q1919 {
    public static void main(String [] args){
        Scanner scan = new Scanner(System.in);

        ArrayList<Character> ArrA = new ArrayList <>();
        ArrayList<Character> ArrB = new ArrayList <>();

        String A = scan.next();
        String B = scan.next();
        int result = 0;

        for(int i=0; i < A.length(); i++){
            ArrA.add(A.charAt(i));
        }

        for(int i=0; i < B.length(); i++){
            ArrB.add(B.charAt(i));
        }

        for(int i=0; i<A.length(); i++){
            if(!ArrB.contains(A.charAt(i))){ // A의 인덱스 0부터 돌면서 B에 포함되어 있는지 계산
                result++;
                System.out.println(result );
            }

        }

        for(int i=0; i<B.length(); i++){
            if(!ArrA.contains(B.charAt(i))){
                result++;
                System.out.println(result );
            }
        }

        System.out.println(result);
    }
}
