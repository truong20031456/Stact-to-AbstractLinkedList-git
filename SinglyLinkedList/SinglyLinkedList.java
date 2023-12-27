package SinglyLinkedList;



import java.util.Iterator;
import java.util.NoSuchElementException;

public class SinglyLinkedList<E> implements AbstractLinkedList<E>{
    private Node<E> head;
    private Node<E> tail;
    private int size;

    private static class Node<E> {
        private final E element;
        private Node<E> next;
        public Node( E data ) {
            this.element = data;
            this.next = null;
        }
    }
    public SinglyLinkedList( ) {
        head = tail = null;
        size = 0;
    }
    public void addFirst( E element ) {
        Node<E> newNode = new Node<>(element);
        if ( isEmpty( ) ) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        size++;
    }
    public void addLast( E element ) {
        Node<E> newNode = new Node<>(element);
        if ( isEmpty( ) ) {
            head = newNode;
        } else {
            tail.next = newNode;
        }
        tail = newNode;
        size++;
    }
    public E removeFirst( ) {
        if ( isEmpty( ) ) {
            throw new NoSuchElementException( );
        }
        E element = head.element;
        if ( head == tail ) {
            head = null;
            tail = null;
        } else {
            Node<E> next = head.next;
            head.next = null;
            head = next;
        }
        size--;
        return element;
    }
    public E removeLast( ) {
        if ( isEmpty( ) ) {
            throw new NoSuchElementException( );
        }
        E removedElement = tail.element;
        if ( head == tail ) {
            head = null;
            tail = null;
        } else {
            Node<E> current = head;
            while ( current.next != tail ) {
                current = current.next;
            }
            current.next = null;
            tail = current;
        }
        size--;
        return removedElement;
    }
    public E remove( E element ) {
        E removedElement;
        if ( isEmpty( ) ) {
            throw new NoSuchElementException( );
        } else if ( tail.element.equals( element ) ) {
            removedElement = removeLast( );
        } else if ( head.element.equals( element ) ) {
            removedElement = removeFirst( );
        } else {
            Node<E> nodeBeforeTarget = head;
            while ( ( !nodeBeforeTarget.next.element.equals( element ) ) && ( nodeBeforeTarget.next != tail ) ) {
                nodeBeforeTarget = nodeBeforeTarget.next;
            }
            Node<E> targetNode = nodeBeforeTarget.next;
            nodeBeforeTarget.next = targetNode.next;
            targetNode.next = null;
            removedElement = targetNode.element;
            size--;
        }
        return removedElement;
    }
    public E getFirst( ) {
        if ( isEmpty( ) ) {
            throw new NoSuchElementException( );
        }
        return head.element;
    }
    public E getLast( ) {
        if ( isEmpty( ) ) {
            throw new NoSuchElementException( );
        }
        return tail.element;
    }
    public int size( ) {
        return size;
    }
    public boolean isEmpty( ) {
        return ( head == null && tail == null ); // or size == 0
    }
    public Iterator<E> iterator( ) {
        return new Iterator<>( ) {
            private Node<E> current = head;

            public boolean hasNext( ) {
                return current != null;
            }

            public E next( ) {
                if ( !hasNext( ) ) {
                    throw new NoSuchElementException( );
                }
                E data = current.element;
                current = current.next;
                return data;
            }
        };
    }
    public String toString( ) {
        StringBuilder result = new StringBuilder( "[" );
        Node<E> current = head;
        while ( current != null ) {
            result.append( current.element );
            if ( current.next != null ) {
                result.append( ", " );
            }
            current = current.next;
        }
        result.append( "]" );
        return result.toString( );
    }
}

class SinglyLinkedListTest {
    public static void main( String[] args ) {
        /**
         * Integer Singly Linked List
         */
        SinglyLinkedList<Integer> singleLinkedList = new SinglyLinkedList<Integer>( );

        singleLinkedList.addLast( 10 );
        singleLinkedList.addLast( 20 );

        System.out.println( singleLinkedList );

        singleLinkedList.addFirst( 30 );
        singleLinkedList.addFirst( 40 );
        singleLinkedList.addFirst( 50 );

        System.out.println( singleLinkedList );

        System.out.println( "Size: " + singleLinkedList.size( ) );
        System.out.println( "First element: " + singleLinkedList.getFirst( ) );
        System.out.println( "Last element: " + singleLinkedList.getLast( ) );

        System.out.println( "Removed first element: " + singleLinkedList.removeFirst( ) );
        System.out.println( "Removed last element: " + singleLinkedList.removeLast( ) );

        System.out.println( singleLinkedList );
        System.out.println( "Size: " + singleLinkedList.size( ) );

        System.out.println( "Removed element: " + singleLinkedList.remove( 30 ) );
        System.out.println( "Removed element: " + singleLinkedList.remove( 40 ) );
        System.out.println( "Removed element: " + singleLinkedList.remove( 10 ) );
        System.out.println( singleLinkedList );
        System.out.println( "Size: " + singleLinkedList.size( ) );

        /**
         * Object Single Linked List
         */
        SinglyLinkedList<Person> persons = new SinglyLinkedList<Person>( );
        persons.addFirst( new Person( "Elon Musk" ) );
        persons.addFirst( new Person( "Cristiano Ronaldo" ) );
        persons.addFirst( new Person( "Lionel Messi" ) );
        persons.addFirst( new Person( "Mark Zuckerberg" ) );
        persons.addFirst( new Person( "Dwayne Johnson" ) );
        persons.addFirst( new Person( "Bill Gates" ) );
        System.out.println( persons );

        for (Person person : persons) {
            System.out.println(person);
        }
    }
}
