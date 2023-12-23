package Assignment2;

public interface AbstractQueue<E> extends Iterable<E> {
    void offer(E element);
    E poll();
    int size();
    boolean isEmpty();
}


