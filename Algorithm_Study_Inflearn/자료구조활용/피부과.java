package Algorithm_Study_Inflearn.자료구조활용;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class 피부과 {
    static int getTime(String time){
        int H = Integer.parseInt(time.split(":")[0]) * 60;
        int M = Integer.parseInt(time.split(":")[1]);
        return H+M;
    }
    public static int solution(int[] laser, String[] enter){
        int answer = 0;
        int n =  enter.length;
        int[][] inList = new int[n][2];
        for(int i=0;i<n;i++){
            int a = getTime(enter[i].split(" ")[0]);
            int b = Integer.parseInt(enter[i].split(" ")[1]);
            inList[i][0]=a;
            inList[i][1]=b;
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(inList[0][1]);
        int ft = inList[0][0];
        int pos=1; // 고객
        for(int t=ft;t<1200;t++){
            if(pos < n && t == inList[pos][0] ){
                if(!queue.isEmpty() && t > ft){
                    ft = t;
                }
                queue.offer(inList[pos][1]);
                pos++;
            }
            if(t == ft && !queue.isEmpty()){
                int idx = queue.poll();
                ft += laser[idx];
            }
            answer = Math.max(answer,queue.size());
        }
        return answer;
    }

    public static void main(String[] args){
        System.out.println(solution(new int[]{30, 20, 25, 15}, new String[]{"10:23 0", "10:40 3", "10:42 2", "10:52 3", "11:10 2"}));
        System.out.println(solution(new int[]{30, 20, 25, 15}, new String[]{"10:23 0", "10:40 3", "10:42 2", "10:52 3", "15:10 0", "15:20 3", "15:22 1", "15:23 0", "15:25 0"}));
        System.out.println(solution(new int[]{30, 20, 25, 15}, new String[]{"10:20 1", "10:40 1", "11:00 1", "11:20 1", "11:40 1"}));
    }
    // 내 풀이 시간복잡도 O(n^2) 쓰레기
    /*
    static int getTime(String time){
        int H = Integer.parseInt(time.split(":")[0]) * 60;
        int M = Integer.parseInt(time.split(":")[1]);
        return H+M;
    }
    public static int solution(int[] laser, String[] enter){

        int answer = 0;
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> info = new ArrayList<>();
        for(String x : enter){
            int t = getTime(x.split(" ")[0]);
            int n = Integer.parseInt(x.split(" ")[1]);
            info.add(laser[n]);
            queue.add(t);
        }
        int idx = 0;
        while(!queue.isEmpty()){
            int temp = queue.poll() + info.get(idx);
            int res = 0;
            for(int x : queue){
                if(temp > x){
                    res++;
                }
                else break;
            }
            answer = Math.max(answer,res);
            idx++;
        }

        return answer;
    }

    public static void main(String[] args){
        System.out.println(solution(new int[]{30, 20, 25, 15}, new String[]{"10:23 0", "10:40 3", "10:42 2", "10:52 3", "11:10 2"}));
        System.out.println(solution(new int[]{30, 20, 25, 15}, new String[]{"10:23 0", "10:40 3", "10:42 2", "10:52 3", "15:10 0", "15:20 3", "15:22 1", "15:23 0", "15:25 0"}));
        System.out.println(solution(new int[]{30, 20, 25, 15}, new String[]{"10:20 1", "10:40 1", "11:00 1", "11:20 1", "11:40 1"}));
    }
    */
}
