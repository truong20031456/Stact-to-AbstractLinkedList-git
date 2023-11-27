package Loo_DoubleLyEnhanced;

public interface AbstractLinklist<E> extends Iterable<E> {
    void addFirst( E element ); // ~ push
    void addLast( E element ); // ~ offer
    E removeFirst( ); // ~ pop
    E removeLast( ); // ~ poll
    E getFirst( ); // ~ peek > head
    E getLast( ); // ~ peek > tail
    int size( );
    boolean isEmpty( );
}
