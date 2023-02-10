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
        int money,day;
        lecture(int m,int d ){
            money = m;
            day = d;
        }
        @Override
        public int compareTo(lecture o) {
                return o.day-day;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int ans =0;
        ArrayList<lecture> arr = new ArrayList<>();
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            arr.add(new lecture(m,d));
        }
        Collections.sort(arr);
        int max = arr.get(0).day;
        int j=0;


        for(int i = max ;i>=1;i--){
            for(;j<n;j++){
                if(arr.get(j).day < i){
                    break;
                }
                q.offer(arr.get(j).money);
            }
            if(!q.isEmpty()){
                ans+=q.poll();
            }
        }

        System.out.println(ans);
    }
}
