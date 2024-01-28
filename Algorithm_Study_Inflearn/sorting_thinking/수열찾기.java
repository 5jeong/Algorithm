package Algorithm_Study_Inflearn.sorting_thinking;

import java.util.Arrays;
import java.util.HashMap;

public class 수열찾기 {
    public static int[] solution(int[] nums) {
        int[] answer = new int[nums.length / 2];
//        LinkedList<Integer> temp = new LinkedList<>();
//        for(int x : nums){
//            temp.add(x);
//        }
//        ArrayList<Integer> res = new ArrayList<>();
//        Collections.sort(temp);
//        for(int x : temp){
//            if(temp.contains(x*2)){
//                res.add(x);
//            }
//        }
//        for(int i=0;i<answer.length;i++){
//            answer[i] = res.get(i);
//        }
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int x : nums) {
            hashMap.put(x, hashMap.getOrDefault(x, 0) + 1);
        }
        Arrays.sort(nums);
        int idx = 0;
        for (int x : nums) {
            if (hashMap.get(x) == 0) {
                continue;
            }
            answer[idx] = x;
            idx++;
            hashMap.put(x, hashMap.get(x) - 1);
            hashMap.put(x * 2, hashMap.get(x * 2) - 1);
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{1, 10, 2, 3, 5, 6})));
        System.out.println(Arrays.toString(solution(new int[]{1, 1, 6, 2, 2, 7, 3, 14})));
        System.out.println(Arrays.toString(solution(new int[]{14, 4, 2, 6, 3, 10, 10, 5, 5, 7, 7, 14})));
    }
}
