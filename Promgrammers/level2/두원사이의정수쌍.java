package Promgrammers.level2;

public class 두원사이의정수쌍 {
    public static long solution(int r1, int r2) {
        long answer = 0;
        double r1pow = Math.pow(r1, 2);
        double r2pow = Math.pow(r2, 2);
        for (int i = 1; i <= r2; i++) {
            double xpow = Math.pow(i, 2);

            double y1 = 0;
            y1 = Math.sqrt(r1pow - xpow);
            y1 = Math.ceil(y1);

            double y2 = 0;
            y2 = Math.sqrt(r2pow - xpow);
            y2 = Math.floor(y2);
            answer += (int) y2 - (int) y1 + 1;
        }
        answer = answer * 4;
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(2, 4));
    }

}
