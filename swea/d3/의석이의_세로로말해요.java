package swea.d3;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class 의석이의_세로로말해요 {
    public static void main(String args[]) throws Exception {
//        System.setIn(new FileInputStream("C:\\Users\\82109\\Desktop\\정훈\\알고리즘 공부\\Algorithm_Java\\swea\\d3\\input.txt"));

        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            ArrayList<String> arrayList = new ArrayList<>();
            int max_len=0;
            String ans="";
            for(int i=0;i<5;i++){
                String str = sc.next();
                max_len = Math.max(max_len,str.length());
                arrayList.add(str);
            }
            for(int i=0;i<max_len;i++){
                for(int j=0;j<5;j++){
                    if(arrayList.get(j).length() >= i+1){
                        ans+=arrayList.get(j).charAt(i);
                    }
                }
            }
            System.out.println("#"+test_case+" "+ans);
        }
    }
}