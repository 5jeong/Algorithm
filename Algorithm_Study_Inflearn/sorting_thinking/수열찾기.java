package Algorithm_Study_Inflearn.sorting_thinking;

import Algorithm_Study_Inflearn.해싱and시간파싱.Solution;

import java.util.*;

public class 수열찾기 {
    public static int[] solution(int[] nums){
        int n = nums.length;
        int[] answer = new int[n / 2];
//        HashMap<Integer,Integer> hashMap = new HashMap<>();
//        Arrays.sort(nums);
//        for(int x : nums){
//            hashMap.put(x,hashMap.getOrDefault(x,0)+1);
//        }
//        int idx=0;
//        for(int x :nums){
//            if(hashMap.get(x)==0) continue;
//            answer[idx] = x;
//            idx++;
//            hashMap.put(x,hashMap.get(x)-1);
//            hashMap.put(x*2,hashMap.get(x*2)-1);
//        }
//        리스트 방식
        ArrayList<Integer> ans = new ArrayList<>();
        for(int x : nums){
            ans.add(x);
        }
        Collections.sort(ans);
        for(int x : nums){
            for(int i=0;i<ans.size();i++){
                if(x*2 == ans.get(i)){
                    ans.remove(i);
                    break;
                }
            }
        }
        for(int i=0;i<n/2;i++){
            answer[i] = ans.get(i);
        }
        return answer;
    }

    public static void main(String[] args){
        System.out.println(Arrays.toString(solution(new int[]{1, 10, 2, 3, 5, 6})));
        System.out.println(Arrays.toString(solution(new int[]{1, 1, 6, 2, 2, 7, 3, 14})));
        System.out.println(Arrays.toString(solution(new int[]{14, 4, 2, 6, 3, 10, 10, 5, 5, 7, 7, 14})));
    }
}
