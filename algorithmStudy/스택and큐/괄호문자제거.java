package algorithmStudy.스택and큐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 괄호문자제거 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        Stack<Character> st = new Stack<>();
        for(char x : str.toCharArray()){
            if(x ==')'){
                while(st.pop() != '(');
            }
            else{
                st.push(x);
            }
            /*
            if(x != ')'){
                st.push(x);
            }

            else{
                while(st.peek() !='('){
                    st.pop();
                }
                st.pop();
            }*/
        }
        for(char x : st){
            System.out.print(x);
        }
    }
}