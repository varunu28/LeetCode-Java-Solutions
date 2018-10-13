class Solution {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> ans = new ArrayList<>();

        if (nums1.length == 0 || nums2.length == 0 || k == 0) {
            return ans;
        }

        PriorityQueue<Element> pq = new PriorityQueue<>(new Comparator<Element>() {
            @Override
            public int compare(Element o1, Element o2) {
                return (o1.x + o1.y) - (o2.x + o2.y);
            }
        });

        for (int i=0; i<nums2.length && i < k; i++) {
            pq.offer(new Element(0, nums2[i], nums1[0]));
        }

        while (k-- > 0 && !pq.isEmpty()) {
            Element temp = pq.poll();
            ans.add(new int[]{temp.y, temp.x});

            if (temp.idx >= nums1.length-1) {
                continue;
            }

            pq.offer(new Element(temp.idx+1, temp.x, nums1[temp.idx+1]));
        }

        return ans;
    }

    class Element {
        int idx;
        int x;
        int y;

        public Element(int val, int x, int y) {
            this.idx = val;
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Element{" +
                    "idx=" + idx +
                    ", x=" + x +
                    ", y=" + y +
                    '}';
        }
    }
}
