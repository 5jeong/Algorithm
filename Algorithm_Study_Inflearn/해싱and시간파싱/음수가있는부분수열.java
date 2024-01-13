package Algorithm_Study_Inflearn.해싱and시간파싱;

import java.util.HashMap;

public class 음수가있는부분수열 {
    public static int solution(int[] nums, int m) {
        int answer = 0;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(0, 1);
        int sum = 0;
        for (int x : nums) {
            sum += x;
            if (hashMap.containsKey(sum - m)) {
                answer += hashMap.get(sum - m);
            }
            hashMap.put(sum, hashMap.getOrDefault(sum, 0) + 1);
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{2, 2, 3, -1, -1, -1, 3, 1, 1}, 5));
        System.out.println(solution(new int[]{1, 2, 3, -3, 1, 2, 2, -3}, 5));
        System.out.println(solution(new int[]{1, 2, 3, -3, 1, 2}, 3));
        System.out.println(solution(new int[]{-1, 0, 1}, 0));
        System.out.println(solution(new int[]{-1, -1, -1, 1}, 0));
    }
}
