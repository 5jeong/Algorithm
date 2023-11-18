package swea.d3;

import java.io.FileInputStream;
import java.util.*;

public class 새샘이의7_3_5게임 {

    static int[] num;
    static HashSet<Integer> hashSet;
    static void dfs(int L,int s,int sum){
        if(L==3){
            hashSet.add(sum);
            return;
        }
        else{
            for(int i=s;i<7;i++){
                dfs(L+1,i+1,sum+num[i]);
            }
        }
    }

    public static void main(String args[]) throws Exception {
        System.setIn(new FileInputStream("C:\\Users\\82109\\Desktop\\정훈\\알고리즘 공부\\Algorithm_Java\\swea\\d3\\input.txt"));
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
//        int T = 10;
        for (int test_case = 1; test_case <= T; test_case++) {
            num = new int[7];
            for(int i=0;i<7;i++){
                num[i] = sc.nextInt();
            }
            hashSet = new HashSet<>();
            dfs(0,0,0);
            ArrayList<Integer> arrayList = new ArrayList<>();
            for(int x : hashSet){
                arrayList.add(x);
            }
            Collections.sort(arrayList,Collections.reverseOrder());
            int ans = arrayList.get(4);
            System.out.println("#"+test_case+" " +ans);
        }
    }
}