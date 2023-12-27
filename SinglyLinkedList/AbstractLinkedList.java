package SinglyLinkedList;

public interface AbstractLinkedList<E> extends Iterable<E>{
    void addFirst( E element ); // ~ push
    void addLast( E element ); // ~ offer
    E removeFirst( ); // ~ pop
    E removeLast( ); // ~ poll
    E getFirst( ); // ~ peek > head
    E getLast( ); // ~ peek > tail
    int size( );
    boolean isEmpty( );
}
