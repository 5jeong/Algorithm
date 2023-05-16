package Algorithm_Study_Inflearn.시뮬레이션and구현;

public class 잃어버린강아지 {
    public static int solution(int[][] board){
        int[] dx = {-1,0,1,0};
        int[] dy = {0,1,0,-1};
        int hs_d =0,dog_d=0,hs_x=0,hs_y=0,dog_x=0,dog_y=0;
        for(int i=0;i<10;i++){
            for(int j=0;j<10;j++){
                if(board[i][j] ==2 ){
                    hs_x = i;
                    hs_y = j;
                }
                else if(board[i][j]==3){
                    dog_x = i;
                    dog_y = j;
                }
            }
        }
        int time=0;
        while(time <10000){
            if(hs_x == dog_x && hs_y == dog_y){
                break;
            }
            time++;
            int hs_nx = hs_x + dx[hs_d];
            int hs_ny = hs_y + dy[hs_d];
            int dog_nx = dog_x + dx[dog_d];
            int dog_ny = dog_y + dy[dog_d];
            if(hs_nx < 0 || hs_ny<0 || hs_nx >=10 || hs_ny >=10 || board[hs_nx][hs_ny]==1){
                hs_d = (hs_d+1)%4;
            }
            else{
                hs_x=hs_nx;
                hs_y=hs_ny;
            }
            if(dog_nx < 0 || dog_ny<0 || dog_nx >=10 || dog_ny >=10 || board[dog_nx][dog_ny]==1){
                dog_d = (dog_d+1)%4;
            }
            else{
                dog_x=dog_nx;
                dog_y=dog_ny;
            }

//            System.out.println("현수 위치 : " + hs_x+ " " + hs_y);
//        System.out.println("강아지 위치 : " +dog_x+" "+dog_y);
//            System.out.println("----------------------");
        }
        int answer = 0;
        if(time==10000){
            answer=0;
        }
        else{
            answer=time;
        }
        return answer;
    }

    public static void main(String[] args){
        int[][] arr1 = {{0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 2, 0, 0},
                {1, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 3, 0, 0, 0, 1},
                {0, 0, 0, 1, 0, 1, 0, 0, 0, 0},
                {0, 1, 0, 1, 0, 0, 0, 0, 0, 0}};
        System.out.println(solution(arr1));
        int[][] arr2 = {{1, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 1, 1, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 1, 0, 0, 0, 0},
                {1, 0, 0, 0, 0, 0, 1, 0, 1, 0},
                {0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 0, 0, 0, 2, 1},
                {0, 0, 0, 1, 0, 1, 0, 0, 0, 1},
                {0, 1, 0, 1, 0, 0, 0, 0, 0, 3}};
        System.out.println(solution(arr2));
    }
}
