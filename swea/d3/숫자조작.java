package swea.d3;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

public class 숫자조작 {

    public static void main(String args[]) throws Exception {
        System.setIn(new FileInputStream("C:\\Users\\82109\\Desktop\\정훈\\알고리즘 공부\\Algorithm_Java\\swea\\d3\\input.txt"));
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
//        T = 10;
        for (int test_case = 1; test_case <= T; test_case++) {
            String n = sc.next();
            char[] num = n.toCharArray();
            int max = Integer.parseInt(n);
            int min = max;
            for(int i=0;i<n.length()-1;i++){
                for(int j=i+1;j<n.length();j++){
                    char temp = num[i];
                    num[i] = num[j];
                    num[j] = temp;
                    int t = Integer.valueOf(String.valueOf(num));
                    if(num[0]!='0' && t > max){
                        max = t;
                    }
                    if(num[0]!='0' && t < min){
                        min = t;
                    }
                    temp = num[j];
                    num[j] = num[i];
                    num[i] = temp;
                }
            }
            System.out.println("#"+test_case+" "+ min+" "+max);
        }
    }
}