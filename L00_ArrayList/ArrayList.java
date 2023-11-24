package L00_ArrayList;

import org.w3c.dom.Node;

import java.lang.reflect.Array;
import java.util.Iterator;

public class ArrayList<E> implements List<E>{

    public static class  Element<E>{
       private E element;

        public E getElement() {
            return element;
        }
        public void setElement(E element){
            this.element = element;
        }
    }

    private static final int DEFAUlT_NUMBER = 4;
private  int size;
public E[] elements;

    public ArrayList(){
    elements = (E[]) new Object[DEFAUlT_NUMBER];
}


    @Override
    public boolean add(E element) {
        elements[size] = element;
        size++;



        return false;
    }

    @Override
    public boolean add(int index, E element) {
        return false;
    }

    @Override
    public E get(int index) {
        return null;
    }

    @Override
    public E set(int index, E element) {
        return null;
    }

    @Override
    public E remove(int index) {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public int indexOf(E element) {
        return 0;
    }

    @Override
    public boolean contains(E element) {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }
    class Main{
        public static void main(String[] args) {
            ArrayList<Integer> so = new ArrayList<>();
            so.add(123);
            System.out.println(so);
        }

    }
}


