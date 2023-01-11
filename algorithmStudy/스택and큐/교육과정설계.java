package algorithmStudy.스택and큐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 교육과정설계 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String plan = br.readLine();
        String ans ="YES";
        Queue<Character> q = new LinkedList<>();

        for (char x : str.toCharArray()) {
            q.offer(x);
        }

        for (char x : plan.toCharArray()) {
            if (q.contains(x)) {
                if(q.poll()!=x){
                    ans="NO";
                }
            }
        }
        if (!q.isEmpty()) {
            ans = "NO";
        }
        System.out.println(ans);
    }
}
