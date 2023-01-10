package algorithmStudy.스택and큐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 후위식연산 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        Stack<Integer> stack = new Stack<>();
        for(char x : str.toCharArray()){
            char temp=' ';
            if(Character.isDigit(x)){
                stack.push(Character.getNumericValue(x));
            }
            else{
                int rt = stack.pop();
                int lt = stack.pop();
                if (x == '+') {
                    stack.push(lt + rt);
                }
                else if (x == '-') {
                    stack.push(lt - rt);
                }
                else if (x == '*') {
                    stack.push(lt * rt);
                }
                else if (x == '/') {
                    stack.push(lt / rt);
                }
            }
        }
        System.out.println(stack.peek());
    }
}
