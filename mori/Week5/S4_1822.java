package mori.Week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class S4_1822 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        ArrayList<Integer> arrayA = new ArrayList<>();
        ArrayList<Integer> arrayB = new ArrayList<>();
        ArrayList<Integer> arrayRS = new ArrayList<>();

        StringTokenizer stValueA = new StringTokenizer(br.readLine());
        while(stValueA.hasMoreTokens())
            arrayA.add(Integer.parseInt(stValueA.nextToken()));

        StringTokenizer stValueB = new StringTokenizer(br.readLine());
        while(stValueB.hasMoreTokens())
            arrayB.add(Integer.parseInt(stValueB.nextToken()));

        Collections.sort(arrayA);
        Collections.sort(arrayB);

        //A에 속하면서 B에 속하지 않는 거 찾기.
        //A에서 하나 꺼내서 value로 두고 B에 있는지 이분탐색하면됨.

        //이번엔 collection의 binarysearch 이용함.
        for(int i = 0; i < A; i++) {
            if(Collections.binarySearch(arrayB, arrayA.get(i)) < 0)
                arrayRS.add(arrayA.get(i));
        }
        System.out.println(arrayRS.size());
        for(int ar : arrayRS)
            System.out.print(ar+" ");


    }
}
