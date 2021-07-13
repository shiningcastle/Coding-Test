import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static void reverseWord(String input) {
        String[] wordList = input.split(" ");
        StringBuilder sentenceBuilder = new StringBuilder();
        for (String word : wordList) {
            StringBuilder wordBuilder = new StringBuilder(word);
            sentenceBuilder.append(wordBuilder.reverse() + " ");
        }
        System.out.println(sentenceBuilder);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            reverseWord(br.readLine());
        }
    }
}