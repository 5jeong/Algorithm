package algorithmStudy.스택and큐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 올바른괄호 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        Stack<Character> stack = new Stack<>();
        for(char x : str.toCharArray()){
            if(stack.isEmpty()){
                stack.push(x);
            }
            else if(x =='('){
                stack.push(x);
            }
            if(stack.peek() == '(' && x == ')'){
                stack.pop();
            }
        }
        if(stack.isEmpty()){
            System.out.println("YES");
        }
        else{
            System.out.println("NO");
        }
    }
}
