package baekjoon.silver;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Baekjoon_1927 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<n;i++){
            int num = sc.nextInt();
            if(num == 0 ){
                if(pq.isEmpty()){
                    sb.append(0).append("\n");
                    continue;
                }
                sb.append(pq.poll()).append("\n");
            }else{
                pq.offer(num);
            }
        }
        System.out.println(sb);
    }
}
