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
        StringTokenizer st =new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        ArrayList<Integer> ans = new ArrayList<>();
        TreeSet<Integer> treeSet = new TreeSet<>(Comparator.reverseOrder());
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for(int i=0;i<n-2;i++){
            for(int j=i+1;j<n-1;j++){
                for(int s=j+1;s<n;s++){
                    int temp=arr[i]+arr[j]+arr[s];
                    treeSet.add(temp);
                }
            }
        }
        int cnt=1;
        for(int x : treeSet){
            if(cnt==k){
                System.out.println(x);
                return;
            }
            cnt++;
        }
        System.out.println("-1");
    }
}
