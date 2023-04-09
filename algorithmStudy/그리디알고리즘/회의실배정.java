package algorithmStudy.그리디알고리즘;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class 회의실배정 {
    static class meeting implements Comparable<meeting> {
        int s,e;
        meeting(int s,int e){
            this.s = s;
            this.e = e;
        }

        @Override
        public int compareTo(meeting o) {
            if(this.e == o.e){
                return this.s - o.s;
            }
            else{
                return this.e - o.e;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        ArrayList<meeting> meetings = new ArrayList<>();
        for(int i=0;i<n;i++){
            st=new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            meetings.add(new meeting(s,e));
        }
        Collections.sort(meetings);
        int ans=0;
        int max = Integer.MIN_VALUE;
        for(meeting meeting : meetings){
            if(meeting.s >= max ){
                max = meeting.e;
                ans++;
            }
        }
        System.out.println(ans);
    }
}
