package baekjoon.silver;

public class Baekjoon_4673 {
    public static void main(String[] args) {
        int[] arr = new int[10001];
        for (int i = 1; i <= 10000; i++) {
            int temp = i;
            int n = i;
            while (n > 0) {
                temp += n % 10;
                n /= 10;
            }
            if (temp > 10000) {
                break;
            }
            arr[temp]++;
        }
        for (int i = 1; i <= 10000; i++) {
            if (arr[i] == 0) {
                System.out.println(i);
            }
        }
    }
}
