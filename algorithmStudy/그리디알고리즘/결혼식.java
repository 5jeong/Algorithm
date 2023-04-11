package algorithmStudy.그리디알고리즘;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class 결혼식 {
    static class marry implements Comparable<marry>{
        int time;
        char state;
        marry(int time,char state){
            this.time = time;
            this.state = state;
        }

        @Override
        public int compareTo(marry o) {
            if(this.time == o.time){
                return this.state - o.state;
            }
            else{
                return this.time - o.time;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        ArrayList<marry> marries = new ArrayList<marry>();
        for(int i=0;i<n;i++){
            st=new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            marries.add(new marry(a,'s'));
            int b = Integer.parseInt(st.nextToken());
            marries.add(new marry(b,'e'));
        }
        Collections.sort(marries);
        int cnt=0;
        int ans=0;
        for(marry x : marries){
            if(x.state=='s'){
                cnt++;
            }
            else{
                cnt--;
            }
            ans = Math.max(ans,cnt);
        }
        System.out.println(ans);
    }
}
