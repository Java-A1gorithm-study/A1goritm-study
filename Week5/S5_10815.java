package Week5;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S5_10815 {
    public static boolean isExisted(int number, int[] cards){
        int start = 0;
        int end = cards.length - 1;
        while(start <= end){
            int mid = (start + end) / 2;
            //System.out.printf("%d %d %d\n", start, mid, end);
            if(cards[mid] < number)
                start = mid + 1;
            else if(cards[mid] > number)
                end = mid - 1;
            else
                return true;
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] cards = new int[n];
        for (int i = 0; i < n; i++){
            int curr = Integer.parseInt(st.nextToken());
            cards[i] = curr;
        }

        Arrays.sort(cards);

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < m; i++) {
            int number = Integer.parseInt(st.nextToken());
            if(isExisted(number, cards))
                bw.write(1 + " ");
            else
                bw.write(0 + " ");
        }

        bw.flush();
        br.close();
        bw.close();
    }
}
