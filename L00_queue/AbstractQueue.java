package L00_queue;

import java.util.Iterator;

public interface AbstractQueue<E> extends Iterable<E> {
    void offer(E element);
    E poll();
    E peek();
    int size();
    boolean isEmpty();
    Iterator<E> iterator();
}
