package baekjoon.gold;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * 최소 회의실 개수
 * 동시에 두개 이상의 회의는 진행x
 * 회의가 끝나는 동시에 다음 회의가 시작가능
 * 최소 회의실 갯수 출력
 */
public class Baekjoon_19598 {

    static class Meeting{
        int start,end;
        Meeting(int start,int end){
            this.start=start;
            this.end=end;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Meeting> meetings = new ArrayList<>();
        for(int i =0 ;i<n;i++){
            meetings.add(new Meeting(sc.nextInt(),sc.nextInt()));
        }

        // 회의 시작순으로 정렬
        meetings.sort((a,b)-> a.start - b.start);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(Meeting meeting : meetings){
            pq.add(meeting.end);

            if(pq.peek() <= meeting.start){
                pq.poll();
            }
        }
        System.out.println(pq.size());
    }
}