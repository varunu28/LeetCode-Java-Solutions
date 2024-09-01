/**
 * Definition for polynomial singly-linked list.
 * class PolyNode {
 *     int coefficient, power;
 *     PolyNode next = null;
 
 *     PolyNode() {}
 *     PolyNode(int x, int y) { this.coefficient = x; this.power = y; }
 *     PolyNode(int x, int y, PolyNode next) { this.coefficient = x; this.power = y; this.next = next; }
 * }
 */

class Solution {
    public PolyNode addPoly(PolyNode poly1, PolyNode poly2) {
        Map<Integer, Integer> powerToValue = new HashMap<>();
        populateMap(powerToValue, poly1);
        populateMap(powerToValue, poly2);
        List<Integer> powerKeys = new ArrayList<>(powerToValue.keySet());
        Collections.sort(powerKeys);
        PolyNode dummy = new PolyNode();
        PolyNode curr = dummy;
        for (int i = powerKeys.size() - 1; i >= 0; i--) {
            if (powerToValue.get(powerKeys.get(i)) == 0) {
                continue;
            }
            PolyNode node = new PolyNode(powerToValue.get(powerKeys.get(i)), powerKeys.get(i));
            curr.next = node;
            curr = curr.next;
        }
        return dummy.next;
    }

    private void populateMap(Map<Integer, Integer> powerToValue, PolyNode poly) {
        while (poly != null) {
            PolyNode node = poly;
            int power = node.power;
            if (node.coefficient != 0) {
                powerToValue.put(power, powerToValue.getOrDefault(power, 0) + node.coefficient);
            }
            poly = poly.next;
        }
    }
}
