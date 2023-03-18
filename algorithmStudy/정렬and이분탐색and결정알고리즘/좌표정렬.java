package algorithmStudy.정렬and이분탐색and결정알고리즘;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;
public class 좌표정렬 {

    static class Point implements Comparable<Point>{
        int x,y;
        Point(int x,int y){
            this.x =x;
            this.y=y;
        }
        @Override
        public int compareTo(Point o) {
            if(o.x==x){
                return this.y-o.y;
            }
            else{
                return this.x - o.x;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        ArrayList<Point> ans = new ArrayList<>();
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            ans.add(new Point(x,y));
        }
        Collections.sort(ans);
        for(Point point : ans){
            System.out.print(point.x + " " + point.y);
            System.out.println();
        }
    }
}
