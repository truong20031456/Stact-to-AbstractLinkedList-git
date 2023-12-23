package Loo_DoubleLyEnhanced;

import LOO_Doublely.AbstractLinked;

import javax.management.InstanceNotFoundException;
import javax.swing.*;
import java.security.PublicKey;
import java.util.Iterator;

public class DoublelyLinkedListEnhanced<E> implements AbstractLinklist<E> {

    private static class Node<E>{
        private E element;
        private Node<E> Next;
        private  Node<E> Prev;
        public Node(E element){
            this.element= element;
            Next = Prev= null;

        }
    }

    private Node<E> head;
    private Node<E> tail;
    private int size;
    public DoublelyLinkedListEnhanced(){
        head = tail = null;
        size =0;
    }
    private final Node<E> current = head;
    @Override
    public void addFirst(E element) {
        Node<E> newNode = new Node<E>(element);
       if(isEmpty()){
           head = tail = newNode;
       }
       newNode.Next = head;
       newNode.Prev= head;
       head = newNode;
       size++;





    }

    @Override
    public void addLast(E element) {
        Node<E> newNode = new Node<E>(element);
        if(isEmpty()){
            head = tail = newNode;
        }
        newNode.Prev = tail;
        newNode.Next =tail;
        tail = newNode;
        size++;



    }

    @Override
    public E removeFirst() throws InstanceNotFoundException {
        if(isEmpty()){
            throw new InstanceNotFoundException("Not Found");
        }

            E element = head.element;
            head.Next.Prev = null;
            head.Next = head.Next.Next;
            size--;

        return element;
    }

    @Override
    public E removeLast() {
        return null;
    }

    @Override
    public E getFirst() {
        return head.element;
    }

    @Override
    public E getLast() {
        return tail.element;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0 && head == null && tail == null;
    }


    @Override
    public Iterator<E> iterator() {
        return null;
    }

}
class Main{
    public static void main(String[] args) throws InstanceNotFoundException {
        DoublelyLinkedListEnhanced<Integer> doublelyLinkedListEnhanced= new DoublelyLinkedListEnhanced<>();
        doublelyLinkedListEnhanced.addFirst(10);
        doublelyLinkedListEnhanced.addFirst(20);
        doublelyLinkedListEnhanced.addLast(30);
        doublelyLinkedListEnhanced.addLast(40);
        doublelyLinkedListEnhanced.removeFirst();
        doublelyLinkedListEnhanced.removeFirst();


    }
}
