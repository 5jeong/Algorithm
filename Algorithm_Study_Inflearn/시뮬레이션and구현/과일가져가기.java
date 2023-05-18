package Algorithm_Study_Inflearn.시뮬레이션and구현;

public class 과일가져가기 {
    public static int getMin(int[] fruit){
        int min=Integer.MAX_VALUE;
        for(int i=0;i<fruit.length;i++){
            min = Math.min(min,fruit[i]);
        }
        return min;
    }
    public static boolean uniqueMin(int[] fruit){
        int min =getMin(fruit);
        int cnt=0;
        for(int i=0;i<fruit.length;i++){
            if(min == fruit[i]){
                cnt++;
            }
        }
        if(cnt == 1){
            return true;
        }
        else{
            return false;
        }
    }
    public static int getMinIdx(int[] fruit){
        int idx=0;
        int min = getMin(fruit);
        for(int i=0;i<fruit.length;i++){
            if(min == fruit[i]){
                idx =i;
            }
        }
        return idx;
    }

    public static int solution(int[][] fruit){
        int answer = 0;
        int n = fruit.length;
        int[] ch = new int[n];
        for(int i=0;i<n;i++){
            if(ch[i]==1) continue;
            if(uniqueMin(fruit[i])==false){
                continue;
            }
            for(int j=i+1;j< n;j++){
                if(ch[j]==1){
                    continue;
                }
                if(uniqueMin(fruit[j])==false){
                    continue;
                }
                int a = getMinIdx(fruit[i]);
                int b = getMinIdx(fruit[j]);
                if(a != b && fruit[i][b] > 0 && fruit[j][a] >0) {
                    if (fruit[i][a] + 1 <= fruit[i][b] - 1 && fruit[j][b] + 1 <= fruit[j][a] - 1) {
                        fruit[i][a]++;
                        fruit[i][b]--;
                        fruit[j][b]++;
                        fruit[j][a]--;
                        ch[i] = 1;
                        ch[j] = 1;
                        break;
                    }
                }
            }
        }
        for(int[] x : fruit){
            answer+=getMin(x);
        }
        return answer;
    }

    public static void main(String[] args){
        System.out.println(solution(new int[][]{{10, 20, 30}, {12, 15, 20}, {20, 12, 15}, {15, 20, 10}, {10, 15, 10}}));
        System.out.println(solution(new int[][]{{10, 9, 11}, {15, 20, 25}}));
        System.out.println(solution(new int[][]{{0, 3, 27}, {20, 5, 5}, {19, 5, 6}, {10, 10, 10}, {15, 10, 5}, {3, 7, 20}}));
        System.out.println(solution(new int[][]{{3, 7, 20}, {10, 15, 5}, {19, 5, 6}, {10, 10, 10}, {15, 10, 5}, {3, 7, 20}, {12, 12, 6}, {10, 20, 0}, {5, 10, 15}}));
    }
}
