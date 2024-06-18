package Promgrammers.level3;


import java.util.ArrayList;
import java.util.List;

public class 하노이의탑 {
    private void hanoiTop(int n, int from, int to, List<int[]> res) {
        if (n == 1) {
            res.add(new int[]{from, to});
            return;
        }
        int emptyIdx = 6 - from - to;
        hanoiTop(n - 1, from, emptyIdx, res);
        hanoiTop(1, from, to, res);
        hanoiTop(n - 1, emptyIdx, to, res);

    }

    public int[][] solution(int n) {
        List<int[]> res = new ArrayList<>();
        hanoiTop(n, 1, 3, res);
        return res.toArray(new int[0][]);
    }
}
