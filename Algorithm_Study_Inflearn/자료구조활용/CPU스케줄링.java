package Algorithm_Study_Inflearn.자료구조활용;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class CPU스케줄링 {
    public  static int[] solution(int[][] tasks){
        int[] answer;
        int n = tasks.length;
        answer=new int[n];
        LinkedList<int[]> programs = new LinkedList<>();
        for(int i=0;i<n;i++){
            programs.add(new int[]{tasks[i][0],tasks[i][1],i});
        }
        programs.sort((a,b) -> a[0]-b[0]); // 호출시간순으로 정렬
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0]==b[0] ? a[1]-b[1] : a[0] -b[0]);
        int fT = 0,idx=0;
        while(!pq.isEmpty() || !programs.isEmpty()){
            if(pq.isEmpty()){
                fT = Math.max(fT,programs.peek()[0]);
            }
            while(!programs.isEmpty() && programs.peek()[0] <= fT){
                int[] x = programs.pollFirst();
                pq.add(new int[]{x[1],x[2]});
            }
            int[] temp = pq.poll();
            fT += temp[0];
            answer[idx++] = temp[1];
        }
        return answer;
    }
    public static void main(String[] args){
        System.out.println(Arrays.toString(solution(new int[][]{{2, 3}, {1, 2}, {8, 2}, {3, 1}, {10, 2}})));
        System.out.println(Arrays.toString(solution(new int[][]{{5, 2}, {7, 3}, {1, 3}, {1, 5}, {2, 2}, {1, 1}})));
        System.out.println(Arrays.toString(solution(new int[][]{{1, 2}, {2, 3}, {1, 3}, {3, 3}, {8, 2}, {1, 5}, {2, 2}, {1, 1}})));
        System.out.println(Arrays.toString(solution(new int[][]{{999, 1000}, {996, 1000}, {998, 1000}, {999, 7}})));
    }

}
