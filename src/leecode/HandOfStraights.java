package leecode;

import java.util.Map;
import java.util.TreeMap;

public class HandOfStraights {

    public boolean isNStraightHand(int[] hand, int W) {

        // special cases
        if (W == 1) return true;
        if (hand.length % W != 0) return false;

        // sort map of num -> count
        Map<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < hand.length; i++) {
            int num = hand[i];
            if (map.containsKey(num)) map.put(num, map.get(num) + 1);
            else map.put(num, 1);
        }

        while (!map.isEmpty()) {
            // doesn't have enough numbers
            if (map.size() < W) return false;

            int i = 0, lastKey = Integer.MIN_VALUE, minCount = Integer.MAX_VALUE;
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                int key = entry.getKey();
                int value = entry.getValue();

                if (minCount == Integer.MAX_VALUE) {
                    minCount = value;
                    map.put(key, 0);
                } else {
                    // cannot continue
                    if (key != lastKey + 1 || value < minCount) return false;
                    map.put(key, value - minCount);
                }

                lastKey = key;
                if (++i >= W) break;
            }

            // remove empty keys
            map.entrySet().removeIf(entry -> entry.getValue() == 0);
        }

        // clear all numbers
        return true;
    }

    public static void main(String[] args) {
        HandOfStraights c = new HandOfStraights();
        System.out.println(c.isNStraightHand(new int[] { 1, 1, 2, 2, 3, 3 }, 2));
        System.out.println(c.isNStraightHand(new int[] { 1, 2, 3, 6, 2, 3, 4, 7, 8 }, 3));
        System.out.println(c.isNStraightHand(new int[] { 1, 2, 3, 4, 5 }, 4));
    }

}
