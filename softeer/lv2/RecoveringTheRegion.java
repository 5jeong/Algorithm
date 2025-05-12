package softeer.lv2;

import java.util.Scanner;

public class RecoveringTheRegion {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n = sc.nextInt();
        int[][] board = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j] = sc.nextInt();
            }
        }
        int idx= 1;
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                sb.append(idx+" ");
            }
            sb.append("\n");
            idx++;
        }
        System.out.println(sb.toString());
    }

}
