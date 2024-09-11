package baekjoon.silver;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Baekjoon_11723 {
    private static HashSet<Integer> hashSet;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cnt = sc.nextInt();
        hashSet = new HashSet<>();
        int num;
        for (int i = 0; i < cnt; i++) {
            String s = sc.next();
            if (s.equals("add")) {
                num = sc.nextInt();
                add(num);
            } else if (s.equals("remove")) {
                num = sc.nextInt();
                remove(num);
            } else if (s.equals("check")) {
                num = sc.nextInt();
                check(num);
            } else if (s.equals("toggle")) {
                num = sc.nextInt();
                toggle(num);
            } else if (s.equals("all")) {
                all();
            } else {
                empty();
            }

        }

    }

    private static void add(int num) {
        hashSet.add(num);
    }

    private static void remove(int num) {
        hashSet.remove(num);
    }

    private static void check(int num) {
        if (hashSet.contains(num)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }

    }

    private static void toggle(int num) {
        if (hashSet.contains(num)) {
            hashSet.remove(num);
        } else {
            hashSet.add(num);
        }
    }

    private static void all() {
        for (int i = 1; i < 20; i++) {
            hashSet.add(i);
        }
    }

    private static void empty() {
        hashSet.clear();
    }

}
