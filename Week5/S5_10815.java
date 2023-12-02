package Week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class S5_10815 {

    public static void main(String[] args) throws IOException {

        //입력을 Scanner로 받았었는데 입력받다가 터져서 bufferReader로 변경
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //상근이의 카드 개수 받기
        int n = Integer.parseInt(br.readLine());

        //카드 숫자 리스트에 저장
        ArrayList<Integer> array = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()) {
            array.add(Integer.parseInt(st.nextToken()));
        }


        //이진 탐색 수행하기 위한 리스트 정렬.
        Collections.sort(array);
        //정렬된 리스트를 인덱스 편의성을 위해 다시 배열로 받음.
        Integer[] arr = array.toArray(new Integer[n]);

        //주어지는 카드의 개수
        int m = Integer.parseInt(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++) {
            if (!binarySearch(arr, Integer.parseInt(st2.nextToken()), 0, n-1))
                System.out.print(0+" ");
            else
                System.out.print(1+" ");
        }
    }


    //java 자체적으로 binarySearch 해주는 게 있다고는 하지만, 공부용으로 그냥 만들어서 쓸거다.
    public static boolean binarySearch(Integer[] arr, int n, int left, int right) {
        if(left > right) return false;
        // 중간 값 구하기. 시프트 연산 사용
        int mid = (left + right) >> 1;

        if(arr[mid] < n)
            return binarySearch(arr, n, mid+1, right);
        else if(arr[mid] > n)
            return binarySearch(arr, n, left, mid-1);
        else
            return true;
        }
    }
