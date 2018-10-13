class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Element> pq = new PriorityQueue<>(new Comparator<Element>() {
            @Override
            public int compare(Element o1, Element o2) {
                return o1.val - o2.val;
            }
        });
        
        for (int i=0; i<matrix[0].length; i++) {
            pq.offer(new Element(matrix[0][i], 0, i));
        }
        
        for (int i=0; i<k-1; i++) {
            Element temp = pq.poll();
            if (temp.x == matrix.length-1) {
                continue;
            }
            
            pq.offer(new Element(matrix[temp.x+1][temp.y], temp.x+1, temp.y));
        }
        
        return pq.poll().val;
    }

    class Element {
        int val;
        int x;
        int y;

        public Element(int val, int x, int y) {
            this.val = val;
            this.x = x;
            this.y = y;
        }
    }
}
