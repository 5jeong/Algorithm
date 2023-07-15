package Algorithm_Study_Inflearn.자료구조활용;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int getTime(String time){
        int H = Integer.parseInt(time.split(":")[0]);
        int M = Integer.parseInt(time.split(":")[1]);
        return H*60+M;
    }
    public int solution(int[] laser, String[] enter){
        int answer = 0;
        int n = enter.length;
        int[][] inList = new int[n][2];
        for(int i = 0; i < n; i++){
            int a = getTime(enter[i].split(" ")[0]);
            int b = Integer.parseInt(enter[i].split(" ")[1]);
            inList[i][0] = a;
            inList[i][1] = b;
        }
        Queue<Integer> Q = new LinkedList<>();
        Q.offer(inList[0][1]);
        int fT = inList[0][0];
        int pos = 1;
        for(int t = fT; t <= 1200; t++){
            if(pos < n && t == inList[pos][0]){
                if(Q.isEmpty() && inList[pos][0] > fT) fT= inList[pos][0];
                Q.offer(inList[pos][1]);
                pos++;
            }
            if(t == fT && !Q.isEmpty()){
                int idx = Q.poll();
                fT += laser[idx];
            }
            answer = Math.max(answer, Q.size());
        }
        return answer;
    }

    public static void main(String[] args){
        long beforeTime = System.currentTimeMillis(); // 코드 실행 전에 시간 받아오기

        Solution T = new Solution();
        System.out.println(T.solution(new int[]{30, 20, 25, 15}, new String[]{"10:23 0", "10:40 3", "10:42 2", "10:52 3", "11:10 2"}));
        System.out.println(T.solution(new int[]{30, 20, 25, 15}, new String[]{"10:23 0", "10:40 3", "10:42 2", "10:52 3", "15:10 0", "15:20 3", "15:22 1", "15:23 0", "15:25 0"}));
        System.out.println(T.solution(new int[]{30, 20, 25, 15}, new String[]{"10:20 1", "10:40 1", "11:00 1", "11:20 1", "11:40 1"}));
        long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
        long diffTime = (afterTime - beforeTime) / 1000; // 두 개의 실행 시간
        System.out.println("실행 시간(ms): " + diffTime); // 세컨드(초 단위 변환)
    }
}