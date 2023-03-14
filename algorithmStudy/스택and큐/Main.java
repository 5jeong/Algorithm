package algorithmStudy.스택and큐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String order = br.readLine();
        String str = br.readLine();
        Queue<Character> queue = new LinkedList<>();
        for(char x : order.toCharArray()){
            queue.offer(x);
        }
        for(char x : str.toCharArray()){
            if(x == queue.peek()){
                queue.poll();
                queue.add(x);
            }
            else{
                queue.add(x);
            }
        }
        if(queue.size() == str.length()){
            System.out.println("YES");
        }
        else{
            System.out.println("NO");
        }
    }
}
