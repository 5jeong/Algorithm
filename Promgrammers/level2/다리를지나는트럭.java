package Promgrammers.level2;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class 다리를지나는트럭 {
    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;

        Queue<Integer> bridge = new LinkedList<>(); // 다리에 있는 트럭
        Queue<Integer> waitTruck = new LinkedList<>(); // 대기중 트럭
        for (int i = 0; i < bridge_length; i++) {
            bridge.add(0);
        }
        for (int truckWeight : truck_weights) {
            waitTruck.add(truckWeight);
        }
        int time = 0;
        int bridgeWeight = 0; // 다리에 있는 트럭 무게

        while (!bridge.isEmpty() || !waitTruck.isEmpty()) {

            bridgeWeight -= bridge.poll();
            //무게초과로 못넣을때
            if (!waitTruck.isEmpty() && (weight < bridgeWeight + waitTruck.peek())) {
                bridge.add(0);
            } else if (!waitTruck.isEmpty()) {
                int truckWeight = waitTruck.poll();
                bridge.add(truckWeight);
                bridgeWeight += truckWeight;
            }
            time++;

        }

        return time;
    }

    public static void main(String[] args) {
        System.out.println(solution(2, 10, new int[]{7, 4, 5, 6}));
        System.out.println(solution(100, 100, new int[]{10}));
        System.out.println(solution(100, 100, new int[]{10, 10, 10, 10, 10, 10, 10, 10, 10, 10}));
    }
}
