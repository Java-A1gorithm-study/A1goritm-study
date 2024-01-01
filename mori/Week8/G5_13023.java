package mori.Week8;
import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class G5_13023 {
    static boolean status = false;
    static ArrayList<Integer>[] list;
    static boolean[] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 사람의 수
        int M = Integer.parseInt(st.nextToken()); // 친구 관계의 수

        list = new ArrayList[N];
        for(int i = 0; i < N; i++) {
            list[i] = new ArrayList<>();
        }


        //관계 입력
        int count = 0;
        while(count < M) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st2.nextToken());
            int b = Integer.parseInt(st2.nextToken());
            list[a].add(b); //방향 없는 거라서 양방향 추가
            list[b].add(a);
            count++;
        }

        for(int i=0; i<N; i++) {
            check = new boolean[N];
            dfs(i,0);
            if(status) {
                bw.write(1+"");
                break;
            }
        }
        if(!status)
            bw.write(0+"");
        bw.flush();
        br.close();
        bw.close();
    }

        static void dfs(int x, int depth) { // 보니까 사람 몇명이든 서로 친구인 5명 존재하면 되는 거 같았다. 그래서 깊이로 품.
            if(depth==4) {
                status=true; //깊이가 4다. 모든 친구 찾음.
                return;
            }
            check[x]= true;
            for(int a : list[x]) {
                if(!check[a]) {
                    dfs(a, depth+1);
                }
            }
            check[x]= false;
        }

}
