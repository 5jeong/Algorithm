package algorithmStudy.그리디알고리즘;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class 회의실배정 {
    static class Point implements Comparable<Point>{
        int x,y;
        Point(int x,int y){
            this.x = x;
            this.y = y;
        }
        @Override
        public int compareTo(Point o) {
            if(this.y == o.y){
                return this.x - o.x;
            }
            else{
                return this.y - o.y;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<Point> arr = new ArrayList<>();
        int n= Integer.parseInt(st.nextToken());
        int ans =0;
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr.add(new Point(x,y));
        }
        Collections.sort(arr);
        int max = Integer.MIN_VALUE;
        for(Point p : arr ){
            if(max <= p.x){
                ans++;
                max = p.y;
            }
        }
        System.out.println(ans);
    }
}
