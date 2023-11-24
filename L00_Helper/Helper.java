package L00_Helper;

import java.util.Iterator;

public class Helper {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        int popValue = stack.pop();
       /* System.out.println(stack.pop());*/
        StringBuilder result = new StringBuilder();
        result.append("[");
        result.append("hello");
        result.append(", ");
        result.append("world");
        result.append("]");
        Iterator<Integer> interator = stack.iterator();
        System.out.println(interator.hasNext());
        while (interator.hasNext()){
            System.out.println(interator.next());
        }




    }

}



class Stack<E> implements AbstractStack<E> {
    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            Node<E> Current = top;

            @Override
            public boolean hasNext() {
                return Current != null;
            }

            @Override
            public E next() {
                E element = Current.element;;
                Current = Current.next;
                return element;
            }
        };
    }

    private static class Node<E> {
        private E element;
        private Node<E> next;

        public Node(E element) {
            this.element = element;
        }
    }

    private Node<E> top;
    private int size;

    public Stack() {
        top = null;
        size = 0;
    }

    @Override
    public void push(E element) {
        Node<E> newNode = new Node<>(element);
        newNode.next = top;
        top = newNode;
        size++;
    }

    @Override
    public E pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        E element = top.element;
        top = top.next;
        size--;
        return element;
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return top.element;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return (size == 0 && top == null);
    }
  @Override
    public String toString(){
Node<E> Current = top;
      StringBuilder result = new StringBuilder();
      result.append("[");


 //Current.element = n2.element
      while (Current!=null){
          result.append(Current.element);
          if (Current.next !=null){
          result.append(", ");}
          Current = Current.next;

          result.append("]");
       }
      return result.toString();

}}
