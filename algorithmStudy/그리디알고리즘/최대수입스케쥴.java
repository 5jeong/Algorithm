package algorithmStudy.그리디알고리즘;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 최대수입스케쥴 {
    static class lecture implements Comparable<lecture>{

        int money, time;
        lecture(int money,int time){
            this.money = money;
            this.time = time;
        }
        @Override
        public int compareTo(lecture o) {
            if(this.time == o.time){
                return o.money - this.money;
            }
            else{
                return o.time - this.time;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        ArrayList<lecture> lectures = new ArrayList<>();
        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            max = Math.max(max,t);
            lectures.add(new lecture(m,t));
        }
        Collections.sort(lectures);

        int ans = 0;
        int j=0;
        for(int i=max;i>=1;i--){
            for(;j<n;j++){
                if(lectures.get(j).time < i){
                    break;
                }
                else{
                    pq.add(lectures.get(j).money);
                }
            }
            if(!pq.isEmpty()){
                ans+=pq.poll();
            }
        }

        System.out.println(ans);
    }
}
