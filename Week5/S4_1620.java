package Week5;
import java.util.*;
import java.io.*;
public class S4_1620 {
    static int getIndex(String[] pokemons, String question){
        int length = pokemons.length;
        String[] sorted = new String[length];
        for (int i = 0; i < length; i++) {
            sorted[i] = pokemons[i];
        }

        Arrays.sort(sorted);

        int start = 0;
        int end = length;
        while(start <= end){
            int mid = (start + end) / 2;
            /*System.out.printf("%d %d %d\n", start, mid, end);
            System.out.println(sorted[mid]);*/
            if(sorted[mid].equals(question)){
                for (int i = 0; i < length; i++) {
                    if(sorted[mid].equals(pokemons[i]))
                        return i;
                }
            }
            if(sorted[mid].compareTo(question) < 0){
                start = mid + 1;
            }
            else{
                end = mid - 1;
            }
        }
        return 0;
    }
//abcdefghijklmnopqrstuvwxyz

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        String[] pokemons = new String[n];
        for (int i = 0; i < n; i++) {
            pokemons[i] = br.readLine();
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < m; i++) {
            String question = br.readLine();
            try{//숫자이면 이름 적어주기
                int index = Integer.parseInt(question);
                bw.write(pokemons[index-1] + "\n");
            }catch(NumberFormatException e){ // 문자열이면 인덱스 적어주기
                int index = getIndex(pokemons, question) + 1;
                bw.write(index + "\n");
            }
        }

        bw.flush();
        br.close();
        bw.close();
    }
}
