package algorithmStudy.해쉬and정렬지원set;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int n= Integer.parseInt(br.readLine());
        String str = br.readLine();
        char ans = ' ';
        HashMap<Character,Integer> hashMap = new HashMap<>();
        for(char x : str.toCharArray()){
            hashMap.put(x, hashMap.getOrDefault(x,0)+1);
        }
        int temp = Integer.MIN_VALUE;
        for(char x : hashMap.keySet()){
            if(temp < hashMap.get(x)){
                temp = hashMap.get(x);
                ans = x;
            }
//            System.out.println("key : "+ x + " value : "+ hashMap.get(x));
        }
        System.out.println(ans);
    }
}
