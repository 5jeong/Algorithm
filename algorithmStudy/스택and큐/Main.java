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
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        Queue<Integer> q = new LinkedList<>();
        int cnt=0;
        for(int i=1;i<=n;i++){
            q.offer(i);
        }
        while(q.size()!=1){
            cnt++;
            if(cnt==k){
                q.poll();
                cnt=0;
            }
            else{
                q.offer(q.poll());
            }
        }
        System.out.println(q.peek());
    }
}
