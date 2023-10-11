package swea.d3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class 암호문3 {

    public static void main(String args[]) throws Exception {
//        System.setIn(new FileInputStream("C:\\Users\\82109\\Desktop\\정훈\\알고리즘 공부\\Algorithm_Java\\swea\\d3\\input.txt"));
        Scanner sc = new Scanner(System.in);
        int T;
//        T=sc.nextInt();
        T=10;
        for (int test_case = 1; test_case <= T; test_case++) {
            LinkedList<Integer> linkedList = new LinkedList<>();
            int n = sc.nextInt();
            for(int i=0;i<n;i++){
                linkedList.add(sc.nextInt());
            }
            int cnt = sc.nextInt();


            for(int i=0;i<cnt;i++){
                char c = sc.next().charAt(0);
                if(c=='I'){
                    int x = sc.nextInt();
                    int y = sc.nextInt();
                    int temp = x+y;
                    for(int j=x;j<temp;j++) {
                        linkedList.add(j, sc.nextInt());
                    }
                }
                if(c=='D'){
                    int x = sc.nextInt();
                    int y = sc.nextInt();
                    int temp = x+y;
                    for(int j=x;j<temp;j++){
                        linkedList.remove(x);
                    }
                }
                if(c=='A'){
                    int y = sc.nextInt();
                    for(int j=0;j<y;j++){
                        linkedList.add(sc.nextInt());
                    }

                }
            }
            System.out.print("#"+ test_case+" ");
            for(int i=0;i<10;i++){
                System.out.print(linkedList.get(i)+" ");
            }
            System.out.println();


        }
    }
}