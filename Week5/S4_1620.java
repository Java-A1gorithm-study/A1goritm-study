package Week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class S4_1620 {
    public static void main(String[] args) throws IOException {
        Map<Integer, String> keyHashMap = new HashMap<>();
        Map<String, Integer> valueHashMap = new HashMap<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int book = Integer.parseInt(st1.nextToken());
        int qNum = Integer.parseInt(st1.nextToken());

        //도감 기록
        for(int i = 1; i <= book; i++) {
            String value = br.readLine();
            keyHashMap.put(i, value);
            valueHashMap.put(value, i);
        }

        //문제 풀이
        for(int j = 0; j < qNum; j++) {
            String question = br.readLine();
            // String 메서드의 matches 메서드를 활용하여 숫자 찾기.
            if (question.matches("\\d+")) {
                System.out.println(keyHashMap.get(Integer.parseInt(question)));
            } else {
                System.out.println(valueHashMap.get(question));
        }
        }
    }
}
