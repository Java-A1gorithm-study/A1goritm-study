package Week8;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class G5_13023 {
    static boolean status;

    static void BT(ArrayList<Integer>[] friendShip, boolean[] isVisited, int start, int cnt, int n){
        if(cnt == 5){
            status = true;
            return;
        }

        isVisited[start] = true;
        for (int i = 0; i < friendShip[start].size(); i++) {
            int next = friendShip[start].get(i);
            if(isVisited[next])
                continue;
            //isVisited[next] = true;
            BT(friendShip, isVisited, next, cnt + 1, n);
            isVisited[next] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] friendShip = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            friendShip[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            friendShip[a].add(b);
            friendShip[b].add(a);
        }

        //int result = 0;
        for (int i = 0; i < n; i++) {
            boolean[] isVisited = new boolean[n];
            BT(friendShip, isVisited, i, 1, n);
            if(status)
                break;
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String answer = status ? "1" : "0";
        bw.write(answer);
        bw.flush();
        br.close();
        bw.close();

    }
}
