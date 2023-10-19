package swea.d3;

import java.io.FileInputStream;
import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

public class 영준이의카드카운팅 {

    public static void main(String args[]) throws Exception {
        System.setIn(new FileInputStream("C:\\Users\\82109\\Desktop\\정훈\\알고리즘 공부\\Algorithm_Java\\swea\\d3\\input.txt"));
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
//        T = 10;
        for (int test_case = 1; test_case <= T; test_case++) {

            String str = sc.next();
            HashSet<String> hashSet = new HashSet<>();
            HashMap<Character,Integer> hashMap =new HashMap<>();
            hashMap.put('S',13);
            hashMap.put('D',13);
            hashMap.put('H',13);
            hashMap.put('C',13);

            int len = str.length();
            for(int i=0;i<len;i+=3){
                char c =str.charAt(i);
                hashSet.add(str.substring(i,i+3));
                hashMap.put(c,hashMap.get(c)-1);
            }
            System.out.print("#"+test_case+" ");
            if(hashSet.size()!=len/3){
                System.out.print("ERROR");
            }
            else{
                System.out.print(hashMap.get('S')+" ");
                System.out.print(hashMap.get('D')+" ");
                System.out.print(hashMap.get('H')+" ");
                System.out.print(hashMap.get('C')+" ");
            }
            System.out.println();
        }
    }
}