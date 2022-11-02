package baekjoon;

import java.io.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class baekjoon_1181 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String n = br.readLine();
        int a = Integer.parseInt(n);
        String[] str = new String[a];
        String[] t = new String[a];
        for(int i=0;i<a;i++){
            str[i] = br.readLine();
        }

        Arrays.sort(str, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                // 단어 길이가 같을 경우
//                if (s1.length() == s2.length()){
                    return s1.compareTo(s2);    // 사전 순 정렬(양수면 바뀐다, 음수,0 이면 그대로)
//                }

            // 그 외의 경우
//		        else{
//                return s1.length() - s2.length(); //사전 순 정렬(양수면 바뀐다, 음수,0 이면 그대로)
//            }
        }
    });
//        Arrays.sort(str);
//        Arrays.sort(str, Comparator.comparing(String::length).reversed());

        System.out.println(str[0]);
        for(int i=1;i<a;i++){
            if(!str[i].equals(str[i-1])){
                System.out.println(str[i]);
            }
        }
    }
}
