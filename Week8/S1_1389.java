package Week8;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S1_1389 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] friendShip = new int[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            Arrays.fill(friendShip[i], 5001); // Integer.MAX_VALUE로 하면 오버플로우 남.
            friendShip[i][i] = 0;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            friendShip[a][b] = 1;
            friendShip[b][a] = 1;
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    friendShip[i][j] = Math.min(friendShip[i][j], friendShip[i][k] + friendShip[k][j]);
                }
            }
        }

        int result = Integer.MAX_VALUE;
        int index = 0;

        for (int i = 1; i <= n; i++) {
            int total = 0;
            for (int j = 1; j <= n; j++) {
                total += friendShip[i][j];
            }

            if (result > total){
                result = total;
                index = i;
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(index + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
