package algorithmStudy.해쉬and정렬지원set;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String t = br.readLine();
        HashMap<Character,Integer> s_Map = new HashMap<>();
        HashMap<Character,Integer> t_Map = new HashMap<>();
        for(char x : t.toCharArray()){
            t_Map.put(x,t_Map.getOrDefault(x,0)+1);
        }
        for(int i=0;i<t.length();i++){
            s_Map.put(s.charAt(i),s_Map.getOrDefault(s.charAt(i),0)+1);
        }
        int ans=0;
        if(s_Map.equals(t_Map)){
            ans++;
        }
        int lt =0;
        for(int rt=t.length();rt<s.length();rt++){
            s_Map.put(s.charAt(rt),s_Map.getOrDefault(s.charAt(rt),0)+1);
            s_Map.put(s.charAt(lt),s_Map.get(s.charAt(lt))-1);
            if(s_Map.get(s.charAt(lt))==0){
                s_Map.remove(s.charAt(lt));
            }
            lt++;
            if(s_Map.equals(t_Map)){
                ans++;
            }
        }
        System.out.println(ans);
    }
}
