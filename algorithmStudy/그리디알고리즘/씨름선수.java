package algorithmStudy.그리디알고리즘;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class 씨름선수 {
    static class Point implements Comparable<Point>{
        int x,y;
        Point(int x,int y){
            this.x = x;
            this.y = y;
        }
        @Override
        public int compareTo(Point o) {
            return o.x - this.x;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int ans =0;
        int max= Integer.MIN_VALUE;
        ArrayList<Point> p =  new ArrayList<>();
        for(int i=0;i<n;i++){
            st= new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            p.add(new Point(x,y));
        }
        Collections.sort(p);
        for(int i=0;i<n;i++){
            if(max < p.get(i).y){
                max = p.get(i).y;
                ans++;
            }
        }
        System.out.println(ans);
    }
}
