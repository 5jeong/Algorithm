package baekjoon.silver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

//베스트 셀러
public class Baekjoon_1302 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n =sc.nextInt();
        Map<String,Integer> map = new HashMap<>();
        int max=0;
        for(int i=0;i<n;i++){
            String s = sc.next();
            map.put(s,map.getOrDefault(s,0)+1);
            max = Math.max(max,map.get(s));
        }

        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for(String x : map.keySet()){
            if(map.get(x)==max){
                res.add(x);
            }
        }
        Collections.sort(res);
        System.out.println(res.get(0));
    }
}
