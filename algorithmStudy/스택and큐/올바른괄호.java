package algorithmStudy.스택and큐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 올바른괄호 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String ans = "YES";
        Stack<Character> st = new Stack<>();
        for(char x : str.toCharArray()){
            if(x=='('){
                st.push(x);
            }
            else{
                if(st.isEmpty()){
                    ans = "NO";
                }
                else{
                    st.pop();
                }
            }
        }
        if(!st.isEmpty()){
            ans="NO";
        }
        System.out.println(ans);
    }
}
