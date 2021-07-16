import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

class Solution {
    private static LinkedList<Integer> list = new LinkedList<>();

    private static void push(int num) {
        list.addLast(num);
    }

    private static int pop() {
        if (list.size() == 0)
            return -1;
        return list.removeFirst().intValue();
    }

    private static int size() {
        return list.size();
    }

    private static int empty() {
        int result = (list.isEmpty()) ? 1 : 0;
        return result;
    }

    private static int front() {
        if (list.size() == 0)
            return -1;
        return list.getFirst().intValue();
    }

    private static int back() {
        if (list.size() == 0)
            return -1;
        return list.getLast().intValue();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            switch (input[0]) {
                case "push":
                    push(Integer.parseInt(input[1]));
                    break;
                case "pop":
                    System.out.println(pop());
                    break;
                case "size":
                    System.out.println(size());
                    break;
                case "empty":
                    System.out.println(empty());
                    break;
                case "front":
                    System.out.println(front());
                    break;
                case "back":
                    System.out.println(back());
                    break;
            }
        }
    }
}
