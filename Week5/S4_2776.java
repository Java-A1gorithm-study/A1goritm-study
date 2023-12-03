package Week5;
import java.io.*;
import java.util.*;
public class S4_2776 {
    static boolean isExist(int question, int[] myNumber){
        int start = 0;
        int end = myNumber.length - 1;
        while(start <= end){
            int mid = (start + end) / 2;
            //System.out.printf("%d %d %d\n", start, mid, end);
            if(myNumber[mid] < question)
                start = mid + 1;
            else if(myNumber[mid] > question)
                end = mid - 1;
            else
                return true;
        }
        return false;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int tc = Integer.parseInt(br.readLine());
        for (int t = 0; t < tc; t++) {
            int n = Integer.parseInt(br.readLine());

            int[] myNUmber = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                myNUmber[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(myNUmber);

            int m = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                int question = Integer.parseInt(st.nextToken());
                if(isExist(question, myNUmber))
                    bw.write(1 + "\n");
                else
                    bw.write(0 + "\n");
            }
            bw.flush();
        }

        br.close();
        bw.close();
    }
}
