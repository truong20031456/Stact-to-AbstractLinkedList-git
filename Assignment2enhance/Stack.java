package Assignment2enhance;



import java.util.Iterator;

public class Stack<E> implements AbstractStack<E> {

    private static class Node<E> {
        private E element;
        private Node<E> Next;
        public Node(E element){
            this.element =element;
            Next =null;
        }

    }
    private Node<E> Top;
    private int size;
    public Stack(){
        Top = null;
        size =0;
    }

    @Override
    public void push(E element) {
        Node<E> newNode = new Node<>(element);
        newNode.Next = Top;
        Top = newNode;
        size++;



    }

    @Override
    public E pop() {
        E element = Top.element;
        Top = Top.Next;
        size--;



        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size==0 && Top ==null;
    }
    public void display() {
        System.out.print("\nData in the Stack:\n");
        if (isEmpty()) {
            System.out.println("EMPTY!!!");
        } else {
            Node<E> temp = Top;
            int stackSize = size(); // Assuming you have a size method to get the number of elements in the stack
            for (int i = stackSize; i > 0; i--) {
                System.out.println(i + ". " + temp.element);
                temp = temp.Next;
            }
            System.out.println("\n");
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            Node<E> Current = Top;
            @Override
            public boolean hasNext() {
                return Current!=null;
            }

            @Override
            public E next()
            {
                E element= Current.element;
                Current = Current.Next;
                return element;
            }
        };
    }
}
