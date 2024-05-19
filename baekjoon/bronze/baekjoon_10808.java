package baekjoon.bronze;

import java.util.Scanner;

public class baekjoon_10808 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int[] ans = new int[26];
        for(char x : str.toCharArray()){
            ans[(int)x - 97]++;
        }
        for(int x : ans){
            System.out.print(x+" ");
        }
    }
}
