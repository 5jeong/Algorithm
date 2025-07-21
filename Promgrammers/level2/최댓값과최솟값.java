package Promgrammers.level2;

import java.util.ArrayList;
import java.util.List;

public class 최댓값과최솟값 {
    public String solution(String s) {
        String answer = "";
        String[] split = s.split(" ");

        StringBuilder sb = new StringBuilder();

        List<Integer> nums = new ArrayList<>();
        for (String x : split) {
            nums.add(Integer.parseInt(x));
        }

        nums.sort((a, b) -> a - b);

        sb.append(nums.get(0)).append(" ").append(nums.get(nums.size() - 1));
        return sb.toString();
    }
}
