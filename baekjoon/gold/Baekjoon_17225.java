package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 세훈이의 선물가게
public class Baekjoon_17225 {

    static int a, b, n;
    static int redStartTime = 0;
    static int blueStartTime = 0;
    static int redEndTime = 0;
    static int blueEndTime = 0;

    static class Gift {
        int startTime;
        int endTime;
        String color;
        int number;

        Gift(int startTime, int endTime, String color) {
            this.startTime = startTime;
            this.color = color;
            this.endTime = endTime;
        }

        public void addNumber(int number) {
            this.number = number;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        int totalCnt = 0;
        int blueCnt = 0;
        int redCnt = 0;
        List<Gift> gifts = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int orderTime = Integer.parseInt(st.nextToken()); // 주문 시각
            String color = st.nextToken(); // 색상( B는 상민, A는 지수 )
            int giftCnt = Integer.parseInt(st.nextToken()); // 선물 개수
            totalCnt += giftCnt;
            if (color.equals("B")) {
                blueCnt += giftCnt;
                for (int j = 0; j < giftCnt; j++) {
                    redStartTime = Math.max(orderTime, redEndTime);
                    redEndTime = redStartTime + a;
                    gifts.add(new Gift(redStartTime, redEndTime, color));
                }
            } else {
                redCnt += giftCnt;
                for (int j = 0; j < giftCnt; j++) {
                    blueStartTime = Math.max(orderTime, blueEndTime);
                    blueEndTime = blueStartTime + b;
                    gifts.add(new Gift(blueStartTime, blueEndTime, color));
                }
            }
        }

        // 정렬: 시작 시간이 빠른 순, 같다면 BLUE 우선
        gifts.sort((o1, o2) -> o1.startTime != o2.startTime ? o1.startTime - o2.startTime
                : o1.color.charAt(0) - o2.color.charAt(0));

        // 번호 부여
        for (int i = 1; i <= totalCnt; i++) {
            gifts.get(i - 1).addNumber(i);
        }

        // 결과 분리
        List<Integer> redGifts = new ArrayList<>();
        List<Integer> blueGifts = new ArrayList<>();
        for (Gift gift : gifts) {
            if (gift.color.equals("B")) {
                blueGifts.add(gift.number);
            } else {
                redGifts.add(gift.number);
            }
        }

        // 정답 출력
        System.out.println(blueCnt);
        for (int num : blueGifts) {
            System.out.print(num + " ");
        }
        System.out.println();
        System.out.println(redCnt);
        for (int num : redGifts) {
            System.out.print(num + " ");
        }

    }

}
