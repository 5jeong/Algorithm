package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class baekjoon_2655 {
    static class brick implements Comparable<brick>{
        int num,underside,height,weight;
        brick(int num,int underside,int height,int weight){
            this.num = num;
            this.underside = underside;
            this.height = height;
            this.weight = weight;
        }
        @Override
        public int compareTo(brick o) {
            return o.underside - this.underside;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] dp = new int[n];
        ArrayList<brick> arr = new ArrayList<>();
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            arr.add(new brick(i+1,a,b,c));
        }
        Collections.sort(arr);
        dp[0] = arr.get(0).height;
        int cnt=0;
        int[] ans = new int[n];
        for(int i=1;i<n;i++){
            int temp=0;
            for(int j=0;j<i;j++){
                if(arr.get(i).weight <arr.get(j).weight){
                    temp = Math.max(temp,dp[j]);
                }
            }
            dp[i] = arr.get(i).height+temp;
            for(int s = 0; s<i;s++){
                if(temp == dp[s]){
                    ans[s]=1;
                    cnt++;
                    break;
                }
            }
        }

        int max =0;
        for(int x : dp){
            max = Math.max(max,x);
        }
        ArrayList<Integer> result = new ArrayList<>();

        for(int i=n-1;i>=0;i--){
            if(max == dp[i]){
                result.add(arr.get(i).num);
                max -= arr.get(i).height;
            }
        }
        System.out.println(result.size());
        for(int x : result){
            System.out.println(x);
        }
    }
}