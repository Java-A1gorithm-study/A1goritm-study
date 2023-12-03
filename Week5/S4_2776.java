package Week5;

import java.io.*;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S4_2776 {

    public static boolean binarySearch(int number, int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while(left <= right) {
            int mid = (left + right) >> 1;
            if(arr[mid] < number)
                left = mid + 1;
            else if (arr[mid] > number)
                right = mid - 1;
            else
                return true;
        }
        return false;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testcase = Integer.parseInt(br.readLine());

        while(testcase > 0) {
            int nb1 = Integer.parseInt(br.readLine());
            StringTokenizer st1 = new StringTokenizer(br.readLine());

            int[] note1 = new int[nb1];
            for (int i = 0; i < nb1; i++)
                note1[i] = Integer.parseInt(st1.nextToken());

            int nb2 = Integer.parseInt(br.readLine());
            StringTokenizer st2 = new StringTokenizer(br.readLine());

            int[] note2 = new int[nb2];
            for (int i = 0; i < nb2; i++)
                note2[i] = Integer.parseInt(st2.nextToken());

            //이분 탐색 돌릴 배열만 소팅해준다.
            Arrays.sort(note1);

            for (int j = 0; j < nb2; j++) {
                if (binarySearch(note2[j], note1))
                    bw.write(1+ "\n");
                else
                    bw.write(0+ "\n");
            }
            testcase--;
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
