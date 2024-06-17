package Promgrammers.level2;

public class 쿼드압축_후_개수세기 {
    private static class Count {
        int zeroCnt;
        int oneCnt;

        Count(int zeroCnt, int oneCnt) {
            this.zeroCnt = zeroCnt;
            this.oneCnt = oneCnt;
        }

        public Count add(Count other) {
            return new Count(zeroCnt + other.zeroCnt, oneCnt + other.oneCnt);
        }
    }

    private Count count(int offsetX, int offsetY, int size, int[][] arr) {
        int h = size / 2;
        for (int x = offsetX; x < offsetX + size; x++) {
            for (int y = offsetY; y < offsetY + size; y++) {
                if (arr[x][y] != arr[offsetX][offsetY]) {
                    return count(offsetX, offsetY, h, arr)
                            .add(count(offsetX, offsetY + h, h, arr))
                            .add(count(offsetX + h, offsetY, h, arr))
                            .add(count(offsetX + h, offsetY + h, h, arr));
                }
            }
        }
        // 모두 0이거나 1이거나
        if (arr[offsetX][offsetY] == 0) {
            return new Count(1, 0);
        }
        return new Count(0, 1);


    }

    public int[] solution(int[][] arr) {
        int[] answer = {};
        Count res = count(0, 0, arr.length, arr);
        return new int[]{res.zeroCnt, res.oneCnt};
    }
}
