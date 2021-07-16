import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {
    static class Deque {
        private LinkedList<Integer> linkList;

        private Deque() {
            this.linkList = new LinkedList<>();
        }

        private void push_front(int x) {
            linkList.addFirst(x);
        }
        private void push_back(int x) {
            linkList.addLast(x);
        }
        private int pop_front() {
            if (linkList.isEmpty())
                return -1;
            return linkList.pollFirst();
        }
        private int pop_back() {
            if (linkList.isEmpty())
                return -1;
            return linkList.pollLast();
        }
        private int size() {
            return linkList.size();
        }
        private int empty() {
            return (linkList.isEmpty()) ? 1 : 0;
        }
        private int front() {
            if (linkList.isEmpty())
                return -1;
            return linkList.peekFirst();
        }
        private int back() {
            if (linkList.isEmpty())
                return -1;
            return linkList.peekLast();
        }
    }
    public static void main(String[] args) throws IOException {
        LinkedList<Integer> linkList = new LinkedList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Deque deque = new Deque();
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            switch (input[0]) {
                case "push_front":
                    deque.push_front(Integer.parseInt(input[1]));
                    break;
                case "push_back":
                    deque.push_back(Integer.parseInt(input[1]));
                    break;
                case "pop_front":
                    System.out.println(deque.pop_front());
                    break;
                case "pop_back":
                    System.out.println(deque.pop_back());
                    break;
                case "size":
                    System.out.println(deque.size());
                    break;
                case "empty":
                    System.out.println(deque.empty());
                    break;
                case "front":
                    System.out.println(deque.front());
                    break;
                case "back":
                    System.out.println(deque.back());
            }
        }
    }
}