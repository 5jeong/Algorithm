package swea.d3;
import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

class Flatten
{
    public static void main(String args[]) throws Exception {
        System.setIn(new FileInputStream("C:\\Users\\82109\\Desktop\\정훈\\알고리즘 공부\\Algorithm_Java\\swea\\d3\\input.txt"));
        Scanner sc = new Scanner(System.in);
//        int T = sc.nextInt();
        int T = 10;
        for (int test_case = 1; test_case <= T; test_case++) {
            int n = sc.nextInt();
            int[] arr=  new int[100];
            for(int i=0;i<100;i++){
                arr[i] = sc.nextInt();
            }
            Arrays.sort(arr); // 오름차순 정렬, 가장 큰 높이 arr[99], 가장 작은 높이 arr[0];
            for(int i=0;i<n;i++){
                if(arr[0]==arr[99]) break;
                arr[0]++;
                arr[99]--;
                Arrays.sort(arr);
            }
            int ans = arr[99] - arr[0];
            System.out.println("#"+test_case+" "+ ans);
        }
    }
}
