package baekjoon.gold;

import java.util.Scanner;

/***
 * 계란으로 계란치기
 * 계란에는 내구도와 무게가 있고,
 * 계란을 치면 내구도는 상대 게란의 무게만끔 깎이고, 내구도가 0이하면 꺠짐
 * 1. 집은 계란의 내구도가 남아있고, 나머지 계란중 내구도가 있는경우 fight
 * 2. 집은 계란의 내구도가 없거나, 내구도가 남아있는 계란이 없는경우 dfs(+1)
 *
 */
public class Baekjoon_16987 {
    static int n, ans;
    static int[] ch;
    static Egg[] eggs;

    static class Egg {
        int hp;
        int weight;

        Egg(int hp, int weight) {
            this.hp = hp;
            this.weight = weight;
        }

        public void fight(Egg other) {
            hp -= other.weight;
            other.hp -= weight;
        }

        public void restore(Egg other) {
            hp += other.weight;
            other.hp += weight;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); // 계란의 수
        ch = new int[n]; // 깨진 계란 체크
        eggs = new Egg[n];
        ans = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            eggs[i] = new Egg(a, b);
        }

        dfs(0);
        System.out.println(ans);

    }

    static void dfs(int pick) {

        if (pick == n) {
            int cnt = 0;
            for (Egg x : eggs) {
                if (x.hp <= 0) {
                    cnt++;
                }
            }
            ans = Math.max(ans, cnt);
        } else {
            Egg now = eggs[pick];
            //선택한 계란의 내구도가 남아있을떄
            if (now.hp > 0) {
                boolean targetExists = false;
                for (int i = 0; i < n; i++) {
                    //같은 계란이면 continue
                    if (pick == i) {
                        continue;
                    }
                    Egg other = eggs[i];
                    if (other.hp > 0) {
                        targetExists = true;
                        now.fight(other);
                        dfs(pick + 1);
                        now.restore(other);
                    }
                }
                // 충돌시킬 계란이 존재하지 않으면
                if (!targetExists) {
                    dfs(pick + 1);
                }
            } else {
                dfs(pick + 1);
            }
        }
    }
}
