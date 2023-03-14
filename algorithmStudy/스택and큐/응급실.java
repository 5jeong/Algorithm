package algorithmStudy.스택and큐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 응급실 {

    static class Patient {
        int dangerous, order;

        Patient(int dangerous, int order) {
            this.dangerous = dangerous;
            this.order = order;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Queue<Main.Patient> queue = new LinkedList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int dangerous = Integer.parseInt(st.nextToken());
            queue.add(new Main.Patient(dangerous, i));
        }

        int ans = 0;
        int cnt=0;
        int max = Integer.MIN_VALUE;
        while (!queue.isEmpty()) {
            for (Main.Patient x : queue) {
                max = Math.max(max, x.dangerous);
            }
            if (queue.peek().dangerous == max) {
                ans++;
                if(queue.peek().order == m) {
                    System.out.println(ans);
                    return;
                }
                queue.poll();
                max = 0;
            }
            else{
                Main.Patient temp = queue.poll();
                queue.add(temp);
            }
        }
    }
}
