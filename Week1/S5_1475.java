package Week1;
import java.io.*;

public class S5_1475 {
    static final int NUMBER = 10;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String roomNumber = br.readLine();
        int roomNumberLength = roomNumber.length();
        int[] countNumber = new int[NUMBER]; // 0~9까지 숫자가 몇 개인지 저장
        for (int i = 0; i < roomNumberLength; i++) {
            int index = roomNumber.charAt(i) - '0';
            countNumber[index]++;
        }

        /*countNumber[6] = (countNumber[6] + 1) / 2;
        countNumber[9] = (countNumber[9] + 1) / 2;*/

        int result = 0;
        for (int i = 0; i < NUMBER - 1; i++) {
            int curr = countNumber[i];
            if(i == 6)
                curr = (curr + countNumber[9] + 1) / 2; // 6과 9가 홀, 홀 일 때 합해서 짝이 될 수 있음
            result = Math.max(curr, result);
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(Integer.toString(result));
        bw.flush();
    }
}
