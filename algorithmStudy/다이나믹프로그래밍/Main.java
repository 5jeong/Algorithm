package algorithmStudy.다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;
public class Main {
    static class brick implements Comparable<brick>{
        int s,h,w;
        brick(int s,int h,int w){
            this.s=s;
            this.h=h;
            this.w=w;
        }

        @Override
        public int compareTo(brick o) {
            return o.s-this.s;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        ArrayList<brick> bricks = new ArrayList<>();
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            bricks.add(new brick(s,h,w));
        }
        Collections.sort(bricks);
        int[] dp=  new int[n];
        dp[0] = bricks.get(0).h;
        for(int i=1;i<n;i++){
            int temp=0;
            for(int j=0;j<i;j++){
                if(bricks.get(i).w < bricks.get(i-1).w){
                    temp=Math.max(temp,dp[j]);
                }

            }
            dp[i] = temp + bricks.get(i).h;
        }
        int ans=0;
        for(int x : dp){
            ans = Math.max(ans,x);
        }
        System.out.println(ans);
    }
}
