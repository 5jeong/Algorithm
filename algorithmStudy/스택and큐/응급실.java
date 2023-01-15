package algorithmStudy.스택and큐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 응급실 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int ans =0;
        Queue<HashMap<Integer,Integer>> q = new LinkedList<>();
        st = new StringTokenizer(br.readLine());
        ArrayList<Integer> arrayList = new ArrayList<>();
        int[] arr = new int[n];
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for(int i=0;i<n;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            hashMap.put(i,arr[i]);
            q.offer(hashMap);

        }

        while(!q.isEmpty()){
            int temp = q.peek().get(0);
            if(q.peek() )



        }
        System.out.println(ans);

    }
}
