package Queue1;

class Queue {
    private int[] elements;
    private int front;
    private int rear;
    private int size;
    private int capacity;

    public Queue(int capacity) {
        this.capacity = capacity;
        elements = new int[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public int size() {
        return size;
    }

    public void enqueue(int element) {
        if (isFull()) {
            System.out.println("Queue is full. Cannot enqueue.");
            return;
        }
        rear = (rear + 1) % capacity;
        elements[rear] = element;
        size++;
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot dequeue.");
            return -1; // Return a default value or throw an exception based on requirements
        }
        int removedElement = elements[front];
        front = (front + 1) % capacity;
        size--;
        return removedElement;
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot peek.");
            return -1; // Return a default value or throw an exception based on requirements
        }
        return elements[front];
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }
        System.out.print("Queue: ");
        int count = 0;
        int index = front;
        while (count < size) {
            System.out.print(elements[index] + " ");
            index = (index + 1) % capacity;
            count++;
        }
        System.out.println();
    }
}

public class Main {
    public static void main(String[] args) {
        Queue queue = new Queue(5);

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);

        queue.display(); // Output: Queue: 10 20 30 40

        queue.dequeue();
        queue.dequeue();

        System.out.println("Peek: " + queue.peek()); // Output: Peek: 30

        queue.display(); // Output: Queue: 30 40
    }
}
