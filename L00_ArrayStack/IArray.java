package L00_ArrayStack;

public interface IArray<E> extends Iterable<E> {

   public void push(E element);
   public void pop( );
   public E peek();
   public int size();
   public boolean isEmpty();






}
