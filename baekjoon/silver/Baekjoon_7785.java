package baekjoon.silver;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

//회사에 있는 사람
public class Baekjoon_7785 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Set<String> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            String a = sc.next();
            String b = sc.next();
            if (b.equals("enter")) {
                set.add(a);
            } else {
                set.remove(a);
            }
        }
        List<String> ans = new ArrayList<>();
        for (String x : set) {
            ans.add(x);
        }
        ans.sort((a, b) -> b.compareTo(a));
        for (String x : ans) {
            System.out.println(x);
        }
    }
}
