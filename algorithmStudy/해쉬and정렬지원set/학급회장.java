package algorithmStudy.해쉬and정렬지원set;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class 학급회장 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String str = br.readLine();
        char ans=' ';
        int max = Integer.MIN_VALUE;
        HashMap<Character,Integer> map = new HashMap<>();
        for(char x : str.toCharArray()){
            map.put(x,map.getOrDefault(x,0)+1);
        }
        for(char x : map.keySet()){
            if(max < map.get(x)){
                max = map.get(x);
                ans = x;
            }
        }
        System.out.println(ans);
    }
}
