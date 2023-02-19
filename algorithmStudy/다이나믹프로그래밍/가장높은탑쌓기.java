package algorithmStudy.다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class 가장높은탑쌓기 {
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
        int ans = 0;
        int[] dy = new int[n];
        ArrayList<brick> bricks = new ArrayList<>();
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            bricks.add(new brick(a,b,c));
        }
        Collections.sort(bricks);
        dy[0] = bricks.get(0).height;

        for(int i=1;i<n;i++){
            int temp =0;
            for(int j=0;j<i;j++){
                if(bricks.get(i).weight < bricks.get(j).weight){
                    temp = Math.max(temp,dy[j]);
                }
            }
            dy[i] = temp+bricks.get(i).height;

        }

        for(int x : dy){
            ans = Math.max(ans,x);
        }
        System.out.println(ans);
    }
}