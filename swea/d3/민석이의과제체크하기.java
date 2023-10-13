package swea.d3;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class 민석이의과제체크하기 {
    public static void main(String args[]) throws Exception {
        System.setIn(new FileInputStream("C:\\Users\\82109\\Desktop\\정훈\\알고리즘 공부\\Algorithm_Java\\swea\\d3\\input.txt"));
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            ArrayList<Integer> arrayList = new ArrayList<>();
            int[] temp = new int[k];
            for(int i=0;i<k;i++){
                temp[i] = sc.nextInt();
            }
            game:for(int i=1;i<=n;i++){
                for(int j=0;j<k;j++){
                    if(i==temp[j]){
                        continue game;
                    }
                }
                arrayList.add(i);
            }
            System.out.print("#"+ test_case+" ");
            for(int x : arrayList){
                System.out.print(x+" ");
            }
            System.out.println();


        }
    }
}