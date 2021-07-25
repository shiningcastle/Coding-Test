import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input = br.readLine().split(" ");
        int x = Integer.parseInt(input[0]), y = Integer.parseInt(input[1]);
        
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++)
                bw.write('*');
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }
}