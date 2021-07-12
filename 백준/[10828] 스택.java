import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    static class Stack {
        private int[] stk;
        private int size = 0;

        private Stack(int n) {
            stk = new int[n];
        }

        private void push(String num) {
            stk[size++] = Integer.parseInt(num);
        }

        private void pop() {
            if (size > 0) {
                System.out.println(stk[size - 1]);
                stk[--size] = 0;
            } else {
                System.out.println(-1);
            }
        }

        private void size() {
            System.out.println(size);
        }

        private void empty() {
            if (size > 0) {
                System.out.println(0);
            } else {
                System.out.println(1);
            }
        }

        private void top() {
            if (size > 0) {
                System.out.println(stk[size - 1]);
            } else {
                System.out.println(-1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack stk = new Stack(n);
        for (int i = 0; i < n; i++) {
            String[] command = br.readLine().split(" ");
            switch (command[0]) {
                case "push":  stk.push(command[1]);
                    break;
                case "pop":  stk.pop();
                    break;
                case "size":  stk.size();
                    break;
                case "empty":  stk.empty();
                    break;
                case "top":  stk.top();
                    break;
            }
        }
    }
}