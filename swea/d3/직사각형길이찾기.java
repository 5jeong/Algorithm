package swea.d3;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Scanner;

public class 직사각형길이찾기 {

    public static void main(String args[]) throws Exception {
//        System.setIn(new FileInputStream("C:\\Users\\82109\\Desktop\\정훈\\알고리즘 공부\\Algorithm_Java\\swea\\d3\\input.txt"));
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();
//        T=10;
        for (int test_case = 1; test_case <= T; test_case++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            HashMap<Integer,Integer> hashMap = new HashMap<>();
            hashMap.put(a,hashMap.getOrDefault(a,0)+1);
            hashMap.put(b,hashMap.getOrDefault(b,0)+1);
            hashMap.put(c,hashMap.getOrDefault(c,0)+1);
            int ans = 0;
            for(int x : hashMap.keySet()){
                if(hashMap.get(x)==1){
                    ans = x;
                }
                if(hashMap.get(x)==3){
                    ans = x;
                }
            }
            System.out.println("#"+test_case+" " +ans);

        }
    }
}
