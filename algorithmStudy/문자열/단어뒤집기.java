package algorithmStudy.문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class 단어뒤집기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] str = new String[n];
        for(int i =0;i<n;i++){
            str[i] = br.readLine();
        }
        ArrayList<String> arr = new ArrayList<>();
        for(String x : str){
            char[] s = x.toCharArray();
            int lt=0,rt=x.length()-1;
            while(lt < rt){
                char tmp = s[lt];
                s[lt] = s[rt];
                s[rt] = tmp;
                lt++;
                rt--;
            }
            arr.add(String.valueOf(s));
        }
        for(int i=0;i<n;i++){
            System.out.println(arr.get(i));
        }
    }
}
