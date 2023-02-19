package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class baekjoon_2655 {
    static class brick implements Comparable<brick>{
        int underside,height,weight;
        brick(int underside,int height,int weight){
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
        int[] dy = new int[n];
        ArrayList<brick> arr = new ArrayList<>();
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            arr.add(new brick(a,b,c));
        }
        Collections.sort(arr);
        dy[0] = arr.get(0).height;
        int cnt=0;
        int[] ans = new int[n];
        for(int i=1;i<n;i++){
            int temp=0;
            for(int j=0;j<i;j++){
                if(arr.get(i).weight <arr.get(j).weight){
                    temp = Math.max(temp,dy[j]);
                }
            }
            dy[i] = arr.get(i).height+temp;
            for(int s = 0; s<i;s++){
                if(temp == dy[s]){
                    ans[s]=1;
                    cnt++;
                    break;
                }
            }
        }

        int max =0;
        for(int x : dy){
            max = Math.max(max,x);
        }

        for(int i=0;i<n;i++){
            if(max == dy[i]){
                ans[i] = 1;
                cnt++;
            }
        }
        for(int i=0;i<n;i++){
            if(max == arr.get(i).height){
                cnt = 1;

            }
        }

        System.out.println(cnt);
        for(int i=n-1;i>=0;i--){
            if(ans[i]==1){
                System.out.println(i+1);
            }
        }
    }
}
