package L00_ArrayStack;

import java.util.Iterator;

public class ArrayStack<E> implements IArray<E>{


    static class Node<E>{
        private final E element;
        private Node<E> Next;
        public Node(E element){
            this.element= element;

        }
    }
    private Node<E> head;
    private int size;

    public ArrayStack() {
        head = null;
        size =0;
    }

    @Override
    public void push(E element) {
        Node<E> newNode = new Node<>(element);
        newNode.Next= head;
        head =newNode;
        size++;


    }

    @Override
    public void pop() {
        E element = head.element;
        head = head.Next;
        size--;

    }

    @Override
    public E peek() {

        return head.element;

    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return head ==null;
    }


    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            Node<E> Current = head;
            @Override
            public boolean hasNext() {

                return Current!= null;
            }

            @Override
            public E next() {
                E element = Current.element;
                Current = Current.Next;
                return element;
            }
        };
    }
    static class Main{
        public static void main(String[] args) {
            ArrayStack<Integer> arrayStack= new ArrayStack<>();
            arrayStack.push(10);
            arrayStack.push(20);
            arrayStack.push(30);
            arrayStack.push(40);
            arrayStack.push(50);
            arrayStack.pop();
            arrayStack.peek();
            System.out.println(arrayStack.peek());

            Iterator<Integer> iterator = arrayStack.iterator();
            while (iterator.hasNext()) {
                System.out.println(iterator.next());
            }}









        }
    }

