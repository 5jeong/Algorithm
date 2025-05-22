package Promgrammers.Level1;

public class 지폐접기 {
    static int walletX, walletY;

    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        walletX = wallet[0];
        walletY = wallet[1];
        int billX = bill[0];
        int billY = bill[1];

        while ((Math.min(billX, billY) > Math.min(walletX, walletY))
                || (Math.max(billX, billY) > Math.max(walletX, walletY))) {

            if (isPossible(billX, billY)) {
                break;
            } else {
                answer++;
            }

            if (billX > billY) {
                billX /= 2;
            } else {
                billY /= 2;
            }


        }
        return answer;
    }

    static boolean isPossible(int billX,int billY){
        if(walletX >= billX && walletY >= billY ){
            return true;
        }
        if(walletX >= billY && walletY >= billX){
            return true;
        }
        return false;
    }
}
