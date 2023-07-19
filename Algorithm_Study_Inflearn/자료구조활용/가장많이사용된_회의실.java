package Algorithm_Study_Inflearn.자료구조활용;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class 가장많이사용된_회의실 {
    public static int solution(int n, int[][] meetings){
        int answer = 0;
        int l = meetings.length;
        int[] res = new int[n];
        TreeSet<Integer> rooms = new TreeSet<>(); // TreeSet 자료구조는 자동으로 오름차순 정렬
        for(int i=0;i<n;i++){
            rooms.add(i);
        }
        Arrays.sort(meetings,(a,b)-> a[0] - b[0]);  // 시간시작순서대로 정렬
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> a[0]==b[0] ? a[1] - b[1] : a[0] - b[0] );
        for(int[] x  : meetings){
            while(!pq.isEmpty() && pq.peek()[0] <= x[0]){
                rooms.add(pq.poll()[1]);
            }
            if(!rooms.isEmpty()){
                int room = rooms.pollFirst();
                res[room]++;
                pq.add(new int[]{x[1],room});
            }
            else{
                int[] temp = pq.poll();
                res[temp[1]]++;
                pq.add(new int[]{temp[0]+(x[1]-x[0]),temp[1]});
            }
        }
        int idx=0;
        for(int i=0;i<n;i++){
            if(res[i] > idx){
                idx = res[i];
                answer=i;
            }

        }
        return answer;
    }

    public static void main(String[] args){
        System.out.println(solution(2, new int[][]{{0, 5}, {2, 7}, {4, 5}, {7, 10}, {9, 12}}));
        System.out.println(solution(3, new int[][]{{3, 9}, {1, 10}, {5, 8}, {10, 15}, {9, 14}, {12, 14}, {15, 20}}));
        System.out.println(solution(3, new int[][]{{1, 30}, {2, 15}, {3, 10}, {4, 12}, {6, 10}}));
        System.out.println(solution(4, new int[][]{{3, 20}, {1, 25}, {5, 8}, {10, 15}, {9, 14}, {12, 14}, {15, 20}}));
    }
}