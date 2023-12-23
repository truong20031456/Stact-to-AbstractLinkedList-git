package Loo_DoubleLyEnhanced;

import javax.management.InstanceNotFoundException;

public interface AbstractLinklist<E> extends Iterable<E> {
    void addFirst( E element ); // ~ push
    void addLast( E element ); // ~ offer
    E removeFirst( ) throws InstanceNotFoundException; // ~ pop
    E removeLast( ); // ~ poll
    E getFirst( ); // ~ peek > head
    E getLast( ); // ~ peek > tail
    int size( );
    boolean isEmpty( );
}
