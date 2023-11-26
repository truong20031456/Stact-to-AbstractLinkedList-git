package LOO_Doublely;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class DoublelyLinkedList<E> implements Iterable<E> {
    private class Node<E> {
        private E element;
        private Node<E> next;
        private Node<E> prev;

        public Node(E element) {
            this.element = element;
            next = prev = null;
        }
    }

    private Node<E> head;
    private Node<E> tail;
    private int size;

    public DoublelyLinkedList() {
        head = tail = null;
        size = 0;
    }

    public void addFirst(E element) {
        Node<E> newNode = new Node<>(element);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    public void addLast(E element) {
        Node<E> newNode = new Node<>(element);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public void removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("List is empty");
        }
        E element = head.element;
        head = head.next;
        if (head != null) {
            head.prev = null;
        } else {
            tail = null;
        }
        size--;
    }

    public void removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("List is empty");
        }
        E element = tail.element;
        tail = tail.prev;
        if (tail != null) {
            tail.next = null;
        } else {
            head = null;
        }
        size--;
    }

    public E getFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("List is empty");
        }
        return head.element;
    }

    public E getLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("List is empty");
        }
        return tail.element;
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
    static class Main{
        public static void main(String[] args) {
            DoublelyLinkedList<Integer> doublelyLinkedList= new DoublelyLinkedList<>();
            doublelyLinkedList.addFirst(10);
            doublelyLinkedList.addFirst(20);
            doublelyLinkedList.addFirst(30);
            doublelyLinkedList.addFirst(40);
            doublelyLinkedList.addLast(50);
            doublelyLinkedList.removeFirst();
            doublelyLinkedList.removeLast();
            doublelyLinkedList.getFirst();
            doublelyLinkedList.getLast();
;





        }
    }
}
