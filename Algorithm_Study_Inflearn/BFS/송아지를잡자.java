package Algorithm_Study_Inflearn.BFS;

import Algorithm_Study_Inflearn.해싱and시간파싱.Solution;

import java.util.LinkedList;
import java.util.Queue;

public class 송아지를잡자 {

    public static int solution(int s, int e){
        Queue<Integer> queue = new LinkedList<>();
        int[][] ch = new int[2][200001];
        queue.add(s);
        ch[0][s] =1;
        int L=0;
        while(!queue.isEmpty()){
            int len = queue.size();
            L++;
            for(int i=0;i<len;i++){
                int temp = queue.poll();
                for(int nx : new int[]{temp+1,temp-1,temp*2}){
                    if(nx>=0 && nx <=200000 && ch[L%2][nx]==0){
                        ch[L%2][nx]=1;
                        queue.offer(nx);
                    }
                }
            }
            e+=L;
            if(e>200000) return -1;
            if(ch[L%2][e] ==1) {
                return L;
            }
        }
        return -1;
    }

    public static void main(String[] args){
        System.out.println(solution(1, 11));
        System.out.println(solution(10, 3));
        System.out.println(solution(1, 34567));
        System.out.println(solution(5, 6));
        System.out.println(solution(2, 54321));
    }
}
