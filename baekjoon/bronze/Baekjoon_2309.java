package baekjoon.bronze;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Baekjoon_2309 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> arrayList = new ArrayList<>();
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            int n = sc.nextInt();
            sum += n;
            arrayList.add(n);
        }
        Collections.sort(arrayList);
        int temp = sum - 100;
        game:for (int i = 0; i < 9; i++) {
            for (int j = i+1; j < 9; j++) {
                if (arrayList.get(i) + arrayList.get(j) == temp) {
                    arrayList.remove(j);
                    arrayList.remove(i);
                    break game;
                }
            }
        }
        for (Integer x : arrayList) {
            System.out.println(x);
        }
    }
}
