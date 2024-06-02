package Promgrammers.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
  <문제풀이 흐름>
  1. 모든 직선쌍에 대해 반복
        A. 교점의 좌표구하기
        B. 정수 좌표만 저장
  2. 지정된 정수 좌표중 X,Y좌표의 최솟값, 최댓값 구하기
  3. 최솟값, 최댓값으로 2차원 배열의 크기 결정
  4. 2차원 배열에 별표시
  5. 문자열 배열로 변환후 반환
*/
public class 교점에별만들기 {
    private static class Point {
        public final long x, y;

        private Point(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }

    //교점구하기
    private Point intersection(long a, long b, long e, long c, long d, long f) {
        double x = (double) (b * f - e * d) / (a * d - b * c);
        double y = (double) (e * c - a * f) / (a * d - b * c);

        if (x % 1 != 0 || y % 1 != 0) {
            return null;
        }

        return new Point((long) x, (long) y);

    }

    //최대 x,y 구하기
    private Point getMaxPoint(List<Point> points) {
        long x = Long.MIN_VALUE;
        long y = Long.MIN_VALUE;
        for (Point p : points) {
            x = Math.max(x, p.x);
            y = Math.max(y, p.y);
        }
        return new Point(x, y);
    }

    //최소 x,y 구하기
    private Point getMinPoint(List<Point> points) {
        long x = Long.MAX_VALUE;
        long y = Long.MAX_VALUE;
        for (Point p : points) {
            x = Math.min(x, p.x);
            y = Math.min(y, p.y);
        }
        return new Point(x, y);
    }

    public String[] solution(int[][] line) {
        List<Point> points = new ArrayList<>();
        for (int i = 0; i < line.length; i++) {
            for (int j = i + 1; j < line.length; j++) {
                Point p = intersection(line[i][0], line[i][1], line[i][2], line[j][0], line[j][1], line[j][2]);
                if (p != null) {
                    points.add(p);
                }
            }
        }
        Point maxPoint = getMaxPoint(points);
        Point minPoint = getMinPoint(points);
        int w = (int) (maxPoint.x - minPoint.x + 1);
        int h = (int) (maxPoint.y - minPoint.y + 1);
        char[][] arr = new char[h][w];
        for (char[] x : arr) {
            Arrays.fill(x, '.');
        }
        for (Point p : points) {
            int x = (int) (p.x - minPoint.x);
            int y = (int) (maxPoint.y - p.y);
            arr[y][x] = '*';
        }
        String[] ans = new String[arr.length];
        for (int i = 0; i < arr.length; i++) {
            ans[i] = new String(arr[i]);
        }
        return ans;
    }
}
