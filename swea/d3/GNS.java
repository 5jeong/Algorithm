package swea.d3;

import java.io.FileInputStream;
import java.util.*;

public class GNS {
    static class info {
        String str;
        int num;
        info(String str, int num){
            this.str=str;
            this.num=num;
        }

    }
    public static void main(String args[]) throws Exception {
        System.setIn(new FileInputStream("C:\\Users\\82109\\Desktop\\정훈\\알고리즘 공부\\Algorithm_Java\\swea\\d3\\input.txt"));
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        String[] s ={"ZRO","ONE","TWO","THR","FOR","FIV","SIX","SVN","EGT","NIN"};
        for (int test_case = 1; test_case <= T; test_case++) {
            String t = sc.next();
            String str = sc.next();
            int n = Integer.parseInt(str);
            String[] arr =  new String[n];
            ArrayList<info> arrayList =new ArrayList<>();
            for(int i=0;i<n;i++){
                arr[i] = sc.next();
                for(int j=0;j<10;j++){
                    if(arr[i].equals(s[j])){
                        arrayList.add(new info(arr[i],j));
                        break;
                    }
                }
            }
            Collections.sort(arrayList,(a,b)-> a.num-b.num);

            System.out.println("#"+test_case);
            for(int i=0;i<n;i++){
                System.out.print(arrayList.get(i).str+" ");
            }
        }
    }
}