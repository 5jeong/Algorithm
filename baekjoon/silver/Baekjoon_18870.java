package baekjoon.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Baekjoon_18870 {
    static class info implements Comparable<info> {
        int idx;
        int value;

        info(int idx, int value) {
            this.idx = idx;
            this.value = value;
        }

        @Override
        public int compareTo(info o) {
            return this.value - o.value;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] ans = new int[n];
        List<info> infos = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(st.nextToken());
            infos.add(new info(i, x));
        }
        Collections.sort(infos);
        int temp = 0;
        ans[0] = 0;
        for (int i = 1; i < n; i++) {
            if (infos.get(i).value != infos.get(i - 1).value) {
                temp++;
            }
            ans[infos.get(i).idx] = temp;
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int x : ans) {
            bw.write(x+" ");
        }
        bw.flush();
    }
}
