import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Hashtable;

public class Main {
    private static String checkMagazine(String[] magazine, String[] note) {
        Hashtable<String, Integer> ht = new Hashtable<String, Integer>();
        for (String word : magazine) {
            if (!ht.containsKey(word)) {
                ht.put(word, 1);                
            } else {
                ht.replace(word, ht.get(word)+1);
            }
        }
        
        for (String word : note) {
            Integer num = ht.get(word);
            if (num == null || num < 1) {
                return "No";
            } else {
                ht.replace(word, num-1);
            }
        }
        return "Yes";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        String[] magazine = br.readLine().split(" ");
        String[] note = br.readLine().split(" ");
        System.out.println(checkMagazine(magazine, note));
        br.close();
    }
}