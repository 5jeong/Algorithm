package algorithmStudy.해쉬and정렬지원set;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.*;

public class 아나그램 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = br.readLine();
        String str2 = br.readLine();
        String ans = "YES";
        HashMap<Character, Integer> hashMap1 = new HashMap<>();
//        HashMap<Character, Integer> hashMap2 = new HashMap<>();
        for (char x : str1.toCharArray()) {
            hashMap1.put(x,hashMap1.getOrDefault(x,0)+1);
        }
//        for (char x : str2.toCharArray()) {
//            hashMap2.put(x,hashMap2.getOrDefault(x,0)+1);
//        }
        for(char x : str2.toCharArray()){
            if(!hashMap1.containsKey(x) || hashMap1.get(x)==0){
                System.out.println("NO");
                return;
            }
            hashMap1.put(x,hashMap1.get(x)-1);
        }
        System.out.println(ans);
    }
}
