package Algorithm_Study_Inflearn.BFS;

import Algorithm_Study_Inflearn.해싱and시간파싱.Solution;

import javax.swing.plaf.PanelUI;
import java.util.LinkedList;
import java.util.Queue;

public class 집으로이동 {
    public static class location{
        int x;
        int distance;
        location(int x,int distance){
            this.x=x;
            this.distance=distance;
        }
    }
    public static int solution(int[] pool, int a, int b, int home){
        int answer = 0;
        int[] dx = {a,-b};

        Queue<location> queue = new LinkedList<>();
        int L=0;
        queue.add(new location(0,0));
        int[][] ch = new int[2][10001];
        for(int x : pool){
            ch[0][x] = 1;
            ch[1][x] = 1;
        }
        while(!queue.isEmpty()){

            int len = queue.size();
            for(int i=0;i<len;i++) {
                location temp = queue.poll();
                for(int j=0;j<2;j++){
                    int nx = temp.x + dx[j];
                    if(j==0 && nx<=10001 && ch[0][nx]==0 ){
                        ch[0][nx]=1;
                        queue.offer(new location(nx,0));
                    }
                    if(j==1 && nx>=0 && ch[1][nx]==0 && temp.distance != 1){
                        ch[1][nx]=1;
                        queue.offer(new location(nx,1));
                    }
                    if(nx == home){
                        return L+1;
                    }
                }
            }
            L++;
        }

        return -1;
    }

    public static void main(String[] args){
        System.out.println(solution(new int[]{11, 7, 20}, 3, 2, 10));
        System.out.println(solution(new int[]{1, 15, 11}, 3, 2, 5));
        System.out.println(solution(new int[]{9, 15, 35, 30, 20}, 2, 1, 25));
        System.out.println(solution(new int[]{5, 12, 7, 19, 23}, 3, 5, 18));
        System.out.println(solution(new int[]{10, 15, 20}, 3, 2, 2));
    }
}
