package Algorithm_Study_Inflearn.시뮬레이션and구현;

public class 과일가져가기 {
    public static int solution(int[][] fruit) {
        int answer = 0;
        int n = fruit.length;
        int[] check = new int[n];
        for (int i = 0; i < n; i++) {
            if (check[i] == 1) {
                continue;
            }
            if (!isUnique(fruit[i])) {
                continue;
            }
            for (int j = i + 1; j < n; j++) {
                if (!isUnique(fruit[j])) {
                    continue;
                }
                int minIdx = getMinIdx(fruit[i]);
                int minIdx2 = getMinIdx(fruit[j]);
                if (minIdx != minIdx2 && fruit[i][minIdx] > 0 && fruit[j][minIdx2] > 0) {
                    if (check[j] == 1) {
                        continue;
                    }
                    if (fruit[i][minIdx] + 1 <= fruit[i][minIdx2] - 1
                            && fruit[j][minIdx] - 1 >= fruit[j][minIdx2] + 1) {
                        fruit[i][minIdx]++;
                        fruit[i][minIdx2]--;
                        fruit[j][minIdx]--;
                        fruit[j][minIdx2]++;
                        check[i] = 1;
                        check[j] = 1;
                        break;
                    }
                }
            }
        }
        for (int[] x : fruit) {
            answer += getMin(x);
        }
        return answer;
    }

    static boolean isUnique(int[] arr) {
        int cnt = 0;
        int min = getMin(arr);
        for (int x : arr) {
            if (x == min) {
                cnt++;
            }
        }
        return cnt == 1;
    }

    static int getMin(int[] arr) {
        int min = Integer.MAX_VALUE;
        for (int x : arr) {
            min = Math.min(min, x);
        }
        return min;
    }

    static int getMinIdx(int[] arr) {
        int min = getMin(arr);
        int minIdx = 0;
        for (int i = 0; i < arr.length; i++) {
            if (min == arr[i]) {
                minIdx = i;
            }
        }
        return minIdx;

    }



    public static void main(String[] args){
        System.out.println(solution(new int[][]{{10, 20, 30}, {12, 15, 20}, {20, 12, 15}, {15, 20, 10}, {10, 15, 10}}));
        System.out.println(solution(new int[][]{{10, 9, 11}, {15, 20, 25}}));
        System.out.println(solution(new int[][]{{0, 3, 27}, {20, 5, 5}, {19, 5, 6}, {10, 10, 10}, {15, 10, 5}, {3, 7, 20}}));
        System.out.println(solution(new int[][]{{3, 7, 20}, {10, 15, 5}, {19, 5, 6}, {10, 10, 10}, {15, 10, 5}, {3, 7, 20}, {12, 12, 6}, {10, 20, 0}, {5, 10, 15}}));
    }
}
