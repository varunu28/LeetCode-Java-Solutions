public class Vector2D implements Iterator<Integer> {
    Iterator<List<Integer>> iterator;
    Iterator<Integer> listIterator;

    public Vector2D(List<List<Integer>> vec2d) {
        if (vec2d == null || vec2d.isEmpty()) {
            return;
        }

        iterator = vec2d.iterator();
        listIterator = iterator.next().iterator();
        checkForValidity();
    }

    private void checkForValidity() {
        while (!listIterator.hasNext() && iterator.hasNext()) {
            listIterator = iterator.next().iterator();
        }
    }

    @Override
    public Integer next() {
        int num = listIterator.next();
        checkForValidity();
        return num;
    }

    @Override
    public boolean hasNext() {
        return listIterator != null && listIterator.hasNext();
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */
