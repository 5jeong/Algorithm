package baekjoon;

import java.io.*;
import java.util.Arrays;
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

        Arrays.sort(str);
        Arrays.sort(str, Comparator.comparing(String::length));

        System.out.println(str[0]);
        for(int i=1;i<a;i++){
            if(!str[i].equals(str[i-1])){
                System.out.println(str[i]);
            }
        }
    }
}
