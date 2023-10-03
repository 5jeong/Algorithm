package swea.d2;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class 간단한압축풀기 {
    public static void main(String args[]) throws Exception
    {

        //System.setIn(new FileInputStream("C:\\Users\\82109\\Desktop\\정훈\\알고리즘 공부\\Algorithm_Java\\swea\\d2\\input.txt"));

        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++) {
            int n = sc.nextInt();
            String[] strings = new String[n];
            int[] cnt = new int[n];
            for(int i=0;i<n;i++){
                strings[i] = sc.next();
                cnt[i] = sc.nextInt();
            }
            ArrayList<String> arrayList = new ArrayList<>();
            for(int i=0;i<n;i++){
                for(int j=0;j<cnt[i];j++){
                    arrayList.add(strings[i]);
                }
            }
            System.out.println("#"+test_case);
            for(int i=0;i<arrayList.size();i++){
                if(i%10==0 && i!=0){
                    System.out.println();
                }
                System.out.print(arrayList.get(i));
            }
            System.out.println();

        }

    }
}
