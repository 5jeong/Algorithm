package algorithmStudy.해쉬and정렬지원set;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.util.TreeSet;

//TreeSet 자료구조 - 균형잡힌 이진트리(중복제거 + 정렬)
public class K번째큰수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        ArrayList<Integer> temp = new ArrayList<>();
        TreeSet<Integer> Tset = new TreeSet<>(Comparator.reverseOrder());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                for(int s=j+1;s<n;s++){
                    int sum=0;
                    sum = arr[i]+arr[j]+arr[s];
                    Tset.add(sum);
                }
            }
        }
        int cnt=0;
        for(int x : Tset){
            cnt++;
            if(cnt==k) {
                System.out.println(x);
                return;
            }
        }
        System.out.println("-1");
    }
}
