package algorithmStudy.배열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        arr[0] = 1;
        arr[1] = 1;
        for(int i=2;i<n;i++){
          arr[i] = arr[i-2] + arr[i-1];
        }
        for(int x : arr){
            System.out.print(x+" ");
        }
    }
}
