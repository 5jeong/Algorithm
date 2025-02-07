package baekjoon.gold;

import java.util.ArrayList;
import java.util.Scanner;

/***
 * 치킨 배달
 * 치킨거리 = 집과 가장 가까운 치킨집 거리
 * 도시의 치킨거리  = 모든 집의 치킨 거리의 합
 * 최대 M개를 골랐을 때 도시 치킨거리 최솟값
 */
public class Baekjoon_15686 {
    static int n, m;
    static int[] chickenIdx;
    static int ans = Integer.MAX_VALUE;
    static ArrayList<Point> homes = new ArrayList<>();
    static ArrayList<Point> chickens = new ArrayList<>();

    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        chickenIdx = new int[m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int a = sc.nextInt();
                if (a == 1) {
                    homes.add(new Point(i, j));
                }
                if (a == 2) {
                    chickens.add(new Point(i, j));
                }
            }
        }
        dfs(0,0);
        System.out.println(ans);
    }

    static void dfs(int L, int s) {
        if (L == m) {
            ans = Math.min(ans, getCityChickenDistance());
        } else {
            // 치킨집 좌표 m개만큼 구하기 ( 조합)
            for (int i = s; i < chickens.size(); i++) {
                chickenIdx[L] = i;
                dfs(L + 1, i + 1);
            }
        }
    }

    private static int getCityChickenDistance() {
        int cityChickenDistance = 0;
        // 모든 집과의 좌표 중 최솟값 구하기
        for (Point home : homes) {
            // 치킨 거리 = 집과 가장 가까운 치킨집 거리
            int chickenDistance = Integer.MAX_VALUE;
            for (int idx : chickenIdx) {
                chickenDistance = Math.min(chickenDistance, getDistance(home, chickens.get(idx)));
            }
            cityChickenDistance += chickenDistance;
        }
        return cityChickenDistance;
    }

    static int getDistance(Point point1, Point point2) {
        return Math.abs(point1.x - point2.x) + Math.abs(point1.y - point2.y);
    }
}
