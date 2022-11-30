package baekjoon;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class baekjoon_6996 {

    private static boolean solveAnagrams(String first, String second ) {
        HashMap<Character, Integer> map=new HashMap<>();
        HashMap<Character, Integer> map2=new HashMap<>();
        for(char x : first.toCharArray()){
            map.put(x, map.getOrDefault(x, 0)+1);
        }
        for(char x : second.toCharArray()){
            map2.put(x,map2.getOrDefault(x,0)+1);
        }
        for(char key : map.keySet()){
            if(map.get(key) != map2.get(key)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numTests = sc.nextInt();

        for (int i = 0; i < numTests; i++) {
            String first = sc.next().toLowerCase();
            String second = sc.next().toLowerCase();

            System.out.println(first + " & " + second + " are " + (solveAnagrams(first, second) ? "anagrams." : "NOT anagrams."));
        }
    }
}

