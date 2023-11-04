package Week1;
import java.io.*;

public class B2_1919 {
    static final int ALPHABET = 26;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String firstWord = br.readLine();
        String secondWord = br.readLine();
        int lengthOfFirstWord = firstWord.length();
        int lengthOfSecondWord = secondWord.length();
        int[] firstWordAlphabets = new int[ALPHABET];
        int[] secondWordAlphabets = new int[ALPHABET];

        for (int i = 0; i < lengthOfFirstWord; i++) {
            firstWordAlphabets[firstWord.charAt(i) - 'a']++;
        }

        for (int i = 0; i < lengthOfSecondWord; i++) {
            secondWordAlphabets[secondWord.charAt(i) - 'a']++;
        }

        int result = 0;
        for (int i = 0; i < ALPHABET; i++) {
            if(firstWordAlphabets[i] == 0 || secondWordAlphabets[i] == 0)
                result += firstWordAlphabets[i] + secondWordAlphabets[i];
            else
                result += Math.abs(firstWordAlphabets[i] - secondWordAlphabets[i]);
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(Integer.toString(result));
        bw.flush();
    }
}
