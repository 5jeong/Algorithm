package swea.d3;
import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

class Flatten
{
    public static void main(String args[]) throws Exception
    {

        System.setIn(new FileInputStream("C:\\Users\\82109\\Desktop\\정훈\\알고리즘 공부\\Algorithm_Java\\swea\\input.txt"));


        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
        for(int test_case = 1; test_case <= T; test_case++)
        {
            int n = sc.nextInt();
            Integer[] height = new Integer[100];
            for(int i=0;i<100;i++){
                height[i] = sc.nextInt();
            }
            int max_height=0,max_idx=0;
            int min_height=Integer.MAX_VALUE,min_idx=0;
            Arrays.sort(height, Collections.reverseOrder());
            for(int i=0;i<n;i++){
                int temp = height[0] - height[99];
                if(temp <=1){
                    break;
                }
                else{
                    height[0]--;
                    height[99]++;
                    Arrays.sort(height, Collections.reverseOrder());
                }
            }
            int ans = height[0] - height[99];
            System.out.println("#"+test_case+" " +ans);
        }
    }
}
