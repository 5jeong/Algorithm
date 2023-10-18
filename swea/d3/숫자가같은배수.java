package swea.d3;

import java.io.FileInputStream;
import java.util.*;

public class 숫자가같은배수 {

    public static void main(String args[]) throws Exception {
        System.setIn(new FileInputStream("C:\\Users\\82109\\Desktop\\정훈\\알고리즘 공부\\Algorithm_Java\\swea\\d3\\input.txt"));
        Scanner sc = new Scanner(System.in);
        int T;

        T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            String n = sc.next();
            int len = n.length();
            ArrayList<Integer> res = new ArrayList<>();
            for (char x : n.toCharArray()) {
                res.add(Integer.valueOf(x));
            }
            Collections.sort(res);
            String ans = "impossible";
            int temp = 0;
            int cnt = 2;
            while (true) {
                temp =  Integer.parseInt(n)*cnt;
                String ch = String.valueOf(temp);
                ArrayList<Integer> a = new ArrayList<>();

                for (char x : ch.toCharArray()) {
                    a.add(Integer.valueOf(x));
                }
                Collections.sort(a);
                if (String.valueOf(temp).length() > len) break;
                String s1= "";
                String s2 ="";
                for (int i = 0; i < res.size(); i++) {
                    s1+= res.get(i);
                    s2+= a.get(i);
                }
                if(s1.equals(s2)){
                    ans = "possible";
                    break;
                }
                cnt++;
            }
            System.out.println("#" + test_case + " " + ans);
        }
    }
}
