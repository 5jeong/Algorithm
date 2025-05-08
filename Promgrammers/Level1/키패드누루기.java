package Promgrammers.Level1;

public class 키패드누루기 {
    static StringBuilder sb;
    static Point left, right;
    static String[][] keyPad;

    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public String solution(int[] numbers, String hand) {
        sb = new StringBuilder();
        keyPad = new String[][]{
                {"1", "2", "3"},
                {"4", "5", "6"},
                {"7", "8", "9"},
                {"*", "0", "#"}
        };

        left = new Point(3, 0);
        right = new Point(3, 2);
        for (int x : numbers) {
            String finger = whatFinger(x, hand);
            if (finger.equals("left")) {
                sb.append("L");
            } else {
                sb.append("R");
            }
        }
        return sb.toString();
    }


    // 어느손가락인지 판단하는 함수
    private String whatFinger(int num, String hand) {
        Point now = findPoint(num);
        // 1,4,7은 항상 왼손
        if (num == 1 || num == 4 || num == 7) {
            left = now;
            return "left";
        }
        if (num == 3 || num == 6 || num == 9) {
            right = now;
            return "right";
        }
        // 거리판단해야함
        return useFinger(hand, now);
    }

    // 가운데 숫자일경우
    // 거리비교해서 어느 손가락 사용하는지 판단(같으면 hand로 판단)
    private String useFinger(String hand, Point now) {
        double leftDis = distance(left, now);
        double rightDis = distance(right, now);
        if (leftDis < rightDis) {
            left = now;
            return "left";
        }
        if (leftDis > rightDis) {
            right = now;
            return "right";
        }
        // 거리가 같을경우 손잡이 리턴
        if (hand.equals("right")) {
            right = now;
            return "right";
        } else {
            left = now;
            return "left";
        }
    }

    // 거리판단
    private double distance(Point a, Point b) {
        return Math.abs(a.x - b.x) + Math.abs(a.y - b.y);
    }

    // 위치 판단
    private Point findPoint(int num) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                if (keyPad[i][j].equals("*") || keyPad[i][j].equals("#")) {
                    continue;
                }
                if (Integer.parseInt(keyPad[i][j]) == num) {
                    return new Point(i, j);
                }
            }
        }
        return null;
    }
}
