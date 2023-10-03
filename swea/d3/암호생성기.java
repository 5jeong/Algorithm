package swea.d3;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 암호생성기 {


    public static void main(String args[]) throws Exception
    {
        System.setIn(new FileInputStream("C:\\Users\\82109\\Desktop\\정훈\\알고리즘 공부\\Algorithm_Java\\swea\\d3\\input.txt"));
        Scanner sc = new Scanner(System.in);
        int T;
        T=10;

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int n = sc.nextInt();
            Queue<Integer> queue = new LinkedList<>();
            for(int i=0;i<8;i++){
                int a = sc.nextInt();
                queue.add(a);
            }
            int cnt=1;
            while(!queue.isEmpty()){

                if(cnt==6){
                    cnt=1;
                }
                int temp = queue.poll();
                temp -=cnt;
                if(temp <=0){
                    temp=0;
                    queue.add(temp);
                    break;
                }
                cnt++;
                queue.add(temp);
            }

            System.out.print("#"+n+" ");
            for(int x : queue){
                System.out.print(x+" ");
            }
            System.out.println();
        }
    }
}
