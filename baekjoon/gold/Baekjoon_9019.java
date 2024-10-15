package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon_9019 {

    static int n, a, b;
    static Queue<Info> queue;
    static int[] ch;

    static class Info {
        int num;
        String res;

        Info(int num, String res) {
            this.num = num;
            this.res = res;
        }
    }

    static Info calculate(int a, String res, int idx) {
        switch (idx) {
            // D 연산
            case 0:
                a = a * 2 % 10000;
                res += "D";
                break;
            // S 연산
            case 1:
                if(a==0){
                    a = 9999;
                }else{
                    a-=1;
                }
                res += "S";
                break;
            // L연산 : 왼쪽회전
            case 2:
                a = (a % 1000 * 10) + (a / 1000);
                res += "L";
                break;
            // R연산 : 오른쪽 회원
            case 3:
                a = (a % 10) * 1000 + a / 10;
                res += "R";
                break;
        }
        return new Info(a, res);
    }


    private static String bfs() {

        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                Info temp = queue.poll();
                if(temp.num == b){
                    return temp.res;
                }
                for (int j = 0; j < 4; j++) {
                    Info info = calculate(temp.num, temp.res, j);
                    if (ch[info.num] == 0) {
                        ch[info.num] = 1;
                        queue.offer(new Info(info.num, info.res));
                    }
                }
            }

        }
        return "";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            queue = new LinkedList<>();

            ch = new int[10000];
            ch[a] = 1;
            queue.add(new Info(a, ""));
            String ans = bfs();
            System.out.println(ans);
        }

    }
}
