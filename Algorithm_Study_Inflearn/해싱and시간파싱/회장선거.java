package Algorithm_Study_Inflearn.해싱and시간파싱;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class 회장선거 {
    public  static String solution(String[] votes, int k){
        String answer = " ";
        int  n = votes.length;
        HashMap<String,Integer> cnt = new HashMap<>();
        String[] arr1 = new String[n];
        String[] arr2 = new String[n];
        for(int i=0;i<n;i++){
            String temp[] = votes[i].split(" ");
            arr1[i] = temp[0];
            arr2[i] = temp[1];
        }

        for(String x : arr2){
            cnt.put(x,cnt.getOrDefault(x,0)+1);
        }
        HashMap<String,Integer> gift = new HashMap<>();
        ArrayList<String> candidate = new ArrayList<>();
        for(String x : cnt.keySet()){
            if(cnt.get(x) >=k){
                candidate.add(x);
            }
        }

        for(int i=0;i<n;i++){
            for(String x : candidate){
                if(arr2[i].equals(x)){
                    gift.put(arr1[i],gift.getOrDefault(arr1[i],0)+1);
                    break;
                }
            }
        }
        int a =Integer.MIN_VALUE;
        ArrayList<String> ans = new ArrayList<>();
        for(String x : gift.keySet()){
            a = Math.max(a,gift.get(x));
        }

        for(String x : gift.keySet()){
            if(a == gift.get(x)){
                ans.add(x);
            }
        }
        Collections.sort(ans);
        answer = ans.get(0);
        return answer;
    }

    public static void main(String[] args){
        System.out.println(solution(new String[]{"john tom", "daniel luis", "john luis", "luis tom", "daniel tom", "luis john"}, 2));
        System.out.println(solution(new String[]{"john tom", "park luis", "john luis", "luis tom", "park tom", "luis john", "luis park", "park john", "john park", "tom john", "tom park", "tom luis"}, 2));
        System.out.println(solution(new String[]{"cody tom", "john tom", "cody luis", "daniel luis", "john luis", "luis tom", "daniel tom", "luis john"}, 2));
        System.out.println(solution(new String[]{"bob tom", "bob park", "park bob", "luis park", "daniel luis", "luis bob", "park luis", "tom bob", "tom luis", "john park", "park john"}, 3));
    }

}
