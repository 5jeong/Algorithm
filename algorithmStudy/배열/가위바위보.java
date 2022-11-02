package algorithmStudy.배열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 가위바위보 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] a = new int[n];
        int[] b = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }
        for(int i=0;i<n;i++){
            if(a[i]==b[i]){
                System.out.println("D");
            }
            else if(a[i]==1){
                if(b[i]==2){
                    System.out.println("B");
                }
                else if(b[i]==3){
                    System.out.println("A");
                }
            }
            else if(a[i]==2){
                if(b[i]==1){
                    System.out.println("A");
                }
                else if(b[i]==3){
                    System.out.println("B");
                }
            }
            else if(a[i]==3){
                if(b[i]==1){
                    System.out.println("B");
                }
                else if(b[i]==2){
                    System.out.println("A");
                }
            }
        }

    }
}
