package swea.d2;

import java.io.FileInputStream;
import java.util.Scanner;

class 백만장자프로젝트
{
    public static void main(String args[]) throws Exception {
//        System.setIn(new FileInputStream("C:\\Users\\82109\\Desktop\\정훈\\알고리즘 공부\\Algorithm_Java\\swea\\d2\\input.txt"));
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            int max =0;
            for(int i=0;i<n;i++){
                arr[i] = sc.nextInt();
            }
            max = arr[n-1];
            long ans=0;
            for(int i=n-2;i>=0;i--){
                if(max > arr[i]){
                    ans += max -arr[i];
                }
                else{
                    max = arr[i];
                }
            }
            System.out.println("#"+test_case+" "+ans);
        }
    }
}