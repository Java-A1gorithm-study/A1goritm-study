package Week5;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Q1620 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        Map<Integer, String> HashMap1 = new HashMap<>();// 포켓몬 저장 해쉬맵
        Map<String, Integer> HashMap2 = new HashMap<>();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());


        for (int i = 1; i <= N; i++) { // 포켓몬 읽기
            String name = br.readLine();
            HashMap1.put(i, name);
            HashMap2.put(name, i);
        }

            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            for (int j = 0; j < M; j++) { // 맞춰야 하는 문제
                String q = br.readLine();
                try {//숫자이면 이름 적어주기
                    String name = HashMap1.get(Integer.parseInt(q));
                    bw.write(name + "\n");
                } catch (NumberFormatException e) { // 문자열이면 인덱스 적어주기
                    Integer index = HashMap2.get(q);
                    bw.write(index + "\n");
                }
            }
            bw.flush();
            br.close();
            bw.close();


        }
}

