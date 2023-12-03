package Week5;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q2776 {
    static boolean binarySearch(int num, int[] arr){ // 이분 탐색 메소드
        int start = 0;
        int end = arr.length - 1;
        while(start <= end){
            int mid = (start + end) / 2;
            if(arr[mid] < num)
                start = mid + 1;
            else if(arr[mid] > num)
                end = mid - 1;
            else
                return true;
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T =Integer.parseInt(br.readLine());

        for(int i=0; i<T; i++){
            int N =Integer.parseInt(br.readLine());
            int [] arr = new int[N];

            for(int j=0; j<N; j++){
                arr[j] = Integer.parseInt(st.nextToken());
            }

            int M = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            int [] arr2 = new int[M];
            for(int k=0; k<M; k++){
                arr2[k] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr);


            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            for (int j = 0; j < M; j++) {
                if (binarySearch(arr2[j], arr))
                    bw.write(1+ "\n");
                else
                    bw.write(0+ "\n");
            }


        }
    }
}
