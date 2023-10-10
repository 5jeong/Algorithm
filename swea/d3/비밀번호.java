package swea.d3;

import java.io.FileInputStream;
import java.util.*;

public class 비밀번호 {

    public static void main(String args[]) throws Exception {
        System.setIn(new FileInputStream("C:\\Users\\82109\\Desktop\\정훈\\알고리즘 공부\\Algorithm_Java\\swea\\d3\\input.txt"));
        Scanner sc = new Scanner(System.in);
        int T;
//        T=sc.nextInt();
        T = 10;
        for (int test_case = 1; test_case <= T; test_case++) {
            int n = sc.nextInt();
            String str = sc.next();
            Stack<Character> stack = new Stack<>();
            for(int i=0;i<n;i++){
                if(!stack.isEmpty() && stack.peek()==str.charAt(i)){
                    stack.pop();
                    continue;
                }
                stack.push(str.charAt(i));
            }
            System.out.print("#"+test_case+" ");
            for(char x : stack){
                System.out.print(x);
            }
            System.out.println();

        }
    }
}