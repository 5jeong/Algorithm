package algorithmStudy.문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String str = st.nextToken();
        String t = st.nextToken();
        ArrayList<Integer> temp = new ArrayList<>();
        int[] ans = new int[str.length()];
        char c = t.charAt(0);
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)==c){
                temp.add(i);
            }
        }
        for(int i=0;i<str.length();i++){
            int k = Integer.MAX_VALUE;
            for(int x : temp){
                k = Math.min(k,Math.abs(x-i));
            }
            ans[i]=k;
        }
        for(int x : ans){
            System.out.print(x+" ");
        }
    }
}
