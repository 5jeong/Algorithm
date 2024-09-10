package Promgrammers.level0;


import java.util.HashMap;

// 기울기를 Hashmap에 저장
// 모든 경우의수 판단
// map의 value가 2개가 되는 경우 1 리턴
public class 평행 {
    public static int solution(int[][] dots) {
        HashMap<Double, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < 4; i++) {
            for (int j = i + 1; j < 4; j++) {
                double temp = calculate(dots[i], dots[j]);
                System.out.println(temp);
                hashMap.put(temp, hashMap.getOrDefault(temp, 0) + 1);
                if (hashMap.get(temp) == 2) {
                    return 1;
                }
            }
        }
        return 0;
    }

    // 기울기 계산
    private static double calculate(int[] a, int[] b) {
        return (double) (a[1] - b[1]) / (a[0] - b[0]);
    }

    public static void main(String[] args) {
        solution(new int[][]{{1, 4}, {9, 2}, {3, 8}, {11, 6}});
    }
}
