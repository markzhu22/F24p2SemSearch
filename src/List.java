public interface List<E> {
    void add(E element);
    E get(int index);
    int size();
    boolean isEmpty();
    void clear();
    boolean contains(E element);
    E remove(int index);
    String[] toArray(String[] strings);
}