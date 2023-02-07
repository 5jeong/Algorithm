package algorithmStudy.그리디알고리즘;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class 결혼식 {
    static class marry implements Comparable<marry>{
        int t;
        char s;
        marry(int t,char s){
            this.t = t;
            this.s = s;
        }
        @Override
        public int compareTo(marry o) {
            if(this.t == o.t){
                return this.s - o.s;
            }
            else{
                return this.t - o.t;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int ans=Integer.MIN_VALUE;
        ArrayList<marry> arr = new ArrayList<>();
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            arr.add(new marry(a,'s'));
            int b = Integer.parseInt(st.nextToken());
            arr.add(new marry(b,'e'));
        }
        Collections.sort(arr);
        int cnt = 0;
        for(marry x : arr){
            if(x.s == 's'){
                cnt++;
            }
            if(x.s == 'e'){
                cnt--;
            }
            if(ans < cnt){
                ans = cnt;
            }
        }
        System.out.println(ans);
    }
}
