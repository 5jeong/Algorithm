package algorithmStudy.스택and큐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Person{
        int id;
        int priority;
        Person(int id,int priority){
            this.id = id;
            this.priority = priority;
        }

}

public class 응급실 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int ans =0;
        Queue<Person> q = new LinkedList<>();
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for(int i=0;i<n;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            q.offer(new Person(i,arr[i]));
        }

        while(!q.isEmpty()){
            Person tmp = q.poll();
            for(Person x : q){
                if(tmp.priority <x.priority){
                    q.offer(tmp);
                    tmp = null;
                    break;
                }
            }
            if(tmp!=null){
                ans++;
                if(tmp.id==m){
                    System.out.println(ans);
                }
            }
        }
    }
}
