package swea.d3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\82109\\Desktop\\정훈\\알고리즘 공부\\Algorithm_Java\\swea\\d3\\input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = 10;
        int count = 1;
        while (count <= T) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            String str = st.nextToken();

            int start = 0;
            int end;
            while (true) {
                if (start == str.length() - 1) {
                    break;
                }
                end = start + 1;
                if (str.charAt(start) == str.charAt(end)) {
                    str = str.substring(0, start) + str.substring(end + 1, str.length());
                    start = 0;
                    continue;
                }
                start++;
            }

            System.out.printf("#%d %s\n", count, str);
            count++;
        }
    }
}
