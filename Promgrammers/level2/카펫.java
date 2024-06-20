package Promgrammers.level2;

public class 카펫 {
    public int[] solution(int brown, int yellow) {
        for (int w = 3; w <= 5000; w++) {
            for (int h = 3; h <= w; h++) {
                if (brown == (w + h - 2) * 2 && yellow == w * h - brown) {
                    return new int[]{w, h};
                }
            }
        }
        return null;
    }
}
