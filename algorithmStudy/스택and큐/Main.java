package algorithmStudy.스택and큐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int ans=0;
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='('){
                stack.push(str.charAt(i));
            }
            else if(str.charAt(i-1)=='('){
                stack.pop();
                ans+=stack.size();
            }
            else if(str.charAt(i-1)==')'){
                stack.pop();
                ans ++;
            }

        }
        System.out.println(ans);
    }
}
