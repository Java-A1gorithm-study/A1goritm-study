package Week3;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class S2_2644 {
    static int result = 0;
    static void DFS(ArrayList<ArrayList<Integer>>family, int start, int end, boolean[] isVisited, int count, int n){
        if(start == end){
            result = count;
            return;
        }


        isVisited[start] = true;
        int length = family.get(start).size();
        for (int i = 0; i < length; i++) {
            int next = family.get(start).get(i);
            if(isVisited[next])
                continue;
            DFS(family, next, end, isVisited, count + 1, n);
            //isVisited[family.get(start).get(i)] = false;

         }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<Integer>> family = new ArrayList<>(n + 1);
        for (int i = 0; i <= n; i++) {
            family.add(new ArrayList<>());
        }

        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int u = Integer.parseInt(st.nextToken());
            family.get(v).add(u);
            family.get(u).add(v);
        }

        boolean[] isVisited = new boolean[n + 1];
        DFS(family, start, end, isVisited, 0, n);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        result = result == 0 ? -1 : result;
        bw.write(Integer.toString(result));
        bw.flush();
    }
}
