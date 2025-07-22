package Promgrammers.level2;

/**
 * 유클리드 호제법
 */
public class N개의최소공배수 {
    public int solution(int[] arr) {
        int answer = arr[0];
        for (int i = 1; i < arr.length; i++) {
            answer = lcm(answer, arr[i]);
        }
        return answer;
    }

    // 최대 공약수
    private int gcd(int num1, int num2) {
        if (num2 == 0) {
            return num1;
        }
        return gcd(num2, num1 % num2);
    }

    // 최소 공배수
    private int lcm(int num1, int num2) {
        return num1 * num2 / gcd(num1, num2);
    }
}
