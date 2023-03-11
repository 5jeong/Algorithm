package algorithmStudy.스택and큐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        Stack<Character> stack = new Stack<>();
        for(char x : str.toCharArray()){
            if(x==')'){
                while(stack.peek()!='('){
                    stack.pop();
                }
                stack.pop();
            }
            else{
                stack.push(x);
            }
        }
        for(char x : stack){
            System.out.print(x);
        }
    }
}
