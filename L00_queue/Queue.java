package L00_queue;



import java.util.Iterator;
import java.util.NoSuchElementException;

public class Queue<E> implements Iterable<E> {
    private class Node<E> {
        private E element;
        private Node<E> next;

        public Node(E element) {
            this.element = element;
            next = null;
        }
    }

    private Node<E> head;
    private Node<E> tail;
    private int size;

    public Queue() {
        head = tail = null;
        size = 0;
    }

    public void offer(E element) {
        Node<E> newNode = new Node<>(element);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public E poll() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        E element = head.element;
        head = head.next;
        size--;
        return element;
    }

    public E peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        return head.element;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private Node<E> current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                E element = current.element;
                current = current.next;
                return element;
            }
        };
    }
    @Override
    public String toString(){
        Node<E> Current = head;
        StringBuilder result = new StringBuilder("[");

        while (Current!=null){
            result.append(Current.element);
            if (Current.next !=null){
                result.append(", ");}
            Current = Current.next;
        }
        result.append("]");
        return result.toString();
    }
}

class Main{
    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<>();
        queue.offer(10);
        queue.offer(20);
        queue.offer(30);
        queue.offer(40);
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
    }
}
