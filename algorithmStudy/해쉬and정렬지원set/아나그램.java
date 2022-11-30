package algorithmStudy.해쉬and정렬지원set;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.*;

public class 아나그램 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        String b = br.readLine();
        String ans ="YES";
        HashMap<Character,Integer> a_map = new HashMap<>();
        HashMap<Character,Integer> b_map = new HashMap<>();

        for(char x : a.toCharArray()){
            a_map.put(x,a_map.getOrDefault(x,0)+1);
        }
        for(char x : b.toCharArray()){
            b_map.put(x,b_map.getOrDefault(x,0)+1);
        }
        for(char key : a_map.keySet()){
            if(a_map.get(key) != b_map.get(key)){
                ans = "NO";
            }
        }
        System.out.println(ans);

    }
}
