package Week8;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class S1_5014 {
    static int BFS(int top, int start, int startLink, int[] dir){
        boolean[] isVisited = new boolean[top + 1];

        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        isVisited[start] = true;
        int cnt = 0;

        while(!q.isEmpty()){
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int curr = q.poll();
                //System.out.println(curr);
                if(curr == startLink)
                    return cnt;

                for (int j = 0; j < 2; j++) {
                    int next = curr + dir[j];
                    if(next < 1 || next > top)
                        continue;
                    if(isVisited[next])
                        continue;
                    q.offer(next);
                    isVisited[next] = true;
                }
            }
            cnt++;
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int top = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());
        int startLink = Integer.parseInt(st.nextToken());
        int[] dir = new int[2];
        dir[0] = Integer.parseInt(st.nextToken());
        dir[1] = -Integer.parseInt(st.nextToken());

        int result = BFS(top, start, startLink, dir);

        String answer = result == -1 ? "use the stairs" : Integer.toString(result);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(answer);
        bw.flush();
        br.close();
        bw.close();
    }
}
