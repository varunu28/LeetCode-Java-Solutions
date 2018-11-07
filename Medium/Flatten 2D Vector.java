class Vector2D implements Iterator<Integer> {

    Iterator<List<Integer>> listIterator;
    Iterator<Integer> iterator;
    boolean flag;

    public Vector2D(List<List<Integer>> vec2d) {
        listIterator = vec2d.iterator();
        check();
    }

    private void check() {
        while (listIterator.hasNext()) {
            List<Integer> list = listIterator.next();
            if (list.size() > 0) {
                iterator = list.iterator();
                break;
            }
        }

        flag = iterator != null;
    }

    @Override
    public Integer next() {
        int num = iterator.next();
        if (!iterator.hasNext()) {
            iterator = null;
            check();
        }

        return num;
    }

    @Override
    public boolean hasNext() {
        return flag;
    }
}
/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */
