package swea.d3;

import java.io.FileInputStream;
import java.util.*;

public class 진기의최고급붕어빵 {


    public static void main(String args[]) throws Exception
    {
        System.setIn(new FileInputStream("C:\\Users\\82109\\Desktop\\정훈\\알고리즘 공부\\Algorithm_Java\\swea\\d3\\input.txt"));
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

//        T=1;
        for(int test_case = 1; test_case <= T; test_case++)
        {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int k = sc.nextInt();
            String ans = "Possible";
            int[] arr = new int[n];
            LinkedList<Integer> linkedList = new LinkedList<>();

            for(int i=0;i<n;i++){
                arr[i]=sc.nextInt();
                linkedList.add(arr[i]);
            }
            Arrays.sort(arr);
            int end =  arr[n-1];
            int cnt=0;
            for(int i=0;i<=end;i++){
                if(i%m==0 && i!=0){
                    cnt+=k;
                }
                if(linkedList.contains(i)){
                    cnt--;
                }
                if(cnt < 0){
                    ans = "Impossible";
                    break;
                }
            }
            System.out.println("#"+test_case+ " "+ ans);
        }
    }
}
