package Week5;

import java.io.*;
import java.util.*;

public class S4_1822{
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
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int[] setA = new int[a];
        int[] setB = new int[b];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < a; i++) {
            setA[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < b; i++) {
            setB[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(setB);

        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < a; i++) {
            if(!isExisted(setA[i], setB))
                result.add(setA[i]);
        }

        Collections.sort(result);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int size = result.size();
        bw.write(size + "\n");
        if(size != 0){
            for (int i = 0; i < size; i++) {
                bw.write(result.get(i) + " ");
            }
        }
        bw.flush();
        br.close();
        bw.close();
    }
}

