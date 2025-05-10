package softeer.lv2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GPT식숫자비교 {
    static class Number {
        int left, right;

        Number(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] nums = new String[n];
        List<Number> numbers = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            nums[i] = sc.next();
            if (nums[i].contains(".")) {
                int left = Integer.parseInt(nums[i].split("\\.")[0]);
                int right = Integer.parseInt(nums[i].split("\\.")[1]);
                numbers.add(new Number(left, right));
            } else {
                int left = Integer.parseInt(nums[i]);
                numbers.add(new Number(left, -1));
            }
        }

        numbers.sort((a, b) -> a.left == b.left ? a.right - b.right : a.left - b.left);

        for (Number x : numbers) {
            System.out.println(x.right == -1 ? x.left : x.left + "." + x.right);
        }
    }
}
