package swea.d3;

import java.io.FileInputStream;
import java.util.*;

public class 새샘이의7_3_5게임 {

    public static void main(String args[]) throws Exception {
        System.setIn(new FileInputStream("C:\\Users\\82109\\Desktop\\정훈\\알고리즘 공부\\Algorithm_Java\\swea\\d3\\input.txt"));
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            Integer[] arr = new Integer[7];
            for(int i=0;i<7;i++){
                arr[i] = sc.nextInt();
            }
//            Arrays.sort(arr, Comparator.reverseOrder());

            int temp = 0;
            int cnt=1;
            int ans=0;
            HashSet<Integer> hashSet = new HashSet<>();
            ArrayList<Integer> arrayList = new ArrayList<>();
            for(int i=0;i<arr.length-2;i++){
                for(int j = i+1 ; j< arr.length-1;j++){
                    for(int k = j+1;k<arr.length;k++){
                        hashSet.add(arr[i] + arr[j] + arr[k]);
                    }
                }
            }

            for(int x : hashSet){
                arrayList.add(x);
            }
            Collections.sort(arrayList,Collections.reverseOrder());
            System.out.println("#"+test_case+" "+ arrayList.get(4));

        }
    }
}