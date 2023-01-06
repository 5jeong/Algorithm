package algorithmStudy.해쉬and정렬지원set;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class 모든아나그램찾기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String t = br.readLine();
        int ans=0;
        int L = t.length() - 1;
        HashMap<Character, Integer> s_map = new HashMap<>();
        HashMap<Character,Integer> t_map = new HashMap<>();
        for(int i=0;i<L;i++){
            s_map.put(s.charAt(i),s_map.getOrDefault(s.charAt(i),0)+1);
        }
        for (char x : t.toCharArray()) {
            t_map.put(x, t_map.getOrDefault(x, 0) + 1);
        }
        int lt=0;
        for(int rt = L;rt<s.length();rt++){
            s_map.put(s.charAt(rt),s_map.getOrDefault(s.charAt(rt),0)+1);
            if(s_map.equals(t_map)) ans++;
            s_map.put(s.charAt(lt),s_map.get(s.charAt(lt))-1);
            if(s_map.get(s.charAt(lt))==0){
                s_map.remove(s.charAt(lt));
            }
            lt++;
        }
        System.out.println(ans);
    }
}