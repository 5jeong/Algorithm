package Promgrammers.Level1;

public class 최소직사각형 {
    public int solution(int[][] sizes) {
        int[][] arr = sizes;
        int maxW = 0;
        int maxH = 0;
        for(int[] x : arr){
            int w = Math.max(x[0],x[1]);
            int h = Math.min(x[0],x[1]);
            maxW = Math.max(maxW,w);
            maxH = Math.max(maxH,h);
        }
        return maxW*maxH;
    }
}
